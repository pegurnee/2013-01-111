
/*  Some code i saw in javaChat on stackoverflow
 * Coding provided by Eddie Gurnee
 * 0.0.1
 */
import java.util.*; 
import java.text.*; 

public class FromChat
{ 
    public static void main(String[] args)
    { 
        int i, j = 2; 
        while (1==1)
        { 
            for(i = 1; i<=10; i++)
            {
                if (i == j)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
                Scanner s = new Scanner(System.in); 
                int update = s.nextInt(); 
                if (update == 2) 
                { 
                    j++; 
                } 

                else if (update == 1) 
                { 
                    j--; 
                }
            }
        } 
    } 

}
