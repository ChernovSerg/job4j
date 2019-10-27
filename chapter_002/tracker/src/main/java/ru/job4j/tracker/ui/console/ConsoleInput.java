package ru.job4j.tracker.ui.console;

import ru.job4j.tracker.ui.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) throws IllegalStateException {
        int select = Integer.parseInt(askStr(question));
        if (select < 0 || select > max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}
