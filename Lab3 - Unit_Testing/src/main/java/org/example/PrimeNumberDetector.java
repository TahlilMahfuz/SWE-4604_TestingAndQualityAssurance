package org.example;

public class PrimeNumberDetector {
    public static boolean isPrimeNumber(long value) {
        if (value < 2 || value > 1000000000000L) {
            throw new IllegalArgumentException("Input must be a long integer in the range 2..1000000000000 inclusive");
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static void isPrimeNumber(double value){
        throw new IllegalArgumentException("Input must be a long integer in the range 2..1000000000000 inclusive");
    }
}
