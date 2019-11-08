package ru.job4j.search;

import java.util.LinkedList;

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
        boolean inserted = false;
        int i = 0;
        for (Task t : tasks) {
            if (t.getPriority() > task.getPriority()) {
                tasks.add(i, task);
                inserted = true;
                break;
            }
            i++;
        }
        if (!inserted) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
