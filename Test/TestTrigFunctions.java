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
        String input = "tan(90)";
        Double expected = -1.99520041220;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    public void TestTrigFunction4() {
        String input = "tan(90)";
        Double expected = -1.99520041220;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    public void TestTrigFunction5() {
        String input = "tan(90)";
        Double expected = -1.99520041220;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    public void TestTrigFunction6() {
        String input = "tan(90)";
        Double expected = -1.99520041220;
        Double threshold = .0001;

        //When
        Double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }
}