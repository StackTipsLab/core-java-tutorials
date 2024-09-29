package com.stacktips.collections.map.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _1b_TreeMapCustomComparator {
    public static void main(String[] args) {
        Comparator<Integer> reverseOrderComparator = (key1, key2) -> key2.compareTo(key1);
        TreeMap<Integer, String> treeMap = new TreeMap<>(reverseOrderComparator);
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        treeMap.remove(3);
        System.out.println("TreeMap after removal of key 3: " + treeMap);
    }
}
