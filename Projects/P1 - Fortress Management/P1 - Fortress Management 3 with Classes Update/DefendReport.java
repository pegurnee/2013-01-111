
/* Contains the report for defense
 * 
 */
public class DefendReport
{
    public static void run(CurrentUser theUser)
    {
        
        int battleStr = 0, battle = rand.nextInt(day + 5), treasure = rand.nextInt(day), dragonTreasure = 0;
        boolean checkBattle = false, dragonAttack = false;
        if (battle <= 4)
        {
            System.out.println("No combat today.");
            System.out.println("What a peaceful and marvelous day!");
        }
        else if (battle >= 5 && battle <= 7)
        {
            System.out.println(customNames[9]);
            checkBattle = true;
            battleStr = battle - 2;
        }
        else if (battle >= 8 && battle <= 11)
        {
            System.out.println(customNames[10]);
            checkBattle = true;
            battleStr = battle;
        }
        else if (battle >= 12 && battle <= 16)
        {
            System.out.println(customNames[11]);
            checkBattle = true;
            battleStr = battle + 2;
        }
        else if (battle >= 17 && battle <= 22)
        {
            System.out.println(customNames[12]);
            checkBattle = true;
            battleStr = battle + 5;
        }            
        else if (battle >= 23)
        {
            dragonAttack = true;
            System.out.println(customNames[13]);
            checkBattle = true;
            battleStr = battle + 10;
        }
        if (checkBattle == true)
        {
            System.out.println("You have " + defend + " " + customNames[4] + " on defense. Will it be enough?");
            System.out.println("Press Enter to find out!");
            keyboard.nextLine();

            int defendStr = (int)((defend * (Math.random() + 1)) + defendBonus + 1);
            if (defendStr >= battleStr)
            {
                System.out.println("Victory is yours!");                               
                if (dragonAttack == true)
                {
                    numDragonKill = numDragonKill + 1;
                    dragonTreasure = numDragonKill + rand.nextInt(day + 10);
                }
                numBattlesWon = numBattlesWon + 1;
                treasure = treasure + rand.nextInt(battle + luck);
                keyboard.nextLine(); 
            }
            else
            {
                System.out.println("Your " + customNames[4] + " have been defeated!");

                int dead = (int)(battleStr - defendStr - (Math.abs(Math.random() - .5) * (numMinions - defend)));
                if (dead >= numMinions)
                {
                    if (defend == 1)
                    {
                        System.out.println("When you have only one of your " + customNames[4] + " on defense, you should expect your " + customNames[2] + " to be overrun.");
                    }
                    else if (defend == 0)
                    {
                        System.out.println("Without any " + customNames[4] + " set to defend your " + customNames[2] + ", your innocent " + customNames[5] + " soon lay in the hands of the enemy.");
                    }
                    else
                    {
                        System.out.println("On this day, that shall live in infamy, all " + defend + " of your " + customNames[4] + " were overrun.");
                        System.out.println();
                        System.out.println("Death and mayham followed, and the rest of your " + customNames[3] + " soon lay dead and defeated.");
                    }
                    numMinions = numMinions - dead;
                }
                else if (dead > 1)
                {
                    System.out.println("Oh no! " + dead + " of your " + customNames[4] + " died in the battle!");
                    numMinions = numMinions - dead;
                }
                else if (dead == 1)
                {
                    System.out.println("Oh no! George R.R. Martin just killed your favorite " + customNames[4] + "!");
                    numMinions = numMinions - dead;
                }              
                else
                {
                    System.out.println("Luckily they all managed to survive!");
                }
                keyboard.nextLine();
                if (dead > 0 && numMinions > 0)
                {
                    gather = 0;
                    defend = 0;
                    recruit = 0;
                    fullMinions = false;
                    System.out.println("In the rush to escape the attack, your " + customNames[3] + " quit their active jobs.");                            
                    System.out.println(customNames[3] + " reset.");
                    keyboard.nextLine();
                }
            }            
        }
        if (numMinions > 0)
        {
            System.out.println("That's it for the battle report!");
            System.out.println();

            System.out.println("Press Enter to end the day!");
            day++;
        }
    }
}
