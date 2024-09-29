package com.stacktips.collections.queue;

import java.util.PriorityQueue;
import java.util.Comparator;

class Task {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

public class TaskManager {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority).reversed());
        taskQueue.add(new Task("Task 1", 3));
        taskQueue.add(new Task("Task 2", 1));
        taskQueue.add(new Task("Task 3", 4));
        taskQueue.add(new Task("Task 4", 2));

        System.out.println("Printing tasks in based on priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing " + task);
        }
    }
}
