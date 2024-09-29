package com.stacktips.collections.list.vector;

import java.util.ArrayList;
import java.util.Vector;

public class _1a_Vector {

    public static void main(String[] args) {
        //Using default constructor
        Vector<String> vector1 = new Vector<>();
        vector1.add("One");
        vector1.add("Two");
        vector1.add("Three");

        // Initial capacity of 20
        Vector<String> vector2 = new Vector<>(20);
        vector2.add("One");
        vector2.add("Two");
        vector2.add("Three");

        // Initial capacity of 20, capacity increment of 5
        Vector<String> vector3 = new Vector<>(20, 5);
        vector3.add("One");
        vector3.add("Two");
        vector3.add("Three");

        //Creating vector from another collection
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        Vector<String> vector4 = new Vector<>(list);

    }
}
