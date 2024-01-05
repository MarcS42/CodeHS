/**********************************************
 * <p>
 *     Frqs 2023 pdf is in Owner/JavaWorld/FRQs
 * </p>
 * *******************************************/
public class SignWithInsert {

    /*
     * <code>displayMe</code>: String to be displayed on Sign
     * */
    private final String displayMe;

    /*
     * <code>signWidth</code>: int width of Sign including punctuation and
     * spaces
     * */
    private final int signWidth;

    /*
     * Only 1 constructor, no setters, so instance vars can be final
     * */
    public SignWithInsert(String displayMe, int signWidth)
    {
        this.displayMe = displayMe;
        this.signWidth = signWidth;
    }

    /*
     * Returns the number of lines that <code>displayMe</code> needs to be
     * separated into, in order to be displayed on a sign of width
     * <code>signWidth</code>.
     * */
    public int numberOfLines2()
    {
        if (displayMe.isEmpty()) return 0;

        int txtLength = displayMe.length();
        if (txtLength <= signWidth)
        {
            return 1;
        }
        if (txtLength % signWidth == 0)
        {
            return txtLength / signWidth;
        }
        return txtLength / signWidth + 1;
    }

    /*
     * Returns the String <code>displayMe</code> spit by inserting semicolons,
     * so it can be displayed on a Sign of width <code>signWidth</code>.
     * */
    public String getLines2()
    {
        if (displayMe.isEmpty()) return null;
        if (displayMe.length() <= signWidth) return displayMe;

        int numberInserts = this.numberOfLines2() - 1;
        String insertMe = ";";
        StringBuilder workWithMe = new StringBuilder(displayMe);
        /*
         * If you are here, numberInserts >= 1
         */
        while(numberInserts > 0)
        {
            /*
             * Try using direct .insert(insertLoc, insertMe) method:
             * */
            // numberInserts*signWidth counts from high end(rt) to low end (lft)
            // so no need to account for previously inserted chars or residual
            // line chars!!
            workWithMe.insert(numberInserts*signWidth, insertMe);
            numberInserts--;
        }
        return workWithMe.toString();
    }

    public static void main(String[] args)
    {
        SignWithInsert s1 = new SignWithInsert("Everything on sale, please " +
                "come in", 15);
        System.out.println("Sign1.numLines: " + s1.numberOfLines2());
        System.out.println("Sign1.gtLines: " + s1.getLines2() + "\n");

        SignWithInsert s2 = new SignWithInsert("Everything on sale, please come in", 17);
        System.out.println("Sign2.numLines: " + s2.numberOfLines2());
        System.out.println("Sign2.gtLines: " + s2.getLines2() + "\n");

        SignWithInsert s3 = new SignWithInsert("Everything on sale, please come in", 40);
        System.out.println("Sign3.numLines: " + s3.numberOfLines2());
        System.out.println("Sign3.gtLines: " + s3.getLines2() + "\n");

        SignWithInsert s4 = new SignWithInsert("ABC222DE",3);
        System.out.println("Sign4.numLines: " + s4.numberOfLines2());
        System.out.println("Sign4.gtLines: " + s4.getLines2()+"\n");

        SignWithInsert s5 = new SignWithInsert("AB_CD_EF",2);
        System.out.println("Sign5.numLines: " + s5.numberOfLines2());
        System.out.println("Sign5.gtLines: " + s5.getLines2() + "\n");
    }
}
