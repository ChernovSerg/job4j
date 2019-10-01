package ru.job4j.loop;

public class Board {
    /**
     * Prints a field size of width on height
     * @param width field width
     * @param height field height
     */
    public static void paint(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int cell = 0; cell < width; cell++) {
                if ((row + cell) % 2 == 0) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        paint(3, 3);
        System.out.println();
        paint(6, 6);
        System.out.println();
        paint(9, 9);
    }
}
