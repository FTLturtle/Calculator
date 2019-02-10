/**
 * This program makes use of the mXparser package developed by Mariusz Gromada:
 * http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html
 *
 * To get the code to run, you need to add the library MathParser.org-mXparser-v.4.2.0-jdk.1.8.jar
 *
 * That library is included in the folder "lib"
 */

import org.mariuszgromada.math.mxparser.*;

public class Calculator {
    private int base;
    private String trigUnits;
    private double memory;
    private double currentValue;

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
        //1abc2x30yz67
        //("1", "abc", "2", "x", "30", "yz", "67")
        // convert input string to decimal
        // if (asdf.substring(0, 1).equals(0) ||

        Expression expression = new Expression(input);
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
     *
     * @param expressionToConvert
     * @param originalBase
     * @return
     */
    private static String convertExpressionToDecimal(String expressionToConvert, int originalBase){
        if (originalBase == 10){
            return expressionToConvert;
        }



        return "";
    }

    private String valueAsStringInCorrectBase(double value){
        if (this.base == 10){
            return "" + value;
        }
        return mXparser.convDecimal2OthBase(value, this.base);
    }

}
