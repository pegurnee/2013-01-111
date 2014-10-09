// Check equality of two integer passcode entries

import java.util.Scanner;   // Utilities to scan input from stream of text

public class CheckPasscode2
{
  public static void main(String [ ] args)
    {
        // create variable keyboard of type Scanner (a class)
        Scanner keyboard = new Scanner(System.in);   // object in class Scanner
        
        int passCode1, passCode2;
        
        System.out.print("Enter integer passcode: ");
        passCode1 = keyboard.nextInt();
        keyboard.nextLine();                  // clear rest of line
        
        System.out.print("Please re-enter passcode: ");
        passCode2 = keyboard.nextInt();
        keyboard.nextLine();                  // clear rest of line

        
        if (passCode1 != passCode2)           // test equality
        {
            System.out.println("Passcodes do not match.");
        }
        else
        {
            System.out.println("Passcodes match."); 
        }
    }
}