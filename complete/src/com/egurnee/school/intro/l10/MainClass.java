package com.egurnee.school.intro.l10;

/**
 * Write a description of class MainClass here.
 * 
 * @author Eddie Gurnee
 * @version 0.0.3
 */
public class MainClass
{
    public static void main(String[] args)
    {
        int nStudents = C.userInputInt("How many students are in the class?", "Class Size");
        int nTests = C.userInputInt("How many tests did each student take?", "Number of Tests");
        
        Student[] classroom = new Student[nStudents];        
        for (int k = 0; k < nStudents; k++)
        {
            classroom[k] = new Student(nTests);
        }
        
        for (int k = 0; k < nStudents; k++)
        {
            C.showMessage(classroom[k].toString(), "Student #" + (k + 1) + ":");
        }
        
    }
}
