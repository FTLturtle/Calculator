import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestExponent {
public Calculator calc = new Calculator();

    @Test
    public void testExponent1() {

        //Input
        String input ="3^5";
        String expected = "243.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testExponent2() {

        //Input
        String input ="-(4^6)";
        String expected = "-4096.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testExponent3() {

        //Input
        String input ="2^0";
        String expected = "1.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testExponent4() {

        //Input
        String input ="-(2^0)";
        String expected = "-1.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testExponent5() {

        //Input
        String input ="3^2";
        String expected = "9.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

}