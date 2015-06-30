package intro.labs.l09;

/**
 * Write a description of class MainClass here.
 * 
 * @author (Eddie Gurnee
 * @version 0.0.2
 */
public class MainClass
{
    public static void main(String[] args)
    {
        double[] meanTester;
        
        int intArraySize = C.userInputInt("How many numbers do you want in the array?", "Array Length");
        
        meanTester = new double[intArraySize];
        
        for (int k = 0; k < intArraySize; k++)
        {
            double dblInputNum = C.userInputDouble("What do you want number " + 
                (k + 1) + " to be?", "Input Number");
            
            meanTester[k] = dblInputNum;
        }
        
        if (meanTester.length == 0)
        {
            C.showMessage("I'm sorry my master, I cannot compute the mean of numbers" +
                "\nwhen you have given me no numbers to compute.", "ArrayIndexNonExistException");
        }
        else
        {
            int numInArray = 0, numGreaterThanMean = 0;
            double sumFromArray = 0.0;            
            for (double inputtedNumber : meanTester)
            {
                numInArray++;
                sumFromArray += inputtedNumber;                
            }
            double computedMean = sumFromArray/numInArray;
            for (double inputtedNumber : meanTester)
            {
                if (inputtedNumber > computedMean)
                {
                    numGreaterThanMean++;
                }
            }
            C.showMessage("The mean of the numbers is: " + computedMean + ".", "Mean del Array");
            
            C.showMessage("There are " + numGreaterThanMean + " numbers greater than the mean.", "Greater than Mean");
        }
    }
}
