package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int max = first;
        if (second > max) {
            max = second;
        } else if (third > max) {
            max = third;
        }
        return max;
    }
}
