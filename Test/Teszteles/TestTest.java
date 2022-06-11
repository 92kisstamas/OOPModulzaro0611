package Teszteles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @Test
    void isPrime() {
        boolean result1 = Teszteles.Test.isPrime(0);
        assertFalse(false, String.valueOf(result1));

        boolean result2 = Teszteles.Test.isPrime(1);
        assertFalse(false, String.valueOf(result2));

        boolean result3 = Teszteles.Test.isPrime(2);
        assertTrue(true, String.valueOf(result3));

        boolean result4 = Teszteles.Test.isPrime(23);
        assertTrue(true, String.valueOf(result4));

        boolean result5 = Teszteles.Test.isPrime(Integer.MAX_VALUE);
        assertTrue(true, String.valueOf(result5));

        boolean result6 = Teszteles.Test.isPrime(25);
        assertFalse(false, String.valueOf(result6));
    }
}