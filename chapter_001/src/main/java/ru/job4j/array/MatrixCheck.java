package ru.job4j.array;

public class MatrixCheck {
    /**
     * Method determine if there is a win horizontal or vertical line.
     * Win simbol is 'X'.
     *
     * @param board source matrix (playing field)
     * @return true if there is a win, else - false.
     */
    public static boolean isWin2(char[][] board) {
        boolean result = false;
        if (board != null
                && board.length > 0
                && board[0].length > 0
                && board[0].length == board.length
        ) {
            char[] row;
            char[] column;
            for (int i = 0; i < board.length; i++) {
                row = MatrixCheck.getRow(board, i);
                column = MatrixCheck.getColumn(board, i);
                if (MatrixCheck.arrayIsMono(row, 'X')
                        || MatrixCheck.arrayIsMono(column, 'X')) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Method determine if there is a win horizontal or vertical line.
     * Win simbol is 'X'.
     * Method is more optimized than method "isWin2".
     *
     * @param board source matrix (playing field)
     * @return true if there is a win, else - false.
     */
    public static boolean isWin(char[][] board) {
        boolean result = false;
        if (board != null
                && board.length > 0
                && board[0].length > 0
                && board[0].length == board.length
        ) {
            for (int row = 0; row < board.length; row++) {
                int count1 = 0;
                int count2 = 0;
                if (board[row][row] == 'X') {
                    for (int cell = 0; cell < board.length; cell++) {
                        if (board[row][cell] == 'X') {
                            count1++;
                        }
                        if (board[cell][row] == 'X') {
                            count2++;
                        }
                    }
                    if (count1 == board.length || count2 == board.length) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the specified row of the matrix
     *
     * @param data   matrix
     * @param numRow row number
     * @return row
     */
    public static char[] getRow(char[][] data, int numRow) {
        char[] row = new char[data[numRow].length];
        for (int i = 0; i < data[numRow].length; i++) {
            row[i] = data[numRow][i];
        }
        return row;
    }

    /**
     * Returns the specified column of the matrix
     *
     * @param data      matrix
     * @param numColumn column number
     * @return row
     */
    public static char[] getColumn(char[][] data, int numColumn) {
        char[] column = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            column[i] = data[i][numColumn];
        }
        return column;
    }

    /**
     * Determine if the array is mono.
     *
     * @param data source array.
     * @param ch   the character which the array should be filled
     * @return true if array is mono, else - false.
     */
    public static boolean arrayIsMono(char[] data, char ch) {
        boolean result = false;
        if (data != null) {
            if (data.length > 0) {
                result = true;
                for (int i = 0; i < data.length; i++) {
                    if (data[i] != ch) {
                        result = false;
                        break;
                    }
                }
            } else {
                result = true;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin2(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        boolean win2 = isWin(hasWinVertical);
        System.out.println("A board has a winner2 : " + win2);
        System.out.println();

        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin2(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        boolean winHor2 = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor2);
        System.out.println();

        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin2(notWin);
        System.out.println("A board has a winner : " + lose);
        boolean lose2 = isWin(notWin);
        System.out.println("A board has a winner : " + lose2);
    }
}
