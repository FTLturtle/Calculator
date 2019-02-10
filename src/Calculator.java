/**
 * This program makes use of the mXparser package developed by Mariusz Gromada:
 * http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html
 *
 * To get the code to run, you need to add the library MathParser.org-mXparser-v.4.2.0-jdk.1.8.jar
 *
 * That library is included in the folder "lib"
 */

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;

public class Calculator {
    private int base;
    private String trigUnits;
    private double memory;
    private double currentValue;
    private static int x;

    public Calculator(){
        base = 10;
        trigUnits = "radians";
        memory = 0;
        currentValue = 0;
    }

    // PUBLIC METHODS:
    /**
     * This method takes a String as input (e.g., "1 + 2 * 3"), interprets the string as a mathematical
     * expression, calculates the value of the expression, and returns the value as a String (e.g., "7").
     */
    public String calc(String input){

        // Checking for degrees or radians mode
        if (trigUnits.equals("degrees")) {
            mXparser.setDegreesMode();
        } else {
            mXparser.setRadiansMode();
        }

        String convertedInput = convertExpressionToDecimal(input, this.base);

        Expression expression = new Expression(convertedInput);
        this.currentValue = expression.calculate();

        return valueAsStringInCorrectBase(this.currentValue);
    }

    /**
     *
     * @return
     */
    public String getCurrentValueAsString(){
        return valueAsStringInCorrectBase(this.currentValue);
    }

    /**
     *
     */
    public void resetCurrentValue(){
        this.currentValue = 0;
    }

    /**
     *
     */
    public void invertCurrentValue(){
        this.currentValue = this.currentValue * -1;
    }

    /**
     *
     * @return
     */
    public String getMemoryAsString(){
        return valueAsStringInCorrectBase(this.memory);
    }

    /**
     *
     */
    public void addCurrentValueToMemory(){
        this.memory = this.memory + this.currentValue;
    }

    /**
     *
     */
    public void resetMemory(){
        this.memory = 0;
    }

    /**
     *
     * @return
     */
    public int getBase() {
        return base;
    }

    /**
     *
     * @param newBase
     */
    public void setBase(int newBase) {
        if (newBase >= 1 && newBase <= 36) {
            this.base = newBase;
        }
    }

    /**
     *
     * @return
     */
    public String getTrigUnits() {
        return trigUnits;
    }

    /**
     *
     * @param newTrigUnits
     */
    public void setTrigUnits(String newTrigUnits) {
        if (newTrigUnits.equals("degrees") || newTrigUnits.equals("radians")) {
            this.trigUnits = newTrigUnits;
        }
    }



    // PRIVATE METHODS:
    /**
     *
     * @return
     */
    private double getCurrentValue() {
        return currentValue;
    }

    /**
     *
     * @param currentValue
     */
    private void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    /**
     *
     * @return
     */
    private double getMemory() {
        return memory;
    }

    /**
     *
     * @param memory
     */
    private void setMemory(double memory) {
        this.memory = memory;
    }

    /**
     *
     * @param addToMemory
     */
    private void addToCurrentMemory(double addToMemory){
        this.memory = this.memory + addToMemory;
    }


    /**
     * This method takes a string, expressionToConvert (e.g., "1010 + 0011101", in base originalBase (e.g., base 2)
     * and turns it into an expression in base 10 (10.0 + 29.9) and returns that.
     */
    private static String convertExpressionToDecimal(String expressionToConvert, int originalBase){
        if (originalBase == 10){
            return expressionToConvert;
        }

        String newExpression = "";
        String tempString = "";
        ArrayList<String> stringArray = new ArrayList();

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
