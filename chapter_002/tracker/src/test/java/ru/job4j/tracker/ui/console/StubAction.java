package ru.job4j.tracker.ui.console;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.Input;
import ru.job4j.tracker.ui.UserAction;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    @Override
    public boolean isCall() {
        return call;
    }
}
