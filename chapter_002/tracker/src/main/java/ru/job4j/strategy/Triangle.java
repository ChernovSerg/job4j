package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        return pic
                .append("  *  \n")
                .append(" * * \n")
                .append("*****").toString();
    }
}
