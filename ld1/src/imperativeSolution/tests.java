package imperativeSolution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void firstProcessTest()
    {
        assertEquals(STATE.PERFECT, PerfectNumber.process(6));
    }
    @Test
    public void secondProcessTest()
    {
        assertNotEquals(STATE.PERFECT, PerfectNumber.process(-6));
    }
    @Test
    public void thirdProcessTest()
    {
        assertEquals(STATE.DEFICIENT, PerfectNumber.process(1));
    }

    @Test
    public void firstDivisorTest() {
        int num = 6;
        Integer[] divisors = new Integer[] { 1, 2, 3 };

        assertArrayEquals(divisors, PerfectNumber.divisors(num).toArray());
    }

    @Test
    public void secondDivisorTest() {
        // correct behavior, array should not be created
        int num = 1;
        Integer[] divisors = new Integer[] { };

        assertArrayEquals(divisors, PerfectNumber.divisors(num).toArray());
    }
    @Test
    public void thirdDivisorTest() {
        int num = 21;
        Integer[] divisors = new Integer[] { 1, 3, 7 };

        assertArrayEquals(divisors, PerfectNumber.divisors(num).toArray());
    }

}
