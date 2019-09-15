package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class SquareTest {

    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound1Then1() {
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound0Then0() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{0};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBoundMinusThen0() {
        int bound = -1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{0};
        assertThat(rst, is(expect));
    }
}