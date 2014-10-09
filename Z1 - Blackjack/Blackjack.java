
/* A simple blackjack simulator
 * All coding provided by Eddie Gurnee
 * version 0.0.2
 */

import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*; // imports all input/output java

public class Blackjack
{
    public static void main(String [ ] args)
    {
        Scanner keyboard = new Scanner(System.in); // creates keyboard scanner
        Random rand = new Random(); // creates random

        int deck = 52;
        int cardsDrawn = 0;
        int suit = 0, value = 0;
        int money = 100, bet = 0;

        boolean[] cardsPlayed = new boolean [deck];
        for (int k = 0; k < deck; k++)
        {
            cardsPlayed[k] = false;
        }

        String[][] totalDeck = {
                {"Ace of", "Two of", "Three of", "Four of", "Five of", "Six of", "Seven of", "Eight of", "Nine of", "Ten of", "Jack of", "Queen of", "King of" },
                {" Spades", " Hearts", " Diamonds", " Clubs",}
            };

        System.out.print("Enter name: ");
        String name = keyboard.nextLine().trim();
        boolean gamePlay = true;
        while (gamePlay == true)
        {
            boolean checkHands = false;
            String stHands = null;
            while (checkHands != true)
            {
                System.out.print("How many hands do you want to play " + name + "? ");
                stHands = keyboard.nextLine().trim();

                int stHandsLength = stHands.length();
                boolean validInt = true;
                for (int m = 0; m < stHandsLength; m++)
                {                                
                    if (Character.isDigit(stHands.charAt(m)) != true)
                    {
                        System.out.println("Invalid Command.");
                        validInt = false;
                    }
                    else
                    {
                        checkHands = true;
                    }
                }
            }
            int hands = Integer.parseInt(stHands);
            for (int k = 0; k < hands; k++)
            {
                if (cardsDrawn > 26)
                {
                    System.out.println("Time to reshuffle the cards!");
                    for (int j = 0; j < deck; j++)
                    {
                        cardsPlayed[j] = false;
                    }
                    cardsDrawn = 0;
                }
                System.out.println("You have " + money + " money.");

                boolean moneyCheck = false;
                while (moneyCheck != true)
                {
                    String stBet = null;
                    boolean checkBet = false;
                    while (checkBet != true)
                    {
                        System.out.print("How much do you want to bet on this hand " + name + "? ");
                        stBet = keyboard.nextLine().trim();

                        int stBetLength = stBet.length();
                        boolean validInt = true;
                        for (int m = 0; m < stBetLength; m++)
                        {                                
                            if (Character.isDigit(stBet.charAt(m)) != true)
                            {
                                System.out.println("Invalid Input.");
                                validInt = false;
                            }
                            else
                            {
                                checkBet = true;
                            }
                        }
                    }
                    bet = Integer.parseInt(stBet);
                    if (bet > money)
                    {
                        System.out.println("I'm sorry, you seem to have already gambled away all that money.");
                    }
                    else
                    {
                        moneyCheck = true;
                    }                      
                }

                money = money - bet;
                
                System.out.println();
                System.out.println("Press enter to get dealt the cards.");
                String stCheckExit = keyboard.nextLine().trim().toLowerCase();
                if (stCheckExit.equals("quit") || stCheckExit.equals("exit"))
                {
                    System.exit(0);
                }
                else
                {
                }

                String[] playerCardsName = new String [7];            
                int[] playerCardsValue = new int [7];

                String[] dealerCardsName = new String [7];
                int[] dealerCardsValue = new int [7];

                int countPlayer = 0, countDealer = 0;
                int currentScore = 0, currentScoreAce = 0;
                int dealerScore = 0, dealerScoreAce = 0;

                int newDeckCheck = 0, shuffleLimit = 40;

                int finalScorePlayer = 0, finalScoreDealer = 0;

                boolean bust = false, dealerBust = false;

                boolean cardsDealt = false, playerRecieve = true;            
                while (cardsDealt != true)
                {                
                    boolean checkDeck = false;
                    newDeckCheck = 0;
                    while (checkDeck != true)
                    {
                        suit = rand.nextInt(4);
                        value = rand.nextInt(13);

                        int suitCheck = suit * 13;
                        int valueCheck = suitCheck + value;

                        if (cardsPlayed[valueCheck] != true)
                        {
                            cardsPlayed[valueCheck] = true;
                            cardsDrawn = cardsDrawn + 1;
                            checkDeck = true;
                        }
                        else
                        {
                            newDeckCheck++;
                        }
                        if (newDeckCheck > shuffleLimit)
                        {
                            for (int l = 0; l < deck; l++)
                            {
                                cardsPlayed[l] = false;
                            }
                            System.out.println("Time to reshuffle the cards!");
                            newDeckCheck = 0;
                        }
                    }
                    String cardName = totalDeck[0][value] + totalDeck[1][suit];
                    value = value + 1;
                    if (value > 10 && value <= 13)
                    {
                        value = 10;
                    }
                    if (playerRecieve == true)
                    {
                        playerRecieve = false;
                        System.out.println("You recieve " + cardName);

                        playerCardsName[countPlayer] = cardName;
                        playerCardsValue[countPlayer] = value;

                        countPlayer++;
                    }
                    else
                    {
                        System.out.println("Your opponent recieves a card.");

                        dealerCardsName[countDealer] = cardName;
                        dealerCardsValue[countDealer] = value;

                        countDealer++;
                        playerRecieve = true;

                        if (countDealer == 1)
                        {
                            System.out.println("Your opponent recieved a " + cardName);
                        }
                        else
                        {
                            System.out.println("Your opponent recieved a face down card.");
                            cardsDealt = true;
                        }                    
                    }
                    if (cardsDealt != true)
                    {
                        System.out.println("Press enter to deal the next card.");
                        stCheckExit = keyboard.nextLine().trim().toLowerCase();
                        if (stCheckExit.equals("quit") || stCheckExit.equals("exit"))
                        {
                            System.exit(0);
                        }
                        else
                        {
                        }
                    }
                    else
                    {
                        System.out.println("Press enter to begin play.");
                        stCheckExit = keyboard.nextLine().trim().toLowerCase();
                        if (stCheckExit.equals("quit") || stCheckExit.equals("exit"))
                        {
                            System.exit(0);
                        }
                        else
                        {
                        }
                    }
                }
                boolean gameOver = false, gotAce = false, bustAce = false, dealerGotAce = false, dealerBustAce = false;            
                while (gameOver != true)
                {
                    currentScore = 0;
                    currentScoreAce = 0;
                    gotAce = false;
                    bustAce = false;
                    for (int j = 0; j < countPlayer; j++)
                    {
                        currentScore = currentScore + playerCardsValue[j];
                        if (playerCardsValue[j] == 1 && gotAce != true)
                        {
                            currentScoreAce = currentScoreAce + 11;
                            gotAce = true;
                        }
                        else
                        {
                            currentScoreAce = currentScoreAce + playerCardsValue[j];
                        }
                    }
                    if (currentScoreAce > 21)
                    {
                        bustAce = true;
                    }
                    if (currentScore > 21)
                    {
                        bust = true;
                        gameOver = true;
                    }
                    else
                    {
                        System.out.print("With a " + playerCardsName[0]);
                        for (int j = 1; j < countPlayer; j++)
                        {
                            System.out.print(" and a " + playerCardsName[j]);
                        }
                        System.out.print(", you have a total of ");
                        if (gotAce == true && bustAce != true)
                        {
                            System.out.print(currentScoreAce);
                        }
                        else
                        {
                            System.out.print(currentScore);
                        }
                        System.out.print(" points.");
                        System.out.println();

                        boolean checkHitOrStand = false;
                        while (checkHitOrStand != true)
                        {
                            System.out.print("Do you want to hit or stand? [hit/stand] ");
                            String stHitOrStand = keyboard.nextLine().trim().toLowerCase();

                            if (stHitOrStand.isEmpty())
                            {
                                System.out.println("Invalid Command.");
                            }
                            else if (stHitOrStand.equals("hit") || stHitOrStand.equals("stand") || stHitOrStand.charAt(0) == 'h' || stHitOrStand.charAt(0) == 's')
                            {
                                if (stHitOrStand.equals("hit") || stHitOrStand.charAt(0) == 'h')
                                {
                                    boolean checkDeck = false;
                                    while (checkDeck != true)
                                    {
                                        suit = rand.nextInt(4);
                                        value = rand.nextInt(13);

                                        int suitCheck = suit * 13;
                                        int valueCheck = suitCheck + value;

                                        if (cardsPlayed[valueCheck] != true)
                                        {
                                            cardsPlayed[valueCheck] = true;
                                            cardsDrawn = cardsDrawn + 1;
                                            checkDeck = true;
                                        }
                                    }
                                    String cardName = totalDeck[0][value] + totalDeck[1][suit];
                                    value = value + 1;
                                    if (value > 10 && value <= 13)
                                    {
                                        value = 10;
                                    }

                                    System.out.println("You recieve " + cardName);

                                    playerCardsName[countPlayer] = cardName;
                                    playerCardsValue[countPlayer] = value;

                                    countPlayer++;
                                }
                                else
                                {
                                    System.out.print("You stand with a score of: ");
                                    if (gotAce == true && bustAce != true)
                                    {
                                        finalScorePlayer = currentScoreAce;
                                        System.out.print(currentScoreAce);
                                    }
                                    else
                                    {
                                        finalScorePlayer = currentScore;
                                        System.out.print(currentScore);
                                    }
                                    System.out.print(" points.");                                
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("The dealer flips over his card to reveal...");
                                    keyboard.nextLine();
                                    System.out.println("A " + dealerCardsName[1] + "!");                                    
                                    System.out.print("In addition to his " + dealerCardsName[0] + ",");
                                    System.out.print(" the dealer has ");

                                    dealerScore = 0;
                                    dealerScoreAce = 0;
                                    dealerGotAce = false;
                                    dealerBustAce = false;
                                    for (int j = 0; j < countDealer; j++)
                                    {
                                        dealerScore = dealerScore + dealerCardsValue[j];
                                        if (dealerCardsValue[j] == 1 && dealerGotAce != true)
                                        {
                                            dealerScoreAce = dealerScoreAce + 11;
                                            dealerGotAce = true;
                                        }
                                        else
                                        {
                                            dealerScoreAce = dealerScoreAce + dealerCardsValue[j];
                                        }
                                    }
                                    if (dealerGotAce == true && dealerScoreAce > 21)
                                    {
                                        dealerBustAce = true;
                                    }
                                    if (dealerGotAce == true && dealerBustAce != true)
                                    {
                                        System.out.print(dealerScoreAce);
                                    }
                                    else
                                    {
                                        System.out.print(dealerScore);
                                    }
                                    System.out.print(" points.");
                                    keyboard.nextLine();

                                    boolean dealerEndTurn = false, dealerTookHit = false;
                                    while (dealerEndTurn != true)
                                    {
                                        dealerScore = 0;
                                        dealerScoreAce = 0;
                                        dealerGotAce = false;
                                        dealerBustAce = false;
                                        for (int j = 0; j < countDealer; j++)
                                        {
                                            dealerScore = dealerScore + dealerCardsValue[j];
                                            if (dealerCardsValue[j] == 1 && dealerGotAce != true)
                                            {
                                                dealerScoreAce = dealerScoreAce + 11;
                                                dealerGotAce = true;
                                            }
                                            else
                                            {
                                                dealerScoreAce = dealerScoreAce + dealerCardsValue[j];
                                            }
                                        }
                                        if (dealerGotAce == true && dealerScoreAce > 21)
                                        {
                                            dealerBustAce = true;
                                        }
                                        if (dealerScore > 21)
                                        {
                                            dealerBust = true;
                                            dealerEndTurn = true;
                                            gameOver = true;
                                        }
                                        else
                                        {
                                            int testDealerScore;
                                            if (dealerGotAce == true && dealerBustAce != true)
                                            {
                                                testDealerScore = dealerScoreAce;
                                            }
                                            else
                                            {
                                                testDealerScore = dealerScore;
                                            }
                                            if (dealerTookHit == true)
                                            {
                                                System.out.println("The dealer now has a score of " + testDealerScore + ".");
                                            }
                                            if (testDealerScore > finalScorePlayer)
                                            {
                                                System.out.print("The dealer will NOW stand with a score of: ");
                                                if (dealerGotAce == true && bustAce != true)
                                                {
                                                    System.out.print(dealerScoreAce);
                                                }
                                                else
                                                {
                                                    System.out.print(dealerScore);
                                                }
                                                System.out.print(" points.");
                                                System.out.println();
                                                dealerEndTurn = true;
                                                gameOver = true;
                                            }
                                            else if (testDealerScore < 17 || (testDealerScore == 17 && dealerGotAce == true && dealerBustAce != true))
                                            {
                                                System.out.println("The dealer will take a hit");
                                                System.out.print("Press enter have him take a card");
                                                stCheckExit = keyboard.nextLine().trim().toLowerCase();
                                                if (stCheckExit.equals("quit") || stCheckExit.equals("exit"))
                                                {
                                                    System.exit(0);
                                                }
                                                else
                                                {
                                                }
                                                boolean checkDeck = false;
                                                while (checkDeck != true)
                                                {
                                                    suit = rand.nextInt(4);
                                                    value = rand.nextInt(13);

                                                    int suitCheck = suit * 13;
                                                    int valueCheck = suitCheck + value;

                                                    if (cardsPlayed[valueCheck] != true)
                                                    {
                                                        cardsPlayed[valueCheck] = true;
                                                        cardsDrawn = cardsDrawn + 1;
                                                        checkDeck = true;
                                                    }
                                                }
                                                String cardName = totalDeck[0][value] + totalDeck[1][suit];
                                                value = value + 1;
                                                if (value > 10 && value <= 13)
                                                {
                                                    value = 10;
                                                }
                                                dealerCardsName[countDealer] = cardName;
                                                dealerCardsValue[countDealer] = value;

                                                System.out.println("Your opponent recieves a " + dealerCardsName[countDealer] + ".");

                                                countDealer++;
                                                
                                                dealerTookHit = true;
                                            }
                                            else
                                            {
                                                System.out.print("The dealer will stand with a score of: ");
                                                if (dealerGotAce == true && bustAce != true)
                                                {
                                                    System.out.print(dealerScoreAce);
                                                }
                                                else
                                                {
                                                    System.out.print(dealerScore);
                                                }
                                                System.out.print(" points.");
                                                System.out.println();
                                                dealerEndTurn = true;
                                                gameOver = true;
                                            }
                                        }
                                    }
                                }
                                checkHitOrStand = true;
                            }
                            else
                            {
                                System.out.println("Invalid Command.");
                            }
                        }
                    }                    
                }
                if (bust == true)
                {
                    System.out.println("That's too bad! You bust!");
                    System.out.println("[You paid out your bet]");
                }
                else if (dealerBust == true)
                {
                    System.out.println("That's not too bad! The dealer bust!");
                    System.out.println("[You were paid out your bet]");
                    money = money + (bet * 2);
                }
                else
                {
                    currentScore = 0;
                    currentScoreAce = 0;
                    gotAce = false;
                    bustAce = false;
                    for (int j = 0; j < countPlayer; j++)
                    {
                        currentScore = currentScore + playerCardsValue[j];
                        if (playerCardsValue[j] == 1 && gotAce != true)
                        {
                            currentScoreAce = currentScoreAce + 11;
                            gotAce = true;
                        }
                        else
                        {
                            currentScoreAce = currentScoreAce + playerCardsValue[j];
                        }
                    }
                    if (currentScoreAce > 21)
                    {
                        bustAce = true;
                    }
                    if (gotAce == true && bustAce != true)
                    {
                        finalScorePlayer = currentScoreAce;
                    }
                    else
                    {
                        finalScorePlayer = currentScore;
                    }
                    dealerScore = 0;
                    dealerScoreAce = 0;
                    dealerGotAce = false;
                    dealerBustAce = false;
                    for (int j = 0; j < countDealer; j++)
                    {
                        dealerScore = dealerScore + dealerCardsValue[j];
                        if (dealerCardsValue[j] == 1 && dealerGotAce != true)
                        {
                            dealerScoreAce = dealerScoreAce + 11;
                            dealerGotAce = true;
                        }
                        else
                        {
                            dealerScoreAce = dealerScoreAce + dealerCardsValue[j];
                        }
                    }
                    if (dealerScoreAce > 21)
                    {
                        dealerBustAce = true;
                    }
                    if (dealerGotAce == true && dealerBustAce != true)
                    {
                        finalScoreDealer = dealerScoreAce;
                    }
                    else
                    {
                        finalScoreDealer = dealerScore;                    
                    }

                    System.out.println();
                    System.out.print("With a " + playerCardsName[0]);
                    for (int j = 1; j < countPlayer; j++)
                    {
                        System.out.print(" and a " + playerCardsName[j]);
                    }
                    System.out.print(", you have a total of " + finalScorePlayer + " points!");

                    System.out.println();
                    System.out.println();

                    System.out.print("With a " + dealerCardsName[0]);
                    for (int j = 1; j < countDealer; j++)
                    {
                        System.out.print(" and a " + dealerCardsName[j]);
                    }
                    System.out.print(", the dealer has a total of " + finalScoreDealer + " points!");
                    System.out.println();
                    keyboard.nextLine();

                    if (finalScorePlayer > finalScoreDealer)
                    {
                        System.out.println("Congradulations! You win!");
                        System.out.println("[You were paid out your bet]");
                        money = money + (bet * 2);
                    }
                    else if (finalScorePlayer < finalScoreDealer)
                    {
                        System.out.println("Condolences. You lose.");
                        System.out.println("[You paid out your bet]");                    
                    }
                    else
                    {
                        System.out.println("A tie. Really?!");
                        System.out.println("Lame");
                        System.out.println("[You got your bet money back]");
                        money = money + bet;
                    }                    
                }
                keyboard.nextLine();
            }
            if (money <= 0)
            {
                System.out.println("DAMN! You already lost all that money?! \nYou totally LOSE!");
                gamePlay = false;
                System.exit(0);
            }
            else
            {
                boolean checkNewGame = false;
                while (checkNewGame != true)
                {
                    System.out.print("Want to play another game? [y/n] ");
                    String stNewGame = keyboard.nextLine().trim().toLowerCase();

                    if (stNewGame.isEmpty())
                    {
                        System.out.println("Invalid Command.");
                    }
                    else if (stNewGame.charAt(0) == 'y' || stNewGame.charAt(0) == 'n')
                    {
                        if (stNewGame.charAt(0) == 'y')
                        {
                            checkNewGame = true;
                        }
                        else
                        {
                            gamePlay = false;
                            System.exit(0);
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Command.");
                    }
                }
            }
        }
    }    
}
