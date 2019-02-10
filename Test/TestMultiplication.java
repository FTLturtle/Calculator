import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMultiplication {
    public Calculator calc = new Calculator();

    @Test
    public void testMultiplication1() {

        //Input
        String input = "8*4";
        String expected = "32.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestMultiplication2() {

        //Input
        String input = "333*333";
        String expected = "110889.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestMultiplication3() {

        //Input
        String input = "-5*5";
        String expected = "-25.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }
}