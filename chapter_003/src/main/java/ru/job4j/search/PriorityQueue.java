package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
            return;
        }
        ListIterator<Task> iter = tasks.listIterator();
        boolean inserted = false;
        while (iter.hasNext()) {
            if (iter.next().getPriority() > task.getPriority()) {
                iter.previous();
                iter.add(task);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
