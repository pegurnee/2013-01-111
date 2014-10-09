
/* Single player form of the game
 * 
 */

import java.util.Comparator; // imports comparator
import java.util.Scanner; // imports scanner
import java.util.Random; // imports random
import java.util.Arrays; // imports arrays
import java.io.*; // imports all input/output java

public class SinglePlayer
{
    public static void run()
    {
        Scanner keyboard = new Scanner(System.in); // creates keyboard scanner       
        Random rand = new Random(); // creates random
        
        CurrentUser user = new CurrentUser();
        
        CommonChecks.checkDifficulty(user);
        
        StartGame.run(user);

        LoadGame.run(user);
        if (!user.loaded())
        {
            EnterName.run(user);
        }
        
        LoadCustomNames.run(user);
        
        SeeIntro.run(user);
        
        GameCycle.run(user, true);
        
        int numMinions = 7, gold = 5; // defines starting variables (gold & minions)

        int defendBonus = 0, gatherBonus = 0, recruitBonus = 0, luck = 0; // defines premanent nighttime variables
        int oldNumMinions = 0; // defines temporary nighttime variables

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
        saveGame[3][0] = "2";

        String [][] variableNames = {
                {"numInArrayInt", "numMinions", "gold", "defendBonus", "gatherBonus", "luck", "day", "maxGold", "maxMinions", "numDragonKill", "numBattlesWon", "itemsFound", "difficulty"},
                {"numInArrayString", "name", "fName"},
                {"numInArrayChar", "confirm", "deny"},
                {"numInArrayBoolean", "debug", "male"}
            };

        boolean male = true;
        boolean debug = false; // allows for debugging options
        boolean loading = false; // allows for loading save games 
        
        boolean startGame = false;
        while (startGame != true)
        {
            String stCheckDebug = keyboard.nextLine().trim().toLowerCase();
            if (stCheckDebug.isEmpty())
            {
                startGame = true;
            }
            else if (stCheckDebug.equals("debug"))
            {
                debug = true;
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
                System.out.print("Would you like to load the previous save file? [y/n] ");
                String stLoadGame = keyboard.nextLine().trim().toLowerCase();

                if (stLoadGame.isEmpty())
                {
                    System.out.println("Invalid Command.");
                }
                else if (stLoadGame.charAt(0) == 'y' || stLoadGame.charAt(0) == 'n')
                {
                    if (stLoadGame.charAt(0) == 'y')
                    {
                        int[] loadLimit = new int[4];
                        fLoad = "saveGame.txt";
                        try
                        {
                            //InputStream stream = MainClass.class.getResourceAsStream(fLoad);        
                            //Scanner inLoad = new Scanner(stream);
                            Scanner inLoad = new Scanner(new FileInputStream(fLoad));
                            for (int k = 0; k < NUMARRAYS; k++)
                            {
                                //String tempLoad = ;
                                loadLimit[k] = Integer.parseInt(inLoad.nextLine());
                                for (int j = 1; j < loadLimit[k]; j++)
                                {
                                    loadGame[k][j] = inLoad.nextLine();
                                }
                            }
                            inLoad.close();
                        }
                        catch (Exception e)
                        {
                            System.out.println("Load failed.");
                            System.exit(0);
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
                        System.out.println();
                        System.out.println(customNames[0]);
                        System.out.println("Welcome back, " + customNames[1] + " " + name + ". \nYour " + customNames[2] + " awaits you.");
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
           
            if (debug == true)
            {
                boolean checkCustomNames = false;
                while (checkCustomNames != true)
                {
                    System.out.print("Would you like to enter custom system names? [y/n] ");
                    String stCheckCustomNames = keyboard.nextLine().trim().toLowerCase();

                    if (stCheckCustomNames.isEmpty())
                    {
                        System.out.println("Invalid Command.");
                    }
                    else if (stCheckCustomNames.charAt(0) == 'y' || stCheckCustomNames.charAt(0) == 'n')
                    {
                        if (stCheckCustomNames.charAt(0) == 'y')
                        {
                            boolean checkCustomLoad = false;
                            while (checkCustomLoad != true)
                            {
                                System.out.print("Would you like to load a specific custom file? [y/n] ");
                                String stCheckCustomLoad = keyboard.nextLine().trim().toLowerCase();

                                if (stCheckCustomLoad.isEmpty())
                                {
                                    System.out.println("Invalid Command.");
                                }
                                else if (stCheckCustomLoad.charAt(0) == 'y' || stCheckCustomLoad.charAt(0) == 'n')
                                {
                                    if (stCheckCustomLoad.charAt(0) == 'y')
                                    {                                       
                                        boolean confirmCustomLoad = false;
                                        while (confirmCustomLoad != true)
                                        {
                                            System.out.print("Enter complete file name (including \".txt\"): ");
                                            fName = keyboard.nextLine().trim();

                                            int fNameLength = fName.length();
                                            String fNameFE = fName.substring(fName.length() - 4);
                                            if (fName.isEmpty())
                                            {
                                                System.out.println("Invalid Command.");
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
                                            String fCustom = "10customNames.txt";
                                            fName = "00example.txt";
                                            String [][] exampleCustom = new String [CUSTOMLENGTH][CUSTOMLENGTH];

                                            Scanner inName = new Scanner(new FileInputStream(fName));
                                            PrintWriter outCustom = new PrintWriter(new FileOutputStream(fCustom));
                                            for (int k = 0; k < CUSTOMLENGTH; k++)
                                            {
                                                exampleCustom[0][k] = inName.nextLine();
                                                boolean checkCustom = false;
                                                while (checkCustom != true)
                                                {
                                                    System.out.print("Enter custom name for \"" + exampleCustom[0][k] + "\": ");                                                
                                                    exampleCustom[1][k] = keyboard.nextLine().trim();
                                                    if (exampleCustom[1][k].isEmpty())
                                                    {
                                                        System.out.println("Invalid Command.");
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
                                        fName = "10customNames.txt";
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
            System.out.println(customNames[0]);
            System.out.println("Welcome " + customNames[1] + " " + name + ", to your new " + customNames[2] + ".");
        }
        System.out.println("__________________________________________");
        System.out.println();

        System.out.println("If at anytime you need to see the command"); // informs how to see commands
        System.out.println("choices again, just enter 'h' or '?'");
        System.out.println();

        System.out.println(customNames[1] + " " + name + ", your " + customNames[3] + " await:");
        System.out.print("Press Enter to Play!");
        keyboard.nextLine();        
        System.out.println("__________________________________________");

        while (runGame == true) // while runGame is true, run the game; for each game period, add one day
        {
            System.out.println();
            System.out.println("Press Enter to start Day " + day + ", " + customNames[1] + " " + name + ".");           
            keyboard.nextLine();

            boolean endDay = false, checkMinions = false ; // defines endDay

            if (day > 1 && oldNumMinions == numMinions) // on days later than day 1 and where no one died or was recruited the day before
            {
                while (checkMinions != true)
                {
                    System.out.println("Would you like to keep the same number ");
                    System.out.print("of " + customNames[4] + ", " + customNames[5] + ", and " + customNames[6] + " as yesterday? [y/n] "); // checks if user wants to keep same number of defenders, gatherers, and recruiters
                    String sameWork = keyboard.nextLine().trim().toLowerCase(); // defines question exclusive variable
                    if (sameWork.isEmpty() || sameWork.charAt(0) == 'y' || sameWork.charAt(0) == 'n')
                    {                    
                        if (sameWork.isEmpty() || sameWork.charAt(0) == 'y')
                        {
                            System.out.println();

                            boolean checkEndDay = false;
                            while (checkEndDay != true)
                            {
                                System.out.print("Would you like to end the day? [y/n] "); // checks if the user wants to end the day
                                String checkEnd = keyboard.nextLine().trim().toLowerCase(); // defines question exclusive variable
                                if (checkEnd.isEmpty() || checkEnd.charAt(0) == 'y' || checkEnd.charAt(0) == 'n')
                                {
                                    if (checkEnd.isEmpty() || checkEnd.charAt(0) == 'y')
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
            while (endDay != true && runGame == true) // daytime of the game, assigns minions to various actions
            {
                // stCommand; // defines the command selector
                System.out.print("What is your command? ");
                String stCommand = keyboard.nextLine().trim().toLowerCase();

                if (stCommand.isEmpty())
                {
                    System.out.println("Invalid Command.");
                }
                else
                {
                    char command = stCommand.charAt(0);
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
                    else if (command == 'd' || command == 'g' || command == 'r') // if 'd', 'g', or 'r' is pressed set/add defenders, gatherers, or recruiters
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
                        boolean checkAddOrSet = false;
                        while (checkAddOrSet != true)
                        {
                            System.out.print("Do you want to add " + customNamesDGR + ", or set total " + customNamesDGR + "? [add/set] ");
                            String stAddOrSet = keyboard.nextLine().trim().toLowerCase();
                            if (stAddOrSet.isEmpty())
                            {
                                System.out.println("Invalid Command.");
                            }
                            else if (stAddOrSet.equals("add") || stAddOrSet.equals("set"))
                            {
                                boolean checkDGR = false;
                                while (checkDGR != true)
                                {
                                    stAddOrSet = stAddOrSet.substring(0, 1).toUpperCase() + stAddOrSet.substring(1);
                                    System.out.print(stAddOrSet + " how many " + customNamesDGR + "? ");
                                    String stTempDGR = keyboard.next().trim();
                                    keyboard.nextLine();

                                    int stTempDGRLength = stTempDGR.length();
                                    boolean validDGR = true;
                                    for (int k = 0; k < stTempDGRLength; k++)
                                    {                                
                                        if (Character.isDigit(stTempDGR.charAt(k)) != true)
                                        {
                                            System.out.println("Invalid Command.");
                                            validDGR = false;
                                        }
                                    }                            
                                    if (validDGR == true)
                                    {
                                        int tempDGR = Integer.parseInt(stTempDGR), compareDGR = 0;
                                        stAddOrSet = stAddOrSet.toLowerCase();

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
                                            while (confirmDGR != true)
                                            {
                                                System.out.print("Confirm " + stAddOrSet);
                                                if (stAddOrSet.equals("set"))
                                                {
                                                    System.out.print("t");
                                                }
                                                System.out.print("ing " + tempDGR + " " + customNamesDGR + "? [y/n] ");
                                                String stConfirmDGR = keyboard.nextLine().trim().toLowerCase();
                                                if (stConfirmDGR.isEmpty())
                                                {
                                                    System.out.println("Invalid Command.");
                                                }
                                                else if (stConfirmDGR.charAt(0) == 'y' || stConfirmDGR.charAt(0) == 'n')
                                                {
                                                    if (stConfirmDGR.charAt(0) == 'y')
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
                                                            System.out.print("ed");
                                                        }
                                                        System.out.println(".");
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
                            else
                            {
                                System.out.println("Invalid Command.");
                            }
                            System.out.println();
                        }
                    }
                    else if (command == 's') // if 's' is pressed, see the economic status 
                    {
                        
                    }
                    else if (command == 'm') // if 'm' is pressed, unassign all minion jobs
                    {
                        
                    }
                    else if (command == 'e') // if 'e' is pressed, end the day
                    {
                        boolean confirmEndDay = false;
                        while (confirmEndDay != true)
                        {
                            System.out.print("Are you sure you want to end the day? [y/n] ");
                            String stConfirmEndDay = keyboard.nextLine().trim().toLowerCase();
                            if (stConfirmEndDay.isEmpty())
                            {
                                System.out.println("Invalid Command.");
                            }
                            else if (stConfirmEndDay.charAt(0) == 'y' || stConfirmEndDay.charAt(0) == 'n')
                            {
                                if (stConfirmEndDay.charAt(0) == 'y')
                                {
                                    if (fullMinions != true) // if there are unassigned minions, double checks end day
                                    {
                                        System.out.println();
                                        System.out.println("You still have " + (numMinions - gather - defend - recruit) + " unassigned " + customNames[3] + ".");
                                        boolean confirmEndEnd = false;
                                        while (confirmEndEnd != true)
                                        {
                                            System.out.print("Are you absolutely positive you want to end the day? [y/n] ");
                                            String stConfirmEndEnd = keyboard.nextLine().trim().toLowerCase();

                                            if (stConfirmEndEnd.isEmpty())
                                            {
                                                System.out.println("Invalid Command.");
                                            }
                                            else if (stConfirmEndEnd.charAt(0) == 'y' || stConfirmEndEnd.charAt(0) == 'n')
                                            {
                                                if (stConfirmEndEnd.charAt(0) == 'y')
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
                    }
                    else if (command == 'q') // if 'q' is pressed, quit the game
                    {
                        boolean checkQuitGame = false;
                        while (checkQuitGame != true)
                        {
                            System.out.print("Are you sure you want to quit? [y/n] ");
                            String stQuitGame = keyboard.nextLine().trim().toLowerCase();

                            if (stQuitGame.isEmpty())
                            {
                                System.out.println("Invalid Command.");
                            }
                            else if (stQuitGame.charAt(0) == 'y' || stQuitGame.charAt(0) == 'n')
                            {
                                if (stQuitGame.charAt(0) == 'y')
                                {
                                    boolean checkSaveGame = false;
                                    while (checkSaveGame != true)
                                    {
                                        System.out.print("Would you like to save the game? [y/n] ");
                                        String stSaveGame = keyboard.nextLine().trim().toLowerCase();

                                        if (stSaveGame.isEmpty())
                                        {
                                            System.out.println("Invalid Command.");
                                        }
                                        else if (stSaveGame.charAt(0) == 'y' || stSaveGame.charAt(0) == 'n')
                                        {
                                            if (stSaveGame.charAt(0) == 'y')
                                            {
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
                                            while (checkHighScore != true)
                                            {
                                                System.out.print("Would you like to see your score? [y/n] ");
                                                String stSeeScore = keyboard.nextLine().trim().toLowerCase();

                                                if (stSeeScore.isEmpty())
                                                {
                                                    System.out.println("Invalid Command.");
                                                }
                                                else if (stSeeScore.charAt(0) == 'y' || stSeeScore.charAt(0) == 'n')
                                                {
                                                    if (stSeeScore.charAt(0) == 'y')
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
                        System.out.println("Press Enter to continue.");
                        //keyboard.nextLine();               
                    }
                }
                if (numMinions == (gather + recruit + defend))
                {
                    fullMinions = true;
                    System.out.println("All of your " + customNames[3] + " are assigned.");
                    boolean checkFullMinions = false;
                    while (checkFullMinions != true)
                    {
                        System.out.print("Would you like to end the day? [y/n] ");
                        String stFull = keyboard.nextLine().trim().toLowerCase();
                        if (stFull.isEmpty())
                        {
                            System.out.println("Invalid Command.");
                        }
                        else if (stFull.charAt(0) == 'y' || stFull.charAt(0) == 'n')
                        {
                            if (stFull.charAt(0) == 'y')
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
               
                System.out.println();
                
                System.out.println("Press Enter to go on to the battle report.");
                keyboard.nextLine();

               
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
            if (numMinions <= 0) // checks current number of minions for game over
            {
                runGame = false; // if user has less than or equal to zero minions, the game is over
            }
        }

        System.out.println();
        System.out.println("That was an excellent game!");
        System.out.println();
    }
}
