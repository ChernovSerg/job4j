package ru.job4j.tracker.ui.console.commands;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeleteCmdTest {
    @Test
    public void whenDeleteFailure() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new DeleteCmd().execute(new StubInput(new String[]{"0"}), new Tracker());
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===")
                .add("Error: item not found.\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }

    @Test
    public void whenDeleteSuccess() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("item1");
        tracker.add(item);
        new DeleteCmd().execute(new StubInput(new String[]{item.getId()}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===")
                .add("Item deleted.\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }
}