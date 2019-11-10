package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public static Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        result.addAll(list);
        return result;
    }

    public static List<User> sortByNameLength(List<User> list) {
        List<User> result = new ArrayList<>(list);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return result;
    }

    public static List<User> sortByAllFields (List<User> list) {
        List<User> result = new ArrayList<>(list);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compareName = o1.getName().compareTo(o2.getName());
                return compareName !=0 ? compareName : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return result;
    }
}
