package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingletonByStaticField {
    private static TrackerSingletonByStaticField instance;

    public Tracker tracker;

    private TrackerSingletonByStaticField() {
    }

    public static TrackerSingletonByStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingletonByStaticField();
            instance.tracker = new Tracker();
        }
        return instance;
    }
}
