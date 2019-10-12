package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.part01.Point;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class TriangleTest {

    @Test
    public void whenExist() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 0);
        boolean result = Triangle.exist(p1, p2, p3);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotExist() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(0, -1);
        boolean result = Triangle.exist(p1, p2, p3);
        assertThat(result, is(false));
    }

    @Test
    public void calcPerimeter() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
        double actual = triangle.perimeter();
        assertEquals(3.4142, actual, 0.0001);
    }

    @Test
    public void calcArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
        double expectedArea = 0.5;
        double actualArea = triangle.area();
        assertEquals(expectedArea, actualArea, 0.00001);
    }
}