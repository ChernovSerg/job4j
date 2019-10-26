package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

public class FindByIdCmd implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
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

    @Override
    public boolean isCall() {
        return true;
    }
}
