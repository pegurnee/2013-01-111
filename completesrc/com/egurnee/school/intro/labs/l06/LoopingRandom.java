package com.egurnee.school.intro.labs.l06;

/* This program exists to show the basics of Random numbers and user exiting loops
 * All coding provided by Eddie Gurnee
 * version 0.0.1
 */
import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*;

public class LoopingRandom
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
            // Stage 1
            if (numStage == 1)
            {
                boolean numNumCheck = false;
                while (!numNumCheck)
                {
                    System.out.print("How many numbers do you want to enter? [press ?? for unsure] ");
                    String enterNumbers = keyboard.nextLine().trim().toLowerCase();

                    if (enterNumbers.equals("??"))
                    {
                        boolean runStage1 = true;
                        while (runStage1)
                        {
                            System.out.print("Enter number to square root (negative number to exit): ");
                            double inputNum = keyboard.nextDouble();
                            keyboard.nextLine();

                            if (inputNum >= 0)
                            {
                                System.out.println("Square root of " + inputNum + " = " + Math.sqrt(inputNum) + ".");
                            }
                            else
                            {
                                runStage1 = false;
                            }
                        }
                        numNumCheck = true;
                    }
                    else
                    {
                        int enterNumbersLength = enterNumbers.length();
                        boolean validNum = true;
                        for (int k = 0; k < enterNumbersLength; k++)
                        {                                
                            if (!Character.isDigit(enterNumbers.charAt(k)))
                            {
                                System.out.println("Invalid Input.");
                                validNum = false;
                            }
                        }                            
                        if (validNum)
                        {
                            int numInput = Integer.parseInt(enterNumbers);
                            for (int k = 0; k < numInput; k++)
                            {
                                System.out.print("Enter number to square root: ");
                                double inputNum = keyboard.nextDouble();
                                keyboard.nextLine();

                                if (inputNum >= 0)
                                {
                                    System.out.println("Square root of " + inputNum + " = " + Math.sqrt(inputNum) + ".");
                                }
                                else
                                {
                                    System.out.println("Square root of " + inputNum + " = " + Math.sqrt(Math.abs(inputNum)) + "i.");                                    
                                }
                            }
                            numNumCheck = true;
                        }
                    }
                }                
            }
            else if (numStage == 2)
            {
                Random rand = new Random();
                boolean checkDiff = false;
                while (!checkDiff)
                {
                    System.out.print("Would you like to play in easy or hard mode? [easy/hard] ");
                    String confirmRun = keyboard.nextLine().trim().toLowerCase();

                    if (confirmRun.charAt(0) == 'e' || confirmRun.charAt(0) == 'h')
                    {
                        boolean hardMode = false, unlimitedNum = true;
                        if (confirmRun.charAt(0) == 'h')
                        {
                            hardMode = true;
                        }
                        int numGuess = 0;
                        boolean checkNumGuess = false;                        
                        while (!checkNumGuess)
                        {
                            System.out.print("How many guesses would you like? [enter \"??\" for unlimited] ");
                            String numGuesses = keyboard.nextLine().trim().toLowerCase();

                            if (numGuesses.equals("??"))
                            {
                                unlimitedNum = true;
                                checkNumGuess = true;
                            }
                            else
                            {
                                int guessNumbersLength = numGuesses.length();
                                boolean validNum = true;
                                for (int k = 0; k < guessNumbersLength; k++)
                                {                                
                                    if (!Character.isDigit(numGuesses.charAt(k)))
                                    {
                                        System.out.println("Invalid Input.");
                                        validNum = false;
                                    }
                                }                            
                                if (validNum)
                                {
                                    numGuess = Integer.parseInt(numGuesses);
                                    unlimitedNum = false;
                                    checkNumGuess = true;
                                }
                            }
                        }
                        int count = 0;
                        boolean guessedNumber = false;
                        if (!hardMode)
                        {
                            int guessNum = (rand.nextInt(100) + 1);
                            if (unlimitedNum)
                            {
                                while (!guessedNumber)
                                {
                                    System.out.print("Guess number: ");
                                    int guess = keyboard.nextInt();
                                    keyboard.nextLine();

                                    if (guess > guessNum)
                                    {
                                        System.out.println("Your number is too high.");
                                    }
                                    else if (guessNum > guess)
                                    {
                                        System.out.println("Your number is too low.");
                                    }
                                    else
                                    {
                                        System.out.println("You win!!");
                                        guessedNumber = true;
                                    }
                                    count++;
                                }
                                System.out.print("You managed to guess the number " + guessNum + " in " + count + " guess");
                                if (count > 1)
                                {
                                    System.out.println("es.\nCongradulations!");
                                }
                                else
                                {
                                    System.out.println(".\nThat's amazing!!");
                                }
                            }
                            else
                            {
                                for (int k = 0; k < numGuess && guessedNumber != true; k++)
                                {                                
                                    System.out.print("Guess number: ");
                                    int guess = keyboard.nextInt();
                                    keyboard.nextLine();

                                    if (guess > guessNum)
                                    {
                                        System.out.println("Your number is too high.");
                                    }
                                    else if (guessNum > guess)
                                    {
                                        System.out.println("Your number is too low.");
                                    }
                                    else
                                    {
                                        System.out.println("You win!!");
                                        guessedNumber = true;
                                    }
                                    count++;
                                }
                                if (guessedNumber)
                                {
                                    System.out.print("You managed to guess the number " + guessNum + " in " + count + " guess");
                                    if (count > 1)
                                    {
                                        System.out.println("es.\nCongradulations!");
                                    }
                                    else
                                    {
                                        System.out.println(".\nThat's amazing!!");
                                    }
                                }
                                else
                                {
                                    System.out.println("I'm sorry, you lose. The number was " + guessNum + ".");
                                }
                            }
                        }
                        else
                        {
                            double guessNum = (Math.random() * 100);
                            if (unlimitedNum)
                            {
                                while (!guessedNumber)
                                {
                                    System.out.print("Guess number: ");
                                    double guess = keyboard.nextDouble();
                                    keyboard.nextLine();

                                    if (guess > guessNum)
                                    {
                                        System.out.println("Your number is too high.");
                                    }
                                    else if (guessNum > guess)
                                    {
                                        System.out.println("Your number is too low.");
                                    }
                                    else
                                    {
                                        System.out.println("You win!!");
                                        guessedNumber = true;
                                    }
                                    count++;
                                }
                                System.out.print("You managed to guess the number " + guessNum + " in " + count + " guess");
                                if (count > 1)
                                {
                                    System.out.println("es.\nCongradulations!");
                                }
                                else
                                {
                                    System.out.println(".\nThat's miraculous!!");
                                }
                            }
                            else
                            {
                                for (int k = 0; k < numGuess && guessedNumber != true; k++)
                                {                                
                                    System.out.print("Guess number: ");
                                    double guess = keyboard.nextDouble();
                                    keyboard.nextLine();

                                    if (guess > guessNum)
                                    {
                                        System.out.println("Your number is too high.");
                                    }
                                    else if (guessNum > guess)
                                    {
                                        System.out.println("Your number is too low.");
                                    }
                                    else
                                    {
                                        System.out.println("You win!!");
                                        guessedNumber = true;
                                    }
                                    count++;
                                }
                                if (guessedNumber)
                                {
                                    System.out.print("You managed to guess the number " + guessNum + " in " + count + " guess");
                                    if (count > 1)
                                    {
                                        System.out.println("es.\nCongradulations!");
                                    }
                                    else
                                    {
                                        System.out.println(".\nThat's miraculous!!");
                                    }
                                }
                                else
                                {
                                    System.out.println("I'm sorry, you lose. The number was " + guessNum + ".");
                                }
                            }
                        }
                        checkDiff = true;
                    }
                    else 
                    {
                        System.out.println("Invalid Input.");
                    }
                }
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
