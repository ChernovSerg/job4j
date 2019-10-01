package ru.job4j.loop;

public class Counter {
    /**
     * Sum of even numbers
     * @param start
     * @param finish
     * @return sum of even numbers
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
