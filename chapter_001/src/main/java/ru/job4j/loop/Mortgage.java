package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 1;
        double amountYear = amount + amount * percent / 100;
        int salaryYear = salary * 12;
        while (salaryYear < amountYear) {
            year++;
            amountYear = (amountYear - salaryYear) + (amountYear - salaryYear) * percent / 100;
        }
        return year;
    }
}
