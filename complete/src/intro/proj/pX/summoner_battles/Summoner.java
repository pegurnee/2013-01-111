package intro.proj.pX.summoner_battles;

/**
 * Write a description of class Summoner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Summoner
{
    // instance variables - replace the example below with your own
    private String name;
    private int level;
    private int experience;
    private int power;
    private int maxTeam;
    private boolean active;
    private boolean alive;
    private int summonIndex;
    
    private Summon[] summons = new Summon[24];

    /**
     * Constructor for objects of class Summoner
     */
    public Summoner()
    {
       alive = true;
       level = 1;
       name = "Undefined";
       maxTeam = 3;
       for (int k = 0; k < summons.length; k++)
       {
           summons[k] = new Summon();
       }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  s   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setName(String s)
    {
        name = s;
    }
    public void setAlive(boolean b)
    {
        alive = b;
    }
    public void setLevel(int i)
    {
        level = i;
    }
    public void setMaxTeam(int t)
    {
        maxTeam = t;
    }
    public void setActive(boolean a)
    {
        active = a;
    }
    
    public String getName()
    {
        return name;
    }
    public int getLevel()
    {
        return level;
    }
    public int getMaxTeam()
    {
        return maxTeam;
    }
    public boolean getAlive()
    {
        return alive;
    }
    public boolean getActive()
    {
        return active;
    }
    
    public String toString()
    {
        return "n";
    }
    public boolean equals()
    {
        return true;
    }
    
    public void storeSummon(Summon s)
    {
        s.setInTeam(false);
    }
    public void bindSummon(Summon b)
    {
        b.setInTeam(true);        
    }
    public String summonsDisplay(boolean b)
    {
        String str = "";
        for (Summon s : summons)
        {
            if (s.getInTeam() == b && s.getReal())
            {
                str = str + s.getLongName() + "\n";
            }
        }
        return str.trim();
    }
    public int numInTeam()
    {
        int n = 0;
        for (Summon s : summons)
        {
            if (s.getInTeam())
            {
                n++;
            }
        }
        return n;
    }
    public String[] nameInTeam()
    {
        String[] n = new String[numInTeam()];
        int j = 0;
        for (int k = 0; k < summons.length; k++)
        {
            if (summons[k].getInTeam() && summons[k].getReal())
            {                
                n[j] = summons[k].getLongName();
                j++;
            }
        }
        return n;
    }
    public Summon[] inTeam()
    {
        Summon[] n = new Summon[numInTeam()];
        for (int k = 0; k < n.length; k++)
        {
            n[k] = new Summon();
        }
        int j = 0;
        for (int k = 0; k < summons.length; k++)
        {
            if (summons[k].getInTeam() && summons[k].getReal())
            {
                n[j] = summons[k];
                j++;
            }
        }
        return n;
    }
    public int numInStorage()
    {
        int n = 0;
        for (Summon s : summons)
        {
            if (!s.getInTeam() && s.getReal())
            {
                n++;
            }
        }
        return n;
    }
    public String[] nameInStorage()
    {
        String[] n = new String[numInStorage()];
        int j = 0;
        for (int k = 0; k < summons.length; k++)
        {
            if (!summons[k].getInTeam() && summons[k].getReal())
            {
                n[j] = summons[k].getLongName();
                j++;
            }
        }
        return n;
    }
    public Summon[] inStorage()
    {
        Summon[] n = new Summon[numInStorage()];
        for (int k = 0; k < n.length; k++)
        {
            n[k] = new Summon();
        }
        int j = 0;
        for (int k = 0; k < summons.length; k++)
        {
            if (!summons[k].getInTeam() && summons[k].getReal())
            {
                n[j] = summons[k];
                j++;
            }
        }
        return n;
    }
    public void combineSummon(Summon main, Summon combine)
    {
        int a = main.getIntType();
        int b = combine.getIntType();
        
        if ((a == 0 && b == 4) || (a == 4 && b == 0))
        {           
            main.setType(6);
        }
        else if ((a == 0 && b == 5) || (a == 5 && b == 0))
        {
            main.setType(7);
        }
        else if ((a == 1 && b == 4) || (a == 4 && b == 1))
        {
            main.setType(8);
        }
        else if ((a == 1 && b == 3) || (a == 3 && b == 1))
        {
            main.setType(9);
        }
        else if ((a == 2 && b == 5) || (a == 5 && b == 2))
        {
            main.setType(10);
        }
        else if ((a == 2 && b == 3) || (a == 3 && b == 2))
        {
            main.setType(11);
        } 
    }
    public void renameSummon(Summon b, String n)
    {
        b.setName(n);
    }
    public void addSummon(Summon input)
    {
        summons[summonIndex] = input;
        summonIndex++;
        if (numInTeam() < maxTeam)
        {
            input.setInTeam(true);
            //return true;
        }
        else
        {
            input.setInTeam(false);
            //return false;
            
            C.showMessage(input.getName() + " was put into storage.", "");
        }        
    }
    //public boolean addedToTeam
    public boolean summonSpace()
    {
        if (summonIndex < summons.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void removeSummon(Summon input)
    {
        summons[summonIndex].setReal(false);
        summonIndex--;
    }
}
