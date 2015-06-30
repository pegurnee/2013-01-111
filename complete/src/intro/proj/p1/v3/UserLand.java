package intro.proj.p1.v3;

public class UserLand
{
    private String name; // name of land
    private int numOfLand; // the number of land
    private int numBought; // the number of land ever purchased
    private int maxValue; // the maximun number of obtained land
    private int cost; // cost of purchasing land
    private int numImproved; // checks how many land is improved
    private CurrentUser theUser; // imports the User's information
    
    // constructor
    public UserLand(CurrentUser importUser)
    {
        theUser = importUser;        
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
    
    // current number related methods
    public void setValue(int setValue)
    {
        numOfLand = setValue;
    }
    public void minusValue(int minusValue)
    {
        numOfLand = numOfLand - minusValue;
        numBought = numBought - minusValue;
    }
    public void addValue(int addValue)
    {
        numOfLand = numOfLand + addValue;
        reconcile();
    }
    public int getValue() // returns the current number of resources
    {
        return numOfLand;
    }
    public void reconcile()
    {
        if (maxValue < numOfLand)
        {
            setMax(numOfLand);
        }
    }
    
    // purchase related methods
    public int getCost()
    {
        cost = 0;
        cost = ((theUser.getDifficulty() + 1) * (numBought + 1) * 5);
        return cost;
    }
    public void buyLand()
    {
        theUser.gold.minusValue(getCost());
        numBought++;
        numOfLand++;
        reconcile();
    }
    
    // improved land methods
    public void setImproved(int value)
    {
        numImproved = value;
    }
    public int getImproved()
    {
        return numImproved;
    }
    public void improveLand()
    {
        numImproved++;
    }
    public boolean checkRoomToImprove()
    {
        boolean check = false;
        if (getUnimproved() > 0)
        {
            check = true;
        }
        return check;
    }
    public int getUnimproved()
    {
        return numOfLand - numImproved;
    }
    
    // not current value methods 
    public int getMax() // returns the number of these resources gained
    {
        return maxValue;
    }
    public void setMax(int newMax) // sets the number of max resources to a specific number
    {
        maxValue = newMax;
    }
    public int getNumBought() // returns the number of these resources gained
    {
        return numBought;
    }
    public void setNumBought(int input) // sets the number of max resources to a specific number
    {
        numBought = input;
    }
}