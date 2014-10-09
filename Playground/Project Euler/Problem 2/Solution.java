
/**
 * Work for Project Euler Problem 2
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Solution
{
    public static void main(String[] args)
    {
        int[] fib = {0,1};
        int currentFib = 1;
        int sum = 0;
        while (currentFib < 4000000)
        {
            currentFib = fib[0] + fib[1];
            if (currentFib % 2 == 0)
            {
                sum += currentFib;
            }
            fib[0] = fib[1];
            fib[1] = currentFib;
        }
        System.out.println(sum);
    }    
}
