// Check two-ended range, display error message if out of range

import java.util.Scanner;   // Utilities to scan input from stream of text

public class CheckRange3
{
  public static void main(String [ ] args)
    {
        // create variable keyboard of type Scanner (a class)
        Scanner keyboard = new Scanner(System.in);   // object in class Scanner
        
        int numKids;
        
        System.out.print("Enter number of children: ");
        numKids = keyboard.nextInt();
        keyboard.nextLine();                  // clear rest of line
        
        if (numKids >= 0 && numKids <= 30)  // expected range is 0 thru 30
        {
            System.out.println("Number of kids is: " + numKids);
        }
        else
        {
            System.out.println("Number of kids is out of range.");
        }
    }
}