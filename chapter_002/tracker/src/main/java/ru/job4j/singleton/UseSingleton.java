package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class UseSingleton {
    public static void main(String[] args) {
        //use TrackerSingletonByEnum
        TrackerSingletonByEnum tracker1 = TrackerSingletonByEnum.INSTANCE;
        tracker1.tracker.add(new Item("e1"));
        TrackerSingletonByEnum tracker2 = TrackerSingletonByEnum.INSTANCE;
        tracker2.tracker.add(new Item("e2"));
        tracker1.tracker.delete(tracker1.tracker.findByName("e1").get(0).getId());

        //use TrackerSingletonByStaticField
        TrackerSingletonByStaticField tracker3 = TrackerSingletonByStaticField.getInstance();
        tracker3.tracker.add(new Item("e1"));
        TrackerSingletonByStaticField tracker4 = TrackerSingletonByStaticField.getInstance();
        tracker4.tracker.add(new Item("e2"));
        tracker3.tracker.delete(tracker3.tracker.findByName("e1").get(0).getId());

        //use TrackerSingletonByStaticFinalField
        TrackerSingletonByStaticFinalField tracker5 = TrackerSingletonByStaticFinalField.getInstance();
        tracker5.tracker.add(new Item("e1"));
        TrackerSingletonByStaticFinalField tracker6 = TrackerSingletonByStaticFinalField.getInstance();
        tracker6.tracker.add(new Item("e2"));
        tracker5.tracker.delete(tracker5.tracker.findByName("e1").get(0).getId());

        //use TrackerSingletonByStaticInnerClass
        TrackerSingletonByStaticInnerClass tracker7;
        tracker7 = TrackerSingletonByStaticInnerClass.getInstance();
        tracker7.tracker.add(new Item("e1"));
        TrackerSingletonByStaticInnerClass tracker8 = TrackerSingletonByStaticInnerClass.getInstance();
        tracker8.tracker.add(new Item("e2"));
        tracker7.tracker.delete(tracker7.tracker.findByName("e1").get(0).getId());
    }
}
