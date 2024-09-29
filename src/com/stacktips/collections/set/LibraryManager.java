package com.stacktips.collections.set;

import java.util.TreeSet;

public class LibraryManager {
    public static void main(String[] args) {
        TreeSet<String> bookTitles = new TreeSet<>();
        bookTitles.add("To Kill a Mockingbird");
        bookTitles.add("1984");
        bookTitles.add("Pride and Prejudice");
        bookTitles.add("Queen of England");
        bookTitles.add("The Catcher in the Rye");
        bookTitles.add("1984"); // Duplicate title, will not be added again

        // Display the book titles in sorted order
        System.out.println("Book titles (sorted):");
        for (String title : bookTitles) {
            System.out.println(title);
        }

        // Finding the first and last book titles
        System.out.println("\nFirst book in the library: " + bookTitles.first());
        System.out.println("Last book in the library: " + bookTitles.last());

        // Displaying a subset of books
        System.out.println("\nBooks between 'P' and 'T':");
        for (String title : bookTitles.subSet("P", "T")) {
            System.out.println(title);
        }
    }
}
