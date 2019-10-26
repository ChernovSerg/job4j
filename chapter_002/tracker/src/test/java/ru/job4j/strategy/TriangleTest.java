package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void drawSquare() {
        Triangle square = new Triangle();
        assertThat(square.draw(), is(new StringBuilder()
                .append("  *  \n")
                .append(" * * \n")
                .append("*****").toString()));
    }
}