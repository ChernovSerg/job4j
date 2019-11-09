package ru.job4j.tracker.ui;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.StubAction;
import ru.job4j.tracker.ui.console.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(Arrays.asList("0"));
        StubAction action = new StubAction(0, "Stub action");
        new StartUI().init(input, new Tracker(), Arrays.asList(action));
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrintMenu() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(Arrays.asList("0"));
        StubAction action = new StubAction(0, "Stub action");
        new StartUI().init(input, new Tracker(), Arrays.asList(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }
}