package com.stacktips.collections.map.identityhashmap;

import java.util.IdentityHashMap;
import java.util.Map;

public class _1a_IdentityHashMap {

    public static void main(String[] args) {
        Map<String, String> map1 = new IdentityHashMap<>();
        String key1 = "key";
        String key2 = "key";
        map1.put(key1, "value1");
        map1.put(key2, "value2");

        for (String key : map1.keySet()) {
            System.out.println(key + " -> " + map1.get(key));
        }

        Map<String, String> map2 = new IdentityHashMap<>();
        String key3 = new String("key");
        String key4 = new String("key");
        map2.put(key3, "value1");
        map2.put(key4, "value2");


        for (String key : map2.keySet()) {
            System.out.println(key + " -> " + map2.get(key));
        }
    }
}
