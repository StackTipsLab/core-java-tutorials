package com.stacktips.collections.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class _1a_TreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Accessing elements
        System.out.println("Value for key 2: " + treeMap.get(2));

        // Getting first and last keys
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());

        // Getting a subMap
        System.out.println("SubMap from 2 to 4: " + treeMap.subMap(2, 4));

        // Removing an element
        treeMap.remove(3);
        System.out.println("TreeMap after removal of key 3: " + treeMap);
    }
}
