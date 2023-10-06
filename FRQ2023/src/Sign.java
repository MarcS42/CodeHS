public class Sign {

    private String displayMe;

    private int signWidth;

    public Sign(String displayMe, int signWidth)
    {
        this.displayMe = displayMe;
        this.signWidth = signWidth;
    }

    public int numberOfLines()
    {
        if(displayMe.isEmpty()) return 0;

        int txtLength = displayMe.length();
        if(txtLength <= signWidth)
        {
            return 1;
        }
        if(txtLength % signWidth == 0)
        {
            return txtLength / signWidth;
        }
        return txtLength / signWidth + 1;
    }
    public String getLines()
    {
        if(displayMe.isEmpty()) return null;
        if(displayMe.length() <= signWidth) return displayMe;

        int numberInserts = 0;
        String insertMe = ";";
        String returnMe = "";
        if (displayMe.length() % signWidth == 0)
        {
            numberInserts = displayMe.length() / signWidth -1;
        }
        if (displayMe.length() % signWidth > 0)
        {
            numberInserts = displayMe.length() / signWidth;
        }
        while (numberInserts > 0)
        {
            returnMe += displayMe.substring(0, signWidth) + insertMe;
        }
    }

    public static void main(String[] args) {
        Sign firstSign = new Sign("Everything on sale, please come in", 40);
        System.out.println(firstSign.numberOfLines());
    }
}
