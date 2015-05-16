package com.egurnee.school.intro.labs.l10;

/**
 * Holds information of the Student's name, number of tests taken, and score on test
 * 
 * @author Eddie Gurnee
 * @version 0.0.1
 */
public class Student
{
    private int nTests;
    private double[] testScores;
    private String name;
    
    public Student()
    {
        this(5);
    }
    public Student(int inputNumTests)
    {
        this(inputNumTests, "Default");
    }
    public Student(int inputNumTests, String inputName)
    {
        nTests = inputNumTests;
        name = inputName;
        testScores = new double[nTests];
        randomizeTests();
    }
    
    private void randomizeTests()
    {
        for (int k = 0; k < nTests; k++)
        {            
            testScores[k] = ((Math.random() * 30) + 70);
        }
    }
    
    public double getMean()
    {
        double sum = 0;
        for (int k = 0; k < nTests; k++)
        {
            sum += testScores[k];
        }
        return sum/nTests;
    }
    public String getGrade()
    {
        if (getMean() > 95) return "A+";
        else if (getMean() > 92) return "A";
        else if (getMean() > 90) return "A-";
        else if (getMean() > 87) return "B+";
        else if (getMean() > 83) return "B";
        else if (getMean() > 80) return "B-";
        else if (getMean() > 77) return "C+";
        else if (getMean() > 73) return "C";
        else if (getMean() > 70) return "C-";
        else if (getMean() > 67) return "D+";
        else if (getMean() > 63) return "D";
        else return "F";
    }
    
    public String toString()
    {
        String str = "Name: " + name;
        for (int k = 0; k < nTests; k++)
        {
            str += String.format("\nTest #%d: %.2f%%", (k +1), testScores[k]);
        }
        str += String.format("\nMean: %.2f%%", getMean());
        str += "\nGrade: " + getGrade();
        return str;
    }    
}
