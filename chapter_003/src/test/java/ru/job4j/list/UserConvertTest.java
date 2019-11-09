package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void process() {
        User u1 = new User("Sergey", "Khimki");
        User u2 = new User("Petr", "Bryansk");
        User u3 = new User("Dmitriy", "Moscow");
        List<User> list = Arrays.asList(u1, u2, u3);

        HashMap<Integer, User> actual = UserConvert.process(list);

        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(u1.getId(), u1);
        expected.put(u2.getId(), u2);
        expected.put(u3.getId(), u3);

        assertThat(actual, is(expected));
    }
}