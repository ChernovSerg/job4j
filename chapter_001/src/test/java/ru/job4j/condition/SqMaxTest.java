package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SqMaxTest {

    @Test
    public void maxTest1() {
        int result = SqMax.max(4, 3, 5, 7);
        assertThat(result, is(7));
    }

    @Test
    public void maxTest2() {
        int result = SqMax.max(2, 1, 3, 0);
        assertThat(result, is(3));
    }

    @Test
    public void maxTest3() {
        int result = SqMax.max(4, 7, 5, 2);
        assertThat(result, is(7));
    }

    @Test
    public void maxTest4() {
        int result = SqMax.max(7, 4, 5, 2);
        assertThat(result, is(7));
    }

}