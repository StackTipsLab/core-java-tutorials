package com.stacktips.collections.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class Notification implements Delayed {
    private final String name;
    private final long startTime;

    public Notification(String name, long delay, TimeUnit unit) {
        this.name = name;
        this.startTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(delay, unit);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = startTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.startTime, ((Notification) other).startTime);
    }

    @Override
    public String toString() {
        return "Task: {name='" + name + "', startTime=" + startTime + '}';
    }
}

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Notification> notifications = new DelayQueue<>();
        notifications.add(new Notification("Task 1", 5, TimeUnit.SECONDS));
        notifications.add(new Notification("Task 2", 10, TimeUnit.SECONDS));
        notifications.add(new Notification("Task 3", 3, TimeUnit.SECONDS));

        // Processing tasks as they expire
        while (!notifications.isEmpty()) {
            Notification task = notifications.take();
            System.out.println("Notifying " + task);
        }
    }
}
