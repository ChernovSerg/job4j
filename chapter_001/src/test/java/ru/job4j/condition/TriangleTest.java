package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.part01.Point;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TriangleTest {

    @Test
    public void whenExist() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 2), new Point(2, 0));
        boolean result = triangle.exist();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotExist() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 2), new Point(0, -1));
        boolean result = triangle.exist();
        assertThat(result, is(false));
    }

    @Test
    public void calcPerimeter() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
        int actual = (int) (triangle.perimeter() * 10000);
        assertThat(actual, is(34142));
    }

    @Test
    public void calcArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
        double expected_area = 0.5;
        double actual_area = triangle.area();
        boolean expected = Math.abs(expected_area - actual_area) < 0.1e6;
        assertTrue(expected);
    }
}