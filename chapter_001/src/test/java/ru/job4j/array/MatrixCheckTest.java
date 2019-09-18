package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixCheckTest {
    @Test
    public void getRowTest() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', 'X', ' ', ' '},
                {'X', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', 'X', ' '},
        };
        char[] expected = {' ', 'X', 'X', ' ', ' '};

        char[] result = MatrixCheck.getRow(input,1);
        System.out.println(result);
        assertThat(result, is(expected));
    }

    @Test
    public void getColumnTest() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', 'X', ' ', ' '},
                {'X', ' ', 'X', ' ', ' '},
                {' ', 'Y', 'X', 'X', ' '},
        };
        char[] expected = {' ', 'X', ' ', 'Y'};

        char[] result = MatrixCheck.getColumn(input,1);
        System.out.println(result);
        assertThat(result, is(expected));
    }

    @Test
    public void arrayIsMonoGood() {
        char[] row = {'X', 'X', 'X'};
        boolean actual = MatrixCheck.arrayIsMono(row, 'X');
        assertThat(actual, is(true));
    }

    @Test
    public void arrayIsMonoFail() {
        char[] row = {'X', ' ', 'X'};
        boolean actual = MatrixCheck.arrayIsMono(row, 'X');
        assertThat(actual, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }

}