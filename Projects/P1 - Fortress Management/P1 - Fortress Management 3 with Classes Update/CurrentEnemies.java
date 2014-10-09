public class CurrentEnemies
{
    private String name; // combat annoucement of the enemy
    private String eliteName; // name of the elite enemy, only used with enemies[4]
    private int battleStrength; // strength of the enemy
    private int numOfTreasure; // num of gold recieved on victory
    private int value; 
    
    public CurrentEnemies(int i)
    {
        value = i;
    }
    
    // name methods
    public void setName(String input)
    {
        name = input;
    }
    public String getName()
    {
        return name;
    }
    public void setEliteName(String input)
    {
        eliteName = input;
    }
    public String getEliteName()
    {
        return eliteName;
    }
    
    public int getTreasure()
    {
        return (int)(Math.random() * value);
    }
    // battle statistics
    
}