package ru.job4j.tracker.ui.console.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandsTests {
    private PrintStream stdout = System.out;
    private Tracker tracker = new Tracker();
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenCreateCmd() {
        new CreateCmd(0, "Create a new Item", output).execute(new StubInput(Arrays.asList("0")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Create a new Item ====")
                .add("New item added.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenDeleteFailure() {
        new DeleteCmd(0, "Delete item", output).execute(new StubInput(Arrays.asList("0")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===")
                .add("Error: item not found.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenDeleteSuccess() {
        Item item = new Item("item1");
        tracker.add(item);
        new DeleteCmd(0, "Delete item", output).execute(new StubInput(Arrays.asList(item.getId())), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===")
                .add("Item deleted.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenEditSuccess() {
        Item item = new Item("item1");
        tracker.add(item);
        new EditCmd(0, "Edit item", output).execute(new StubInput(Arrays.asList(item.getId(), "new_name")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Edit item ===")
                .add("Item replaced.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenEditFailure() {
        Item item = new Item("item1");
        tracker.add(item);
        new EditCmd(0, "Edit item", output).execute(new StubInput(Arrays.asList("find_item", "new_name")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Edit item ===")
                .add("Error: item not found.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenExit() {
        new ExitCmd(0, "Exit Program", output).execute(new StubInput(Arrays.asList("")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Exit Program ===")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenFindByIdSuccess() {
        Item item = new Item("item1");
        tracker.add(item);
        new FindByIdCmd(0, "Find item by Id", output).execute(new StubInput(Arrays.asList(item.getId())), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find item by Id ===")
                .add("Item found: " + "Item{id='" + item.getId() + "', name='" + item.getName() + "'}\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenFindByIdFailure() {
        Item item = new Item("item1");
        tracker.add(item);
        new FindByIdCmd(0, "Find item by Id", output).execute(new StubInput(Arrays.asList("0")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find item by Id ===")
                .add("Error: item not found.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenFindByNameSuccess() {
        Item item = new Item("item1");
        tracker.add(item);
        new FindByNameCmd(0, "Find items by name", output).execute(new StubInput(Arrays.asList("item1")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find items by name ===")
                .add("Item found: [Item{id='" + item.getId() + "', name='" + item.getName() + "'}]\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenFindByNameFailure() {
        Item item = new Item("item1");
        tracker.add(item);
        new FindByNameCmd(0, "Find items by name", output).execute(new StubInput(Arrays.asList("qwe")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find items by name ===")
                .add("Error: item not found.\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenShowAll() {
        Item item = new Item("item1");
        tracker.add(item);
        new ShowAllCmd(0, "Show all items", output).execute(new StubInput(Arrays.asList("")), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Show all items ====")
                .add("[Item{id='" + item.getId() + "', name='" + item.getName() + "'}]\n")
                .toString();
        assertThat(this.output.toString(), is(expect));
    }
}
