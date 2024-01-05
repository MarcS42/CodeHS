import java.util.Random;

public class BoxOfCandy {

    private final Candy[][] box;
    private static final Random r1 = new Random();
    /** box 2d array should be rectangular - # cols > # rows
     *  Implementation not shown*/
    public BoxOfCandy(int rows, int cols)
    {
        String[] flavors = {"Lime","Orange","Cherry","Lemon","Grape"};
        box = new Candy[rows][cols];
        // Randomly fill 33% of locations in box with candies
        for (int i = 0; i < rows*cols*0.33; i++)
        {
            box[r1.nextInt(rows)][r1.nextInt(cols)] =
                    new Candy(flavors);
        }
    }

    /**
     * Tests 'column major' traversal of 2d array, testing for null
     * Returns true if either a) A Candy is found in row 0 of @Parameter
     * column; or b) A Candy is successfully moved to row 0 from column.
     * Returns false otherwise. If moved, the original location of Candy is
     * set to null.
     * */
    public boolean moveCandyToFirstRow(int col)
    {
        boolean returnMe = true;
        if(box[0][col] == null) // .equals(null) will not work-always returns
            // null
        {
            for (int row = 1; row < box.length; row++)
            {
                if (box[row][col] != null)
                {
                    box[0][col] = box[row][col];
                    box[row][col] = null;
                    return true; // Stops as soon as a Candy is found
                }
            }
            returnMe = false;
        }
        return returnMe;
    }

    /**
     * Searches <code>box</code> in row major order, **but from bottom row**
     * left corner **to top row** right corner, for a Candy of flavor
     * Parameter: flavor. If found, it a) returns the Candy object, and b)
     * sets the value of the returned Candy location in <code>box</code> to
     * null. Otherwise, returns null.
     * */
    public Candy removeNextByFlavor(String flavor)
    {
        Candy returnMe = null;
        for(int row = box.length - 1; row >= 0; row--)
        {
            for (int col = 0; col < box[0].length; col++)
            {
                if (box[row][col] != null && box[row][col].getFlavor().equals(flavor))
                {
                    returnMe = box[row][col];
                    box[row][col] = null;
                }
            }
        }
        return returnMe;
    }
    public void printBoxArray()
    {
        for(Candy[] row:box)
        {
            for (Candy col:row)
            {
                System.out.printf("%-7s",col);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        BoxOfCandy box1 = new BoxOfCandy(3,5);


        System.out.println("BoxOfCandy before moveCandyToFirstRow: ");
        box1.printBoxArray();

        boolean moveCandyToFirstRow = box1.moveCandyToFirstRow(2);

        System.out.println("Move Candy T/F: " + moveCandyToFirstRow);
        System.out.println("BoxOfCandy after moveCandyToFirstRow: ");
        System.out.println("BoxOfCandy to be searched: ");
        box1.printBoxArray();

        String searchMe = "Grape";
        System.out.println("\nLooking for: " + searchMe);
        System.out.println("Found: " + box1.removeNextByFlavor(searchMe));
        System.out.println("BoxOfCandy after search for: " + searchMe);
        box1.printBoxArray();

    }
}
