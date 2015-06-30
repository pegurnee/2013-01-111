package intro.toys.fiddling;


/* Fiddling with arrays, specifically doubling the size
 * 
 */

import java.util.Arrays;

public class ArraysClass
{
    public static void run()
    {
        int test[] = new int[5];
        test[0] = 12;
        test[1] = 14;
        test[2] = 8;

        System.out.println(test.length);
        System.out.println(test[1]);
        
        test = doubleSize(test);
        
        System.out.println(test.length);
        System.out.println(test[1]);
        System.out.println(test[5]);
    }

    public static int[] doubleSize(int[] a)
    {
        int b[] = new int[a.length * 2];
        
        for (int k = 0; k < a.length; k++)
        {
            b[k] = a[k];
        }
        
        return b;
    }

}
