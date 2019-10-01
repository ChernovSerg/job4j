package ru.job4j.part01;

public class SqArea {
    /**
     * Determines the area of a square
     * @param p perimeter
     * @param k coefficient
     * @return area of a square
     */
    public static int square(int p, int k) {
        int h = p / (2 * (k + 1));
        int lng = h * k;
        return h * lng;
    }

    public static void main(String[] args) {
        int result1 = square(4, 1);
        System.out.println(" p = 4, k = 1, s = 1, real = " + result1);
        result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 1, real = " + result1);
    }
}
