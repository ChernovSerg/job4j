package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        Item it3 = new Item("item3");
        tracker.add(it1);
        tracker.add(it2);
        tracker.add(it3);
        tracker.delete(it2.getId());
        assertNull(tracker.findById(it2.getId()));
    }

    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        tracker.add(it1);
        tracker.add(it2);
        Item[] actual = tracker.findAll();
        assertThat(actual.length, is(2));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        Item it3 = new Item("item3");
        tracker.add(it1);
        tracker.add(it2);
        tracker.add(it3);
        tracker.add(it2);
        Item[] actual = tracker.findByName(it2.getName());
        assertThat(actual.length, is(2));
    }
}