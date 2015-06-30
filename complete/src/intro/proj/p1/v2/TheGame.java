package intro.proj.p1.v2;


/* It's a game.
 * All coding provided by Eddie Gurnee
 * version 0.1.9
 */

import javax.swing.*; // imports swing
import java.io.*; // imports all input/output java
import java.util.Comparator; // imports comparator
import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays

public class TheGame
{
    public void run()
    {
        Scanner keyboard = new Scanner(System.in); // creates keyboard scanner       
        Random rand = new Random(); // creates random

        int numMinions = 7, gold = 5; // defines starting variables (gold & minions)

        int defendBonus = 0, gatherBonus = 0, recruitBonus = 0, luck = 0; // defines premanent nighttime variables
        int oldNumMinions = 0; // defines temporary nighttime variables
        boolean autoResetJobs = false; // option variable

        int defend = 0, gather = 0, recruit = 0; // defines daytime variables
        boolean fullMinions = false; // another daytime variable

        int difficulty = 1; // normal difficulty setting
        char confirm = 'y', deny = 'n'; // allows editing confirm/deny keys 

        int day = 1, maxGold = 0, maxMinions = 0, numDragonKill = 0, numBattlesWon = 0, itemsFound = 0; // defines scoring variables
        boolean runGame = true; // defines the check to run the game

        final int CUSTOMLENGTH = 17; // sets int to establish array length 
        String[] customNames = new  String [CUSTOMLENGTH]; // defines custom name array

        String name = null;

        String fSave = "saveGame.txt";
        String fLoad = "saveGame.txt";
        String fName = null;
        final int NUMARRAYS = 4;
        final int NUMPERARRAY = 13;
        String[][] loadGame = new String [NUMARRAYS][NUMPERARRAY];
        String[][] saveGame = new String [NUMARRAYS][NUMPERARRAY];

        saveGame[0][0] = "13";
        saveGame[1][0] = "3";
        saveGame[2][0] = "3";
        saveGame[3][0] = "3";

        String [][] variableNames = {
                {"numInArrayInt", "numMinions", "gold", 
                    "defendBonus", "gatherBonus", "luck", 
                    "day", "maxGold", "maxMinions", "numDragonKill", 
                    "numBattlesWon", "itemsFound", "difficulty"},
                {"numInArrayString", "name", "fName"},
                {"numInArrayChar", "confirm", "deny"},
                {"numInArrayBoolean", "debug", "male"}
            };

        boolean male = true; // checks if user is male or not
        boolean debug = false; // allows for debugging options
        boolean debugCheckedOnce = false; 
        boolean loading = false; // allows for loading save games

        // check for existing text files
        String[] fileNames = {"00example.txt", "01protoss.txt", 
                "02dwarf.txt", "03chiss.txt", "04undead.txt", 
                "05goblin.txt", "06demon.txt", "07robot.txt", 
                "08pirate.txt", "09ninja.txt", "10cultist.txt",
                "99basic.txt", "100customNames.txt", "HighScore.txt", "HighScoreName.txt"};
        for (int k = 0; k < fileNames.length; k++)
        {
            File f = new File(fileNames[k]);
            if (!f.exists())
            {
                try
                {
                    String fCopy = fileNames[k];

                    InputStream stream = TheGame.class.getResourceAsStream(fCopy);        
                    Scanner inLoad = new Scanner(stream);

                    PrintWriter outCustom = new PrintWriter(new FileOutputStream(fCopy));
                    while (inLoad.hasNextLine())
                    {
                        String str = inLoad.nextLine();
                        outCustom.println(str);
                    }
                    stream.close();
                    outCustom.close();
                }
                catch (Exception e)
                {
                    System.out.println("Creating Host Files Error.");
                    System.exit(0);
                }
            }
        }

        System.out.println("Fortress Manager!");
        System.out.println("Press Enter to Start!");

        boolean startGame = false;
        while (!startGame)
        {
            String stCheckDebug = keyboard.nextLine().trim().toLowerCase();
            if (stCheckDebug.isEmpty())
            {
                startGame = true;
            }
            else if (stCheckDebug.equals("debug"))
            {
                startGame = true;
                String debugExtraCheck = (String)               // user choice received here
                    JOptionPane.showInputDialog
                    (null,                           // current frame
                        null,  // prompt
                        null,                   // title
                        JOptionPane.PLAIN_MESSAGE,
                        null,                        // path to alternate icon
                        null,                        // items in drop-down
                        "");                   // default choice (can be null)
                if (debugExtraCheck.equals("deBUG"))
                {
                    debug = true;
                    System.out.println("Debug enabled.");
                }
            }
            else if (stCheckDebug.equals("load") || stCheckDebug.equals("loadgame") || stCheckDebug.equals("load game"))
            {
                loading = true;
                startGame = true;
            }
            else if (stCheckDebug.equals("hello world"))
            {
                System.out.println("Oh, I'm sorry, you are looking at the wrong program.");
                System.out.println("Please open some other boring program.");
                System.out.println("This one is too badass for that.");
                keyboard.nextLine();
                System.exit(0);
            }
            else
            {
            }
        }
        if (loading)
        {
            boolean checkLoadGame = false;
            while (!checkLoadGame)
            {
                System.out.print("Would you like to load the previous save file? [" + confirm + "/" + deny + "] ");
                String stLoadGame = keyboard.nextLine().trim().toLowerCase();

                if (stLoadGame.isEmpty())
                {
                }
                else if (stLoadGame.charAt(0) == confirm || stLoadGame.charAt(0) == deny)
                {
                    if (stLoadGame.charAt(0) == confirm)
                    {
                        int[] loadLimit = new int[4];
                        fLoad = "saveGame.txt";

                        int loadLocationChoice = JOptionPane.showConfirmDialog
                            ( null, 
                                "Would you like to load from a file besides " + fLoad + "?", 
                                null, 
                                JOptionPane.YES_NO_OPTION);

                        if (loadLocationChoice == 0)
                        {                                            
                            String newLoadLocation = (String)              // user choice received here
                                JOptionPane.showInputDialog
                                (null,                                       // current frame
                                    "Name new load location:",          // prompt
                                    null,  // title
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,                          // path to alternate icon
                                    null,                          // items in drop-down
                                    null);                         // default choice

                            fLoad = (newLoadLocation + ".txt");
                        }
                        boolean confirmLocationFail = false, confirmLocation = false;
                        while (!confirmLocation)
                        {
                            confirmLocationFail = false;
                            try
                            {
                                Scanner inLoad = new Scanner(new FileInputStream(fLoad));
                                for (int k = 0; k < NUMARRAYS; k++)
                                {
                                    loadLimit[k] = Integer.parseInt(inLoad.nextLine());
                                    for (int j = 1; j < loadLimit[k]; j++)
                                    {
                                        loadGame[k][j] = inLoad.nextLine().trim();
                                    }
                                }
                                inLoad.close();
                            }
                            catch (Exception e)
                            {
                                confirmLocationFail = true;
                                int loadLoadRetryChoice = JOptionPane.showConfirmDialog
                                    ( null, 
                                        "Error loading from file location, would you like to try to load from another location?", 
                                        null, 
                                        JOptionPane.YES_NO_OPTION);

                                if (loadLoadRetryChoice == 0)
                                {
                                    String newLoadLocation = (String)              // user choice received here
                                        JOptionPane.showInputDialog
                                        (null,                                       // current frame
                                            "Name new load location, remember: \n-\".txt\" files only \n-Do not include the \".txt\" \n-Capitalization does not matter:",          // prompt
                                            null,  // title
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,                          // path to alternate icon
                                            null,                          // items in drop-down
                                            null);                         // default choice

                                    fLoad = (newLoadLocation + ".txt");
                                }
                                else
                                {
                                    System.exit(0);
                                }
                            }
                            if (!confirmLocationFail)
                            {
                                confirmLocation = true;
                            }
                        }
                        for (int k = 0; k < NUMARRAYS; k++)
                        {
                            for (int j = 1; j < loadLimit[k]; j++)
                            {
                                if (variableNames[k][j].equals("numMinions"))
                                {
                                    numMinions = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("gold"))
                                {
                                    gold = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("defendBonus"))
                                {
                                    defendBonus = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("gatherBonus"))
                                {
                                    gatherBonus = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("luck"))
                                {
                                    luck = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("day"))
                                {
                                    day = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("maxMinions"))
                                {
                                    maxMinions = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("maxGold"))
                                {
                                    maxGold = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("numDragonKill"))
                                {
                                    numDragonKill = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("numBattlesWon"))
                                {
                                    numBattlesWon = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("itemsFound"))
                                {
                                    itemsFound = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("difficulty"))
                                {
                                    difficulty = Integer.parseInt(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("name"))
                                {
                                    name = loadGame[k][j];
                                }
                                else if (variableNames[k][j].equals("fName"))
                                {
                                    fName = loadGame[k][j];
                                }
                                else if (variableNames[k][j].equals("confirm"))
                                {
                                    confirm = loadGame[k][j].charAt(0);
                                }
                                else if (variableNames[k][j].equals("deny"))
                                {
                                    deny = loadGame[k][j].charAt(0);
                                }
                                else if (variableNames[k][j].equals("debug"))
                                {
                                    debug = Boolean.parseBoolean(loadGame[k][j]);
                                }
                                else if (variableNames[k][j].equals("male"))
                                {
                                    male = Boolean.parseBoolean(loadGame[k][j]);
                                }
                            }
                        }
                        try
                        {
                            Scanner inName = new Scanner(new FileInputStream(fName));

                            for (int k = 0; k < CUSTOMLENGTH; k++)
                            {
                                customNames[k] = inName.nextLine();                
                            }
                            inName.close();
                        }
                        catch (Exception e)
                        {
                            System.out.println("Error loading race names.");
                            System.exit(0);
                        }
                        if (customNames[1].equals("null"))
                        {
                            if (male)
                            {
                                customNames[1] = "Lord";                                
                            }
                            else
                            {
                                customNames[1] = "Lady";
                            }
                        }
                        System.out.println();                        
                        System.out.println("Welcome back, " + customNames[1] + " " + name + ".");                        
                    }
                    else
                    {
                        loading = false;
                    }
                    checkLoadGame = true;
                }
                else
                {
                    System.out.println("Invalid Command.");
                }
            }            
        }
        if (!loading)
        {
            boolean createName = false;
            for (int k = 0; createName != true; k++)
            {
                System.out.print("Enter Name: "); 
                name = keyboard.nextLine().trim(); // reads in username            
                if (name.isEmpty())
                {
                    if (k == 7)
                    {
                        System.out.println("Name Accepted! \nYou shall henceforth be known as Shitsipper.");
                        name = "Shitsipper";
                        createName = true;
                        keyboard.nextLine();
                    }
                }
                else
                {
                    createName = true;
                }
            }

            String checkName = name.toLowerCase(); // new variable checkName is all lowercase to compare against custom user names
            if (checkName.equals("eddie"))
            {
                debug = true;
            }
            else if (checkName.equals("quit"))
            {
                System.exit(0);
            }
            else
            {
                boolean checkGender = true;
                if (checkName.equals("tassadar"))
                {
                    fName = "01protoss.txt";
                    name = "Tassadar";
                }
                else if (checkName.equals("thorin"))
                {
                    fName = "02dwarf.txt";
                    name = "Thorin Oakenshield";
                }
                else if (checkName.equals("thrawn"))
                {
                    fName = "03chiss.txt";
                    name = "Commander Mitth'raw'nuruodo";
                }                
                else 
                {                
                    if (checkName.equals("mike") || checkName.equals("bill"))
                    {
                        boolean checkDebug = false;
                        while (!checkDebug)
                        {
                            System.out.print("Would you like to enable debug mode? [" + confirm + "/" + deny + "] ");
                            String stCheckDebug = keyboard.nextLine().trim().toLowerCase();

                            if (stCheckDebug.isEmpty())
                            {
                            }
                            else if (stCheckDebug.charAt(0) == confirm || stCheckDebug.charAt(0) == deny)
                            {
                                if (stCheckDebug.charAt(0) == confirm)
                                {
                                    debug = true;
                                    System.out.println("Debug Mode enabled.");
                                }
                                checkDebug = true;
                            }
                            else
                            {
                                System.out.println("Invalid Command.");
                            }
                        }
                    }
                    checkGender = false;
                    fName = "99basic.txt";
                }
                try
                {
                    Scanner inName = new Scanner(new FileInputStream(fName));
                    for (int k = 0; k < CUSTOMLENGTH; k++)
                    {
                        customNames[k] = inName.nextLine();                
                    }
                    inName.close();

                    while (!checkGender)
                    {
                        System.out.print("Are you a male or female? [m/f] ");
                        String str = keyboard.nextLine().trim().toLowerCase();
                        if (str.isEmpty())
                        {                            
                        }
                        else if (str.charAt(0) != 'm' && str.charAt(0) != 'f')
                        {
                            System.out.println("Invalid Input.");
                        }
                        else
                        {
                            if (str.charAt(0) == 'm')
                            {
                                customNames[1] = "Lord";
                                male = true;
                            }
                            else
                            {
                                customNames[1] = "Lady";
                                male = false;
                            }
                            checkGender = true;
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Error loading race names.");
                    System.exit(0);
                }
                boolean firstTimeCheck = false;
                while (!firstTimeCheck)
                {
                    System.out.print("Is this your first time playing? [" + confirm + "/" + deny + "] ");
                    String firstTime = keyboard.nextLine();  // checks for first time players
                    if (firstTime.isEmpty())
                    {
                    }
                    else if (firstTime.charAt(0) == confirm || firstTime.charAt(0) == deny) // if first time, displays storyline
                    {
                        if (firstTime.charAt(0) == confirm)
                        {
                            System.out.println();
                            System.out.println("Well then let me tell you the basics...");
                            System.out.println("The point of this game is to survive.");
                            System.out.println("You begin the game as a leader of of a small");
                            System.out.println("group of seven dedicated followers");
                            System.out.println("(known in this game as " + customNames[3] + ")");
                            System.out.println("managing their movements throughout the days.");
                            System.out.println("If all of your " + customNames[3] + " die, the game is over!");
                            boolean learnCommands = false;                
                            while (!learnCommands)
                            {
                                System.out.print("Would you like to see the commands? [" + confirm + "/" + deny + "] ");
                                String checkLearnCommands = keyboard.nextLine().trim().toLowerCase(); // checks to learn the commands

                                if (checkLearnCommands.isEmpty()) // if yes, shows commands
                                {
                                }
                                else if (checkLearnCommands.charAt(0) == confirm || checkLearnCommands.charAt(0) == deny)
                                {
                                    if (checkLearnCommands.charAt(0) == confirm)
                                    {
                                        System.out.println("Press 'd' to set " + customNames[4] + ".");
                                        System.out.println("Press 'g' to set " + customNames[5] + ".");
                                        System.out.println("Press 'r' to set " + customNames[6] + ".");
                                        System.out.println("Press 's' to see economic status.");
                                        System.out.println("Press 'm' to see reset " + customNames[3] + " distribution.");
                                        System.out.println("Press 'e' to end the day.");
                                        System.out.println("Press 'o' to access options.");
                                        System.out.println("Press 'q' to quit game.");
                                    }
                                    else
                                    {
                                    }
                                    learnCommands = true;
                                }
                                else
                                {
                                    System.out.println("Invalid Command.");
                                }
                            }
                        }
                        else
                        {
                        }
                        firstTimeCheck = true;
                    }
                    else
                    {
                        System.out.println("Invalid Command.");
                    }                
                }
            }
            if (debug)
            {
                boolean checkCustomNames = false;
                while (!checkCustomNames)
                {
                    System.out.print("Would you like to enter custom system names? [" + confirm + "/" + deny + "] ");
                    String stCheckCustomNames = keyboard.nextLine().trim().toLowerCase();

                    if (stCheckCustomNames.isEmpty())
                    {
                    }
                    else if (stCheckCustomNames.charAt(0) == confirm || stCheckCustomNames.charAt(0) == deny)
                    {
                        if (stCheckCustomNames.charAt(0) == confirm)
                        {
                            boolean checkCustomLoad = false;
                            while (!checkCustomLoad)
                            {
                                System.out.print("Would you like to load a specific custom name file? [" + confirm + "/" + deny + "] ");
                                String stCheckCustomLoad = keyboard.nextLine().trim().toLowerCase();

                                if (stCheckCustomLoad.isEmpty())
                                {
                                }
                                else if (stCheckCustomLoad.charAt(0) == confirm || stCheckCustomLoad.charAt(0) == deny)
                                {
                                    if (stCheckCustomLoad.charAt(0) == confirm)
                                    {                                       
                                        boolean confirmCustomLoad = false;
                                        while (!confirmCustomLoad)
                                        {
                                            System.out.print("Enter complete file name (including \".txt\"): ");
                                            fName = keyboard.nextLine().trim();

                                            int fNameLength = fName.length();
                                            String fNameFE = fName.substring(fName.length() - 4);
                                            if (fName.isEmpty())
                                            {
                                            }
                                            else if (!fNameFE.equals(".txt"))
                                            {                                                
                                                System.out.println("Improper format.");
                                            }
                                            else
                                            {  
                                                checkCustomLoad = true;
                                            }
                                        }
                                    }
                                    else
                                    { 
                                        System.out.print("Enter Custom User Name: ");
                                        name = keyboard.nextLine().trim();
                                        // creates a complete custom set of system names
                                        try
                                        {
                                            String fCustom = "100customNames.txt";
                                            fName = "00example.txt";
                                            String [][] exampleCustom = new String [CUSTOMLENGTH][CUSTOMLENGTH];

                                            Scanner inName = new Scanner(new FileInputStream(fName));
                                            PrintWriter outCustom = new PrintWriter(new FileOutputStream(fCustom));
                                            for (int k = 0; k < CUSTOMLENGTH; k++)
                                            {
                                                exampleCustom[0][k] = inName.nextLine();
                                                boolean checkCustom = false;
                                                while (!checkCustom)
                                                {
                                                    System.out.print("Enter custom name for \"" + exampleCustom[0][k] + "\": ");                                                
                                                    exampleCustom[1][k] = keyboard.nextLine().trim();
                                                    if (exampleCustom[1][k].isEmpty())
                                                    {
                                                    }
                                                    else
                                                    {
                                                        outCustom.println(exampleCustom[1][k]);
                                                        checkCustom = true;
                                                    }
                                                }
                                            }                                                
                                            outCustom.close();
                                            inName.close();                                            
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println("Error writing custom race names.");
                                            System.exit(0);
                                        }
                                        fName = "100customNames.txt";
                                    }                                    
                                    try
                                    {
                                        // loads custom names
                                        Scanner inName = new Scanner(new FileInputStream(fName));

                                        for (int k = 0; k < CUSTOMLENGTH; k++)
                                        {
                                            customNames[k] = inName.nextLine();
                                        }
                                        inName.close();
                                        System.out.println("Custom names loaded from " + fName);
                                    }
                                    catch (Exception e)
                                    {
                                        System.out.println("Error reading custom race names.");
                                        System.exit(0);
                                    }
                                    checkCustomLoad = true;
                                }
                                else
                                {
                                    System.out.println("Invalid Command.");
                                }
                            }
                        }
                        else
                        {
                        }
                        checkCustomNames = true;
                    }
                    else
                    {
                        System.out.println("Invalid Command.");
                    }
                }
            }

            System.out.println();
            System.out.println("Welcome " + customNames[1] + " " + name + ", to your new " + customNames[2] + ".");            
        }
        System.out.println("__________________________________________");
        keyboard.nextLine();

        System.out.println("If at anytime you need to see the command"); // informs how to see commands
        System.out.println("choices, just enter 'h' or '?'");
        keyboard.nextLine();

        System.out.print(customNames[1] + " " + name + " your " + customNames[3] + " await");
        if (!customNames[0].equals("null"))
        {
            System.out.print(", \n" + customNames[0]);
        }        
        System.out.println("!");

        System.out.println("__________________________________________");

        while (runGame) // while runGame is true, run the game; for each game period, add one day
        {
            System.out.println();
            System.out.println("Press Enter to start Day " + day + ", " + customNames[1] + " " + name + ".");           
            keyboard.nextLine();

            boolean endDay = false, checkMinions = false ; // defines endDay
            if (debug)
            {
                boolean checkStartDayDebug = false;
                while (!checkStartDayDebug)
                {
                    System.out.print("Adjust " + customNames[8] + " and " + customNames[3] + " values?  [" + confirm + "/" + deny + "] ");
                    String stStartDayDebug = keyboard.nextLine().trim().toLowerCase();
                    if (stStartDayDebug.isEmpty())
                    {
                    }
                    else if (stStartDayDebug.charAt(0) == confirm || stStartDayDebug.charAt(0) == deny)
                    {
                        if (stStartDayDebug.charAt(0) == confirm)
                        {
                            System.out.print("Value for " + customNames[8] + ":");
                            gold = keyboard.nextInt();
                            keyboard.nextLine();

                            System.out.print("Value for " + customNames[3] + ":");
                            numMinions = keyboard.nextInt();
                            keyboard.nextLine();

                            boolean checkStartDayDebug2 = false;
                            while (!checkStartDayDebug2)
                            {
                                System.out.print("Adjust current number of " + customNames[4] + ", " + customNames[5] + ", and " + customNames[6] + " values?  [" + confirm + "/" + deny + "] ");
                                String stStartDayDebug2 = keyboard.nextLine().trim().toLowerCase();
                                if (stStartDayDebug2.isEmpty())
                                {
                                }
                                else if (stStartDayDebug2.charAt(0) == confirm || stStartDayDebug2.charAt(0) == deny)
                                {
                                    if (stStartDayDebug2.charAt(0) == confirm)
                                    {
                                        System.out.print("Value for " + customNames[4] + ":");
                                        defend = keyboard.nextInt();
                                        keyboard.nextLine();

                                        System.out.print("Value for " + customNames[5] + ":");
                                        gather = keyboard.nextInt();
                                        keyboard.nextLine();

                                        System.out.print("Value for " + customNames[6] + ":");
                                        recruit = keyboard.nextInt();
                                        keyboard.nextLine();
                                    }
                                    else
                                    {
                                    }
                                    checkStartDayDebug2 = true;
                                }
                                else
                                {
                                    System.out.println("Invalid Command.");
                                }
                            }
                        }
                        else
                        {
                        }
                        checkStartDayDebug = true;
                    }
                    else
                    {
                        System.out.println("Invalid Command.");
                    }
                }
            }

            if (autoResetJobs)
            {
                defend = 0;
                gather = 0;
                recruit = 0;
                fullMinions = false;
            }
            else
            {
                if (day > 1 && oldNumMinions == numMinions) // on days later than day 1 and where no one died or was recruited the day before
                {
                    while (!checkMinions)
                    {
                        System.out.println("Would you like to keep the same number ");
                        System.out.print("of " + customNames[4] + ", " + customNames[5] + ", and " + customNames[6] + " as yesterday? [" + confirm + "/" + deny + "] "); // checks if user wants to keep same number of defenders, gatherers, and recruiters
                        String sameWork = keyboard.nextLine().trim().toLowerCase(); // defines question exclusive variable
                        if (sameWork.isEmpty() || sameWork.charAt(0) == confirm || sameWork.charAt(0) == deny)
                        {                    
                            if (sameWork.isEmpty() || sameWork.charAt(0) == confirm)
                            {
                                System.out.println();

                                boolean checkEndDay = false;
                                while (!checkEndDay)
                                {
                                    System.out.print("Would you like to end the day? [" + confirm + "/" + deny + "] "); // checks if the user wants to end the day
                                    String checkEnd = keyboard.nextLine().trim().toLowerCase(); // defines question exclusive variable
                                    if (checkEnd.isEmpty() || checkEnd.charAt(0) == confirm || checkEnd.charAt(0) == deny)
                                    {
                                        if (checkEnd.isEmpty() || checkEnd.charAt(0) == confirm)
                                        {
                                            endDay = true; // ends the day
                                        }
                                        else
                                        {
                                        }
                                        checkEndDay = true;
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Command.");
                                    }
                                }
                            }
                            checkMinions = true;
                        }
                        else
                        {
                            System.out.println("Invalid Command.");
                        }
                    }
                }
                else if (oldNumMinions != numMinions) // will reset defenders, gatherers, and recruiters if someone died
                {
                    fullMinions = false;
                }
            }
            while (endDay != true && runGame == true) // daytime of the game, assigns minions to various actions
            {
                System.out.print("What is your command? ");
                String stCommand = keyboard.nextLine().trim().toLowerCase();  // defines the command selector
                if (stCommand.isEmpty())
                {
                }                
                else
                {
                    char command = stCommand.charAt(0);
                    if (command == 'd' || command == 'g' || command == 'r') // if 'd', 'g', or 'r' is pressed set/add defenders, gatherers, or recruiters
                    {                        
                        String customNamesDGR = null;
                        fullMinions = false;
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
                        // stAorS = null;
                        boolean checkAddOrSet = false;
                        while (!checkAddOrSet)
                        {
                            System.out.print("Do you want to add " + customNamesDGR + ", or set total " + customNamesDGR + "? [add/set] ");
                            String stAddOrSet = keyboard.nextLine().trim().toLowerCase();
                            if (stAddOrSet.isEmpty())
                            {
                            }
                            else if (stAddOrSet.equals("add") || stAddOrSet.equals("set") || (stAddOrSet.charAt(0) == confirm && !stAddOrSet.equals("set")) || (stAddOrSet.charAt(0) == deny && !stAddOrSet.equals("add")))
                            {
                                if (stAddOrSet.charAt(0) == confirm && !stAddOrSet.equals("set"))
                                {
                                    stAddOrSet = "add";
                                }
                                else if ((stAddOrSet.charAt(0) == deny && !stAddOrSet.equals("add")))
                                {
                                    stAddOrSet = "set";
                                }
                                boolean checkDGR = false;
                                while (!checkDGR)
                                {
                                    stAddOrSet = stAddOrSet.substring(0, 1).toUpperCase() + stAddOrSet.substring(1);
                                    System.out.print(stAddOrSet + " how many " + customNamesDGR + "? ");
                                    String stTempDGR = keyboard.next().trim();
                                    keyboard.nextLine();
                                    boolean validDGR = true;
                                    int tempDGR = 0;
                                    if (stTempDGR.isEmpty())
                                    {
                                    }
                                    else if(stTempDGR.charAt(0) == 'q')
                                    {
                                        validDGR = false;
                                        checkDGR = true;
                                    }
                                    else if (stTempDGR.equals("max") || stTempDGR.charAt(0) == 'm')
                                    {
                                        tempDGR = numMinions - other1 - other2;
                                    }
                                    else
                                    {
                                        int stTempDGRLength = stTempDGR.length();
                                        for (int k = 0; k < stTempDGRLength; k++)
                                        {                                
                                            if (Character.isDigit(stTempDGR.charAt(k)) != true)
                                            {                                            
                                                validDGR = false;
                                            }
                                        }
                                        if (!validDGR)
                                        {
                                            System.out.println("Invalid Command.");
                                        }
                                        else
                                        {
                                            tempDGR = Integer.parseInt(stTempDGR);
                                        }
                                    }

                                    if (validDGR)
                                    {                                                                                        
                                        stAddOrSet = stAddOrSet.toLowerCase();
                                        int compareDGR = 0;

                                        if (stAddOrSet.equals("add"))
                                        {
                                            compareDGR = (tempDGR + defend + gather + recruit);
                                        }
                                        else if (stAddOrSet.equals("set"))
                                        {
                                            compareDGR = (tempDGR + other1 + other2);
                                        }
                                        if (compareDGR > numMinions)
                                        {
                                            System.out.println();
                                            System.out.println("Error!");
                                            System.out.println("You don't have enough " + customNames[3] + " to do that.");
                                            System.out.println("Press 'm' to reset " + customNames[3] + " distribution.");
                                            System.out.println("Or press 's' to see where they are distributed.");
                                        }
                                        else
                                        {
                                            boolean confirmDGR = false;
                                            while (!confirmDGR)
                                            {
                                                System.out.print("Confirm " + stAddOrSet);
                                                if (stAddOrSet.equals("set"))
                                                {
                                                    System.out.print("t");
                                                }
                                                System.out.print("ing " + tempDGR + " " + customNamesDGR + "? [" + confirm + "/" + deny + "] ");
                                                String stConfirmDGR = keyboard.nextLine().trim().toLowerCase();
                                                if (stConfirmDGR.isEmpty())
                                                {
                                                }
                                                else if (stConfirmDGR.charAt(0) == confirm || stConfirmDGR.charAt(0) == deny)
                                                {
                                                    if (stConfirmDGR.charAt(0) == confirm)
                                                    { 
                                                        if (stAddOrSet.equals("add"))
                                                        {
                                                            if (command == 'd')
                                                            {
                                                                defend = defend + tempDGR;
                                                            }
                                                            else if (command == 'g')
                                                            {
                                                                gather = gather + tempDGR;
                                                            }
                                                            else if (command == 'r')
                                                            {
                                                                recruit = recruit + tempDGR;
                                                            }
                                                        }
                                                        else if (stAddOrSet.equals("set"))
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
                                                        }
                                                        System.out.print(tempDGR + " " + customNamesDGR + " " + stAddOrSet);
                                                        if (stAddOrSet.equals("add"))
                                                        {
                                                            System.out.print("ed. You now have ");
                                                            if (command == 'd')
                                                            {
                                                                System.out.print(defend);
                                                            }
                                                            else if (command == 'g')
                                                            {
                                                                System.out.print(gather);
                                                            }
                                                            else if (command == 'r')
                                                            {
                                                                System.out.print(recruit);
                                                            }
                                                            System.out.println(" " + customNamesDGR + " prepared for the night.");
                                                        }
                                                        else
                                                        {
                                                            System.out.println(".");
                                                        }
                                                    }
                                                    else
                                                    {
                                                    }
                                                    confirmDGR = true;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid Command.");
                                                }
                                            }
                                        }
                                        checkDGR = true;
                                    }
                                }
                                checkAddOrSet = true;
                            }
                            else if(stAddOrSet.charAt(0) == 'q')
                            {
                                checkAddOrSet = true;
                            }
                            else
                            {
                                System.out.println("Invalid Command.");
                            }
                            System.out.println();
                        }
                    }
                    else 
                    {
                        if (command == 'h' || command == '?') // if 'h' is pressed, show command options
                        {               
                            System.out.println("Press 'd' to set " + customNames[4] + ".");
                            System.out.println("Press 'g' to set " + customNames[5] + ".");
                            System.out.println("Press 'r' to set " + customNames[6] + ".");
                            System.out.println("Press 's' to see economic status.");
                            System.out.println("Press 'm' to see reset " + customNames[3] + " distribution.");
                            System.out.println("Press 'e' to end the day.");
                            System.out.println("Press 'o' to access options.");
                            System.out.println("Press 'q' to quit game.");
                            System.out.println("Press Enter to continue.");
                            keyboard.nextLine();
                        }                    
                        else if (command == 's') // if 's' is pressed, see the economic status 
                        {
                            System.out.println("You currently have " + numMinions + " " + customNames[3] + ".");
                            if (numMinions > (defend + gather + recruit))
                            {
                                System.out.println((numMinions - defend - gather - recruit) + " of which are unassigned.");
                            }
                            if (defend > 0)
                            {
                                System.out.println(defend + " of them are defending.");
                            }
                            if (gather > 0)
                            {
                                System.out.println(gather + " of them are gathering " + customNames[8] + ".");
                            }                        
                            if (recruit > 0)
                            {
                                System.out.println(recruit + " of them are " + customNames[7] + " more " + customNames[3] + ".");
                            }
                            if (gold > 0)
                            {
                                System.out.println("You currently have " + gold + " " + customNames[8] + ".");
                            }
                            System.out.println();
                        }
                        else if (command == 'm') // if 'm' is pressed, unassign all minion jobs
                        {
                            gather = 0;
                            defend = 0;
                            recruit = 0;
                            fullMinions = false;
                            System.out.println(customNames[3].substring(0, 1).toUpperCase() + customNames[3].substring(1) + " reset.");
                            System.out.println();
                        }
                        else if (command == 'e') // if 'e' is pressed, end the day
                        {
                            boolean confirmEndDay = false;
                            while (!confirmEndDay)
                            {
                                System.out.print("Are you sure you want to end the day? [" + confirm + "/" + deny + "] ");
                                String stConfirmEndDay = keyboard.nextLine().trim().toLowerCase();
                                if (stConfirmEndDay.isEmpty())
                                {
                                }
                                else if (stConfirmEndDay.charAt(0) == confirm || stConfirmEndDay.charAt(0) == deny)
                                {
                                    if (stConfirmEndDay.charAt(0) == confirm)
                                    {
                                        if (!fullMinions) // if there are unassigned minions, double checks end day
                                        {
                                            System.out.println();
                                            System.out.println("You still have " + (numMinions - gather - defend - recruit) + " unassigned " + customNames[3] + ".");
                                            boolean confirmEndEnd = false;
                                            while (!confirmEndEnd)
                                            {
                                                System.out.print("Are you absolutely positive you want to end the day? [" + confirm + "/" + deny + "] ");
                                                String stConfirmEndEnd = keyboard.nextLine().trim().toLowerCase();

                                                if (stConfirmEndEnd.isEmpty())
                                                {
                                                }
                                                else if (stConfirmEndEnd.charAt(0) == confirm || stConfirmEndEnd.charAt(0) == deny)
                                                {
                                                    if (stConfirmEndEnd.charAt(0) == confirm)
                                                    {
                                                        endDay = true;
                                                    }
                                                    else
                                                    {
                                                    }
                                                    confirmEndEnd = true;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid Command.");
                                                }
                                            }
                                        }
                                        else
                                        {
                                            endDay = true;
                                        }                                    
                                    }
                                    else
                                    {                                    
                                    }
                                    confirmEndDay = true;
                                }
                                else
                                {
                                    System.out.println("Invalid Command.");
                                }
                            }
                            System.out.println();
                        }
                        else if (command == 'o') // if 'o' is pressed, choose options
                        {
                            String[] optionChoices;
                            if (debugCheckedOnce != true && debug != true)
                            {
                                optionChoices = new String[6];

                                optionChoices[0] = "Auto-Reset " + customNames[3];
                                optionChoices[1] = "Change Save Location";
                                optionChoices[2] = "Save Game";
                                optionChoices[3] = "Change Confirm/Deny Characters";
                                optionChoices[4] = "Change Difficulty";
                                optionChoices[5] = "Debug";
                            }
                            else
                            {
                                optionChoices = new String[5];

                                optionChoices[0] = "Auto-Reset " + customNames[3];
                                optionChoices[1] = "Change Save Location";
                                optionChoices[2] = "Save Game";
                                optionChoices[3] = "Change Confirm/Deny Characters";
                                optionChoices[4] = "Change Difficulty";
                            }

                            String optionChoice = (String)               // user choice received here
                                JOptionPane.showInputDialog
                                (null,                             // current frame
                                    "Choose the option to change:",          // prompt
                                    "Options",  // title
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,                          // path to alternate icon
                                    optionChoices,                 // items in drop-down
                                    optionChoices[0]);             // default choice

                            if (optionChoice == null)
                            {
                            }
                            else if (optionChoice.equals(optionChoices[0]))
                            {
                                int autoResetChoice = JOptionPane.showConfirmDialog
                                    (null, 
                                        "Would you like your " + customNames[3] + " jobs to automatically reset at the end of each day?", 
                                        null, 
                                        JOptionPane.YES_NO_OPTION);

                                if (autoResetChoice == 0)
                                {
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your " + customNames[3] + " jobs will automatically reset at the end of the day.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);
                                    System.out.println("Your " + customNames[3] + " jobs will automatically reset at the end of the day.");
                                    autoResetJobs = true;
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your " + customNames[3] + " will retain jobs at the end of the day, if possible.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);
                                    System.out.println("Your " + customNames[3] + " will retain jobs at the end of the day, if possible.");
                                    autoResetJobs = false;
                                }
                            }
                            else if (optionChoice.equals(optionChoices[1]))
                            {
                                int saveLocationChoice = JOptionPane.showConfirmDialog
                                    ( null, 
                                        "Would you like to change the file location used to save the game?", 
                                        null, 
                                        JOptionPane.YES_NO_OPTION);

                                if (saveLocationChoice == 0)
                                {                                            
                                    String newSaveLocation = (String)              // user choice received here
                                        JOptionPane.showInputDialog
                                        (null,                                       // current frame
                                            "Name new save location (without file extension):",          // prompt
                                            null,  // title
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,                          // path to alternate icon
                                            null,                          // items in drop-down
                                            null);                         // default choice

                                    fSave = (newSaveLocation + ".txt");

                                    JOptionPane.showMessageDialog
                                    (null,
                                        "New save location set to " + fSave + ".",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);

                                    System.out.println("New save location set to " + fSave + ".");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your save location remains at " + fSave + ".",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);

                                    System.out.println("Your save location remains at " + fSave + ".");
                                }
                            }
                            else if (optionChoice.equals(optionChoices[2]))
                            {
                                int saveGameChoice = JOptionPane.showConfirmDialog
                                    (null, 
                                        "Would you like to save your current game?", 
                                        null, 
                                        JOptionPane.YES_NO_OPTION);

                                if (saveGameChoice == 0)
                                {
                                    for (int k = 0; k < NUMARRAYS; k++)
                                    {
                                        int saveLimit = Integer.parseInt(saveGame[k][0]);
                                        for (int j = 1; j < saveLimit; j++)
                                        {
                                            if (variableNames[k][j].equals("numMinions"))
                                            {
                                                saveGame[k][j] = Integer.toString(numMinions);
                                            }
                                            else if (variableNames[k][j].equals("gold"))
                                            {
                                                saveGame[k][j] = Integer.toString(gold);
                                            }
                                            else if (variableNames[k][j].equals("defendBonus"))
                                            {
                                                saveGame[k][j] = Integer.toString(defendBonus);
                                            }
                                            else if (variableNames[k][j].equals("gatherBonus"))
                                            {
                                                saveGame[k][j] = Integer.toString(gatherBonus);
                                            }
                                            else if (variableNames[k][j].equals("luck"))
                                            {
                                                saveGame[k][j] = Integer.toString(luck);
                                            }
                                            else if (variableNames[k][j].equals("day"))
                                            {
                                                saveGame[k][j] = Integer.toString(day);
                                            }
                                            else if (variableNames[k][j].equals("maxMinions"))
                                            {
                                                saveGame[k][j] = Integer.toString(maxMinions);
                                            }
                                            else if (variableNames[k][j].equals("maxGold"))
                                            {
                                                saveGame[k][j] = Integer.toString(maxGold);
                                            }
                                            else if (variableNames[k][j].equals("numDragonKill"))
                                            {
                                                saveGame[k][j] = Integer.toString(numDragonKill);
                                            }
                                            else if (variableNames[k][j].equals("numBattlesWon"))
                                            {
                                                saveGame[k][j] = Integer.toString(numBattlesWon);
                                            }
                                            else if (variableNames[k][j].equals("itemsFound"))
                                            {
                                                saveGame[k][j] = Integer.toString(itemsFound);
                                            }
                                            else if (variableNames[k][j].equals("difficulty"))
                                            {
                                                saveGame[k][j] = Integer.toString(difficulty);
                                            }
                                            else if (variableNames[k][j].equals("name"))
                                            {
                                                saveGame[k][j] = name;
                                            }
                                            else if (variableNames[k][j].equals("fName"))
                                            {
                                                saveGame[k][j] = fName;
                                            }
                                            else if (variableNames[k][j].equals("confirm"))
                                            {
                                                saveGame[k][j] = Character.toString(confirm);
                                            }
                                            else if (variableNames[k][j].equals("deny"))
                                            {
                                                saveGame[k][j] = Character.toString(deny);
                                            }
                                            else if (variableNames[k][j].equals("debug"))
                                            {
                                                saveGame[k][j] = Boolean.toString(debug);
                                            }
                                            else if (variableNames[k][j].equals("male"))
                                            {
                                                saveGame[k][j] = Boolean.toString(male);
                                            }
                                        }
                                    }
                                    try
                                    {
                                        PrintWriter outSave = new PrintWriter(new FileOutputStream(fSave));

                                        for (int k = 0; k < NUMARRAYS; k++)
                                        {
                                            int saveLimit = Integer.parseInt(saveGame[k][0]);
                                            for (int j = 0; j < saveLimit; j++)
                                            {
                                                outSave.println(saveGame[k][j]);
                                            }
                                        }

                                        outSave.close();

                                        JOptionPane.showMessageDialog
                                        (null,
                                            "Your current game has been saved in " + fSave + ".",
                                            null,
                                            JOptionPane.PLAIN_MESSAGE);
                                        System.out.println("Your current game has been saved in " + fSave + ".");
                                    }
                                    catch (Exception e)
                                    {
                                        JOptionPane.showMessageDialog
                                        (null,
                                            "Error saving your game, your current game was not saved.",
                                            null,
                                            JOptionPane.PLAIN_MESSAGE);
                                        System.out.println("Error saving your game, your current game was not saved.");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your current game was not saved.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);
                                    System.out.println("Your current game was not saved.");
                                }                               
                            }
                            else if (optionChoice.equals(optionChoices[3]))
                            {
                                int confirmDenyCharChoice = JOptionPane.showConfirmDialog
                                    (null, 
                                        "Would you like to change the characters used to confirm and deny to something other than '" + confirm + "' and '" + deny + "'?", 
                                        null, 
                                        JOptionPane.YES_NO_OPTION);

                                if (confirmDenyCharChoice == 0)
                                {
                                    String newConfirmDeny = (String)              // user choice received here
                                        JOptionPane.showInputDialog
                                        (null,                                       // current frame
                                            "What character would you like to use for confirm instead of '" + confirm + "'?",          // prompt
                                            null,  // title
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,                          // path to alternate icon
                                            null,                          // items in drop-down
                                            null);                         // default choice

                                    confirm = newConfirmDeny.charAt(0);

                                    newConfirmDeny = (String)              // user choice received here
                                    JOptionPane.showInputDialog
                                    (null,                                       // current frame
                                        "What character would you like to use for deny instead of '" + deny + "'?",          // prompt
                                        null,  // title
                                        JOptionPane.PLAIN_MESSAGE,
                                        null,                          // path to alternate icon
                                        null,                          // items in drop-down
                                        null);                         // default choice

                                    deny = newConfirmDeny.charAt(0);

                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your new confirm and deny characters are '" + confirm + "' and '" + deny + "'.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);

                                    System.out.println("Your new confirm and deny characters are '" + confirm + "' and '" + deny + "'.");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Your confirm and deny characters remain  '" + confirm + "' and '" + deny + "'.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);
                                    System.out.println("Your confirm and deny characters remain  '" + confirm + "' and '" + deny + "'.");
                                }
                            }
                            else if (optionChoice.equals(optionChoices[4]))
                            {
                                JOptionPane.showMessageDialog
                                (null,
                                    "Optional difficult is not yet implemented",
                                    null,
                                    JOptionPane.PLAIN_MESSAGE);
                            }
                            else if (optionChoice.equals(optionChoices[5]))
                            {                                
                                String debugExtraCheck = (String)               // user choice received here
                                    JOptionPane.showInputDialog
                                    (null,                           // current frame
                                        null,  // prompt
                                        null,                   // title
                                        JOptionPane.PLAIN_MESSAGE,
                                        null,                        // path to alternate icon
                                        null,                        // items in drop-down
                                        "");                   // default choice (can be null)

                                if (debugExtraCheck.equals("deBUG"))
                                {
                                    debug = true;
                                    JOptionPane.showMessageDialog
                                    (null,
                                        "Debug enabled.",
                                        null,
                                        JOptionPane.PLAIN_MESSAGE);

                                    System.out.println("Debug enabled.");
                                }
                                else
                                {
                                    debugCheckedOnce = true;
                                }
                            }
                        }
                        else if (command == 'q') // if 'q' is pressed, quit the game
                        {
                            boolean checkQuitGame = false;
                            while (!checkQuitGame)
                            {
                                System.out.print("Are you sure you want to quit? [" + confirm + "/" + deny + "] ");
                                String stQuitGame = keyboard.nextLine().trim().toLowerCase();

                                if (stQuitGame.isEmpty())
                                {
                                }
                                else if (stQuitGame.charAt(0) == 'q')
                                {
                                    System.exit(0);
                                }
                                else if (stQuitGame.charAt(0) == confirm || stQuitGame.charAt(0) == deny)
                                {
                                    if (stQuitGame.charAt(0) == confirm)
                                    {
                                        boolean checkSaveGame = false;
                                        while (!checkSaveGame)
                                        {
                                            System.out.print("Would you like to save the game? [" + confirm + "/" + deny + "] ");
                                            String stSaveGame = keyboard.nextLine().trim().toLowerCase();

                                            if (stSaveGame.isEmpty())
                                            {
                                            }
                                            else if (stSaveGame.charAt(0) == confirm || stSaveGame.charAt(0) == deny)
                                            {
                                                if (stSaveGame.charAt(0) == confirm)
                                                {
                                                    for (int k = 0; k < NUMARRAYS; k++)
                                                    {
                                                        int saveLimit = Integer.parseInt(saveGame[k][0]);
                                                        for (int j = 1; j < saveLimit; j++)
                                                        {
                                                            if (variableNames[k][j].equals("numMinions"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(numMinions);
                                                            }
                                                            else if (variableNames[k][j].equals("gold"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(gold);
                                                            }
                                                            else if (variableNames[k][j].equals("defendBonus"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(defendBonus);
                                                            }
                                                            else if (variableNames[k][j].equals("gatherBonus"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(gatherBonus);
                                                            }
                                                            else if (variableNames[k][j].equals("luck"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(luck);
                                                            }
                                                            else if (variableNames[k][j].equals("day"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(day);
                                                            }
                                                            else if (variableNames[k][j].equals("maxMinions"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(maxMinions);
                                                            }
                                                            else if (variableNames[k][j].equals("maxGold"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(maxGold);
                                                            }
                                                            else if (variableNames[k][j].equals("numDragonKill"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(numDragonKill);
                                                            }
                                                            else if (variableNames[k][j].equals("numBattlesWon"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(numBattlesWon);
                                                            }
                                                            else if (variableNames[k][j].equals("itemsFound"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(itemsFound);
                                                            }
                                                            else if (variableNames[k][j].equals("difficulty"))
                                                            {
                                                                saveGame[k][j] = Integer.toString(difficulty);
                                                            }
                                                            else if (variableNames[k][j].equals("name"))
                                                            {
                                                                saveGame[k][j] = name;
                                                            }
                                                            else if (variableNames[k][j].equals("fName"))
                                                            {
                                                                saveGame[k][j] = fName;
                                                            }
                                                            else if (variableNames[k][j].equals("confirm"))
                                                            {
                                                                saveGame[k][j] = Character.toString(confirm);
                                                            }
                                                            else if (variableNames[k][j].equals("deny"))
                                                            {
                                                                saveGame[k][j] = Character.toString(deny);
                                                            }
                                                            else if (variableNames[k][j].equals("debug"))
                                                            {
                                                                saveGame[k][j] = Boolean.toString(debug);
                                                            }
                                                            else if (variableNames[k][j].equals("male"))
                                                            {
                                                                saveGame[k][j] = Boolean.toString(male);
                                                            }
                                                        }
                                                    }
                                                    try
                                                    {
                                                        PrintWriter outSave = new PrintWriter(new FileOutputStream(fSave));

                                                        for (int k = 0; k < NUMARRAYS; k++)
                                                        {
                                                            int saveLimit = Integer.parseInt(saveGame[k][0]);
                                                            for (int j = 0; j < saveLimit; j++)
                                                            {
                                                                outSave.println(saveGame[k][j]);
                                                            }
                                                        }

                                                        outSave.close();
                                                    }
                                                    catch (Exception e)
                                                    {
                                                        System.out.println("Saving Error. \nTerminating Program.");
                                                        System.exit(0);
                                                    }
                                                }                                            
                                                boolean checkHighScore = false;
                                                while (!checkHighScore)
                                                {
                                                    System.out.print("Would you like to see your score? [" + confirm + "/" + deny + "] ");
                                                    String stSeeScore = keyboard.nextLine().trim().toLowerCase();

                                                    if (stSeeScore.isEmpty())
                                                    {
                                                    }
                                                    else if (stSeeScore.charAt(0) == confirm || stSeeScore.charAt(0) == deny)
                                                    {
                                                        if (stSeeScore.charAt(0) == confirm)
                                                        {
                                                            runGame = false;
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Well, thanks for playing!");
                                                            System.exit(0);
                                                        }
                                                        checkHighScore = true;                                            
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Invalid Command.");
                                                    }
                                                }
                                                checkSaveGame = true;                                            
                                            }
                                            else
                                            {
                                                System.out.println("Invalid Command.");
                                            }
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("That's the spirit! \nNow get back in there!!");
                                    }
                                    checkQuitGame = true;
                                }
                                else
                                {
                                    System.out.println("Invalid Command.");
                                }
                            }
                        }
                        else // if anything else is pressed, error code
                        {
                            System.out.println("Invalid Command. Press 'h' or '?' for help.");
                        }
                    }
                }
                if (numMinions == (gather + recruit + defend))
                {
                    fullMinions = true;
                    System.out.println("All of your " + customNames[3] + " are assigned.");
                    boolean checkFullMinions = false;
                    while (!checkFullMinions)
                    {
                        System.out.print("Would you like to end the day? [" + confirm + "/" + deny + "] ");
                        String stFull = keyboard.nextLine().trim().toLowerCase();
                        if (stFull.isEmpty())
                        {
                        }
                        else if (stFull.charAt(0) == confirm || stFull.charAt(0) == deny)
                        {
                            if (stFull.charAt(0) == confirm)
                            {
                                endDay = true;
                            }
                            else
                            {
                            }
                            checkFullMinions = true;
                        }                        
                        else
                        {
                            System.out.println("Invalid Command.");
                        }
                    }
                }
            }
            if (endDay)
            {
                oldNumMinions = numMinions;

                System.out.println("__________________________________________");
                System.out.println();            
                System.out.println("Press Enter to see the day's events.");
                keyboard.nextLine();

                int serendipity = rand.nextInt(day + defendBonus + gatherBonus + luck);

                if (serendipity < 1)
                {

                }
                if (recruit > 0)
                {
                    double recruitGenBonus = ((1 / Math.log((double)day) * 10) * Math.random() + .25);
                    int recruitGen = 0; 

                    if (day < 5)
                    {
                        recruitGen = rand.nextInt(3) + 2 + (int)(recruit * .25);
                    }
                    else
                    {
                        recruitGen = (int)(recruitGenBonus + (recruit * .25) + recruitBonus);
                    }
                    if (recruitGen > 0)
                    {
                        System.out.println("Your " + customNames[6] + " " + customNames[15].substring(0, 1).toLowerCase() + customNames[15].substring(1) + " " + recruitGen + " " + customNames[3] + " today!");
                        numMinions = numMinions + recruitGen;
                        System.out.println("Your " + customNames[2] + " now has " + numMinions + " " + customNames[3] + "!");                        
                    }
                    else
                    {
                        System.out.println("Your " + customNames[6] + " weren't able to " + customNames[16] + " any " + customNames[3] + " today, sorry!");
                    }
                }
                else
                {
                    System.out.println("You can't " + customNames[16] + " any " + customNames[3] + " without assigning some " + customNames[6] + "!");
                }
                System.out.println();
                System.out.println("Press Enter to see the " + customNames[8] + " report.");
                keyboard.nextLine();
                if (gather > 0)
                {
                    int goldGen = rand.nextInt(gather + luck) + gatherBonus;

                    if (goldGen > 0)
                    {
                        System.out.println("Your " + customNames[5] + " produced " + goldGen + " " + customNames[8] + " today!");
                        gold = gold + goldGen;
                        System.out.println("Your stockpiles now have " + gold + " " + customNames[8] + "!");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Your " + customNames[5] + " weren't able to produce any " + customNames[8] + " today, sorry!");
                    }            
                }
                else
                {
                    System.out.println("You can't gather anything without assigning some " + customNames[5] + "!");
                }
                System.out.println();
                System.out.println("Press Enter to see the battle report.");
                keyboard.nextLine();

                int battleStr = 0, battle = rand.nextInt(day + 5), treasure = rand.nextInt(day), dragonTreasure = 0;
                boolean checkBattle = false, dragonAttack = false;
                if (battle <= 4)
                {
                    System.out.println("No combat today.");
                    System.out.println("What a peaceful and marvelous day!");
                }
                else if (battle >= 5 && battle <= 7)
                {
                    System.out.println(customNames[9]);
                    checkBattle = true;
                    battleStr = battle - 2;
                }
                else if (battle >= 8 && battle <= 11)
                {
                    System.out.println(customNames[10]);
                    checkBattle = true;
                    battleStr = battle;
                }
                else if (battle >= 12 && battle <= 16)
                {
                    System.out.println(customNames[11]);
                    checkBattle = true;
                    battleStr = battle + 2;
                }
                else if (battle >= 17 && battle <= 22)
                {
                    System.out.println(customNames[12]);
                    checkBattle = true;
                    battleStr = battle + 5;
                }            
                else if (battle >= 23)
                {
                    dragonAttack = true;
                    System.out.println(customNames[13]);
                    checkBattle = true;
                    battleStr = battle + 10;
                }
                if (checkBattle)
                {
                    System.out.println("You have " + defend + " " + customNames[4] + " on defense. Will it be enough?");
                    System.out.println("Press Enter to find out!");
                    keyboard.nextLine();

                    int defendStr = (int)((defend * (Math.random() + 1)) + defendBonus + 1);
                    if (defendStr >= battleStr)
                    {
                        System.out.println("Victory is yours!");                               
                        if (dragonAttack)
                        {
                            numDragonKill = numDragonKill + 1;
                            dragonTreasure = numDragonKill + rand.nextInt(day + 10);
                        }
                        numBattlesWon = numBattlesWon + 1;
                        treasure = treasure + rand.nextInt(battle + luck);
                        keyboard.nextLine(); 
                    }
                    else
                    {
                        System.out.println("Your " + customNames[4] + " have been defeated!");

                        int dead = (int)(battleStr - defendStr - (Math.abs(Math.random() - .5) * (numMinions - defend)));
                        if (dead >= numMinions)
                        {
                            if (defend == 1)
                            {
                                System.out.println("When you have only one of your " + customNames[4] + " on defense, you should expect your " + customNames[2] + " to be overrun.");
                            }
                            else if (defend == 0)
                            {
                                System.out.println("Without any " + customNames[4] + " set to defend your " + customNames[2] + ", your innocent " + customNames[5] + " soon lay in the hands of the enemy.");
                            }
                            else
                            {
                                System.out.println("On this day, that shall live in infamy, all " + defend + " of your " + customNames[4] + " were overrun.");
                                System.out.println();
                                System.out.println("Death and mayham followed, and the rest of your " + customNames[3] + " soon lay dead and defeated.");
                            }
                            numMinions = numMinions - dead;
                        }
                        else if (dead > 1)
                        {
                            System.out.println("Oh no! " + dead + " of your " + customNames[4] + " died in the battle!");
                            numMinions = numMinions - dead;
                        }
                        else if (dead == 1)
                        {
                            System.out.println("Oh no! George R.R. Martin just killed your favorite " + customNames[4] + "!");
                            numMinions = numMinions - dead;
                        }              
                        else
                        {
                            System.out.println("Luckily they all managed to survive!");
                        }
                        keyboard.nextLine();
                        if (dead > 0 && numMinions > 0)
                        {
                            gather = 0;
                            defend = 0;
                            recruit = 0;
                            fullMinions = false;
                            System.out.println("In the rush to escape the attack, your " + customNames[3] + " quit their active jobs.");                            
                            System.out.println(customNames[3] + " reset.");
                            keyboard.nextLine();
                        }
                    }            
                }
                if (numMinions > 0)
                {
                    System.out.println("That's it for the battle report!");
                    System.out.println();

                    System.out.print("Press Enter to stop viewing the day's reports.");
                    day++;
                }
                keyboard.nextLine();
                System.out.println("__________________________________________");
            }
            if (maxMinions < numMinions) // checks and sets maxMinions for scoring
            {
                maxMinions = numMinions;
            }
            if (maxGold < gold) // checks and sets maxGold for storing
            {
                maxGold = gold;
            }            
            if (numMinions <= 0) // checks current number of minions for game over
            {
                runGame = false; // if user has less than or equal to zero minions, the game is over
            }
        }

        System.out.println("Game over!");
        System.out.println();

        if (debug)
        {
            boolean checkScoreDebug = false;
            while (!checkScoreDebug)
            {
                System.out.print("Score Debug: [" + confirm + "/" + deny + "] ");
                String stScoreDebug = keyboard.nextLine().trim().toLowerCase();

                if (stScoreDebug.isEmpty())
                {
                }
                else if (stScoreDebug.charAt(0) == confirm || stScoreDebug.charAt(0) == deny)
                {
                    if (stScoreDebug.charAt(0) == confirm)
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
                System.out.println("That is a new high score! \nCongratulations!!");
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
        System.out.println();
        System.out.println("That was an excellent game!");
        System.out.println();
    }
}
