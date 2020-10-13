package functional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void firstDivisorTest() {
        int num = 21;
        Integer[] divisors = new Integer[] { 1, 3, 7 };

        assertArrayEquals(divisors, PerfectNumber.divisors(num).toArray());
    }
}
