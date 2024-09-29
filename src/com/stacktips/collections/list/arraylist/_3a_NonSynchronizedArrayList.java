package com.stacktips.collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class _3a_NonSynchronizedArrayList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        // Create a runnable task that adds elements to the collections.list
        Runnable addItemsTask = () -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        };

        // Create multiple threads that will run the addItemsTask
        Thread thread1 = new Thread(addItemsTask);
        thread1.start();

        Thread thread2 = new Thread(addItemsTask);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Size of List: " + arrayList.size());
    }
}
