import java.util.Scanner;
import java.text.NumberFormat;

public class LoanCalculator
{  
    public static double getDoubleWithinRange(Scanner sc, String prompt, 
    double min, double max) //validate double
    {
        double d = 0;
        boolean isValid = false;
        while(isValid == false)
        {
            System.out.println(prompt); //print prompt for double
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();

                if (d <= min) //if input <= minimum double
                {
                    System.out.println("Error! Number must be greater than " + min);
                    System.out.println();//print error grater than min double
                }
                else if (d >= max) // if input >= maximum double value 
                {
                    System.out.println("Error number must be less than " + max); 
                    System.out.println();//print error less than max double value
                }

                else 
                    isValid = true; //else double is valid
            }
            else 
            {
                System.out.println("Error! Invalid decimal value.");
                System.out.println();
                sc.nextLine();
            }
        }   

        return d;       //return double
    }
    //validate integer
    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while(isValid == false)
        {
            System.out.println(prompt); //print prompt for integer
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                if (i <= min) //if input <= minimum integer
                {
                    System.out.println("Error! Number must be greater than " + min);
                    System.out.println();//print error grater than min integer
                }
                else if (i >= max) // if input >= maximum integer value 
                {
                    System.out.println("Error number must be less than " + max); 
                    System.out.println();//print error less than max integer value
                }

                else 
                    isValid = true; //else integer is valid
            }
            else 
            {
                System.out.println("Error! Invalid integer value.");
                System.out.println();
                sc.nextLine();
            }
        }
        return i;       //return integer
    }
    public static void main(String[] args)
    {
        System.out.println("Welcome to the loan calculator"); //welcome user to loan calculator
        Scanner sc = new Scanner(System.in); // create new scanner
        String choice = "y"; //start choice loop
        while (choice.equalsIgnoreCase("y"))
        {
            System.out.println();
            System.out.println("DATA ENTRY");
            double loanAmount = getDoubleWithinRange(sc, "Enter loan amount: ", 
                    0.0, 1000000.0); //get user input for loanAmount
            //get user input for interestRate
            double interestRate = getDoubleWithinRange(sc, 
                    "Enter yearly interest rate: ", 0, 20); 
            //get user input for years
            int years = getIntWithinRange(sc, "Enter number of years: ", 0, 100); 
            int months = years * 12; // calculate years to months
            //calculate monthly payment
            double monthlyPayment = loanAmount * interestRate/
                (1 - 1/Math.pow(1 + interestRate, months)); 
            //import currency instance
            NumberFormat currency = NumberFormat.getCurrencyInstance(); 
            // import percent instance
            NumberFormat percent = NumberFormat.getPercentInstance(); 
            percent.setMinimumFractionDigits(1); //set fraction digits for percent 
            System.out.println("RESULST"); //print results 
            //print loanAmount
            System.out.println("Loan Amount: " + currency.format(loanAmount)); 
            //print interestRate
            System.out.println("Yearly interest rate: " + percent.format(interestRate)); 
            System.out.println("Number of years: " + years); //print years
            //print monthlyPayment
            System.out.println("Monthly payment: " + currency.format(monthlyPayment)); 

            boolean quit = false; 
            do{ 

                System.out.println();
                System.out.println("Continue? (y/n): "); //prompt user to continue 
                String userinput1 = sc.next();

                char choice1 = userinput1.toLowerCase().charAt(0); 
                switch(choice1){ 
                    case 'y': 

                    break; 
                    case 'n': 
                    // case n, do something here 
                    quit = true;
                    break; 
                    case ' ':
                    System.out.println("Error! This entry is required. Try again.");
                    break;
                    default: 
                    System.out.println("Error! Entry must be 'y or 'n''");
                    break; 
                } 
            }while (!quit);
        }
    }           
}