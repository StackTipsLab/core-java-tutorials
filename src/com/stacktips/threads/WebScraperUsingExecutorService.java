package com.stacktips.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WebScraperUsingExecutorService {

    private final ExecutorService executorService;
    private final WebScraper webScraper;

    public WebScraperUsingExecutorService(int nThreads) {
        this.executorService = Executors.newFixedThreadPool(nThreads);
        this.webScraper = new WebScraper();
    }

    public List<String> scrapeWebsites(List<String> urls) throws InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        for (String url : urls) {
            futures.add(executorService.submit(() -> webScraper.scrapeWebsite(url)));
        }

        List<String> results = new ArrayList<>();
        for (Future<String> future : futures) {
            try {
                results.add(future.get(30, TimeUnit.SECONDS));
            } catch (ExecutionException | TimeoutException e) {
                results.add("Error: " + e.getMessage());
            }
        }

        return results;
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        List<String> urls = List.of(
            "https://www.example.com",
            "https://www.github.com",
            "https://www.stackoverflow.com",
            "https://www.java.com",
            "https://www.spring.io"
        );

        WebScraperUsingExecutorService scraper = new WebScraperUsingExecutorService(3);
        try {
            List<String> results = scraper.scrapeWebsites(urls);
            results.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scraper.shutdown();
        }
    }
}