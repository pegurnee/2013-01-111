

public class Resources
{
    private int numOfResource; // current number of resources
    private int maxValue; // total number obtained
    private int oldValue; // number of resources 
    private String name; // name of the resource

    // name methods
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }        

    // current value
    public int getValue() // returns the current number of resources
    {
        return numOfResource;
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
    public int getOld()
    {
        return oldValue;
    }
    public void setOld(int yesterdayValue)
    {
        oldValue = yesterdayValue;
    }
    
    // value editors
    public void setValue(int setValue)
    {
        numOfResource = setValue;
        maxValue = setValue;
    }
    public void minusValue(int minusValue)
    {
        numOfResource = numOfResource - minusValue;
    }
    public void addValue(int addValue)
    {
        numOfResource = numOfResource + addValue;
        maxValue = maxValue + addValue;
    }
}