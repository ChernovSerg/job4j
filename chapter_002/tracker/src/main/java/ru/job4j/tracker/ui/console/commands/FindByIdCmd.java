package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.function.Consumer;

public class FindByIdCmd extends BaseAction {
    private final Consumer<String> output;

    public FindByIdCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ===");
        output.accept("=== " + this.name() + " ===");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String idForFind = input.askStr("Enter the ID of the item you want to find: ");
        Item found = tracker.findById(idForFind);
        if (found != null && found.getId() != null) {
//            System.out.println("Item found: " + found + "\n");
            output.accept("Item found: " + found + "\n");
        } else {
//            System.out.println("Error: item not found.\n");
            output.accept("Error: item not found.\n");
        }
        return true;
    }
}
