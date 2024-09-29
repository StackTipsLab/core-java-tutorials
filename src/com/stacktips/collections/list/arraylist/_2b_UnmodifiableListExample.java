package com.stacktips.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2b_UnmodifiableListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);

        unmodifiableList.add("D"); // throws UnsupportedOperationException
        System.out.println(unmodifiableList);
    }
}
