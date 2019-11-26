package ru.job4j.sort;

public class User implements Comparable<User> {
    private static int index = 0;

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}
