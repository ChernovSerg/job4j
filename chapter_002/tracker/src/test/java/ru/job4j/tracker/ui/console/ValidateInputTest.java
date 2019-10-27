package ru.job4j.tracker.ui.console;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void resetOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenAskInt1Success() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "1"})
        );
        input.askInt("Enter");
        assertThat(out.toString(), is(""));
    }

    @Test
    public void whenAskInt2Success() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "1"})
        );
        input.askInt("Enter", 2);
        assertThat(out.toString(), is(""));
    }

    @Test
    public void whenAskInt1Failure() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "100"})
        );
        input.askInt("Enter");
        assertThat(
                out.toString(),
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("Please enter validate data again.")
                        .toString()
                )
        );
    }

    @Test
    public void whenAskInt2Failure1() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.askInt("Enter", 2);
        assertThat(
                out.toString(),
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("Please enter validate data again.")
                        .toString()
                )
        );
    }

    @Test
    public void whenAskInt2Failure2() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"5", "1"})
        );
        input.askInt("Enter", 2);
        assertThat(
                out.toString(),
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("Please select key from menu")
                        .toString()
                )
        );
    }
}