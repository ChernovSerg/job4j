package ru.job4j.condition;

public class Max {
    /**
     * Return maximum of two values
     * @param left
     * @param right
     * @return maximum
     */
    public static int max(int left, int right) {
        int result = left >= right ? left : right;
        return result;
    }

    /**
     * Return maximum of three values
     * @param first
     * @param second
     * @param third
     * @return maximum
     */
    public static double max(double first, double second, double third) {
        double max = first;
        if (second >= max && second >= third) {
            max = second;
        } else if (third >= max && third >= second) {
            max = third;
        }
        return max;
    }
}
