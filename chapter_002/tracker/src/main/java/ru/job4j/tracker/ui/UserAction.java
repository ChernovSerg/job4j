package ru.job4j.tracker.ui;

import ru.job4j.tracker.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);

    boolean isCall();

    int key();
}
