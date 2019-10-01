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
}
