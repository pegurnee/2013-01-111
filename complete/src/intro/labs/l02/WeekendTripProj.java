package intro.labs.l02;

/** 1/16/13
 * This is used to compute the time taken for a weekend trip, 
 * provided the trip is not too long or too short
 * Coding provided by Eddie Gurnee
 */
import java.util.Scanner; // imports the Scanner object
public class WeekendTripProj
{
    public static void main (String [ ] args)
    {
        Scanner keyboard = new Scanner(System.in); //create the variable keyboard of the scanner type
        
        double distance, travelTime, averageSpeed; //declares variable for distance, time, and average speed
        
        System.out.println("So you want to go on a weekend trip, huh?"); 
        System.out.println();
        System.out.print("How far is your destination? "); 
        distance = keyboard.nextDouble(); //reads the distance inputed
        
        if (distance > 300) //check distance greater than 300
        {
            if (distance > 600) //check distance greater than 600
            {
            System.out.println("YOU HAVE GOT TO BE KIDDING ME!! THAT'S WAY TOO FAR!!");
            }
            else {
            System.out.println("Sorry, but that distance is too long for a simple weekend trip") ;
            }
        }
        else if (distance < 19)
        {
            System.out.println("Sorry, but that distance is too close for a weekend trip");
        }
        else
        {
        System.out.println("That's sounds delightful!");
        
        System.out.println("What do you think your average speed will be (in miles per hour)? ");
        averageSpeed = keyboard.nextDouble(); //reads the average speed
        
        if (averageSpeed > 80) //check speed greater than 80
        {
            if (averageSpeed > 100) //check speed greater than 100
            {
            System.out.println("Cannot compute time considering amout of times you will be pulled over.");
            }
            else {
            System.out.println("You probably shouldn't be driving that fast.") ;
            }
        }
        else if (averageSpeed < 35)
        {
            System.out.println("Take public transportation, you drive too slow.");
        }
        else
        {
        travelTime = distance / averageSpeed;
                       
        System.out.println("With an average speed of " + averageSpeed + "mph, you should get there in " + travelTime + " hours.");
        System.out.println();
        System.out.println("Enjoy your weekend!");
        }
    }
    } 
}
