package ru.job4j.tracker.ui.console.commands;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CreateCmdTest {
    @Test
    public void whenCreateCmd() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new CreateCmd().execute(new StubInput(new String[]{"0"}), new Tracker());
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Create a new Item ====")
                .add("New item added.\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }
}