package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerSingletonByEnum {
    INSTANCE;
    Tracker tracker = new Tracker();
}
