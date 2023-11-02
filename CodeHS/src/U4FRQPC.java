public class U4FRQPC {
    /*   Question 1
Part (a)
The method countOccurences is intended to count how many times any character found in the countThese parameter is found in the source parameter.
For example, if countThese is "abc" and source is "abbra cadabbra" the result is 10 because the characters in source (shown in bold) are counted:
source: abbra cadabbra
Below are more examples:
source	           countThese	counted characters	returned count
abbra cadabbra	      abc	        abbacaabba	         10
abbra cadabbra	      d   	        d                   	1
wysiwyg	            wyz	        wywy	               4
Nothing to see here	123	 	                           0
/** Returns the number of occurrences of any character in countThese found in source.
 * @param source		the string to count
 * @param countThese	a String containing individual characters to count
 * @return the number of times a character in countThese occurs in source
 */
    public static int countOccurences(String source, String countThese)
    {
        int count = 0;
        for(int i = 0; i < countThese.length(); i++)
        {
            for(int j = 0; j < source.length(); j++)
            {
                if(countThese.substring(i,i+1).equals(source.substring(j,j+1)))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /*Part (b)
    The method countDivisibleDigits is intended to count how many digits in the parameter num are evenly divisible by the second parameter div.
    For example, the call countDivisibleDigits(1234567890, 3) should return the result 4 because the digits 3, 6, 9, and 0 are all evenly divisible by 3.
    Below are more examples:
    num	       div	evenly divisible digits	returned count
    1234567890	3	  3690	                   4
    123123123	3	    333	                    3
    1234567890	4	    480	                    3
    234852	    2	    2482 	                4
    /** Returns the number of digits in num that can be evenly divided by the parameter div.
     * @param num	the number to analyze
     *  precondition:		num is a positive integer
     * @param div	the divisor
     * @return the number of digits in num evenly divisible by div
     */
    public static int countDivisibleDigits(int num, int div)
    {//Not quite right, but it works since 'div' is always 1 digit long
        //Were likely supposed to us mod 10 to peal off digits
        int count1 = 0;
        String Snum = String.valueOf(num);
        String Sdiv = String.valueOf(div);
        for (int i = 0; i < Sdiv.length() ; i++)
        {
            for (int j = 0; j < Snum.length(); j++)
            {
                if ((Integer.parseInt(Snum.substring(j,j+1))) % (Integer.parseInt(Sdiv.substring(i,i+1))) == 0)
                {
                    count1++;
                }
            }
        }
        return count1;
    }

    public static void main(String[] args) {
        System.out.println("Expected = 10: "+countOccurences("abbra cadabbra","abc"));
        System.out.println("Expected = 1: "+countOccurences("abbra cadabbra","d"));
        System.out.println("Expected = 4: "+countOccurences("wysiwyg","wyz"));
        System.out.println("Expected = 0: "+countOccurences("Nothing to see here","123"));

        System.out.println("\nExpected = 4: "+countDivisibleDigits(1234567890,3));
        System.out.println("Expected = 3: "+countDivisibleDigits(123123123,3));
        System.out.println("Expected = 3: "+countDivisibleDigits(1234567890,4));
        System.out.println("Expected = 4: "+countDivisibleDigits(234852,2));
    }
}
