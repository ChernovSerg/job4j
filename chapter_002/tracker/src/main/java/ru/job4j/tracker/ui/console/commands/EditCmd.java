package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.function.Consumer;

public class EditCmd extends BaseAction {
    private final Consumer<String> output;

    public EditCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ===");
        output.accept("=== " + this.name() + " ===");
//        System.out.println("--- all items ---");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String idItem = input.askStr("Enter the ID of the item you want to replace with the new item: ");
        String newName = input.askStr("Enter a name for the new item: ");
        Item newItem = new Item(newName);
        if (tracker.replace(idItem, newItem)) {
//            System.out.println("Item replaced.\n");
            output.accept("Item replaced.\n");
//            System.out.println(Arrays.toString((tracker.findAll())) + "\n");
        } else {
//            System.out.println("Error: item not found.\n");
            output.accept("Error: item not found.\n");
        }
        return true;
    }
}
