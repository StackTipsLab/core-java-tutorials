package com.stacktips.threads;

import java.io.IOException;
import java.net.URL;

public class WebScraper {

    String scrapeWebsite(String urlString) {
        try {
            URL url = new URL(urlString);
            try (var stream = url.openStream()) {
                int contentLength = stream.readAllBytes().length;
                return String.format("URL: %s, Content Length: %d bytes", urlString, contentLength);
            }
        } catch (IOException e) {
            return "Error scraping " + urlString + ": " + e.getMessage();
        }
    }
}
