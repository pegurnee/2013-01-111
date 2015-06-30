package intro.toys.defend_gather_recruit;

/* The coding for the DefendGatherRecruit
 * 
 */

import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*; // imports all input/output java

public class DefendGatherRecruit
{
    public static void main(String [ ] args)
    {
        Scanner keyboard = new Scanner(System.in); // creates keyboard scanner    

        int defend = 0, gather = 0, recruit = 0; // defines daytime variables
        int numMinions = 7, gold = 5; // defines starting variables (gold & minions)

        String [] customNames = new  String [16]; // defines custom name array  
        String stCommand; // defines the command selector
        boolean endTest = false;

        while (endTest != true)
        {
            System.out.print("What is your command? ");
            stCommand = keyboard.nextLine();

            if (stCommand.isEmpty())
            {
                System.out.println("Invalid Command.");
            }
            else
            {
                stCommand = stCommand.toLowerCase().trim();
                char command = stCommand.charAt(0);    

                if (command == 'd' || command == 'g' || command == 'r') // if 'd' is pressed
                {                        
                    String customNamesDGR = null;
                    int other1 = 0, other2 = 0;
                    if (command == 'd')
                    {
                        customNamesDGR = customNames[4];
                        other1 = gather;
                        other2 = recruit;
                    }
                    else if (command == 'g')
                    {
                        customNamesDGR = customNames[5];
                        other1 = recruit;
                        other2 = defend;
                    }
                    else if (command == 'r')
                    {
                        customNamesDGR = customNames[6];
                        other1 = defend;
                        other2 = gather;
                    }
                    boolean checkDGR = false;
                    while (checkDGR != true)
                    {                        
                        String stTempDGR;
                        System.out.print("Set how many " + customNamesDGR + "? ");
                        stTempDGR = keyboard.next().trim();
                        keyboard.nextLine();
                        boolean invalidDGR = false;
                        int stTempDGRLength = stTempDGR.length();
                        for (int k = 0; k < stTempDGRLength; k++)
                        {                                
                            if (Character.isDigit(stTempDGR.charAt(k)) != true)
                            {
                                System.out.println("Invalid Command.");
                                invalidDGR = true;
                            }
                        }
                        if (invalidDGR == false)
                        {
                            int tempDGR = Integer.parseInt(stTempDGR);
                            if ((tempDGR + other1 + other2) > numMinions)
                            {
                                System.out.println();
                                System.out.println("Error!");
                                System.out.println("You don't have enough " + customNames[3] + " to do that.");
                                System.out.println("Press 'm' to reset " + customNames[3] + " distribution.");
                                System.out.println("Or press 's' to see where they are distributed.");
                                checkDGR = true;
                            }
                            else
                            {
                                boolean confirmDGR = false;
                                while (confirmDGR != true)
                                {
                                    String stConfirmDGR;
                                    System.out.print("Confirm " + tempDGR + " " + customNamesDGR + "? [y/n] ");
                                    stConfirmDGR = keyboard.nextLine().trim().toLowerCase();
                                    if (stConfirmDGR.isEmpty())
                                    {
                                        System.out.println("Invalid Command.");
                                    }
                                    else if (stConfirmDGR.charAt(0) == 'y')
                                    {
                                        if (command == 'd')
                                        {
                                            defend = tempDGR;
                                        }
                                        else if (command == 'g')
                                        {
                                            gather = tempDGR;
                                        }
                                        else if (command == 'r')
                                        {
                                            recruit = tempDGR;
                                        }
                                        System.out.println(customNamesDGR + " set.");
                                        checkDGR = true;
                                        confirmDGR = true;                                        
                                    }
                                    else if (stConfirmDGR.charAt(0) == 'n')
                                    {
                                        checkDGR = true;
                                        confirmDGR = true;
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Command.");
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                else if (command == 'e')
                {
                    endTest = true;
                }
                else if (command == 's') // if 's' is pressed, see the economic status 
                {
                    System.out.println("You currently have " + numMinions + " " + customNames[3] + ".");
                    if (numMinions > (defend + gather + recruit))
                    {
                        System.out.println((numMinions - defend - gather - recruit) + " of which are unassigned.");
                    }
                    if (gather > 0)
                    {
                        System.out.println(gather + " of them are gathering " + customNames[8] + ".");
                    }
                    if (defend > 0)
                    {
                        System.out.println(defend + " of them are defending.");
                    }
                    if (recruit > 0)
                    {
                        System.out.println(recruit + " of them are " + customNames[7] + " more " + customNames[3] + ".");
                    }
                    System.out.println("You currently have " + gold + " " + customNames[8] + ".");
                    System.out.println();
                }
                else
                {
                    System.out.println("Invalid Command.");
                }
            }
        }
    }
}
