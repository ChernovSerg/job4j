package ru.job4j.loop;

public class Factorial {
    /**
     * Calculates factorial
     * @param n the number whose factorial is to be calculated
     * @return factorial
     * @throws IllegalArgumentException
     */
    public int calc(int n) throws IllegalArgumentException {
        int factorial = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return factorial;
    }
}
