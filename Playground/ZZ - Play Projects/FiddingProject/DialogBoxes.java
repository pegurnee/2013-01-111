// Dialog boxes: get input

import javax.swing.*;     // user interface elements

public class DialogBoxes
{
    public static void main(String [ ] args)
    {
        JOptionPane.showMessageDialog
        (null,                                              // default frame
            "This is how an info message looks in BlueJ.",  // main message
            "Pay Attention",                                // title
            JOptionPane.INFORMATION_MESSAGE);               // kind of msg

        JOptionPane.showMessageDialog
        (null,
            "Danger, Will Robinson!",
            "Danger, Danger!",
            JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog
        (null,
            "Oh, how could you be so wayward?",
            "Your Bad",
            JOptionPane.ERROR_MESSAGE);      

        // Ask a yes/no question, get int answer via button press    
        int ynChoice = JOptionPane.showConfirmDialog
            ( null, 
                "Are we having fun yet?", 
                "Fun Question", 
                JOptionPane.YES_NO_OPTION);  // or YES_NO_CANCEL_OPTION

        System.out.println("Choice from Y/N dialog box: " + ynChoice);

        // Box that displays a set of choice buttons
        //   create array of options to present in dialog box    
        String [ ] options = {"Land", "Bonds", "Gold", "Stamps"};

        int n = JOptionPane.showOptionDialog   // n will store the choice
            (null, 
                "What would you like to invest in?", 
                "Investment Question", 
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,         // path to alternate icon
                options,      // array of options to display
                options[2]);  // default option

        JOptionPane.showMessageDialog
        (null,
            "You selected " + options[n],
            "Your Investment Choice",
            JOptionPane.INFORMATION_MESSAGE);

        // Select from drop-down list    
        String[ ] flavors = {"Vanilla", "Chocolate", "Strawberry"};

        String choice = (String)               // user choice received here
            JOptionPane.showInputDialog
            (null,                             // current frame
                "Choose Your Flavor",          // prompt
                "Swoop Scoop Ice Cream Shop",  // title
                JOptionPane.PLAIN_MESSAGE,
                null,                          // path to alternate icon
                flavors,                       // items in drop-down
                "Vanilla");                    // default choice

        System.out.println("Flavor choice: " + choice);

        // Read String typed by user

        choice = (String)               // user choice received here
        JOptionPane.showInputDialog
        (null,                           // current frame
            "What is your first name?",  // prompt
            "Greeter",                   // title
            JOptionPane.PLAIN_MESSAGE,
            null,                        // path to alternate icon
            null,                        // items in drop-down
            "Herman");                   // default choice (can be null)

        System.out.println("Hello, " + choice + "!");        

        // get numeric input via dialog box
        choice = (String)                // user choice received here
        JOptionPane.showInputDialog
        (null,                           // current frame
            "How many miles did you walk?",  // prompt
            "Calories Consumed",             // title
            JOptionPane.PLAIN_MESSAGE,
            null,                    // path to alternate icon
            null,                    // items in drop-down
            null);                   // default choice

        choice = choice.trim();      // trim off white space
        double miles = Double.parseDouble(choice);  // convert to double
        double calories = miles * 100.0;

        // display answer via information message (see note below)
        JOptionPane.showMessageDialog
        (null,  
            "You consumed " + calories + " calories.",
            "Calorie Consumption",
            JOptionPane.INFORMATION_MESSAGE);
    }
}

// Note: Can use formatted String in output instead of the raw double, e.g:
// String caloriesString = String.format("%6.1f", calories);
// ... then use caloriesString in the output message box.
