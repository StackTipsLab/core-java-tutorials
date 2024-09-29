package com.stacktips.collections.map.hashtable;

import java.util.Hashtable;

public class _1a_Hashtable {


    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");

        // Retrieve a value by its key
        String value = hashtable.get(2);
        System.out.println("Value for key 2: " + value);

        // Remove a key-value pair
        hashtable.remove(3);

        // Check if a key exists
        boolean containsKey = hashtable.containsKey(1);
        System.out.println("Hashtable contains key 1: " + containsKey);

        // Check if a value exists
        boolean containsValue = hashtable.containsValue("Two");
        System.out.println("Hashtable contains value 'Two': " + containsValue);

        // Get the size of the hashtable
        int size = hashtable.size();
        System.out.println("Size of hashtable: " + size);

        // Check if the hashtable is empty
        boolean isEmpty = hashtable.isEmpty();
        System.out.println("Is hashtable empty? " + isEmpty);
    }

}
