package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class FindLoopTest {

    @Test
    public void findTest1() {
        int[] array = {2, -3, 5, 8, -2};
        FindLoop find = new FindLoop();
        int pos = find.indexOf(array, 8);
        assertThat(pos,is(3));
    }

    @Test
    public void findTest2() {
        int[] array = {2, -3, 5, 8, -2};
        FindLoop find = new FindLoop();
        int pos = find.indexOf(array, 6);
        assertThat(pos,is(-1));
    }
}