
/**
 * Work for Project Euler Problem 6
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Solution
{
    public static void main(String[] args)
    {
        int max = 100;
        long difference = squareSum(max) - sumSquare(max);
        System.out.println(difference);
    }
    private static long sumSquare(int max)
    {
        long sum = 0L;
        for (int k = 0; k < max; k++)
        {
            sum += ((k+1)*(k+1));
        }
        return sum;
    }
    private static long squareSum(int max)
    {
        int sum = 0;
        for (int k = 0; k < max; k++)
        {
            sum += (k+1);
        }
        return (long)(sum * sum);
    }
}