package com.egurnee.school.intro.labs.l07.silly;

/* The RAM class, holds data for that is in use
 * 
 */
public class RAMClass
{
    private String user;
    private String pass;

    private String[] acceptedName = {"bill", "mike", "eddie"};
    private String[] acceptedPass = {"password", "123456", "12345678", "abc123", "qwerty",
            "monkey", "letmein", "dragon", "111111", "baseball",
            "iloveyou", "trustno1", "1234567", "sunshine", "master",
            "123123", "welcome", "shadow", "ashley", "football",
            "jesus", "michael", "ninja", "mustang", "password1",
            "1234", "12345", "pussy", "696969", "abc123",
            "jennifer", "2000", "jordan", "superman", "harley",
            "enter", "admin", "sesame", "backspace", "ctrlaltdel"
        };

    private String[] optionsStage = {"Stage 1", "Stage 2", "Stage 3", "Exit"};

    private String userPrompt = "Please enter your name:";
    private String passPrompt = "Please enter your password:";

    private String nameError = "Invalid Username or Password.";
    private String inputError = "Invalid User Input.";

    private String firstQuestion = "What stage would you like to see?";
    private String continueQuestion = "Would you like to see another stage?";
    
    private String[] stagePrompts = {
        "How many hours is the student registered for?",
        "Is the student a science student?",
        "How much scholarship did the student recieve?",
    };
    private String[] repeatYesNo = {"Yes", "No"};
    
    private String totalPrompt = "The total cost for the student is $";
    
    private int stageSelect;    
    private int anotherStage;
    private int checkScience;

    private final int PERHOUR = 1200;
    private int hours;       
    private int scholarship;    
    
    private int tuition;
    
    private final double ROUNDING = 0.5;
    private final double SCIENCEFEES = 1.12;
    private final double NORMALFEES = 1.09;
    private double fees; 

    private boolean scienceStudent;

    public final boolean T = true;
    public final boolean F = false;

    public void setUser(String n, boolean nYes)
    {
        if (nYes)
        {
            user = n;
        }
        else
        {
            pass = n;
        }
    }

    public String getUser(boolean nYes)
    {
        if (nYes)
        {
            return user;
        }
        else
        {
            return pass;
        }
    }

    public String[] getAcceptedList(boolean nYes)
    {
        if (nYes)
        {
            return acceptedName;
        }
        else 
        {
            return acceptedPass;
        }
    }
    
    public String[] getOptions (boolean fYes)
    {
        if (fYes)
        {
            return optionsStage;
        }
        else
        {
            return repeatYesNo;
        }
    }

    public String getUserPrompt(boolean nYes)
    {
        if (nYes)
        {
            return userPrompt;
        }
        else
        {
            return passPrompt;
        }
    }

    public String getQuestion (boolean fYes)
    {
        if (fYes)
        {
            return firstQuestion;
        }
        else
        {
            return continueQuestion;
        }
    }
    public String getNameError()
    {
        return nameError;
    }
    public String getInputError()
    {
        return inputError;
    }
    public String getTotalPrompt()
    {
        return totalPrompt;
    }
    
    public String getStagePrompts(int k)
    {
        return stagePrompts[k];
    }
    
    public void setStage(int input)
    {
        stageSelect = input;
    }
    public int getStage()
    {
        return stageSelect;
    }
    public int getPerHour()
    {
        return PERHOUR;
    }
    public void setHours(int input)
    {
        hours = input;
    }
    public int getHours()
    {
        return hours;
    }
    public void setFeesScience()
    {
        fees = SCIENCEFEES;
    }
    public void setFeesNot()
    {
        fees = NORMALFEES;
    }
    public double getFees()
    {
        return fees;
    }
    public double getRounding()
    {
        return ROUNDING;
    }
    public void noScholarship()
    {
        scholarship = 0;
    }
    public void setScholarship(int input)
    {
        scholarship = input;
    }
    public int getScholarship()
    {
        return scholarship;
    }
    public void setTuition(int input)
    {
        tuition = input;
    }
    public int getTuition()
    {
        return tuition;
    }
    public void setScienceCheck(int input)
    {
        checkScience = input;
    }
    public int getScienceCheck()
    {
        return checkScience;
    }
    public void setScience(boolean input)
    {
        scienceStudent = input;
    }
    public boolean getScience()
    {
        return scienceStudent;
    }
    public void setAnother(int input)
    {
        anotherStage = input;
    }
    public int getAnother()
    {
        return anotherStage;
    }
}
