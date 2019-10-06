package ru.job4j.part01;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        Point first = new Point(0, 0);
        Point second = new Point(3, 4);
        double expected = 5;
        double out = first.distance(second);
        Assert.assertEquals(expected, out, 0.001);
    }
}
