package intro.proj.p1.v3;

public class MinionJobs
{
    private int numOfWorker; // current number of workers declared
    private int bonus; // current level of bonus
    private String name; // name of person doing job
    private String active; // active term for the job
    private String past; // past term for the job
    private String verb; // verb of the job
    
    // value related methods
    public int getValue()
    {
        return numOfWorker;
    }
    public void setValue(int setValue)
    {
        numOfWorker = setValue;
    }
    public void addValue(int addValue)
    {
        numOfWorker = numOfWorker + addValue;
    }
    
    // name related methods
    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setActive(String input)
    {
        active = input;
    }
    public String getActive()
    {
        return active;
    }
    public void setPast(String input)
    {
        past = input;
    }
    public String getPast()
    {
        return past;
    }
    public void setVerb(String input)
    {
        verb = input;
    }
    public String getVerb()
    {
        return verb;
    }
    
    // bonus related methods
    public void setBonus(int newBonus)
    {
        bonus = newBonus;
    }
    public int getBonus()
    {
        return bonus;
    }
}