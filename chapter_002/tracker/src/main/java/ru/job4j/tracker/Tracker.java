package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    private int getIndexById(String id) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int getIndexByName(String id) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public Item findById(String id) {
        Item result = null;
        int position = getIndexById(id);
        if (position >= 0) {
            result = this.items[position];
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int position = getIndexById(id);
        if (position >= 0) {
            this.items[position] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int position = getIndexById(id);
        if (position >= 0) {
            this.items[position] = null;
            this.position--;
            System.arraycopy(this.items, position + 1, this.items, position, this.items.length - position - 1);
            result = true;
        }
        return result;
    }

    public Item[] findByName(String name) {
        Item[] preResult = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                preResult[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(preResult, count);
    }

    public Item[] findAll() {
        Item[] preResult = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null) {
                preResult[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(preResult, count);
    }

}
