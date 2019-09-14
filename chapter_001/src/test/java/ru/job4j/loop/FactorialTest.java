package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.Is.is;

public class FactorialTest {

    Factorial f = new Factorial();

    @Test
    public void calcTest1() {
        int result = f.calc(0);
        assertThat(result, is(1));
    }

    @Test
    public void calcTest2() {
        int result = f.calc(1);
        assertThat(result, is(1));
    }

    @Test
    public void calcTest3() {
        int result = f.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void calcTest4() {
        try {
            int result = f.calc(-1);
        } catch (IllegalArgumentException e) {
            assertThat(e, isA(IllegalArgumentException.class));
        }
    }

}