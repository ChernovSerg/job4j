package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        return pic
                .append("****\n")
                .append("*  *\n")
                .append("*  *\n")
                .append("****").toString();
    }
}
