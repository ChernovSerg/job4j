package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then1() {
        int result = Max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To2ThenAny() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void multiMax1() {
        double result = Max.max(3.0, 2.0, 1.0);
        assertThat(result, is(3.0));
    }

    @Test
    public void multiMax2() {
        double result = Max.max(2.0, 3.1, 1.0);
        assertThat(result, is(3.1));
    }

    @Test
    public void multiMax3() {
        double result = Max.max(1.0, 2.0, 3.0);
        assertThat(result, is(3.0));
    }

    @Test
    public void multiMax4() {
        double result = Max.max(2.0, 3.1, 3.1);
        assertThat(result, is(3.1));
    }

}
