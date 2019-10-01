package ru.job4j.array;

import java.util.Arrays;

public class Turn {
    /**
     * Flips an array
     *
     * @param array source array. No modified.
     * @return flipped array
     */
    public int[] back(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        return result;
    }
}
