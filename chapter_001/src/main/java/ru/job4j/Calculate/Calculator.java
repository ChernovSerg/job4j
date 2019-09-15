package ru.job4j.Calculate;

/**
 * It is simple calculator.
 * @author Сергей Ч
 *
 */
public class Calculator {
    /**
     * Method adds two arguments and prints them.
     * @param first
     * @param second
     * @return nothing
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * Method divides two arguments and prints them.
     * @param first
     * @param second
     * @return nothing
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(result);
    }

    /**
     * Method multiplies two arguments and prints them.
     * @param first
     * @param second
     * @return nothing
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(result);
    }

    /**
     * Method subtracts two arguments and prints them.
     * @param first
     * @param second
     * @return nothing
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(result);
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10,5);
    }
}
