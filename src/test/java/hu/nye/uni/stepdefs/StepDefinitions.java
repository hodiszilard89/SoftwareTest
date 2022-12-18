package hu.nye.uni.stepdefs;


import hu.nye.uni.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class StepDefinitions {
    private final WebDriver webDriver;
    //private final HomePage homePage;


    public StepDefinitions() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        this.webDriver = webDriverFactory.getWebDriver();

    }

    @Given("the home page is opened")
    public void theHomePageIsOpend() {
        //homePage.openHomePage();
        webDriver.manage().deleteAllCookies();
        webDriver.get("https://wearecommunity.io/");
    }

    @Then("the cookie distance is closed")
    public void theCookieDistanceIsClosed() {
        WebElement cookieDisclamer = new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                ExpectedConditions.
                        elementToBeClickable(By.id("onetrust-accept-btn-handler"))
        );
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", cookieDisclamer);
    }

    @And("click About button")
    public void clickAboutButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/header/div/div/ul[1]/li[5]"))
        ).click();
        waitForPageReadiness();
    }

    @Given("social cards is visibility")
    public void socialCardsIsVisibility() {new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
            ExpectedConditions.
                    visibilityOfElementLocated(By.
                            xpath("//*[@id=\"app\"]/div[1]/main/section[2]/div/div/div/div[1]/div[2]/div[2]"))
    ).click();
        waitForPageReadiness();

    }

////////////////
    public void waitForPageReadiness() {
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                driver ->
                        String.valueOf(
                                ((JavascriptExecutor) driver).
                                        executeScript("return document.readyState").
                                        equals("complete"))
        );
    }

}
