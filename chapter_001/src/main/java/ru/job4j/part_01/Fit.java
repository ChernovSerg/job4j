package ru.job4j.part_01;

public class Fit {
    public static double manWeight(double height) {
        return (height - 100.0) * 1.15;
    }


    public static double womanWeight(double height) {
        return (height - 110.0) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(176);
        System.out.println("Man 100 is " + man);
    }
}
