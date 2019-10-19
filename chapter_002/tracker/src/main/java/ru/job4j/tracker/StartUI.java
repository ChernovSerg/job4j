package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0:
                    createItem(input, tracker);
                    break;
                case 1:
                    showAllItems(tracker);
                    break;
                case 2:
                    replaceItem(input, tracker);
                    break;
                case 3:
                    deleteItem(input, tracker);
                    break;
                case 4:
                    findItem(input, tracker);
                    break;
                case 5:
                    findItemsByName(input, tracker);
                    break;
                case 6:
                    System.out.println("=== Exit Program ===");
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("New item added.\n");
    }

    public static void findItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        System.out.println(Arrays.toString((tracker.findAll())));
        String idForFind = input.askStr("Enter the ID of the item you want to find: ");
        Item found = tracker.findById(idForFind);
        if (found != null) {
            System.out.println("Item found: " + found + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        System.out.println(Arrays.toString((tracker.findAll())));
        String nameForFind = input.askStr("Enter the NAME of the item you want to find: ");
        Item[] found2 = tracker.findByName(nameForFind);
        if (found2 != null && found2.length > 0) {
            System.out.println("Item found: " + Arrays.toString(found2) + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.println(Arrays.toString((tracker.findAll())));
        String id = input.askStr("Enter the ID of the item you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted.\nActual items:");
            System.out.println(Arrays.toString((tracker.findAll())) + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        System.out.println("--- all items ---");
        System.out.println(Arrays.toString((tracker.findAll())));
        String idItem = input.askStr("Enter the ID of the item you want to replace with the new item: ");
        String newName = input.askStr("Enter a name for the new item: ");
        Item newItem = new Item(newName);
        newItem.setId(idItem);
        if (tracker.replace(idItem, newItem)) {
            System.out.println("Item replaced. \nActual items:");
            System.out.println(Arrays.toString((tracker.findAll())) + "\n");
        } else {
            System.out.println("Error: item not found.\n");
        }
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] result = tracker.findAll();
        System.out.println(Arrays.toString((result)) + "\n");
    }

    public static void main(String[] args) {
        Input scanner = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
