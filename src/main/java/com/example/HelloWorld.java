package com.example;

import com.microsoft.playwright.*;

public class HelloWorld {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
            Browser browser = playwright.chromium().launch(options);
            Page page = browser.newPage();

            // Abrir una página
            page.navigate("https://example.com");

            // Buscar un elemento
            Locator element = page.locator("h1");

            // Imprimir el texto del elemento
            System.out.println("Texto del elemento: " + element.textContent());

            // Cerrar el navegador
            browser.close();
        }
    }
}
