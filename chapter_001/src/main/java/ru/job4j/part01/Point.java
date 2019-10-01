package ru.job4j.part01;

public class Point {
    /**
     * Determines the distance between two points
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return distance between two points
     */
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 3, 4);
        System.out.println("result (0, 0) to (2, 0) = " + result);
    }
}
