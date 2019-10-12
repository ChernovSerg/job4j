package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("New item added.\n");
                    break;
                case 1:
                    System.out.println("=== Show all items ====");
                    System.out.println(Arrays.toString((tracker.findAll())) + "\n");
                    break;
                case 2:
                    System.out.println("=== Edit item ===");
                    System.out.print("Enter a name for the new item: ");
                    String newName = scanner.nextLine();
                    Item newItem = new Item(newName);
                    System.out.println("--- all items ---");
                    System.out.println(Arrays.toString((tracker.findAll())));
                    System.out.print("Enter the ID of the item you want to replace with the new item: ");
                    String idItem = scanner.nextLine();
                    if (tracker.replace(idItem, newItem)) {
                        System.out.println("Item replaced. \nActual items:");
                        System.out.println(Arrays.toString((tracker.findAll())) + "\n");
                    } else {
                        System.out.println("Error: item not found.\n");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete item ===");
                    System.out.println(Arrays.toString((tracker.findAll())));
                    System.out.print("Enter the ID of the item you want to delete: ");
                    String id = scanner.nextLine();
                    if (tracker.delete(id)) {
                        System.out.println("Item deleted.\nActual items:");
                        System.out.println(Arrays.toString((tracker.findAll())) + "\n");
                    } else {
                        System.out.println("Error: item not found.\n");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by Id ===");
                    System.out.println(Arrays.toString((tracker.findAll())));
                    System.out.print("Enter the ID of the item you want to find: ");
                    String idForFind = scanner.nextLine();
                    Item found = tracker.findById(idForFind);
                    if (found != null) {
                        System.out.println("Item found: " + found + "\n");
                    } else {
                        System.out.println("Error: item not found.\n");
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ===");
                    System.out.println(Arrays.toString((tracker.findAll())));
                    System.out.print("Enter the NAME of the item you want to find: ");
                    String nameForFind = scanner.nextLine();
                    Item[] found2 = tracker.findByName(nameForFind);
                    if (found2 != null && found2.length > 0) {
                        System.out.println("Item found: " + Arrays.toString(found2) + "\n");
                    } else {
                        System.out.println("Error: item not found.\n");
                    }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
