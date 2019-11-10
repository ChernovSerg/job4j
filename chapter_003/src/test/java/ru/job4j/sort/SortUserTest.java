package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SortUserTest {
    @Test
    public void testSortUser() {
        User u1 = new User(15, "Nikolay");
        User u2 = new User(8, "Vladimir");
        User u3 = new User(10, "Sergey");
        List<User> src = Arrays.asList(u1, u2, u3);
        Set<User> actual = SortUser.sort(src);

        TreeSet<User> expected = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        expected.addAll(src);
        assertThat(actual, is(expected));
    }

}