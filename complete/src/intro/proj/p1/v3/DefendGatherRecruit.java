package intro.proj.p1.v3;


/* Contains the DGR event
 */
public class DefendGatherRecruit
{
    public static class DefendGatherRecruitObj
    {
        private int numOfWorker; // current number of workers declared
        private int testNumOfWorker; // current temp number of workers
        private String name; // name of person doing job
        private boolean addOrSet; // the 'add' or 'set' option

        // value related methods
        public int getValue()
        {
            return numOfWorker;
        }
        public void setValue(int setValue)
        {
            numOfWorker = setValue;
        }
        public int getTemp()
        {
            return testNumOfWorker;
        }
        public void setTemp(int setValue)
        {
            testNumOfWorker = setValue;
        }

        // name related methods
        public String getName()
        {
            return name;
        }
        public void setName(String newName)
        {
            name = newName;
        }

        // addOrSet related methods
        public boolean getAddOrSet()
        {
            return addOrSet;
        }
        public void setAddOrSet(boolean input)
        {
            addOrSet = input;
        }
    }

    private static void convertAddOrSet(CurrentUser theUser, DefendGatherRecruitObj importDGR, String response)
    {
        try
        {
            if (response.equals("add") || (response.charAt(0) == theUser.getConfirmChar() && !response.equals("set")))
            {
                importDGR.setAddOrSet(true);
            }
            else if (response.equals("set") || (response.charAt(0) == theUser.getDenyChar() && !response.equals("add")))
            {
                importDGR.setAddOrSet(false);
            }
        }
        catch (Exception e)
        {
            System.out.println("Congratz, you broke the game.");
            System.exit(0);
        }
    }

    public static void checkIntDGR(CurrentUser theUser, DefendGatherRecruitObj importDGR, String question, int[] importOthers)
    {
        boolean check = false;
        while (!check)
        {
            String str = CommonChecks.forceAnswer(question);
            if (str.equals("max") || str.charAt(0) == 'm')
            {
                importDGR.setValue(theUser.minions.getValue() - importOthers[0] - importOthers[1]);
                check = true;
            }
            else
            {
                if (CommonChecks.checkNumberInt(str))
                {
                    importDGR.setValue(Integer.parseInt(str));
                    check = true;
                }
                else
                {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    public static int checkOverflowDGR(CurrentUser theUser, DefendGatherRecruitObj importDGR, int[] importOther)
    {
        int totalCurrentWorkers = 0;
        if (importDGR.getAddOrSet())
        {
            for (int k = 0; k < theUser.defGatRec.length; k++)
            {
                totalCurrentWorkers = totalCurrentWorkers + theUser.defGatRec[k].getValue();
            }                
        }
        else
        {
            for (int k = 0; k < importOther.length; k++)
            {
                totalCurrentWorkers = totalCurrentWorkers + importOther[k];
            }
        }        
        return (totalCurrentWorkers + importDGR.getValue());
    }

    public static void run(CurrentUser theUser, char commandImport)
    {
        DefendGatherRecruitObj theDGR = new DefendGatherRecruitObj();
        char[] checkArray = {'d', 'g', 'r'};
        int[] others = new int[2];
        int j = 0;
        int userIndexForGDR = -1;
        for (int k = 0; k < checkArray.length; k++)
        {
            if (commandImport == checkArray[k])
            {
                theDGR.setName(theUser.defGatRec[k].getName());
                userIndexForGDR = k;
            }
            else
            {
                others[j] = theUser.defGatRec[k].getValue();
                j++;
            }
        }
        String questionAddOrSet = "Do you want to add " + theDGR.getName() + ", or set total " + theDGR.getName() + "?";
        String[] possibleAddOrSet = {"add", "set"};
        String responseAddOrSet = CommonChecks.checkTwoStringOptions(theUser, questionAddOrSet, "Invalid command.", possibleAddOrSet);

        if (responseAddOrSet.charAt(0) == 'q')
        {
        }
        else
        {
            convertAddOrSet(theUser, theDGR, responseAddOrSet);
            String questionTempDGR = null;
            if (theDGR.getAddOrSet())
            {
                questionTempDGR = "Add how many " + theDGR.getName() + "? ";
            }
            else
            {
                questionTempDGR = "Set how many " + theDGR.getName() + "? ";
            }

            checkIntDGR(theUser, theDGR, questionTempDGR, others);
            theDGR.setTemp(checkOverflowDGR(theUser, theDGR, others));

            if (theDGR.getTemp() > theUser.minions.getValue())
            {
                System.out.println("I'm sorry " + theUser.getTitle() + ",");
                System.out.println("you don't have enough " + theUser.minions.getName() + " to do that.");
                System.out.println();
                System.out.println("Press 'm' to reset " + theUser.minions.getName() + " distribution.");
                System.out.println("Or press 's' to see where they are distributed.");
            }
            else
            {                
                String questionConfirm = null;
                if (!theDGR.getAddOrSet())
                {
                    questionConfirm = "Confirm setting " + theDGR.getValue() + " " + theDGR.getName() + "?";
                }
                else
                {
                    questionConfirm = "Confirm adding " + theDGR.getValue() + " " + theDGR.getName() + "?";
                }

                char confirmResult = CommonChecks.checkConfirmDeny(theUser, questionConfirm);

                if (confirmResult == theUser.getConfirmChar())
                {
                    if (theDGR.getAddOrSet())
                    {
                        theUser.defGatRec[userIndexForGDR].addValue(theDGR.getValue());                        
                    }
                    else
                    {
                        theUser.defGatRec[userIndexForGDR].setValue(theDGR.getValue());
                    }
                    System.out.print(theDGR.getValue() + " " + theDGR.getName());

                    if (!theDGR.getAddOrSet())
                    {
                        System.out.println(" set.");
                    }
                    else
                    {
                        System.out.println(" added. You now have " + theUser.defGatRec[userIndexForGDR].getValue() + " " + theDGR.getName() + " prepared to " + theUser.defGatRec[userIndexForGDR].getVerb() + " during the night.");
                    }
                }
            }
        }
    }
}