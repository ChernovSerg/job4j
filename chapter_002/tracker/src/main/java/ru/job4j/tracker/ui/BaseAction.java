package ru.job4j.tracker.ui;

public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public boolean isCall() {
        return true;
    }
}
