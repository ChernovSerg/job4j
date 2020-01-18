package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FindByNameCmd extends BaseAction {
    private final Consumer<String> output;

    public FindByNameCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ===");
        output.accept("=== " + this.name() + " ===");
//        System.out.println(Arrays.toString((tracker.findAll())));
        String nameForFind = input.askStr("Enter the NAME of the item you want to find: ");
        List<Item> found2 = tracker.findByName(nameForFind);
        if (found2 != null && found2.size() > 0) {
//            System.out.println("Item found: " + Arrays.toString(found2.toArray()) + "\n");
            output.accept("Item found: " + Arrays.toString(found2.toArray()) + "\n");
        } else {
//            System.out.println("Error: item not found.\n");
            output.accept("Error: item not found.\n");
        }
        return true;
    }
}
