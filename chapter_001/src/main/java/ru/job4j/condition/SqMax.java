package ru.job4j.condition;

public class SqMax {
    /**
     * Return maximum of four values
     * @param first
     * @param second
     * @param third
     * @param forth
     * @return maximum
     */
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second && first > third && first > forth) {
            result = first;
        } else if (second > third && second > forth) {
            result = second;
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}
