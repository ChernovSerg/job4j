package ru.job4j.array;


public class Matrix {

    /**
     * Method creates a matrix (two-dimensional array)
     *
     * @param size array dimension
     * @return matrix instance
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
