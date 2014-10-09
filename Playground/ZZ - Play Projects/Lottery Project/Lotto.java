
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Lotto
{
    public static void main(String[] args)
    {        
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        boolean checkPlay = false, readInput = false;
        final int MAX = 45;

        while (readInput != true)
        {
            System.out.print("Would you like to buy a lotto ticket? [y/n] ");
            String stBuyTicket = keyboard.nextLine().trim().toLowerCase();

            if (stBuyTicket.isEmpty())
            {
                System.out.println("Invalid Input.");
            }
            else if (stBuyTicket.charAt(0) == 'y' || stBuyTicket.charAt(0) == 'n')
            {
                if (stBuyTicket.charAt(0) == 'y')
                {
                    checkPlay = true;
                }
                else
                {
                    checkPlay = false;                    
                }
                readInput = true;
            }
            else
            {
                System.out.println("Invalid Input.");
            }
        }        
        while (checkPlay == true)
        { 
            int[] lotto = new int[6];
            int lottoLength = lotto.length;
            int[] userLotto = new int[6];
            int userLottoLength = userLotto.length;
            for (int i = 0; i < lottoLength; i++)
            {
                boolean checkLotto = false;
                while (checkLotto != true)
                {  
                    int numCheck = (rand.nextInt(MAX) + 1);
                    boolean confirmSame = false;
                    for (int j = 0; j <= i; j++)
                    {
                        if (numCheck == lotto[j])
                        {
                            confirmSame = true;
                        }
                    }
                    if (confirmSame != true)
                    {
                        lotto[i] = numCheck;
                        checkLotto = true;                                               
                    }
                }
            }            
            readInput = false;
            while (readInput != true)
            {
                System.out.println("Would you like choose your own numbers or just randomize them?");
                System.out.print("Choose your own numbers? [y/n] ");            
                String stBuyTicket = keyboard.nextLine().trim().toLowerCase();
                if (stBuyTicket.isEmpty())
                {
                    System.out.println("Invalid Input.");
                }
                else if (stBuyTicket.charAt(0) == 'y' || stBuyTicket.charAt(0) == 'n')
                {
                    if (stBuyTicket.charAt(0) == 'y')
                    {
                        for (int i = 0; i < userLottoLength; i++)
                        {
                            boolean checkUserLotto = false;
                            while (checkUserLotto != true)
                            {
                                System.out.print("Which number would you like to choose for number " + (i + 1) + ": ");
                                String numUserInput = keyboard.nextLine().trim();

                                int numUserInputLength = numUserInput.length();
                                boolean checkInput = true;
                                if (numUserInputLength > 2 || numUserInputLength < 1)
                                {
                                    System.out.println("Invalid Input. Try again.");
                                    checkInput = false;
                                }
                                else
                                {
                                    for (int j = 0; j < numUserInputLength; j++)
                                    {
                                        if (Character.isDigit(numUserInput.charAt(j)) != true)
                                        {
                                            System.out.println("Invalid Input. Try again.");
                                            checkInput = false;
                                        }
                                    }
                                }
                                if (checkInput == true)
                                {
                                    int userInput = Integer.parseInt(numUserInput);
                                    if (userInput > MAX || userInput < 1)
                                    {
                                        System.out.println("Invalid Input. Try again.");
                                    }
                                    else
                                    {
                                        boolean confirmSame = false;
                                        for (int j = 0; j <= i; j++)
                                        {
                                            if (userInput == userLotto[j])
                                            {
                                                System.out.println("You've already choosen this number. Choose again.");
                                                confirmSame = true;
                                            }
                                        }
                                        if (confirmSame != true)
                                        {
                                            userLotto[i] = userInput;
                                            checkUserLotto = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        for (int i = 0; i < userLottoLength; i++)
                        {                            
                            boolean checkLotto = false;
                            while (checkLotto != true)
                            {  
                                int numCheck = (rand.nextInt(MAX) + 1);
                                boolean confirmSame = false;                                
                                for (int j = 0; j <= i; j++)
                                {
                                    if (numCheck == userLotto[j])
                                    {
                                        confirmSame = true;
                                    }
                                }
                                if (confirmSame != true)
                                {
                                    userLotto[i] = numCheck;
                                    checkLotto = true;                                               
                                }
                            }
                        } 
                    }
                    readInput = true;
                    System.out.print("Your lotto numbers are: " + userLotto[0]);
                    for (int i = 1; i < userLottoLength; i++)
                    {
                        System.out.print(", " + userLotto[i]);
                    }
                    System.out.print("!");
                    System.out.println();

                    System.out.print("And the winning lotto numbers are: " + lotto[0]);
                    for (int i = 1; i < lottoLength; i++)
                    {
                        System.out.print(", " + lotto[i]);
                    }
                    System.out.print("!");
                    System.out.println();

                    Arrays.sort(lotto);
                    Arrays.sort(userLotto);

                    if (Arrays.equals(userLotto, lotto) == true)
                    {
                        System.out.println("Your lotto numbers match the winning lotto numbers! \nYou win!");
                    }
                    else
                    {
                        System.out.println("Your lotto numbers do not match the winning lotto numbers. \nYou lose.");
                    }
                }
                else
                {
                    System.out.println("Invalid Input.");
                }
            }
            readInput = false;
            while (readInput != true)
            {
                System.out.print("Would you like to buy another lotto ticket? [y/n] ");
                String stBuyTicket = keyboard.nextLine().trim().toLowerCase();

                if (stBuyTicket.isEmpty())
                {
                    System.out.println("Invalid Input.");
                }
                else if (stBuyTicket.charAt(0) == 'y' || stBuyTicket.charAt(0) == 'n')
                {
                    if (stBuyTicket.charAt(0) == 'y')
                    {
                        checkPlay = true;
                    }
                    else
                    {
                        checkPlay = false;
                    }
                    readInput = true;
                }
                else
                {
                    System.out.println("Invalid Input.");
                }
            }
        }
        System.out.println("That's a good decision. Save your money");
        System.exit(0);
    }
}