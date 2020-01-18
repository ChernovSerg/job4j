package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

import java.util.function.Consumer;

public class ExitCmd extends BaseAction {
    private final Consumer<String> output;

    public ExitCmd(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("=== " + this.name() + " ===");
        output.accept("=== " + this.name() + " ===");
        return false;
    }
}
