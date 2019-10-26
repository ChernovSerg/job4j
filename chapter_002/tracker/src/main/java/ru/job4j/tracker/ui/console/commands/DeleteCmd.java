package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

public class DeleteCmd implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String id = input.askStr("Enter the ID of the item you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted.\n");
//            System.out.println(Arrays.toString((tracker.findAll())) + "\n");
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
