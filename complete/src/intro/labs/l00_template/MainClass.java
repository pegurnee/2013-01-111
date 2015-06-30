package intro.labs.l00_template;

/* This program exists to show the basics of Random numbers and user exiting loops
 * All coding provided by Eddie Gurnee
 * version 0.0.1
 */
import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*; // imports input/output functions

public class MainClass
{
    public static void main(String [ ] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean runLab = true;
        while (runLab)
        {
            int numStage = 0;
            boolean checkStage = false;
            while (!checkStage)
            {
                System.out.print("Which stage would you like to see? ");        
                String stNumStage = keyboard.next().trim();
                keyboard.nextLine();

                int stNumStageLength = stNumStage.length();
                boolean validInt = true;
                for (int k = 0; k < stNumStageLength; k++)
                {                                
                    if (!Character.isDigit(stNumStage.charAt(k)))
                    {
                        System.out.println("Invalid Input.");
                        validInt = false;
                    }
                } 
                if (validInt == true)
                {
                    int testNumStage = Integer.parseInt(stNumStage);
                    if (testNumStage == 1 || testNumStage == 2 || testNumStage == 3)
                    {
                        numStage = testNumStage;
                        checkStage = true;
                    }
                    else
                    {
                        System.out.println("Invalid Input.");
                    }
                }
            }
            //
            // Lab goes here
            //
            boolean checkRun = false;
            while (!checkRun)
            {
                System.out.print("Would you like to see another stage? [y/n] ");
                String confirmRun = keyboard.nextLine().trim().toLowerCase();

                if (confirmRun.charAt(0) == 'y' || confirmRun.charAt(0) == 'n')
                {
                    if (confirmRun.charAt(0) == 'n')
                    {
                        runLab = false;
                    }
                    checkRun = true;
                }
                else 
                {
                    System.out.println("Invalid Input.");
                }
            }
        }
    }
}
