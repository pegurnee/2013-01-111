package intro.proj.pX.summoner_battles;

/**
 * Write a description of class Summon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Summon
{
    private String name;
    private String strType;
    
    private int[] statsADS = new int[3];
    private int maxHealth;
    private int health;
    private double accuracy;
    private double evasion;   
    
    private int level;
    private int experience;
    private int individualValue;
    private int[] effortValue = new int[4];
    private int[] baseStatsADSH = new int[4];    
    private int intType;
    private boolean alive;
    
    private int numEvolved;
    
    private boolean inTeam;
    private boolean real;
    
    /**
     * Constructor for objects of class Summon
     */
    public Summon()
    {
        name = strType = "Undefined";
        accuracy = evasion = 90.0;
        level = experience = numEvolved = 0;
        
        real = false;
    }
    public Summon(String n)
    {
        this(n, (int)(0.5 + (Math.random() * 5)));
    }
    public Summon(String n, int t)
    {
        this();
        name = n;
        setType(t);
        level = 1;
        real = true;
        individualValue = (int)(0.5 + (Math.random() * 32));
        calculateStats();
    }
    
    public void setName(String n)
    {
        name = n;
    }
    public void setType(int t)
    {
        switch (t)
        {
            case 0: strType = "Water";
                    baseStatsADSH[0] = 10; baseStatsADSH[1] = 12; baseStatsADSH[2] = 8; baseStatsADSH[3] = 15;
                    break;
            case 1: strType = "Grass";
                    baseStatsADSH[0] = 8; baseStatsADSH[1] = 15; baseStatsADSH[2] = 10; baseStatsADSH[3] = 12;
                    break;
            case 2: strType = "Fire";
                    baseStatsADSH[0] = 12; baseStatsADSH[1] = 8; baseStatsADSH[2] = 15; baseStatsADSH[3] = 10;
                    break;
            case 3: strType = "Rock";
                    baseStatsADSH[0] = 13; baseStatsADSH[1] = 15; baseStatsADSH[2] = 7; baseStatsADSH[3] = 15;
                    break;
            case 4: strType = "Ice";
                    baseStatsADSH[0] = 20; baseStatsADSH[1] = 6; baseStatsADSH[2] = 15; baseStatsADSH[3] = 9;
                    break;
            case 5: strType = "Lightning";
                    baseStatsADSH[0] = 10; baseStatsADSH[1] = 8; baseStatsADSH[2] = 20; baseStatsADSH[3] = 12;
                    break;
            case 6: strType = "Crystalline";
                    baseStatsADSH[0] = 25; baseStatsADSH[1] = 11; baseStatsADSH[2] = 16; baseStatsADSH[3] = 8;
                    break;
            case 7: strType = "Storm";
                    baseStatsADSH[0] = 18; baseStatsADSH[1] = 12; baseStatsADSH[2] = 16; baseStatsADSH[3] = 14;
                    break;
            case 8: strType = "Forest";
                    baseStatsADSH[0] = 15; baseStatsADSH[1] = 12; baseStatsADSH[2] = 10; baseStatsADSH[3] = 23;
                    break;
            case 9: strType = "Bug";
                    baseStatsADSH[0] = 25; baseStatsADSH[1] = 8; baseStatsADSH[2] = 20; baseStatsADSH[3] = 7;
                    break;
            case 10: strType = "Dragon";
                    baseStatsADSH[0] = 20; baseStatsADSH[1] = 20; baseStatsADSH[2] = 20; baseStatsADSH[3] = 20;
                    break;
            case 11: strType = "Steel";
                    baseStatsADSH[0] = 15; baseStatsADSH[1] = 22; baseStatsADSH[2] = 5; baseStatsADSH[3] = 18;
                    break;
            case 12: strType = "Time";
                    baseStatsADSH[0] = 27; baseStatsADSH[1] = 23; baseStatsADSH[2] = 38; baseStatsADSH[3] = 12;
                    break;
            case 13: strType = "Gravity";
                    baseStatsADSH[0] = 21; baseStatsADSH[1] = 38; baseStatsADSH[2] = 21; baseStatsADSH[3] = 20;
                    break;
            case 14: strType = "Light";
                    baseStatsADSH[0] = 38; baseStatsADSH[1] = 18; baseStatsADSH[2] = 32; baseStatsADSH[3] = 12;
                    break;
        }
        intType = t;
    }
    public void setInTeam(boolean i)
    {
        inTeam = i;
    }
    public void setReal(boolean r)
    {
        if (!r)
        {
            inTeam = r;
        }
        real = r;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        return name;
    }
    public String getLongName()
    {
        return name + " (" + strType + ") Level: " + level;
    }
    public String getStrType()
    {
        return strType;
    }
    public int getIntType()
    {
        return intType;
    }
    public boolean getInTeam()
    {
        return inTeam;
    }
    public boolean getReal()
    {
        return real;
    }
    public int getLevel()
    {
        return level;
    }
    public double getAccuracy()
    {
        return accuracy;
    }
    
    public boolean equals(Summon otherSummon)
    {
        return false;
    }
    public String toString()
    {
        return "lol";
    }
    
    public void levelUp()
    {
        level++;
        calculateStats();
    }
    public void calculateStats()
    {
        for (int k = 0; k < statsADS.length; k++)
        {
            statsADS[k] = (int)((((baseStatsADSH[k] + effortValue[k] + individualValue) * level) / 10) + 0.5);
        }
        
        int oldMHealth = maxHealth;        
        maxHealth = (int)((((baseStatsADSH[3] + effortValue[3] + individualValue) * level) / 5) + 0.5);        
        health = health + (maxHealth - oldMHealth);
    }
}
