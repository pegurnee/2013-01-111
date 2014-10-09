
/* The lab class
 * 
 */
public class Lab07
{
    private int h; // hours    
    private int s; // scholarship
    private int t; // tuition
    
    private double f; // fees

    private boolean sc; // check science student        

    private String cQ = "Would you like to see another stage?"; // continue prompt
    private String sQ = "What stage would you like to see?"; // stage selection question

    private String[] optS = {"Stage 1", "Stage 2", "Stage 3", "Exit"}; // stage options
    private String[] proS = { // prompts in individual stages
            "How many hours is the student registered for?",
            "Is the student a science student?",
            "How much in scholarships did the student recieve?",
        };
    private String[] optYN = {"Yes", "No"}; // yes or no options
    private String proT = "The total cost for the student is $"; // prompt for total

    private int staS; // stage select
    private int anoS; // another stage
    private int cheS; // science status
    public Lab07()
    {
        cStage();
    }
    public void cStage()
    {
        staS = UI.op(sQ, optS); // stage selection dialog
        if (staS == 3)
        {
            System.exit(0);
        }
        h = UI.in(proS[0]); // setting hours to dialog
        if (staS == 0)
        {
            st1();
        }
        else if (staS == 1 || staS == 2)
        {
            st2st3();
        }
        UI.dT(t); // displays total cost
        anoS = UI.op(cQ, optYN); // see another stage dialog box
        if (anoS == 0)
        {
            aStage();
        }
        else
        {
            System.exit(0);
        }
    }
    public void aStage()
    {
        cStage();
    }
    public void st1()
    {
        t = Maths.run(h); // sets total to the forumla
    }
    public void st2st3()
    {
        cheS = UI.op(proS[1], optYN);
        if (cheS == 0)
        {
            sc = true;
            f = 1.12;
        }
        else
        {
            sc = false;
            f = 1.09;
        }
        if (staS == 1)
        {
            st2();
        }        
        else
        {
            st3();
        }
    }
    public void st2()
    {
        t = Maths.run(h, f);
    }
    public void st3()
    {
        s = UI.in(proS[2]);
        t = Maths.run(h, f, s);
    }    
}
