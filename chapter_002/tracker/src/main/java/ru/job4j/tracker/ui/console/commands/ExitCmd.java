package ru.job4j.tracker.ui.console.commands;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

public class ExitCmd implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Exit Program ===");
        return false;
    }

    @Override
    public boolean isCall() {
        return true;
    }
}
