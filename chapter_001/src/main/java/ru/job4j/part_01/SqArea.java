package ru.job4j.part_01;

public class SqArea {
    public static int square(int p, int k) {
        int H = p / (2*(k+1));
        int L = H * k;
        return H * L;
    }

    public static void main(String[] args) {
        int result1 = square(4, 1);
        System.out.println(" p = 4, k = 1, s = 1, real = " + result1);
        result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 1, real = " + result1);
    }
}
