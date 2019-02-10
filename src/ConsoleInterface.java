import java.util.Scanner;
import org.mariuszgromada.math.mxparser.*;

public class ConsoleInterface {
    public static void display() {
        boolean run = true;
        Calculator newCalc = new Calculator();

        System.out.println("Welcome to the calculator, enter your equation below or enter one of the following commands: \n" +
                "Index - to print an index of available computations \n" +
                "Search - to check if your desired computation is available \n" +
                "Clear - to clear the calculator \n" +
                "Quit - to exit the calculator\n" +
                "Invert - to invert the sign of the value\n" +
                "Switch Display Mode - to change the operator units\n" +
                "Set Trig Units - to set the units displayed for trig functions" +
                "MC -  to clear the currently saved value from memory\n" +
                "MC+ - to add the currently displayed value to memory\n" +
                "MRC - to display the currently saved value to the console");
        while (run){
            Scanner mainScn = new Scanner(System.in);
            String input = mainScn.nextLine().toLowerCase();

            switch (input) {
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
                case "invert":
                    newCalc.invertCurrentValue();
                    System.out.println(newCalc.getCurrentValueAsString());
                    break;
                case "switch display mode":
                    System.out.println("Please enter the number of the base you would like to switch to switch to ");
                    int baseNum = mainScn.nextInt();
                    mainScn.nextLine();
                    newCalc.setBase(baseNum);
                    System.out.println("Your units are now changed");
                    break;
                case "set trig units":
                    System.out.println("Please enter Degrees or Radians to select your desired Trig Unit");
                    String trigUnit = mainScn.nextLine();
                    mainScn.nextLine().toLowerCase();
                    newCalc.setTrigUnits(trigUnit);
                    System.out.println("Your units are now changed");
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

    public static void index(){
        mXparser.consolePrintHelp();

    }

    public static void clearCommand(){
        for(int i = 0; i < 60; i++);
        System.out.println();
    }
}

