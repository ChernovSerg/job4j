package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when54by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 2};
        int[] rsl = machine.change(54, 35);
        assertThat(rsl, is(expected));
    }
}