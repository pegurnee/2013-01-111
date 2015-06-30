package intro.proj.pX.summoner_battles;

/**
 * Write a description of class Adventure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adventure
{
    public static void manageSummons(Summoner user)
    {
        String[] manageOptions = {"Display Summons", "Change Summons", "Combine Summons",
                "Rename Summons"};
        int c = C.userSelectButtons("What would you like to adjust?", "Manage Summons", 
                manageOptions);
        
        if (c == 0)
        {
            int d = C.userSelectButtons("Would you like to see your bound or stored Summons?", 
                    "Display Summons", new String[]{"Bound", "Stored"});
                    
            if (d == 0)
            {
                C.showMessage(user.summonsDisplay(true), "Bound Summons");
            }
            else if (d == 1)
            {                
                C.showMessage(user.summonsDisplay(false), "Stored Summons");
            }
        }
        else if (c == 1)
        {
            int d = C.userSelectButtons("Would you like to store or bind a Summon?", 
                    "Change Summons", new String[]{"Store", "Bind"});
                        
            if (d == 0)
            {
                if (user.numInTeam() > 1)
                {
                    int n = C.userSelectDropDown("Which Summon would you like to store?", 
                            "Store Summon", user.nameInTeam());
                            
                    Summon[] inTeamArray = user.inTeam();
                    user.storeSummon(inTeamArray[n]);
                    
                    
                    C.showMessage(inTeamArray[n].getLongName() + " has been stored.", "");
                }
                else
                {
                    C.showMessage("You can't store your last Summon.", "");
                }
            }
            else if (d == 1)
            {
                if (user.numInStorage() > 0)
                {
                    if (user.numInTeam() < user.getMaxTeam())
                    {
                        int n = C.userSelectDropDown("Which Summon would you like to bind?",
                                "Bind Summon", user.nameInStorage());
                                
                        Summon[] inStoreArray = user.inStorage();
                        user.bindSummon(inStoreArray[n]);
                        
                        C.showMessage(inStoreArray[n].getLongName() + " has been bound.", "");
                    }
                    else
                    {
                        C.showMessage("You don't have enough power to bind another Summon.", "");
                    }
                }
                else
                {
                    C.showMessage("You don't have any Summons in storage.", "");
                }
            }
        }
        else if (c == 2)
        {
            int n = C.userSelectButtons("Which Summon would you like to use a base?", 
                    "Combine Summon", user.nameInTeam());
            
            Summon[] inTeamArray = user.inTeam();
            
            int m = C.userSelectDropDown("Which Summon would you like to add to " + 
                    inTeamArray[n].getName() + "?", "Combine Summon", user.nameInStorage());
                                
            Summon[] inStoreArray = user.inStorage();
            
            if (C.userYesOrNo("Are you sure you want to combine the essense of " + 
                    inStoreArray[m].getName() + " to " + inTeamArray[n].getName() + "?", "Confirm Combine"))
            {
                user.combineSummon(inTeamArray[n], inStoreArray[m]);
                C.showMessage("Summons Combined", "Success");
            }            
        }
        else if (c == 3)
        {
            int n = C.userSelectButtons("Which Summon would you like to rename?", 
                            "Rename Summon", user.nameInTeam());
                            
            Summon[] inTeamArray = user.inTeam();
            user.renameSummon(inTeamArray[n], C.userInputString("What do you want to call your Summon?",
                    "Enter New Name"));
        }
    }
    public static void advanceSummoner(Summoner user)
    {
    }
    public static void explore(Summoner user)
    {
        C.showMessage("Random Summon!", "");
        if (user.summonSpace())
        {
            user.addSummon(new Summon(C.userInputString("Name Random Summon:", "Name Summon")));
        }
        else
        {
            C.showMessage("Not enough space for more Summons. \nRelease or combine Summons to make more space.", "No Room");
        }
    }
    public static void unrankedChallenge(Summoner user)
    {
    }
    public static void challengeNextRank(Summoner user)
    {
    }
    public static void resign(Summoner user)
    {
        user.setActive(false);
        user.setAlive(false);
    }
}