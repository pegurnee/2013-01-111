package com.egurnee.school.intro.labs.l07.silly;

/* Contains the methods that does the functions
 * 
 */
public class CPUClass
{
    private class ControlUnit
    {        
        private void checkUser(RAMClass ram)
        {
            UIClass.enterUser(ram, ram.T);
            alu.dasBoot(ram, alu.checkStrings(ram, ram.T));
            UIClass.enterUser(ram, ram.F);
            alu.dasBoot(ram, alu.checkStrings(ram, ram.F));
        }
        private void runStage(RAMClass ram)
        {
            UIClass.enterStage(ram, ram.T);
            alu.failedInput(ram, enterHours(ram));
            
            cu.seeAnother(ram);
        }
        private boolean enterHours(RAMClass ram)
        {
            UIClass.enterHours(ram);
            
            return alu.logicCheck(ram, ram.getHours());
        }
        private void stage1(RAMClass ram)
        {
            ram.setFeesNot();
            ram.noScholarship();
            UIClass.displayTotal(ram, alu.computeTotal(ram));
        }
        private void enterScience(RAMClass ram)
        {
            UIClass.enterScience(ram);
            ram.setScience(alu.checkScience(ram, ram.getScienceCheck()));
            alu.applyScienceFees(ram, ram.getScience());
        }
        private void stage2(RAMClass ram)
        {
            enterScience(ram);
            ram.noScholarship();
            UIClass.displayTotal(ram, alu.computeTotal(ram));
        }
        private boolean enterScholarship(RAMClass ram)
        {
            UIClass.enterScholarship(ram);
            
            return alu.logicCheck(ram, ram.getScholarship());
        }
        private void stage3(RAMClass ram)
        {
            enterScience(ram);
            alu.failedScholarship(ram, enterScholarship(ram));
        }
        private void stage3part2(RAMClass ram)
        {
            UIClass.displayTotal(ram, alu.computeTotal(ram));
        }
        private void seeAnother(RAMClass ram)
        {
            UIClass.anotherStage(ram, ram.F);
            alu.checkAnother(ram.getAnother());
            runStage(ram);
        }
        private void inputError(RAMClass ram)
        {
            UIClass.errorMessage(ram.getInputError());
        }
    }
    private class ArithmeticLogicUnit
    {
        private boolean checkStrings(RAMClass ram, boolean nYes)
        {
            for (int k = 0; k < ram.getAcceptedList(nYes).length; k++)
            {
                if (ram.getUser(nYes).equalsIgnoreCase(ram.getAcceptedList(nYes)[k]))
                {
                    return ram.T;
                }
            }
            return ram.F;
        }
        private void dasBoot (RAMClass ram, boolean safe)
        {
            if (!safe)
            {
                UIClass.errorMessage(ram.getNameError());
                System.exit(0);
            }
        }
        private boolean checkScience(RAMClass ram, int check)
        {
            if (check == 0)
            {
                return ram.T;
            }
            else
            {
                return ram.F;
            }
        }
        private void applyScienceFees(RAMClass ram, boolean science)
        {
            if (science)
            {
                ram.setFeesScience();
            }
            else
            {
                ram.setFeesNot();
            }
        }
        private boolean logicCheck (RAMClass ram, int checkNum)
        {
            if (checkNum < 0)
            { 
                return ram.T;
            }
            else
            {
                return ram.F;
            }
        }
        private int computeTotal(RAMClass ram)
        {
            ram.setTuition((int)(ram.getHours() * ram.getPerHour() * ram.getFees() + ram.getRounding()) - ram.getScholarship());
            
            if (ram.getTuition() < 0)
            {
                ram.setTuition(0);
            }
            
            return ram.getTuition();
        }
        private void failedScholarship(RAMClass ram, boolean check)
        {
            if(check)
            {
                cu.inputError(ram);
            }
            else
            {
                cu.stage3part2(ram);
            }
        }
        private void failedInput(RAMClass ram, boolean check)
        {
            if(check)
            {
                cu.inputError(ram);
            }
            else
            {
                compareStage(ram, ram.getStage());
            }
        }
        private void compareStage (RAMClass ram, int stageNum)
        {
            if (stageNum == 0)
            {
                cu.stage1(ram);
            }
            else if (stageNum == 1)
            {
                cu.stage2(ram);
            }
            else if (stageNum == 2)
            {
                cu.stage3(ram);
            }
            else
            {
                System.exit(0);
            }
        }
        private void checkAnother(int check)
        {
            if (check == 1)
            {
                System.exit(0);
            }
        }        
    }
    private ControlUnit cu = new ControlUnit();
    private ArithmeticLogicUnit alu = new ArithmeticLogicUnit();
    private RAMClass memory = new RAMClass();

    public CPUClass()
    {
        cu.checkUser(memory);
        cu.runStage(memory);
    }
}
