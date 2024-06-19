package com.example.steps;

import com.example.HomePage;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class HomePageSteps {
    private static Playwright playwright;
    private static Browser browser;
    private Page page;
    private HomePage homePage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Given("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        BrowserContext context = browser.newContext();
        page = context.newPage();
        homePage = new HomePage(page);
        homePage.navigateTo();
    }

    @Then("the user should see the header text {string}")
    public void theUserShouldSeeTheHeaderText(String expectedText) {
        assertEquals(expectedText, homePage.getHeaderText());
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}