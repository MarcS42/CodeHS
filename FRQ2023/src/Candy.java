import java.util.Random;

public class Candy {
    private final String flavor;
    private static final Random r = new Random();
    public Candy(String[] flavors)
    {

        this.flavor = flavors[r.nextInt(flavors.length)];
    }
    public String getFlavor()
    {
        return flavor;
    }

    public String toString()
    {
        return flavor;
    }
}
