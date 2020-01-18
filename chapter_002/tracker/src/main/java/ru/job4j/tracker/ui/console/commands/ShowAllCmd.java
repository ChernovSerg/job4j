package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ShowAllCmd extends BaseAction {
    private final Consumer<String> output;

    public ShowAllCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ====");
        output.accept("=== " + this.name() + " ====");
        List<Item> result = tracker.findAll();
//        System.out.println(Arrays.toString((result.toArray())) + "\n");
        output.accept(Arrays.toString((result.toArray())) + "\n");
        return true;
    }
}
