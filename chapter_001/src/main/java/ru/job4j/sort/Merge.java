package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        if (left.length == 0) {
            return right;
        } else if (right.length == 0) {
            return left;
        }

        for (int i = 0, j = 0, r = 0; i < left.length || j < right.length; r++) {
            if (i == left.length) {
                rsl[r] = right[j];
                j++;
                continue;
            } else if (j == right.length) {
                rsl[r] = left[i];
                i++;
                continue;
            }

            if (left[i] < right[j]) {
                rsl[r] = left[i];
                i++;
            } else if (right[j] < left[i]) {
                rsl[r] = right[j];
                j++;
            } else {
                rsl[r] = left[i];
                rsl[++r] = right[j];
                i++;
                j++;
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
