package intro.proj.p1.v3;


/* Contains all Post-Game Wrapup
 */
public class TheWrapUp
{
    public void run(CurrentUser theUser)
    {
        
        System.out.println("Game over!");
        System.out.println();

        if (theUser.getDebug())
        {
            boolean checkScoreDebug = false;
            while (checkScoreDebug != true)
            {
                System.out.print("Score Debug: [y/n] ");
                String stScoreDebug = keyboard.nextLine().trim().toLowerCase();

                if (stScoreDebug.isEmpty())
                {
                    System.out.println("Invalid Command.");
                }
                else if (stScoreDebug.charAt(0) == 'y' || stScoreDebug.charAt(0) == 'n')
                {
                    if (stScoreDebug.charAt(0) == 'y')
                    {
                        System.out.print("Enter days passed: ");
                        day = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Enter max gold: ");
                        maxGold = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Enter max minions: ");
                        maxMinions = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Enter number of Battles won: ");
                        numBattlesWon = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Enter number of Dragons killed: ");
                        numDragonKill = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    else
                    {
                    }
                    checkScoreDebug = true;
                }
                else
                {
                    System.out.println("Invalid Command.");
                }
            }
        }

        double score = (day * 4) + (maxGold) + (maxMinions * (3.333333333)) + (numBattlesWon * 5) + (numDragonKill * 20);
        score = (double)Math.round(score * 1000) /1000;

        System.out.println(customNames[1] + " " + name + ", by the end of your saga you had:");    
        if (day <= 1)
        {
            System.out.println("You didn't even survive the first day. \nThat sucks.");
        }
        else if (day > 1 && day < 25)
        {
            System.out.println("Survived for a total of " + day + " days");    
        }
        else
        {
            System.out.println("Survived for a total of " + day + " days \nBADASS!!");
        }
        if (maxGold >= 50)
        {
            System.out.println("Obtained a total of " + (maxGold - 5) + " new " + customNames[8] + " \nBADASS!!");
        }
        else if (maxGold <= 5)
        {
            System.out.println("You ended without obtaining any new " + customNames[8] + ". \nThat sucks.");
        }
        else
        {
            System.out.println("Obtained a total of " + (maxGold - 5) + " new " + customNames[8]);
        }
        if (maxMinions >= 20)
        {
            System.out.println(customNames[15] + " a total of " + (maxMinions - 7) + " new " + customNames[3] + " \nBADASS!!");
        }
        else if (maxMinions <= 7)
        {
            System.out.println("You never obtained any new " + customNames[3] + ". \nThat sucks.");
        }
        else if (maxMinions == 8)
        {
            System.out.println(customNames[15] + " only " + (maxMinions - 7) + " new " + customNames[3]);
        }
        else
        {
            System.out.println(customNames[15] + " a total of " + (maxMinions - 7) + " new " + customNames[3]);
        }
        if (numBattlesWon >= 15)
        {
            System.out.println("Defended from " + numBattlesWon + " attacks \nBADASS!!"); 
        }
        else if (numBattlesWon == 1)
        {
            System.out.println("Defended from " + numBattlesWon + " attack");
        }
        else if (numBattlesWon < 1)
        {
            System.out.println("You never sucessfully defended from any attacks. \nThat sucks.");
        }
        else
        {
            System.out.println("Defended from " + numBattlesWon + " attacks");
        }
        if (numDragonKill == 0)
        {

        }
        else if (numDragonKill == 1)
        {
            System.out.println("Managed to successfully defeat " + numDragonKill + " " + customNames[14]);
        }
        else if (numDragonKill < 7)
        {
            System.out.println("Managed to successfully defeat " + numDragonKill + " " + customNames[14]);
        }
        else
        {
            System.out.println("Managed to successfully defeat " + numDragonKill + " " + customNames[14] + " \nBADASS!!");
        }
        System.out.println();
        System.out.println("With all of that, your score was: " + score + ".");
        final int MAXSCORES = 11;
        HighScoreClass[] highScores = new HighScoreClass[MAXSCORES];
        for(int k = 0; k < MAXSCORES; k++ )
        {
            highScores[k] = new HighScoreClass();
        }        
        try
        {
            String fHScore = "HighScore.txt"; // file name of where the high scores are stored            
            Scanner inScore = new Scanner(new FileInputStream(fHScore));
            for (int k = 0; k < (MAXSCORES - 1); k++)
            {            
                highScores[k].scoreValue = inScore.nextInt(); // reads the high scores
            }        
            inScore.close();

            fHScore = "HighScoreName.txt";
            inScore = new Scanner(new FileInputStream(fHScore));
            for (int k = 0; k < (MAXSCORES - 1); k++)
            {            
                highScores[k].userName = inScore.nextLine(); // reads the high score name
            }
            inScore.close();      

            int newScore = (int)(score * 1000);
            if (newScore > highScores[0].scoreValue)
            {
                System.out.println("That is a new high score! \nCongradulations!!");
                highScores[MAXSCORES-1].scoreValue = newScore;
                highScores[MAXSCORES-1].userName = name;

                Arrays.sort(highScores);

                HighScoreClass[] newHighScores = new HighScoreClass[MAXSCORES - 1];
                for(int k = 0; k < (MAXSCORES - 1); k++ )
                {
                    newHighScores[k] = new HighScoreClass();
                }                

                fHScore = "HighScore.txt";
                PrintWriter outScore = new PrintWriter(new FileOutputStream(fHScore));
                for (int k = 0; k < (MAXSCORES - 1); k++)
                {
                    newHighScores[k].scoreValue = highScores[k+1].scoreValue;                
                    outScore.println(newHighScores[k].scoreValue);
                }
                outScore.close();

                fHScore = "HighScoreName.txt";
                outScore = new PrintWriter(new FileOutputStream(fHScore));
                for (int k = 0; k < (MAXSCORES - 1); k++)
                {
                    newHighScores[k].userName = highScores[k+1].userName;                
                    outScore.println(newHighScores[k].userName);
                }
                outScore.close();

                System.out.println();
                boolean checkScore = false;
                for (int k = 0; checkScore != true; k++)
                {
                    int numScore = newHighScores[k].scoreValue;
                    if (numScore == newScore)
                    {
                        System.out.println("Your score is number " + (10 - k) + " on the high score list!");
                        checkScore = true;
                    }
                    else
                    {
                    }
                }
            }
            fHScore = "HighScore.txt"; // file name of where the high scores are stored            
            inScore = new Scanner(new FileInputStream(fHScore));
            for (int k = 0; k < (MAXSCORES - 1); k++)
            {            
                highScores[k].scoreValue = inScore.nextInt(); // reads the high scores
            }        
            inScore.close();

            fHScore = "HighScoreName.txt";
            inScore = new Scanner(new FileInputStream(fHScore));
            for (int k = 0; k < (MAXSCORES - 1); k++)
            {            
                highScores[k].userName = inScore.nextLine(); // reads the high score name
            }
            inScore.close();

            keyboard.nextLine();

            System.out.println("The current High Score List is:");
            for (int k = 0; k < (MAXSCORES - 1); k++)
            {
                System.out.println("#" + (10 - k) + ". " + highScores[k].scoreValue + " - " + highScores[k].userName);
            }
        }
        catch (Exception e)  // if exception thrown from "try"
        { 
            System.out.println("Error in high score writing.");
            System.exit(0);    // terminate program
        }
    }
}
