import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TestDivision {
    public Calculator calc = new Calculator();

    @Test
    public void testDivision1() {

        //Input,Given,Threshold
        String input = "4/2";
        Double expected =  2.0;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestDivision2() {

        //Input,Given,Threshold
        String input ="10/3";
        Double expected = 3.3333;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);
    }

    @Test
    public void TestDivision3() {

        //Input,Given,Threshold
        String input ="5/2";
        Double expected = 2.5;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestDivision4() {

        //Input,Given
        String input ="0/0";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }
}