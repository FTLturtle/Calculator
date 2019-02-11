/**
 * This program makes use of the mXparser package developed by Mariusz Gromada
 * URL: http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html
 *
 * To get the code to run, you need to add the library MathParser.org-mXparser-v.4.2.0-jdk.1.8.jar
 * which is already included in the lib folder.
 */

import org.mariuszgromada.math.mxparser.*;
import java.util.ArrayList;

public class Calculator {
    private int base; // current base of calculator. The base controls how the calculator interprets input and output valid bases are 1 to 36, but default is 10
    private String trigUnits; // current trig units, degrees or radians. Controls how trig functions work (sin(), cos(), etc.)
    private double memory; // double value stored in memory
    private double currentValue; // most recent value

    /**
     *  Constructor. Defaults to base 10, radians as trig units, and 0 for the memory and currentValue
     */
    public Calculator(){
        base = 10;
        trigUnits = "radians";
        memory = 0;
        currentValue = 0;
    }


    // PUBLIC METHODS:
    /**
     * This is the main method of the calculator object. This method takes a String as input (e.g., "(2 * 3) / 2"),
     * interprets the string as a mathematical expression, calculates the value of the expression,
     * and returns the value as a String (e.g., "2.5"). If the input is not a valid mathematical expression, the
     * method will return the string "NaN".
     */
    public String calc(String input){

        // Checking for degrees or radians mode
        if (trigUnits.equals("degrees")) {
            mXparser.setDegreesMode();
        } else {
            mXparser.setRadiansMode();
        }

        String convertedInput = convertExpressionToDecimal(input, this.base); // If the user has changed the base, the expression needs to be converted to decimal before it will work.

        Expression expression = new Expression(convertedInput); // Declaring and initializing a new Expression object
        this.currentValue = expression.calculate(); // Calculating the value of the expression

        return valueAsStringInCorrectBase(this.currentValue); // returns the value of the expression in the correct base
    }

    /**
     * Accesses the currentValue and returns it as a string
     */
    public String getCurrentValueAsString(){
        return valueAsStringInCorrectBase(this.currentValue);
    }

    /**
     * resets currentValue to 0.
     */
    public void resetCurrentValue(){
        this.currentValue = 0;
    }

    /**
     * inverts current value
     */
    public void invertCurrentValue(){
        this.currentValue = this.currentValue * -1;
    }

    /**
     * Accesses the memory and returns it as a string.
     */
    public String getMemoryAsString(){
        return valueAsStringInCorrectBase(this.memory);
    }

    /**
     * adds the currentValue to memory.
     */
    public void addCurrentValueToMemory(){
        this.memory = this.memory + this.currentValue;
    }

    /**
     * Resets memory to 0.
     */
    public void resetMemory(){
        this.memory = 0;
    }

    /**
     * Accesses the current base of the calculator and returns it as an int.
     */
    public int getBase() {
        return base;
    }

    /**
     * Sets the current base of the calculator. Valid bases are 1 to 36. If a valid number is not entered, then no
     * change occurs.
     */
    public void setBase(int newBase) {
        if (newBase >= 1 && newBase <= 36) {
            this.base = newBase;
        }
    }

    /**
     * Accesses the current trigUnits being used for trig functions.
     */
    public String getTrigUnits() {
        return trigUnits;
    }

    /**
     * Sets the current trigUnits being used. Valid input is "degrees" or "radians". If a valid input is not entered,
     * then no change occur.
     */
    public void setTrigUnits(String newTrigUnits) {
        if (newTrigUnits.equals("degrees") || newTrigUnits.equals("radians")) {
            this.trigUnits = newTrigUnits;
        }
    }



    // PRIVATE METHODS:

    /**
     * This method takes a string, expressionToConvert (e.g., "1010 + 0011101", in base originalBase (e.g., base 2)
     * and turns it into an expression in base 10 (10.0 + 29.9) and returns that. This is essential, because the
     * mXparser library only supports parsing strings as mathematical expressions in decimal. Before an expression
     * in another base can be properly evaluated, it needs to be converted into decimal.
     */
    private static String convertExpressionToDecimal(String expressionToConvert, int originalBase){

        if (originalBase == 10){ // if the base is already 10, then the expression does not need to be changed.
            return expressionToConvert;
        }

        // in every case, but base 10, the expression needs to be converted to decimal
        String newExpression = "";
        String tempString = "";
        ArrayList<String> stringArray = new ArrayList();

        // The following for loop splits up the expressionToConvert string into multiple pieces in an arrayList
        // it looks for the numbers and splits it up so each number is in its own string
        // NOTE: for bases 11 to 36, uppercase characters are used as digits.
        for (int i = 0; i < expressionToConvert.length(); i++){
            if (Character.isDigit(expressionToConvert.charAt(i)) || Character.isUpperCase(expressionToConvert.charAt(i))){
                tempString += expressionToConvert.charAt(i);
                if (i+1 == expressionToConvert.length() || !(Character.isDigit(expressionToConvert.charAt(i+1)) || Character.isUpperCase(expressionToConvert.charAt(i+1)))){
                    stringArray.add(tempString);
                    tempString = "";
                }
            } else {
                tempString += expressionToConvert.charAt(i);
                if (i+1 == expressionToConvert.length() || Character.isDigit(expressionToConvert.charAt(i+1)) || Character.isUpperCase(expressionToConvert.charAt(i+1))){
                    stringArray.add(tempString);
                    tempString = "";
                }
            }
        }

        // The following for loop converts all the numbers from their original base into decimal, and then reconstructs the string
        for (String s : stringArray) {

            if (Character.isDigit(s.charAt(0)) || Character.isUpperCase(s.charAt(0))){
                tempString = "" + mXparser.convOthBase2Decimal(s, originalBase);
            } else {
                tempString = s;
            }
            newExpression = newExpression + tempString;

        }
        return newExpression;
    }

    private String valueAsStringInCorrectBase(double value){
        if (this.base == 10){
            return "" + value;
        }
        return mXparser.convDecimal2OthBase(value, this.base);
    }

}