package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class MatrixTest {

    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}