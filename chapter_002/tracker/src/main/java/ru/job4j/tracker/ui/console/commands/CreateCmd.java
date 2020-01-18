package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.function.Consumer;

public class CreateCmd extends BaseAction {
    private final Consumer<String> output;

    public CreateCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ====");
        output.accept("=== " + this.name() + " ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
//        System.out.println("New item added.\n");
        output.accept("New item added.\n");
        return true;
    }
}
