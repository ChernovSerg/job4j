package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int max = first;
        if (second > max && second > third) {
            max = second;
        } else if (third > max && third > second) {
            max = third;
        }
        return max;
    }
}
