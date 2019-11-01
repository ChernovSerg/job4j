package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class FindByIdCmd extends BaseAction {
    public FindByIdCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String idForFind = input.askStr("Enter the ID of the item you want to find: ");
        Item found = tracker.findById(idForFind);
        if (found != null) {
            System.out.println("Item found: " + found + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
        return true;
    }
}
