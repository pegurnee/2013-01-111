
/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User
{
    private String name;
    private int difficulty;    
    private int numQuestions, numComplete, numCorrect, numWrong;
    private int bonusCorrect;
    
    /**
     * Constructor for objects of class User
     */
    public User()
    {
        name = "no name";
        difficulty = -1;
        
        numQuestions = 0;
        numComplete = 0;
        numCorrect = 0;
        numWrong = 0;
        
    }
    public User(String inputName, int inputDiff)
    {
        this();
        name = inputName;
        difficulty = inputDiff;
        
        if (difficulty == 1)
        {
            numQuestions = 10;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void completeQuestion(boolean b)
    {
        if (b)
        {
            numCorrect++;
        }
        else
        {
            numWrong++;
        }
        numComplete++;
    }
    public double getPercent()
    {
        return numCorrect/numComplete;
    }
}
