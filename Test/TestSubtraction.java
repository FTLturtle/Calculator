import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSubtraction {
    public  Calculator calc = new Calculator();

    @Test
    public void testSubtraction1() {

        //Input
        String input ="49-6";
        String expected = "43.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testSubtraction2() {

        //Input
        String input ="951-111";
        String expected = "840.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testSubtraction3() {

        //Input
        String input ="-950-50";
        String expected = "-1000.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }
}