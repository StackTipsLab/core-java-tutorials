package com.stacktips.threads;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebScraperUsingCompletableFuture {

    private final ExecutorService executorService;
    private final WebScraper webScraper;

    public WebScraperUsingCompletableFuture(int nThreads) {
        this.executorService = Executors.newFixedThreadPool(nThreads);
        this.webScraper = new WebScraper();
    }

    public List<String> scrapeWebsites(List<String> urls) {
        List<CompletableFuture<String>> futures = urls.stream()
                .map(url -> CompletableFuture.supplyAsync(() -> webScraper.scrapeWebsite(url), executorService)
                        .orTimeout(30, TimeUnit.SECONDS)
                        .exceptionally(e -> "Error: " + e.getMessage()))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .toList();
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

        WebScraperUsingCompletableFuture scraper = new WebScraperUsingCompletableFuture(3);
        try {
            List<String> results = scraper.scrapeWebsites(urls);
            results.forEach(System.out::println);
        } finally {
            scraper.shutdown();
        }
    }
}