package com.stacktips.collections.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class _1a_LinkedHashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("B", 2);
        map.put("A", 1);
        map.put("C", 3);
        map.put(null, 4);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
