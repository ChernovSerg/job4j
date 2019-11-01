package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SIngletonTests {
    @Test
    public void testSingletonByEnum() {
        Item item1 = new Item("e1");
        TrackerSingletonByEnum instance1 = TrackerSingletonByEnum.INSTANCE;
        instance1.tracker.add(item1);
        TrackerSingletonByEnum instance2 = TrackerSingletonByEnum.INSTANCE;
        assertThat(instance1.tracker.findById(item1.getId()), is(instance2.tracker.findById(item1.getId())));
    }

    @Test
    public void testSingletonByStaticField() {
        Item item1 = new Item("e1");
        TrackerSingletonByStaticField instance1 = TrackerSingletonByStaticField.getInstance();
        instance1.tracker.add(item1);
        TrackerSingletonByStaticField instance2 = TrackerSingletonByStaticField.getInstance();
        assertThat(instance1.tracker.findById(item1.getId()), is(instance2.tracker.findById(item1.getId())));
    }

    @Test
    public void testSingletonByStaticFinalField() {
        Item item1 = new Item("e1");
        TrackerSingletonByStaticFinalField instance1 = TrackerSingletonByStaticFinalField.getInstance();
        instance1.tracker.add(item1);
        TrackerSingletonByStaticFinalField instance2 = TrackerSingletonByStaticFinalField.getInstance();
        assertThat(instance1.tracker.findById(item1.getId()), is(instance2.tracker.findById(item1.getId())));
    }

    @Test
    public void testSingletonByStaticInnerClass() {
        Item item1 = new Item("e1");
        TrackerSingletonByStaticInnerClass instance1 = TrackerSingletonByStaticInnerClass.getInstance();
        instance1.tracker.add(item1);
        TrackerSingletonByStaticInnerClass instance2 = TrackerSingletonByStaticInnerClass.getInstance();
        assertThat(instance1.tracker.findById(item1.getId()), is(instance2.tracker.findById(item1.getId())));
    }
}
