
/**
 * Work for Project Euler Problem 4
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Solution
{
    public static void main(String[] args)
    {        
        int largestPal = 0;
        
        for (int k = 0; k < 1000; k++)
        {
            for (int j = 0; j < 1000; j++)
            {
                int testPal = k * j;
                if (Integer.toString(testPal).equals(reverseString(Integer.toString(testPal))))
                {
                    if (testPal > largestPal)
                    {
                        largestPal = testPal;
                    }
                }
            }
        }
        
        System.out.println(largestPal);
    }
    private static String reverseString(String input)
    {
        char[] arrChar = new char[input.length()];
        for (int k = 0; k < input.length(); k++)
        {
            arrChar[k] = input.charAt(input.length()-(k+1));
        }
        String str = "";
        for (char c : arrChar)
        {
            str += c;
        }
        System.out.println(input);
        System.out.println(str);
        return str;
    }
}