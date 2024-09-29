package com.stacktips.collections.list.copyonwritearraylist;

import java.util.ArrayList;
import java.util.List;

public class _1a_ConcurrentModificationException {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
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
