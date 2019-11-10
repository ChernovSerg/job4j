package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
        assertNotNull(tracker.findById(it2.getId()));
        assertNull(tracker.findById(it2.getId()).getId());
        assertNull(tracker.findById(it2.getId()).getName());
    }

    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        tracker.add(it1);
        tracker.add(it2);
        List<Item> actual = tracker.findAll();
        List<Item> expected = Arrays.asList(it1, it2);
        assertNotSame(expected, actual);
        assertThat(actual.get(0).getId(), is(expected.get(0).getId()));
        assertThat(actual.get(1).getId(), is(expected.get(1).getId()));
    }

    @Test
    public void testFIndById() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        tracker.add(it1);
        tracker.add(it2);
        Item actual = tracker.findById(it1.getId());
        assertNotSame(actual, it1);
        assertThat(actual.getId(), is(it1.getId()));
        assertThat(actual.getName(), is(it1.getName()));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item it1 = new Item("item1");
        Item it2 = new Item("item2");
        Item it3 = new Item("item3");
        Item it4 = new Item("item2");
        tracker.add(it1);
        tracker.add(it2);
        tracker.add(it3);
        tracker.add(it4);
        List<Item> actual = tracker.findByName(it2.getName());
        List<Item> expected = Arrays.asList(it2, it4);
        assertThat(actual.size(), is(2));
        assertNotSame(actual.get(0), expected.get(0));
        assertNotSame(actual.get(1), expected.get(1));
        assertThat(actual.get(0).getId(), is(expected.get(0).getId()));
        assertThat(actual.get(0).getName(), is(expected.get(0).getName()));
        assertThat(actual.get(1).getId(), is(expected.get(1).getId()));
        assertThat(actual.get(1).getName(), is(expected.get(1).getName()));
    }
}