import org.mariuszgromada.math.mxparser.*;

public class Calculator {
    private String displayMode;
    private String unitMode;
    private double memory;

    public Calculator(){
        displayMode = "decimal";
        unitMode = "radian";
        memory = 0;
    }

    public String calc(String input){
        Expression expression = new Expression(input);
        double value = expression.calculate();
        String result = "" + value;
        return result;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void addToCurrentMemory(double addToMemory){
        this.memory = this.memory + addToMemory;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
    }

    public String getUnitMode() {
        return unitMode;
    }

    public void setUnitMode(String unitMode) {
        this.unitMode = unitMode;
    }

    private void updateLastValue(){

    }
}
