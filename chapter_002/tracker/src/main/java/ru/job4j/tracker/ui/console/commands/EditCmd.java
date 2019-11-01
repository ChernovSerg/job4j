package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class EditCmd extends BaseAction {
    public EditCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
//        System.out.println("--- all items ---");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String idItem = input.askStr("Enter the ID of the item you want to replace with the new item: ");
        String newName = input.askStr("Enter a name for the new item: ");
        Item newItem = new Item(newName);
        newItem.setId(idItem);
        if (tracker.replace(idItem, newItem)) {
            System.out.println("Item replaced.\n");
//            System.out.println(Arrays.toString((tracker.findAll())) + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
        return true;
    }
}
