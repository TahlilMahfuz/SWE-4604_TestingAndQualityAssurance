import org.example.PrimeNumberDetector;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.*;

public class PrimeNumberTest {
    @Test
    public void testIsPrimeNumber2() {
        PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
        assertTrue(primeNumberDetector.isPrimeNumber(2));
    }
    @Test
    public void testIsPrimeNumber20(){
        PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
        assertFalse(primeNumberDetector.isPrimeNumber(20));
    }
    @Test
    public void testIsPrimeNumber47(){
        PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
        assertTrue(primeNumberDetector.isPrimeNumber(47));
    }
    @Test
    public void testIsPrimeNumber933(){
        PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
        assertFalse(primeNumberDetector.isPrimeNumber(933));
    }
    @Test
    public void testIsPrimeNumber1000000000000(){
        PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
        assertFalse(primeNumberDetector.isPrimeNumber(1000000000000L));
    }

    @Disabled("This test is disabled")
    @Test
    public void testNonIntegerInput() {
        try {
            PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
            primeNumberDetector.isPrimeNumber(2.5);
        } catch (IllegalArgumentException e) {
            assertEquals("Input must be a long integer in the range 2..1000000000000 inclusive", e.getMessage());
        }
    }
    @Test
    public void testIntegersLessThan2() {
        try {
            PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
            primeNumberDetector.isPrimeNumber(1);
        } catch (IllegalArgumentException e) {
            assertEquals("Input must be a long integer in the range 2..1000000000000 inclusive", e.getMessage());
        }
    }
    @Test
    public void testNegativeLongs() {
        try {
            PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
            primeNumberDetector.isPrimeNumber(-14);
        } catch (IllegalArgumentException e) {
            assertEquals("Input must be a long integer in the range 2..1000000000000 inclusive", e.getMessage());
        }
    }
    @Test
    public void testTooLargeLongs() {
        try {
            PrimeNumberDetector primeNumberDetector = new PrimeNumberDetector();
            primeNumberDetector.isPrimeNumber(1000000000000000000L);
        } catch (IllegalArgumentException e) {
            assertEquals("Input must be a long integer in the range 2..1000000000000 inclusive", e.getMessage());
        }
    }
}
