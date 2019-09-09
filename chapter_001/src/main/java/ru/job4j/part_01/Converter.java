package ru.job4j.part_01;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println(in + " rubles are " + expected + " euro. Test result: " + passed);

        in = 180;
        expected = 2;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println(in + " rubles are " + expected + " dollar. Test result: " + passed);

        in = 4;
        expected = 280;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println(in + " Euro are " + expected + " rubles. Test result: " + passed);

        in = 5;
        expected = 299;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println(in + " Dollars are " + expected + " rubles. Test result: " + passed);

    }
}
