package ru.job4j.oop.ball;

public class Battery {
    private int load;
    Battery(int volt) {
        this.load = volt;
    }

    public void exchange(Battery another) {
        this.load = this.load - 1;
        another.load += 1;
    }

    public static void main(String[] args) {
        Battery first = new Battery(12);
        Battery second = new Battery(10);
        System.out.println("first:" + first.load + ". second: " + second.load);
        first.exchange(second);
        System.out.println("first:" + first.load + ". second: " + second.load);
    }
}
