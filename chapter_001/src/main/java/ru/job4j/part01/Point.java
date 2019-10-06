package ru.job4j.part01;

public class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Determines the distance between two points
     * @param another another point
     * @return distance between two points
     */
    public double distance(Point another) {
        return Math.sqrt(Math.pow((another.x - this.x), 2) + Math.pow((another.y - this.y), 2));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(3, 4);
        double result = first.distance(second);
        System.out.println("distance = " + result);
    }
}
