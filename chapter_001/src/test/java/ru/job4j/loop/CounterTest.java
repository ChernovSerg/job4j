package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CounterTest {

    @Test
    public void SumTest1() {
        Counter cnt = new Counter();
        int sum =  cnt.add(1,5);
        assertThat(sum, is(6));
    }

    @Test
    public void SumTest2() {
        Counter cnt = new Counter();
        int sum =  cnt.add(1,4);
        assertThat(sum, is(6));
    }

    @Test
    public void SumTest3() {
        Counter cnt = new Counter();
        int sum =  cnt.add(2,7);
        assertThat(sum, is(12));
    }

    @Test
    public void SumTest4() {
        Counter cnt = new Counter();
        int sum =  cnt.add(2,6);
        assertThat(sum, is(12));
    }

    @Test
    public void SumTest5() {
        Counter cnt = new Counter();
        int sum =  cnt.add(-5,2);
        assertThat(sum, is(-4));
    }

}
