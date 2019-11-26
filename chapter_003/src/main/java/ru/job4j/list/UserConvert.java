package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * Преобразует List в HashMap.
     *
     * @param list список из элементов типа User
     * @return HashMap
     */
    public static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}

class User {
    private static int index = 0;

    private int id;
    private String name;
    private String city;

    public User(String name, String city) {
        this.id = index++;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", city='" + city + '\''
                + '}';
    }
}
