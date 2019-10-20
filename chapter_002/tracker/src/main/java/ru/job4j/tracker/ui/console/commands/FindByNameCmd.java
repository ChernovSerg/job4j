package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

import java.util.Arrays;

public class FindByNameCmd implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        System.out.println(Arrays.toString((tracker.findAll())));
        String nameForFind = input.askStr("Enter the NAME of the item you want to find: ");
        Item[] found2 = tracker.findByName(nameForFind);
        if (found2 != null && found2.length > 0) {
            System.out.println("Item found: " + Arrays.toString(found2) + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
        return true;
    }

    @Override
    public boolean isCall() {
        return true;
    }
}
