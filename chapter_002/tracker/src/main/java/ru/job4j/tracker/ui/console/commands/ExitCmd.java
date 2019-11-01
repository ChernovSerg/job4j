package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class ExitCmd extends BaseAction {
    public ExitCmd(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== " + this.name() + " ===");
        return false;
    }
}
