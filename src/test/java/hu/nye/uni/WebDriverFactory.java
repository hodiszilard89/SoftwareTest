package hu.nye.uni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Objects;

public class WebDriverFactory {
    private static WebDriver webDriver;


    public WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {

            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(new ChromeOptions().setHeadless(false));
            webDriver.manage().window().setSize(new Dimension(1280,720));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        }

        return webDriver;
    }
}