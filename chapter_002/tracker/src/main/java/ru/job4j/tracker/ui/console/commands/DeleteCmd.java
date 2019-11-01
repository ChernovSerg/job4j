package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class DeleteCmd extends BaseAction {
    public DeleteCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
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
}
