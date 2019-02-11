/**
 * This program makes use of the mXparser package developed by Mariusz Gromada
 * URL: http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html
 *
 * To get the code to run, you need to add the library MathParser.org-mXparser-v.4.2.0-jdk.1.8.jar
 * which is already included in the lib folder.
 */

import java.util.Scanner;
import org.mariuszgromada.math.mxparser.*;

public class ConsoleInterface {

    /**
     * This is the main method for the ConsoleInterface class. This is the only method that is called from the main
     * method. It declares and initializes a Calculator object. It prints out instructions and asks the user to input
     * a command or a mathematical expression. If they input a command, it executes the command. If they input a
     * mathematical expression (for example (3 + 5) * 8) then it will send that expression to the calculator to
     * evaluate, and then give the user back the result.
     */
    public static void display() {
        boolean run = true;
        Calculator newCalc = new Calculator();

        System.out.println("Welcome to the calculator, enter a mathematical expression or enter one of the following commands: \n" +
                "Index - to display an index of available computations \n" +
                "Search - to check if your desired computation is available \n" +
                "Clear - to clear the calculator display\n" +
                "Quit - to exit the calculator\n" +
                "Set Base Mode - to set the current base between 1 and 36 (base 2 is binary, base 8 is octal, etc.) - default is 10\n" +
                "Check Base Mode - check the current base\n" +
                "NOTE: If you are working in a base above 10, use uppercase letters to represent the higher digits\n" +
                "Set Trig Units - to set the units used for trig functions (degrees or radians) - default is radians\n" +
                "Check Trig Units - check the current trig units being used\n" +
                "Current Value - to display the current value (i.e., the last value evaluated)\n" +
                "Reset Current Value - to reset the current value to 0\n" +
                "Invert - to invert the sign of the current value\n" +
                "MC -  to reset the value saved in memory to 0\n" +
                "MC+ - to add the currently displayed value to memory\n" +
                "MRC - to display the value saved in memory to the console\n" +
                "Welcome - to display this welcome message again (including list of commands)\n\n" +
                "Instructions: To use the calculator, enter a mathematical expression, for example: (3 + 5) * 8 * sin(pi/2)\n" +
                "The calculator will evaluate your expression and tell you the result. The example above\n" +
                "would give you an answer of 64. Enter 'Index' for a list of available computations. Check\n" +
                "above for other available commands. An invalid expression will return NaN.\n");
        while (run){
            System.out.println("Enter a mathematical expression or enter one of the commands listed in the welcome message");
            Scanner mainScn = new Scanner(System.in);
            String input = mainScn.nextLine();

            switch (input.toLowerCase()) {
                case "index":
                    ConsoleInterface.index();
                    break;
                case "search":
                    System.out.println("Please enter a function name to see if it is available");
                    String input2 = mainScn.nextLine().toLowerCase();
                    String[] searchValues = {"addition", "subtraction", "multiplication", "division", "exponential", "factorial", "sin", "cos", "tan", "modulo", "equality" };
                    for(int i = 0; i < searchValues.length; i++ ) {
                        if (searchValues[i].equals(input2)) {
                            System.out.println("Yes, " + input2 + " is an available function");
                        }
                    }
                    break;
                case "clear":
                    ConsoleInterface.clearCommand();
                    break;
                case "quit":
                    run = false;
                    System.out.println("Thank you for using the calculator, have a nice day");
                    break;
                case "current value":
                    System.out.println(newCalc.getCurrentValueAsString());
                    break;
                case "reset current value":
                    newCalc.resetCurrentValue();
                    System.out.println(newCalc.getCurrentValueAsString());
                    break;
                case "invert":
                    newCalc.invertCurrentValue();
                    System.out.println(newCalc.getCurrentValueAsString());
                    break;
                case "set base mode":
                    System.out.println("Please enter the number of the base you would like to switch to switch to ");
                    int baseNum = mainScn.nextInt();
                    mainScn.nextLine();
                    newCalc.setBase(baseNum);
                    System.out.println("Your units are now changed");
                    break;
                case "check base mode":
                    System.out.println("Current Base: " + newCalc.getBase());
                    break;
                case "set trig units":
                    System.out.println("Please enter Degrees or Radians to select your desired Trig Unit");
                    String trigUnit = mainScn.nextLine().toLowerCase();
                    newCalc.setTrigUnits(trigUnit);
                    System.out.println("Your units are now changed");
                    break;
                case "check trig units" :
                    System.out.println("Current trig units: " + newCalc.getTrigUnits());
                    break;
                case "mc":
                    newCalc.resetMemory();
                    System.out.println("Memory has been reset");
                    break;
                case "mrc":
                    System.out.println(newCalc.getMemoryAsString());
                    break;
                case "m+":
                    newCalc.addCurrentValueToMemory();
                    System.out.println("Value has been saved");
                    break;
                default:
                    System.out.println(newCalc.calc(input));
            }
        }
    }

    /**
     * This prints out the index of all available computations
     */
    public static void index(){
        mXparser.consolePrintHelp();

    }

    /**
     * This will clear the screen by inputting 60 newlines
     */
    public static void clearCommand(){
        for(int i = 0; i < 60; i++){
            System.out.println();
        }
    }
}

