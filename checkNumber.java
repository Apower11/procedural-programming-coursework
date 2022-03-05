public class checkNumber {
    public static void main(String[] p)
    {
        boolean digitFound = CheckNumber(2, "Big juicy cock 2");
        System.out.println(digitFound);
        System.exit(0);
    }

    public static boolean CheckNumber(int number, String digitSeries)
    {
        boolean containsDigit = false;
        System.out.println("String: " + digitSeries);
        for(int i = 0; i < digitSeries.length(); i++)
        {
            char digit = digitSeries.charAt(i);
            System.out.println(digit);
            int numericDigit = (int)(digit);
            System.out.println("Numeric digit: " + numericDigit);
            if(numericDigit == number)
            {
                containsDigit = true;
                System.out.println("It's true");
            }
        }
     return containsDigit;
    }
}
