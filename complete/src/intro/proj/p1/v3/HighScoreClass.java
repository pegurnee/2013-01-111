package intro.proj.p1.v3;


/* Holds information regarding high scores
 * 
 */
public class HighScoreClass implements Comparable<HighScoreClass>
{
    public int scoreValue;
    public String userName;

    public int compareTo(HighScoreClass compareHighScoreClass)
    {
        int compareQuantity = ((HighScoreClass) compareHighScoreClass).score(); 

        return this.scoreValue - compareQuantity;
    }
    public int score()
    {
        return scoreValue;
    }
    public String name()
    {
        return userName;
    }
}
