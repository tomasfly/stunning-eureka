package com.example.api;

import com.microsoft.playwright.*;

public class ApiTestExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Use the Playwright API to create a new browser context for API testing
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(true);
            Browser browser = playwright.chromium().launch(options);
            BrowserContext context = browser.newContext();

            // Create a new page for sending HTTP requests
            Page page = context.newPage();

            // Send a GET request
            Response response = page.navigate("https://jsonplaceholder.typicode.com/todos/1");

            // Print the response status and body
            System.out.println("Response Status: " + response.status());
            System.out.println("Response Body: " + response.text());

            // Close the browser
            browser.close();
        }
    }
}