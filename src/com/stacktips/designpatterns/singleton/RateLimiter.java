package com.stacktips.designpatterns.singleton;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class RateLimiter {

    private static RateLimiter instance;

    private Map<String, Queue<Integer>> userRequests;

    private static final int MAX_REQUESTS_PER_MINUTE = 3;

    private RateLimiter() {
        userRequests = new HashMap<>();
    }

    public static RateLimiter getInstance() {
        if (instance == null) {
            synchronized (RateLimiter.class) {
                if (instance == null) {
                    instance = new RateLimiter();
                }
            }
        }
        return instance;
    }

    public synchronized boolean allowRequest(int timestamp, String userId) {
        int currentMinute = timestamp / 60;

        Queue<Integer> requests = userRequests.computeIfAbsent(userId, k -> new LinkedList<>());
        while (!requests.isEmpty() && requests.peek() / 60 < currentMinute) {
            requests.poll();
        }

        if (requests.size() < MAX_REQUESTS_PER_MINUTE) {
            requests.offer(timestamp);
            return true;
        }

        return false;
    }
}