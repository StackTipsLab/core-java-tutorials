package com.stacktips.collections.set;

import java.util.LinkedHashSet;

public class UserActivityTracker {
    public static void main(String[] args) {
        LinkedHashSet<String> pagesVisited = new LinkedHashSet<>();

        pagesVisited.add("home.html");
        pagesVisited.add("about.html");
        pagesVisited.add("contact.html");
        pagesVisited.add("home.html"); // Duplicate visit, will not be added again
        pagesVisited.add("services.html");

        // Display the pages visited in the order of insertion
        System.out.println("Pages visited:");
        for (String page : pagesVisited) {
            System.out.println(page);
        }
    }
}
