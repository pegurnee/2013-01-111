public class UserBuildings
{
    private String name; // name of the building    
    private int numOfBuildings; // the number of said buildings
    private int numBought; // the number of land ever purchased
    private int maxValue; // the maximun number of obtained buildings
    private int cost; // the cost of a specific building
    private int bonus; // the passive bonus added by the building
    private int buildingType; // the specific type of building: defending, gathering, recruiting    
    private CurrentUser theUser; // imports the User's information
    
    // constructor
    public UserBuildings(CurrentUser theUser, int buildType)
    {
        //theUser = importUser;
        //int diffMod = theUser.getDifficulty();
        for (int k = 0; k < buildType; k++)
            {
            if (buildType == k)
            {
                cost = (int)(10 * ((theUser.getDifficulty()*1.5) + 1) * (k + 1));
                buildingType = k;
            }
            if (theUser.getDifficulty() == k)
            {
                bonus = (15 - (k * 5));
            }
        }        
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
    
    // number related methods
    public void setValue(int setValue)
    {
        numOfBuildings = setValue;
    }
    public void minusValue(int minusValue)
    {
        numOfBuildings = numOfBuildings - minusValue;
        numBought = numBought - minusValue;
    }
    public void addValue(int addValue)
    {
        numOfBuildings = numOfBuildings + addValue;
        reconcile();
    }
    public int getValue() // returns the current number of resources
    {
        return numOfBuildings;
    }
    public void reconcile()
    {
        if (maxValue < numOfBuildings)
        {
            setMax(numOfBuildings);
        }
    }
    public int getBonus() // returns the current number of resources
    {
        return bonus;
    }
    
    // purchase related methods    
    public int getCost()
    {        
        return cost;
    }
    public void buyImprovement(CurrentUser theUser)
    {
        theUser.land.improveLand();
        theUser.gold.minusValue(this.getCost());
        numOfBuildings++;
        reconcile();
        recalculateCost(theUser);
    }
    private void recalculateCost(CurrentUser theUser)
    {        
        cost = (int)(10 * ((theUser.getDifficulty()*1.5) + 1) * (buildingType + 1));
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
}