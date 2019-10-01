package ru.job4j.loop;

public class PrimeNumber {
    /**
     * Determines the number of primes in the range from 1 to "finish"
     * @param finish
     * @return number of primes
     */
    public int calc(int finish) {
        int count = 0;
        if (finish > 1) {
            for (int i = 2; i <= finish; i++) {
                boolean remainder = true;
                int j;
                for (j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        remainder = false;
                        break;
                    }
                }
                if (!remainder && j == i) {
                    count++;
                }
            }
        }
        return count;
    }
}
