import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTrigFunctions {
    Calculator calc = new Calculator();

    @Test
    public void TestTrigFunction1() {
        //Input
        String input = "sin(90)";
        Double expected = 0.893996663600;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction2() {
        //Input
        String input = "cos(90)";
        Double expected = -0.44807361612;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction3() {

        //Input,Given,Threshold
        String input = "tan(90)";
        Double expected = -1.99520041220;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction4() {
        //Input,Given,Threshold
        String input = "asin(90)";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestTrigFunction5() {
        //Input,Given,Threshold
        String input ="acos(90)";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestTrigFunction6() {
        String input = "atan(0)";
        Double expected = 0.0;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction7() {
        //Input
        String input = "asin(1)";
        Double expected = 1.570796326794;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction8() {
        //Input
        String input = "acos(1)";
        Double expected = 0.0;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction9() {

        //Input,Given,Threshold
        String input = "atan(10)";
        Double expected = 1.4711276774303;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }
}