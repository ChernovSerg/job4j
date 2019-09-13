package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MultiMaxTest {

    @Test
    public void MultiMaxTest1() {
        MultiMax check = new MultiMax();
        int result = check.max(6, 3, 4);
        assertThat(result, is(6));
    }

    @Test
    public void MultiMaxTest2() {
        MultiMax check = new MultiMax();
        int result = check.max(-3, 13, 4);
        assertThat(result, is(13));
    }

    @Test
    public void MultiMaxTest3() {
        MultiMax check = new MultiMax();
        int result = check.max(6, 3, 10);
        assertThat(result, is(10));
    }

}