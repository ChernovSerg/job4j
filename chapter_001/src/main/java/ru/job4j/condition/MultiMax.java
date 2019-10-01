package ru.job4j.condition;

public class MultiMax {
    /**
     * Return maximum of three values.
     * @param first
     * @param second
     * @param third
     * @return maximum
     */
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
