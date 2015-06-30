package intro.proj.p1.v1;

import java.util.Random;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		   Scanner keyboard = new Scanner(System.in);
	       Random rand = new Random();
	       
	       int day = 0, defendBonus = 0, gatherBonus = 0, luck = 0, numBattlesWon = 0, itemsFound = 0, gold = 5, maxGold = 0, defend = 0, gather = 0, yesterdayDefend = 0, yesterdayGather = 0, numMinions = 7, maxMinions = 0, numDragonKill = 0; ;
	       char firstTime;
	       String name;      
	       
	       System.out.print("Enter Name: ");
	       name = keyboard.nextLine();
	       
	       System.out.println();
	       System.out.println("Welcome Lord " + name +" to your new domain.");
	       
	       System.out.print("Is this your first time playing? [y/n] ");
	       firstTime = keyboard.nextLine().charAt(0);
	       
	       if (firstTime == 'y')
	       {           
	           System.out.println();
	           System.out.println("Well then let me tell you the basics...");
	           System.out.println("The point of this game is to survive.");
	           System.out.println("You take control of a small group of dedicated followers");
	           System.out.println("(known in this game as minions)");
	           System.out.println("managing their movements throughout the days.");
	           System.out.println("Would you like to see the commands? [y/n] ");
	           char checkLearnCommands = keyboard.nextLine().charAt(0);
	           
	           if (checkLearnCommands == 'y')
	           {               
	           System.out.println("Press 'd' to set defenders.");
	           System.out.println("Press 'g' to set gatherers.");
	           System.out.println("Press 's' to see economic status.");
	           System.out.println("Press 'r' to see reset minion distribution.");
	           System.out.println("Press 'e' to end the day.");
	           System.out.println("Press 'q' to quit game.");           
	        }
	           System.out.println();
	           System.out.println("If at anytime you need to see the command");
	           System.out.println("choices again, just enter 'h' or '?' at the '");
	           System.out.println();
	           System.out.println("If you run out of minions the game is over!");
	           System.out.println("Press Enter to Play!");
	           keyboard.nextLine();
	       }
	       
	       System.out.println();       
	       System.out.println("Your followers await.");
	       while (numMinions > 0)
	       {
	       for (day = 1; day > 0; day++)
	       {
	           System.out.println("Press Enter to start Day " + day + ", Lord " + name + ".");
	           keyboard.nextLine();
	           
	           if (maxMinions < numMinions)
	           {
	               maxMinions = numMinions;
	            }
	           if (maxGold < gold)
	           {
	               maxGold = gold;
	            }
	            
	           boolean endDay = false;
	           if (day > 1)
	           {
	                char sameWork = 'n';
	                System.out.println("Would you like to keep the same number ");
	                System.out.print("of gatherers and defenders as yesterday? [y/n] ");
	                sameWork = keyboard.nextLine().charAt(0);
	                if (sameWork == 'y')
	                {                    
	                    defend = yesterdayDefend;
	                    gather = yesterdayGather;
	                    
	                    char checkEnd = 'n';
	                    System.out.print("Would you like to end the day? [y/n] ");
	                    checkEnd = keyboard.nextLine().charAt(0);
	                    
	                    if (checkEnd == 'y')
	                    {
	                        endDay = true;
	                    }
	                }                
	           }
	           else
	           {
	                defend = 0;
	                gather = 0;                
	           }         
	           
	           while (endDay == false)
	           {
	           
	           char command = 'z';
	           System.out.print("What is your command? ");
	           command = keyboard.nextLine().charAt(0);
	           
	           if (command == 'h' || command == 'H' || command == '?')
	           {               
	               System.out.println("Press 'd' to set defenders.");
	               System.out.println("Press 'g' to set gatherers.");
	               System.out.println("Press 's' to see economic status.");
	               System.out.println("Press 'm' to see reset minion distribution.");
	               System.out.println("Press 'e' to end the day.");
	               System.out.println("Press 'q' to quit game.");
	               System.out.println("Press Enter to continue.");
	               keyboard.nextLine();
	            }
	            else if (command == 'd' || command == 'D')
	            {
	                int tempDefend = 0;
	                char confirmDefend = 'n';
	                
	                System.out.print("Set how many defenders? ");
	                tempDefend = keyboard.nextInt();
	                keyboard.nextLine();
	                System.out.print("Confirm " + tempDefend + " defenders? [y/n] ");
	                confirmDefend = keyboard.nextLine().charAt(0);
	                
	                if (confirmDefend == 'y' && (tempDefend + gather) <= numMinions)
	                {
	                    defend = tempDefend;
	                    System.out.println();
	                    System.out.println("Defenders set.");
	                    System.out.println();
	                }
	                else if (confirmDefend == 'y')
	                {
	                    System.out.println("You don't have enough minions to do that.");
	                    System.out.println("Press 'm' to reset minion distribution.");
	                    System.out.println("Or press 's' to see where they are distributed.");
	                    System.out.println("Press Enter to continue.");
	                    keyboard.nextLine();
	                }
	                else
	                {
	                    System.out.println();
	                }                
	            }
	            else if (command == 'g' || command == 'G')
	            {
	                int tempGather = 0;
	                char confirmGather = 'n';
	                
	                System.out.print("Set how many gatherers? ");
	                tempGather = keyboard.nextInt();
	                keyboard.nextLine();
	                System.out.print("Confirm " + tempGather + " gatherers? [y/n] ");
	                confirmGather = keyboard.nextLine().charAt(0);
	                
	                if (confirmGather == 'y' && (tempGather + defend) <= numMinions)
	                {
	                    gather = tempGather;
	                    System.out.println();
	                    System.out.println("Gatherers set.");
	                    System.out.println();
	                }
	                else if (confirmGather == 'y')
	                {
	                    System.out.println("You don't have enough minions to do that.");
	                    System.out.println("Press 'm' to reset minion distribution.");
	                    System.out.println("Or press 's' to see where they are distributed.");
	                    System.out.println("Press Enter to continue.");
	                    keyboard.nextLine();
	                }
	                else
	                {
	                    System.out.println();
	                } 
	            }
	            else if (command == 's' || command == 'S')
	            {
	                System.out.println("You currently have " + numMinions + " minions.");
	                if (numMinions > (defend + gather))
	                {
	                    System.out.println((numMinions - defend - gather) + " of which are unassigned.");
	                }
	                if (gather > 0)
	                {
	                    System.out.println(gather + " of them are gathering gold.");
	                }
	                if (defend > 0)
	                {
	                    System.out.println(defend + " of them are defending.");
	                }                
	                System.out.println("You currently have " + gold + " gold.");
	                System.out.println("Press Enter to continue.");
	                keyboard.nextLine();
	            }
	            else if (command == 'm' || command == 'M')
	            {
	                gather = 0;
	                defend = 0;
	                System.out.println("Minions reset. Press Enter to continue.");
	                keyboard.nextLine();
	            }
	            else if (command == 'e' || command == 'E')
	            {
	                char confirmEndDay = 'n';
	                System.out.print("Are you sure you want to end the day? [y/n] ");
	                confirmEndDay = keyboard.nextLine().charAt(0);
	                
	                if (confirmEndDay == 'y')
	                {
	                    if (numMinions > (defend + gather))
	                    {
	                        char confirmEndEnd = 'n';
	                        
	                        System.out.println();
	                        System.out.println("You still have unassigned minions.");
	                        System.out.println();
	                        System.out.print("Are you absolutely positive you want to end the day? [y/n] ");
	                        confirmEndEnd = keyboard.nextLine().charAt(0);
	                        
	                        if (confirmEndEnd == 'y')
	                        {                            
	                            endDay = true;
	                        }
	                    }
	                    else
	                    {
	                        endDay = true;
	                    }
	                }
	            }
	            else if (command == 'q' || command == 'Q')
	            {
	                System.exit(0);
	            }
	            else
	            {
	                System.out.println("Invalid Command. Press 'h' or '?' for help.");
	                System.out.println("Press Enter to continue.");
	                keyboard.nextLine();               
	            }
	        }
	        yesterdayDefend = defend;
	        yesterdayGather = gather;
	        
	        System.out.println("__________________________________________");
	        System.out.println();
	        System.out.println("Press Enter to see the day's events.");
	        keyboard.nextLine();
	        if (gather > 0)
	        {
	            int goldGen = rand.nextInt(gather + luck) + gatherBonus;
	        
	            if (goldGen > 0)
	            {
	                System.out.println("Your gatherers produced " + goldGen + " gold today!");
	                gold = gold + goldGen;
	                System.out.println("Your stockpiles now have " + gold + " gold!");
	                System.out.println();
	            }
	            else
	            {
	                System.out.println("Your gatherers weren't able to produce anything today, sorry!");
	            }            
	        }
	        else
	        {
	            System.out.println("You can't gather anything without assigning some gatherers!");
	        }
	        
	        System.out.println("Press Enter to go on to the battle report.");
	        keyboard.nextLine();
	        
	        int battleStr = 0, battle = day + rand.nextInt(5), treasure = rand.nextInt(day), dragonTreasure = 0;
	        boolean checkBattle = false, dragonAttack = false;
	        
	        if (battle <= 4)
	        {
	            System.out.println("No combat today.");
	            System.out.println("What a peaceful and marvelous day!");
	        }
	        else if (battle == 5 || battle >= 6)
	        {
	            System.out.println("Wild animals attack!!");
	            System.out.println("[Press Enter]");
	            keyboard.nextLine();
	            checkBattle = true;
	            battleStr = battle + 5;
	        }
	        else if (battle >= 20)
	        {
	            dragonAttack = true;
	            System.out.println("Dragon attack!!");            
	        }
	        
	        if (checkBattle == true)
	        {
	            System.out.println("You have " + defend + " troops on defense. Will it be enough?");
	            keyboard.nextLine();
	            
	            int defendStr = defend + rand.nextInt(day) + defendBonus + 1;
	            
	            if (defendStr >= battleStr)
	            {
	                System.out.println("Victory is yours!");                               
	                if (dragonAttack == true)
	                {
	                    numDragonKill = numDragonKill + 1;
	                    dragonTreasure = numDragonKill + rand.nextInt(day + 10);
	                }
	                treasure = treasure + rand.nextInt(battle + luck);
	                keyboard.nextLine(); 
	            }
	            else
	            {
	                System.out.println("Your troops have been defeated!");
	                
	                int dead = battleStr - defendStr - rand.nextInt(gather + 1);
	                keyboard.nextLine();
	                if (dead > 1)
	                {
	                    System.out.println("Oh no! " + dead + " of your troops died in the battle!");
	                    numMinions = numMinions - dead;
	                    keyboard.nextLine();
	                }
	                else if (dead == 1)
	                {
	                    System.out.println("Oh no! George R.R. Martin just killed your favorite minion!");
	                    numMinions = numMinions - dead;
	                    keyboard.nextLine();
	                }              
	                else
	                {
	                    System.out.println("Luckily they all managed to survive!");
	                    keyboard.nextLine();
	                }
	            }            
	        }
	        System.out.println("That's it for the battle report!");
	        System.out.println();
	        System.out.println("Press Enter to see if anything else happens today!");
	        keyboard.nextLine();
	        
	        int serendipity = rand.nextInt(day + defendBonus + gatherBonus + luck);
	        
	        if (serendipity < 1)
	        {
	            System.out.println("Oh well, there is always tomorrow!");
	        }
	        
	        System.out.println("__________________________________________");
	        System.out.println();
	       }
	    }
	    System.out.println();
	    System.out.println("Game over!");
	    System.out.println();
	    
	    double score = (day * 5) + (gold * 1.5) + (maxMinions / 3) + (numBattlesWon * 3) + (numDragonKill * 10);
	    
	    System.out.println("Lord " + name + ", by the end of your saga you had:");    
	    if (day == 1)
	    {
	        System.out.println("Survived for a only " + day + "day \nThat sucks.");
	    }
	    else if (day > 1 && day < 20)
	    {
	        System.out.println("Survived for a total of " + day + "days");    
	    }
	    else
	    {
	        System.out.println("Survived for a total of " + day + "days \nBADASS!!");
	    }
	    if (gold >= 50)
	    {
	        System.out.println("Obtained a total of " + gold + " gold \nBADASS!!");
	    }
	    else if (maxGold <= 5)
	    {
	        System.out.println("You never gathered any new gold.");
	    }
	    else
	    {
	        System.out.println("Obtained a total of " + gold + " gold");
	    }
	    if (maxMinions >= 20)
	    {
	        System.out.println("Recruited a total of " + (maxMinions - 7) + " minions \nBADASS!!");
	    }
	    else if (maxMinions <= 7)
	    {
	        System.out.println("You never recruited any new minions.");
	    }
	    else if (maxMinions == 8)
	    {
	        System.out.println("Recruited only " + (maxMinions - 7) + " minion");
	    }
	    else
	    {
	        System.out.println("Recruited a total of " + (maxMinions - 7) + " minions");
	    }
	    if (numBattlesWon >= 15)
	    {
	        System.out.println("Defended from " + numBattlesWon + " attacks \nBADASS!!"); 
	    }
	    else if (numBattlesWon == 1)
	    {
	        System.out.println("Defended from " + numBattlesWon + "attack");
	    }
	    else if (numBattlesWon < 1)
	    {
	        System.out.println("You never sucessfully defended from any attacks.");
	    }
	    else
	    {
	        System.out.println("Defended from " + numBattlesWon + "attacks");
	    }
	    if (numDragonKill == 0)
	    {
	        
	    }
	    else if (numDragonKill == 1)
	    {
	        System.out.println("Managed to successfully kill " + numDragonKill + " dragon");
	    }
	    else if (numDragonKill < 7)
	    {
	        System.out.println("Managed to successfully kill " + numDragonKill + " dragons");
	    }
	    else
	    {
	        System.out.println("Managed to successfully kill " + numDragonKill + " dragons \nBADASS!!");
	    }
	    System.out.println();
	    System.out.println("With all of that, your score was: " + score + ".");
	    if (score > 500)
	    {
	        System.out.println("That is a new high score! \nCongradulations!!");
	    }

	}

}
