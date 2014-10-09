
/**
 * Work for Project Euler Problem 5
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Solution
{
    public static void main(String[] args)
    {
        long lowestMultiple = factorialize(20);
        for (int count = 1; count <= lowestMultiple; count++)
        {
            if (checkNoRemainder(20, count))
            {                
                lowestMultiple = count;
                System.out.println(lowestMultiple);
            }
        }
    }
    private static long factorialize(int input)
    {
        long product = 1;
        while (input > 0)
        {
            product *= input;
            input--;
        }
        return product;
    }
    private static boolean checkNoRemainder(int highestNum, int checkNum)
    {
        for (int k = 0; k < highestNum; k++)
        {
            if (checkNum % (k + 1) != 0)
            {
                return false;
            }
        }
        return true;
    }
}