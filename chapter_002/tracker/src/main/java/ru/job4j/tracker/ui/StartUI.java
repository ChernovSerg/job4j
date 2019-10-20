package ru.job4j.tracker.ui;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.ConsoleInput;
import ru.job4j.tracker.ui.console.commands.*;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input scanner = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateCmd(),
                new ShowAllCmd(),
                new EditCmd(),
                new DeleteCmd(),
                new FindByIdCmd(),
                new FindByNameCmd(),
                new ExitCmd()
        };
        new StartUI().init(scanner, tracker, userActions);
    }
}
