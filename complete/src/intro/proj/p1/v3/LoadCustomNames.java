package intro.proj.p1.v3;

import java.util.Scanner;
import java.io.*;

/* Loads the custom name data
 * 
 */
public class LoadCustomNames
{
    public static void run(CurrentUser theUser)
    {
        Scanner keyboard = new Scanner(System.in);
        String fName = theUser.getfName();
        if (theUser.getDebug())
        {
            int confirmCustomName = CommonChecks.checkConfirmDenyOOC(theUser, "Would you like to enter custom system names?");

            if (confirmCustomName == 0)
            {
                CommonChecks.checkCustomInput(theUser);
            }
            else
            {
                int confirmCustomNameFiles = CommonChecks.checkConfirmDenyOOC(theUser, "Would you like to load a specific custom name file?");
                if (confirmCustomNameFiles == 0)
                {
                    CommonChecks.checkAltCommand(theUser);
                }
            }            
        }
        try
        {
            Scanner inName = new Scanner(new FileInputStream(theUser.getfName()));
            int limit = Integer.parseInt(inName.nextLine().trim());
            String[] customNameArray = new String[limit + 1];
            for (int k = 0; k < limit; k++)
            {
                customNameArray[k] = inName.nextLine();                
            }
            inName.close();

            initialize(theUser, customNameArray);
        }
        catch (Exception e)
        {
            System.out.println("Error loading race names.");
            System.exit(0);
        }
    }

    public static void initialize(CurrentUser theUser, String[] theCustomNames)
    {
        theUser.setSaying(theCustomNames[0]);        
        theUser.setTitle(theCustomNames[1]);
        if (theUser.getTitle().equals("null") || theUser.getTitle().equals("01 - Title"))
        {
            if (theUser.getMale())
            {
                theUser.setTitle("Lord");
            }
            else
            {
                theUser.setTitle("Lady");
            }
        }
        theUser.setLocation(theCustomNames[2]);
        theUser.minions.setName(theCustomNames[3]);
        for (int k = 0; k < theUser.defGatRec.length; k++)
        {
            theUser.defGatRec[k].setName(theCustomNames[k + 4]);
        }
        for (int k = 0; k < theUser.defGatRec.length; k++)
        {
            theUser.defGatRec[k].setActive(theCustomNames[k + 7]);
        }
        for (int k = 0; k < theUser.defGatRec.length; k++)
        {
            theUser.defGatRec[k].setPast(theCustomNames[k + 10]);
        }
        for (int k = 0; k < theUser.defGatRec.length; k++)
        {
            theUser.defGatRec[k].setVerb(theCustomNames[k + 13]);
        }
        theUser.gold.setName(theCustomNames[16]);
        for (int k = 0; k < theUser.enemies.length; k++)
        {
            theUser.enemies[k].setName(theCustomNames[k + 17]);
        }
        theUser.enemies[4].setEliteName(theCustomNames[22]);
        for (int k = 0; k < theUser.buildings.length; k++)
        {
            theUser.buildings[k].setName(theCustomNames[k + 23]);
        }
        theUser.land.setName(theCustomNames[26]);
    }
}

