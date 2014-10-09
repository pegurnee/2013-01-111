
/* This object contains information about the user
 * 
 */

public class CurrentUser
{
    private String name; // the name of the user
    private String fName; // the file used to load custom names for the user's game
    private String fSave; // the file used to save and load the game
    private String title; // the title of the current user
    private String saying; // a bonus saying used if the custom name file has one
    private String location; // the name of the area the play has control over

    private boolean load; // checks if the user has loaded
    private boolean debug; // checks if the user is in debug mode
    private boolean male; // checks if the user is male
    private boolean debugChecked; // checks if the user already attempted to enter debug mode
//     private boolean customNames; // checks if the user is using custom name files
    private boolean fullMinions; // checks if the user's minions are fully declared
    private boolean runGame; // checks if the game is still running
    private boolean autoJobReset; // checks to see if the jobs automatically reset at the beginning of the day
    private boolean endDay; // checks to see if the day should end
    
//     private int defendBonus, gatherBonus, recruitBonus; // contributes static bonuses to a player
    private int day; // keeps track of the days
    private int numDragonKill, numBattlesWon; // scoring variables
    private int itemsFound, difficulty; // currently unused
    
    private double luck; // currently unused
    
    private char confirm = 'y'; // the char used to confirm options
    private char deny = 'n'; // the char used to deny options
    
    public Resources gold = new Resources();
    public Resources minions = new Resources();
    
    public UserLand land = new UserLand(this);
    
    public CurrentEnemies[] enemies = new CurrentEnemies[5];    
    public MinionJobs[] defGatRec = new MinionJobs[3];
    public UserBuildings[] buildings = new UserBuildings[3];
    
    //public MinionJobs defend = new MinionJobs();
    //public MinionJobs gather = new MinionJobs();
    //public MinionJobs recruit = new MinionJobs();
    
    // constructor
    public CurrentUser()
    {
        for (int k = 0; k < defGatRec.length; k++)
        {
            defGatRec[k] = new MinionJobs();            
        }
        for (int k = 0; k < enemies.length; k++)
        {
            enemies[k] = new CurrentEnemies(k);
        }
        for (int k = 0; k < buildings.length; k++)
        {
            buildings[k] = new UserBuildings(this, k);            
        }
    }
    
    // minion jobs   
    public void resetMinions()
    {
        for (int k = 0; k < defGatRec.length; k++)
        {
            defGatRec[k].setValue(0);
        }
    }
    public boolean checkFull()
    {        
        if (minions.getValue() == this.workingMinions())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int workingMinions()
    {
        return defGatRec[0].getValue() + defGatRec[1].getValue() + defGatRec[2].getValue();
    }
    public int unassignedMinions()
    {
        return this.minions.getValue() - this.workingMinions();
    }
    
    // enemy methods
        
    // name methods
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }    
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    public String getTitle()
    {
        return title;
    }
    public void setSaying(String newSaying)
    {
        saying = newSaying;
    }
    public String getSaying()
    {
        return saying;
    }
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    public String getLocation()
    {
        return location;
    }

    // custom name methods
    public void setfName(String newfName)
    {
        fName = newfName;
    }
    public String getfName()
    {
        return fName;
    }
//     public boolean checkCustomNames()
//     {
//         return customNames;
//     }
//     public void setCustomNames(boolean input)
//     {
//         customNames = input;
//     }
    
    // day methods
    public void setDay(int newDay)
    {
        day = newDay;
    }
    public void dayCount()
    {
        day++;
    }
    public int getDay()
    {
        return day;
    }
    public void setEndDay(boolean input)
    {
        endDay = input;
    }
    public boolean getEndDay()
    {
        return endDay;
    }
    public void setRunGame(boolean input)
    {
        runGame = input;
    }
    public boolean getRunGame()
    {
        return runGame;
    }

    // scoring methods
    public void setNumDragonKill(int input)
    {
        numDragonKill = input;
    }
    public void dragonKilled()
    {
        numDragonKill++;
    }
    public int getNumDragonKill()
    {
        return numDragonKill;
    }
    public void setNumBattlesWon(int input)
    {
        numBattlesWon = input;
    }
    public void battleWon()
    {
        numBattlesWon++;
    }
    public int getNumBattlesWon()
    {
        return numBattlesWon;
    }
    public void setItemsFound(int input)
    {
        itemsFound = input;
    }
    public int getItemsFound()
    {
        return itemsFound;
    }

    // options related methods
    public boolean getDebug()
    {
        return debug;
    }
    public void setDebug(boolean newDebug)
    {
        debug = newDebug;
    }
    public boolean getAutoJobReset()
    {
        return autoJobReset;
    }
    public void setAutoJobReset(boolean input)
    {
        autoJobReset = input;
    }    
    public char getConfirmChar()
    {
        return confirm;
    }
    public void setConfirmChar(char newConfirm)
    {
        confirm = newConfirm;
    }
    public char getDenyChar()
    {
        return deny;
    }
    public void setDenyChar(char newDeny)
    {
        deny = newDeny;
    }
    public void setfSave(String newfSave)
    {
        fSave = newfSave;
    }
    public String getfSave()
    {
        return fSave;
    }
    public boolean getDebugChecked()
    {
        return debugChecked;
    }
    public void setDebugChecked(boolean input)
    {
        debugChecked = input;
    }
    public void setDifficulty(int input)
    {
        difficulty = input;
    }
    public int getDifficulty()
    {
        return difficulty;
    }

    // load game related methods
    public boolean loaded() // checks if the user loaded the game
    {
        return load;
    }
    public void setLoad(boolean newLoad) // 
    {
        load = newLoad;
    }
    public boolean getMale()
    {
        return male;
    }
    public void setMale(boolean newMale)
    {
        male = newMale;
    }

    //     // currently unused variable methods
    //     public void setLuck(double input)
    //     {
    //         luck = input;
    //     }
    //     public double getLuck()
    //     {
    //         return luck;
    //     }
    //     public void setItems(int input)
    //     {
    //         itemsFound = input;
    //     }
    //     public int getItems()
    //     {
    //         return itemsFound;
    //     }
    //     
}
