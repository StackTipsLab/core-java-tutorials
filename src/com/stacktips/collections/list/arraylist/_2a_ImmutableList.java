package com.stacktips.collections.list.arraylist;

import java.util.List;

public class _2a_ImmutableList {
    public static void main(String[] args) {
        List<String> immutableList = List.of("A", "B", "C");
        System.out.println(immutableList);

        immutableList.add("D"); // throws UnsupportedOperationException

        System.out.println(immutableList);
    }
}
