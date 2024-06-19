package com.example;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public String getHeaderText() {
        return page.locator("h1").textContent();
    }

    public void navigateTo() {
        page.navigate("https://example.com");
    }
}