package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingletonByStaticFinalField {
    private static final TrackerSingletonByStaticFinalField INSTANCE = new TrackerSingletonByStaticFinalField();
    public Tracker tracker;

    private TrackerSingletonByStaticFinalField() {
        this.tracker = new Tracker();
    }

    public static TrackerSingletonByStaticFinalField getInstance() {
        return INSTANCE;
    }
}
