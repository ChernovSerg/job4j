package ru.job4j.tracker.ui;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.ui.console.ConsoleInput;
import ru.job4j.tracker.ui.console.ValidateInput;
import ru.job4j.tracker.ui.console.commands.*;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        UserAction action;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            action = getActionByKey(actions, select);
            run = action.execute(input, tracker);
        }
    }

    private UserAction getActionByKey(List<UserAction> actions, int key) {
        UserAction action = null;
        for (UserAction act : actions) {
            if (act.key() == key) {
                action = act;
                break;
            }
        }
        return action;
    }

    private void showMenu(List<UserAction> actions) {
        for (UserAction action : actions) {
            System.out.println(action.key() + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Input scanner = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> userActions = Arrays.asList(
                new CreateCmd(1, "Add new item"),
                new EditCmd(2, "Edit item"),
                new FindByIdCmd(3, "Find item by Id"),
                new FindByNameCmd(4, "Find items by name"),
                new DeleteCmd(5, "Delete item"),
                new ShowAllCmd(6, "Show all items"),
                new ExitCmd(0, "Exit program")
        );
        new StartUI().init(scanner, tracker, userActions);
    }
}
