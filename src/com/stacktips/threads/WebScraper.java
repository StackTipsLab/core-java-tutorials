package com.stacktips.threads;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebScraper {

    String scrapeWebsite(String urlString) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlString))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return String.format("URL: %s, Content Length: %d bytes", urlString, response.body().length());

        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("URI Syntax Exception: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("URI Syntax Exception: " + e.getMessage());
        }

        return "Error: Unable to scrape website.";
    }
}
