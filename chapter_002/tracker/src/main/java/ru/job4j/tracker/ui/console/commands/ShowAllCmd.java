package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

import java.util.Arrays;

public class ShowAllCmd implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] result = tracker.findAll();
        System.out.println(Arrays.toString((result)) + "\n");
        return true;
    }

    @Override
    public boolean isCall() {
        return true;
    }
}
