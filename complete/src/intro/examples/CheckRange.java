package intro.examples;

// Reading various types from the keyboard, one item per line

import java.util.Scanner;   // Utilities to scan input from stream of text

public class CheckRange
{
  public static void main(String [ ] args)
    {
        // create variable keyboard of type Scanner (a class)
        Scanner keyboard = new Scanner(System.in);   // object in class Scanner
        
        double x, sqrtX;
        System.out.print("Enter number to get square root of: ");   // prompt
        x = keyboard.nextDouble();            // read next double
        keyboard.nextLine();                  // clear rest of line
        if (x >= 0)
        {
            sqrtX = Math.sqrt(x);
            System.out.println("square root is: " + sqrtX);
        }
    }
}