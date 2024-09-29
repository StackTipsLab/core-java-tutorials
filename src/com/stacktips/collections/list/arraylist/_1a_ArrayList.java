package com.stacktips.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1a_ArrayList {
    public static void main(String[] args) {
        //Using the Default Constructor
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        // Using Constructor with Initial Capacity
        List<String> list2 = new ArrayList<>(20);
        list2.add("Apple");
        list2.add("Banana");

        //Initializing array collections.list using the anonymous inner class method
        List<String> list3 = new ArrayList<String>() {{
            add("Apple");
            add("Banana");
            add("Orange");
        }};

        // fixed-size collections.list from the elements of another collection
        List<String> list4 = Arrays.asList("Apple", "Banana", "Orange");
        List<String> list5 = new ArrayList<>(list4);

        // Using Arrays.asList method
        List<String> list6 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));

        // Using Collections.addAll method
        List<String> list7 = new ArrayList<>();
        Collections.addAll(list7, "Apple", "Banana", "Orange");

        // Using Java8 streams and collectors
        List<String> list8 = Stream.of("Apple", "Banana", "Orange")
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(list1.get(1));

        System.out.println(list2.contains("Banana"));
    }
}
