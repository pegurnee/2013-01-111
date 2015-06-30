package intro.proj.pX.summoner_battles;

/**
 * Write a description of class Phase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phase
{
    public static int setupGame()
    {        
        return 2;
    }
    public static void endGame(Summoner user)
    {
    }
    public static void adventure(Summoner user)
    {
        user.setActive(true);
        
        while (user.getActive())
        {
            String[] adventureOptions = {"Manage Summons", "Advance Summoner", 
                "Explore", "Unranked Challenge", "Challenge Next Rank", "Resign"
            };
            
            int a = C.userSelectDropDown("What would you like to do?", "Select Event", adventureOptions);
            
            if (a == 0)
            {
                Adventure.manageSummons(user);
            }
            else if (a == 1)
            {
                Adventure.advanceSummoner(user);
            }
            else if (a == 2)
            {
                Adventure.explore(user);
            }
            else if (a == 3)
            {
                Adventure.unrankedChallenge(user);
            }
            else if (a == 4)
            {
                Adventure.challengeNextRank(user);
            }
            else
            {
                Adventure.resign(user);
            }
        }
    }
    private static void combat(Summoner user, Summon battler)
    {
    }
    private static void combat(Summoner user1, Summoner user2)
    {
    }
    private static void battle(Summon battler1, Summon battler2)
    {
    }
}
