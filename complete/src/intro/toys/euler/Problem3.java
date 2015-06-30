package intro.toys.euler;

/**
 * Work for Project Euler Problem 3
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Problem3
{
    public static void main(String[] args)
    {
        int largestPrime = 1;
        long multiple = 600851475143L;
        int count = 1;
        while (multiple >= count)
        {
            if (multiple % count == 0)
            {
                multiple /= count;
                largestPrime = count;                
            }
            count++;
        }
        System.out.println(largestPrime);
    }
}