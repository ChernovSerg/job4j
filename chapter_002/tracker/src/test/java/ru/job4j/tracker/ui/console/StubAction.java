package ru.job4j.tracker.ui.console;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.BaseAction;
import ru.job4j.tracker.ui.Input;

public class StubAction extends BaseAction {
    private boolean call = false;

    public StubAction(int key, String name) {
        super(key, name);
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
