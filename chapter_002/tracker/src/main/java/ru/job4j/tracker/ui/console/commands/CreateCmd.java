package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class CreateCmd extends BaseAction {
    public CreateCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("New item added.\n");
        return true;
    }
}
