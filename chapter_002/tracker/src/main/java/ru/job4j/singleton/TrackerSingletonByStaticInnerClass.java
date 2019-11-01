package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingletonByStaticInnerClass {
    public Tracker tracker;

    private TrackerSingletonByStaticInnerClass() {
        this.tracker = new Tracker();
    }

    private static class SingletonByStaticInnerClassHolder {
        private static final TrackerSingletonByStaticInnerClass INSTANCE = new TrackerSingletonByStaticInnerClass();
    }

    public static TrackerSingletonByStaticInnerClass getInstance() {
        return SingletonByStaticInnerClassHolder.INSTANCE;
    }
}
