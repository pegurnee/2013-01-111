package com.egurnee.school.intro.l5;

/* This program is used to prove that I know how to use the basic File InputOutPut commands
 * All coding provided by Eddie Gurnee
 * version 0.0.2
 */
import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*;

public class InputOutput
{
    public static void main(String [ ] args)
    {
        String fName = "InputOutput.txt";
        Random rand = new Random();
        try
        {
            PrintWriter outStream = new PrintWriter(new FileOutputStream(fName));
            for (int k = 0; k < 3; k++)
            {
                int firstOut = rand.nextInt(50) + 1;
                outStream.println(firstOut);
            }
            outStream.close();
        }
        catch (Exception e)
        {
            System.out.println("Error creating random number file");
            System.exit(0);    // terminate program
        }
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
            // Stage 1
            if (numStage == 1)
            {
                int[] inputNum = new int[3];
                try
                {
                    Scanner inStream = new Scanner(new FileInputStream(fName));                
                    for (int k = 0; k < inputNum.length; k++)
                    {
                        inputNum[k] = inStream.nextInt();
                    }
                    inStream.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error reading numbers from file");
                    System.exit(0);
                }
                boolean increaseAllCheck = false;
                while (increaseAllCheck != true)
                {
                    System.out.print("Want to check if the numbers are increasing? [y/n] ");
                    String str1 = keyboard.nextLine().trim().toLowerCase();
                    if (str1.charAt(0) != 'y' && str1.charAt(0) != 'n')
                    {
                        System.out.println("Invalid Input.");
                    }
                    else
                    {
                        if (str1.charAt(0) == 'y')
                        {
                            if (inputNum[0] < inputNum[1] && inputNum[1] < inputNum[2])
                            {
                                System.out.println("All of the numbers are increasing.");
                            }
                            else
                            {
                                System.out.println("All of the numbers are not increasing.");
                                boolean increaseAnyCheck = false;
                                while (increaseAnyCheck != true)
                                {
                                    System.out.print("Want to check if any of the numbers are increasing? [y/n] ");
                                    String str2 = keyboard.nextLine().trim().toLowerCase();
                                    if (str2.charAt(0) != 'y' && str2.charAt(0) != 'n')
                                    {
                                        System.out.println("Invalid Input.");
                                    }
                                    else
                                    {
                                        if (str2.charAt(0) == 'y')
                                        {
                                            boolean increaseAny = false;
                                            if (inputNum[0] < inputNum[1])
                                            {
                                                System.out.println("The number 2 value is increased from the number 1 value.");
                                                System.out.println("(" + inputNum[1] + " > " + inputNum[0] + ")");
                                                increaseAny = true;
                                            }
                                            if (inputNum[1] < inputNum[2])
                                            {
                                                System.out.println("The number 3 number is increased from the number 2 number.");
                                                System.out.println("(" + inputNum[2] + " > " + inputNum[1] + ")");
                                                increaseAny = true;
                                            }
                                            if (inputNum[0] < inputNum[2])
                                            {
                                                System.out.println("The number 3 number is increased from the number 1 number.");
                                                System.out.println("(" + inputNum[2] + " > " + inputNum[0] + ")");
                                                increaseAny = true;
                                            }
                                            if (!increaseAny)
                                            {
                                                System.out.println("In the order that they are in, none of the numbers increase upon each other.");
                                            }
                                        }
                                        increaseAnyCheck = true;
                                    }
                                }
                            }
                        }
                        boolean equalCheck = false;
                        while (equalCheck != true)
                        {
                            System.out.print("Want to check if any of the numbers are equal? [y/n] ");
                            String str3 = keyboard.nextLine().trim().toLowerCase();
                            if (str3.charAt(0) != 'y' && str3.charAt(0) != 'n')
                            {
                                System.out.println("Invalid Input.");
                            }
                            else
                            {
                                if (inputNum[0] == inputNum[1] && inputNum[1] == inputNum[2])
                                {
                                    System.out.println("All of the numbers are equal.");
                                }
                                else
                                {
                                    if (str3.charAt(0) == 'y')
                                    {
                                        boolean equalsAny = false;
                                        if (inputNum[0] == inputNum[1])
                                        {
                                            System.out.println("The number 2 value is the same as the number 1 value.");
                                            System.out.println("(" + inputNum[1] + " = " + inputNum[0] + ")");
                                            equalsAny = true;
                                        }
                                        if (inputNum[1] == inputNum[2])
                                        {
                                            System.out.println("The number 3 number is the same as the number 2 number.");
                                            System.out.println("(" + inputNum[2] + " = " + inputNum[1] + ")");
                                            equalsAny = true;
                                        }
                                        if (inputNum[0] == inputNum[2])
                                        {
                                            System.out.println("The number 3 number is the same as the number 1 number.");
                                            System.out.println("(" + inputNum[2] + " = " + inputNum[0] + ")");
                                            equalsAny = true;
                                        }
                                        if (!equalsAny)
                                        {
                                            System.out.println("None of the values equal any other values.");
                                        }
                                    }
                                }
                                equalCheck = true;
                            }
                        }
                        increaseAllCheck = true;
                    }
                }
            }
            // Stage 2
            else if (numStage == 2)
            {
                int[] inputNum = new int[3];
                try
                {
                    Scanner inStream = new Scanner(new FileInputStream(fName));                
                    for (int k = 0; k < inputNum.length; k++)
                    {
                        inputNum[k] = inStream.nextInt();
                    }
                    inStream.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error reading numbers from file");
                    System.exit(0);
                }
                Arrays.sort(inputNum);
                if (inputNum[0] == inputNum[1] && inputNum[1] == inputNum[2])
                {
                    System.out.println("All of the numbers are tied for the highest at " + inputNum[2] + ".");
                }
                else if (inputNum[1] == inputNum[2])
                {
                    System.out.println("Two of the numbers are tied for the highest at " + inputNum[2] + ".");
                }
                else
                {
                    System.out.println("The highest number is " + inputNum[2] + ".");
                }
            }
            // Stage 3
            else if (numStage == 3)
            {
                int[] inputNum = new int[3];
                try
                {
                    Scanner inStream = new Scanner(new FileInputStream(fName));                
                    for (int k = 0; k < inputNum.length; k++)
                    {
                        inputNum[k] = inStream.nextInt();
                    }
                    inStream.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error reading numbers from file");
                    System.exit(0);
                }
                Arrays.sort(inputNum);
                try
                {
                    String fHighest = "HighestOutput.txt";
                    PrintWriter outStream = new PrintWriter(new FileOutputStream(fHighest));
                    outStream.println(inputNum[2]);
                    outStream.close();
                }
                catch (Exception e)
                {
                    System.out.println("My bad!");
                    System.exit(0);
                }
                System.out.println("Stage 3: Complete");
            }
            else
            {
                System.out.println("Something is totally broken.");
                System.exit(0);
            }
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
