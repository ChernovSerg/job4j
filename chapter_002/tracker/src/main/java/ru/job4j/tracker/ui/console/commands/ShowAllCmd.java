package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.Arrays;
import java.util.List;

public class ShowAllCmd extends BaseAction {
    public ShowAllCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ====");
        List<Item> result = tracker.findAll();
        System.out.println(Arrays.toString((result.toArray())) + "\n");
        return true;
    }
}
