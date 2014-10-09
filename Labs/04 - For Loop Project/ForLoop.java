
/* The purpose of this program is to play with ForLoops
 * 
 * All coding provided by Eddie Gurnee
 * version 0.0.3
 */

import java.util.Scanner;

public class ForLoop
{
    public static void main(String[]args)
    {
        int whatStage; // finds out what stage you want to see
        String userName; //checks user name                
        Scanner keyboard = new Scanner(System.in);
                              
        System.out.print("What stage of Lab 4 do you want to see? "); // prompt to view stage of lab 4
        whatStage = keyboard.nextInt(); // 
        keyboard.nextLine(); // clears line
        
        if (whatStage == 1)
        {
            
            // part 1, displays numbers from -5 to 5
            for (int count = 0; count <= 10; count++)
            {
                System.out.println((count - 5)); // displays each number in the count, less 5
            }
        }
        
        else if (whatStage == 2)
        {
            // part 2, displays even numbers from 2 to 24
            for (int count = 1; count <= 12; count++)
            {
                System.out.println((count * 2)); //displays each number in the count, multiplied by 2
            }
        }
        
        else if (whatStage == 3)
        {
            //part 3, displays even numbers 24 to 2
            for (int count = 12; count >= 1; count--)
            {
                System.out.println((count * 2));
            }
        }
        
        else if (whatStage == 4)
        {
            //part 4, displays each character in an inputted string, in reverse order
            String userString;
            int stringLen;       // to hold length of user's input String
            char c;              // to hold each char from String in succession                  
        
            System.out.print("Enter a text String: ");
            userString = keyboard.nextLine();
            
        
            stringLen = userString.length();    // get length of user's String
        
            System.out.println("Here's your String, reverse disassembled:");    
               
                       
            for (int j = stringLen - 1; j >= 0; j--)
            {
                c = userString.charAt(j);   // extract char at current position
                System.out.println(c);            
            }
        }
        
        else if (whatStage == 5)
        {
            //part 5, displays the inputted string, in reverse order
            String userString;
            int stringLen;       // to hold length of user's input String
            char c;              // to hold each char from String in succession
                           
            System.out.print("Enter a text String: ");
            userString = keyboard.nextLine();
        
            stringLen = userString.length();    // get length of user's String
        
            System.out.println("Here's your String, revedisassembled:");    
                                      
            for (int j = stringLen - 1; j >= 0; j--)
            {
                c = userString.charAt(j);   // extract char at current position
                System.out.print(c + " ");  // prints 
            }
        }
        else
        {
            System.out.println("That's not a valid stage."); // in case user inputs wrong stage
        }       
    }
}
        


