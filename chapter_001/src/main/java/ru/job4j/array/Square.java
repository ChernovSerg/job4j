package ru.job4j.array;

public class Square {
    /**
     * Array of numbers in degree 2
     * @param bound
     * @return array of "bound" numbers in degree 2.
     */
    public int[] calculate(int bound) {
        if (bound <= 0) {
            return new int[1];
        }
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
