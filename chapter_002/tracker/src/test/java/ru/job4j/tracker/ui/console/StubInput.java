package ru.job4j.tracker.ui.console;

import ru.job4j.tracker.ui.Input;

import java.util.List;

public class StubInput implements Input {
    private List<String> answers;
    private int position = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int val = askInt(question);
        if (val < 0 || val > max) {
            throw new IllegalStateException();
        }
        return val;
    }
}
