package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CounterTest {

    @Test
    public void sumTest1() {
        Counter cnt = new Counter();
        int sum = cnt.add(1, 5);
        assertThat(sum, is(6));
    }

    @Test
    public void sumTest2() {
        Counter cnt = new Counter();
        int sum = cnt.add(1, 4);
        assertThat(sum, is(6));
    }

    @Test
    public void sumTest3() {
        Counter cnt = new Counter();
        int sum = cnt.add(2, 7);
        assertThat(sum, is(12));
    }

    @Test
    public void sumTest4() {
        Counter cnt = new Counter();
        int sum = cnt.add(2, 6);
        assertThat(sum, is(12));
    }

    @Test
    public void sumTest5() {
        Counter cnt = new Counter();
        int sum = cnt.add(-5, 2);
        assertThat(sum, is(-4));
    }

    @Test
    public void sumTest6() {
        Counter cnt = new Counter();
        int sum = cnt.add(4, -2);
        assertThat(sum, is(0));
    }

    @Test
    public void sumTest7() {
        Counter cnt = new Counter();
        int sum = cnt.add(1, 1);
        assertThat(sum, is(0));
    }

    @Test
    public void sumTest8() {
        Counter cnt = new Counter();
        int sum = cnt.add(4, 4);
        assertThat(sum, is(4));
    }
}
