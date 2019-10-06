package ru.job4j.condition;

import ru.job4j.part01.Point;

public class Triangle {
    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        if (this.exist(p1, p2, p3)) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }
    }

    /**
     * Determines if a triangle exists with such sides
     *
     * @return true or false
     */
    private boolean exist(Point p1, Point p2, Point p3) {
        double ab = p1.distance(p2);
        double bc = p2.distance(p3);
        double ac = p1.distance(p3);
        boolean result = false;
        if ((ab + ac) > bc && (ab + bc) > ac && (bc + ac) > ab) {
            result = true;
        }
        return result;
    }

    public boolean exist() {
        return this.p1 != null;
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * @return Периметр.
     */
    public double perimeter() {
        return this.p1.distance(this.p2) + this.p2.distance(this.p3) + this.p1.distance(this.p3);
    }

    /**
     * Метод должен вычислить площадь треугольника.
     * <p>
     * Формула:
     * √ p *(p - ab) * (p - ac) * (p - bc)
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        if (this.exist()) {
            double p = this.perimeter() / 2;
            double ab = this.p1.distance(this.p2);
            double bc = this.p2.distance(this.p3);
            double ac = this.p1.distance(this.p3);
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}
