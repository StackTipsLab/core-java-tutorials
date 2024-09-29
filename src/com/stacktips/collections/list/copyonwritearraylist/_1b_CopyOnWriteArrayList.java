package com.stacktips.collections.list.copyonwritearraylist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class _1b_CopyOnWriteArrayList {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Guava");
        list.add("Grapes");

        for (String value : list) {
            if (value.equals("Banana")) {
                list.remove("Grapes");
            }
        }

        System.out.println(list);
    }
}
