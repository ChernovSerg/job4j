package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    private int getIndexById(String id) {
        int result = -1;
        int i = 0;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public Item findById(String id) {
        Item result = new Item(null);
        int index = getIndexById(id);
        if (index >= 0) {
            result.setId(this.items.get(index).getId());
            result.setName(this.items.get(index).getName());
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = getIndexById(id);
        if (index >= 0) {
            item.setId(this.items.get(index).getId());
            this.items.set(index, item);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = getIndexById(id);
        if (index >= 0) {
            this.items.remove(index);
            result = true;
        }
        return result;
    }

    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                Item found = new Item(item.getName());
                found.setId(item.getId());
                result.add(found);
            }
        }
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            Item t = new Item(item.getName());
            t.setId(item.getId());
            result.add(t);
        }
        return result;
    }

}
