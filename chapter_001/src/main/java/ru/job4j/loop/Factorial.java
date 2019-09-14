package ru.job4j.loop;

public class Factorial {
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
