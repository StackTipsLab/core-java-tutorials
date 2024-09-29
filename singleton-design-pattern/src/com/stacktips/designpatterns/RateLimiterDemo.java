package com.stacktips.designpatterns;

import java.util.Scanner;

public class RateLimiterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RateLimiter rateLimiter = RateLimiter.getInstance();

        while (true) {
            System.out.print("Enter user ID (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
            if (rateLimiter.allowRequest(currentTimestamp, input)) {
                System.out.println("Hello! Request accepted for user " + input);
            } else {
                System.out.println("Rate limit exceeded for user " + input + ". Try again later.");
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}