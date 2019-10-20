package ru.job4j.tracker.ui;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.StubAction;
import ru.job4j.tracker.ui.console.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        assertThat(action.isCall(), is(true));
    }

//    public void testCreateItem() {
//        String[] answers = {"e1"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("e1");
//        assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void testDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("e1");
//        tracker.add(item);
//        String[] answers = {item.getId()};
//        StartUI.deleteItem(new StubInput(answers), tracker);
//        assertThat(tracker.findAll().length, is(0));
//    }
//
//    @Test
//    public void testReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("e1");
//        tracker.add(item);
//        String[] answers = {item.getId(), "replaced item"};
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("replaced item"));
//    }

}