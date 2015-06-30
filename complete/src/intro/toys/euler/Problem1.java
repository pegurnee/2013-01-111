package intro.toys.euler;


/**
 * Work for Project Euler Problem 1
 * 
 * @author All Coding Provided by Eddie Gurnee
 * @version 4/18/13
 */
public class Problem1
{
    public static void main(String[] args)
    {
        int sum = 0;       

        System.out.println("Threes: " + countDown(1000, 3, 0));
        sum += addUp(3, countDown(1000, 3, 0));        
        System.out.println("Sum: " + sum);

        System.out.println("Fives: " + countDown(1000, 5, 0));
        sum += addUp(5, countDown(1000, 5, 0));
        System.out.println("Sum: " + sum);

        System.out.println("Fifteens: " + countDown(1000, 15, 0));
        sum -= addUp(15, countDown(1000, 15, 0));        
        System.out.println("Sum: " + sum);
    }
    private static int countDown(int starter, int counter, int chocula)
    {
        while (starter > counter)
        {
            starter -= counter;
            chocula++;
        }
        return chocula;
    }
    private static int addUp(int adder, int numberOfAdds)
    {
        int addend = 0;
        for (int k = 0; k < numberOfAdds; k++)
        {
            addend += ((k+1) * adder);
        }
        return addend;
    }
}
