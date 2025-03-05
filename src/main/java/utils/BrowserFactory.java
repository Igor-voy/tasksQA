package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private static BrowserFactory instance = null;
    private WebDriver driver;
    private ChromeOptions optionsChrome = new ChromeOptions();
    private FirefoxOptions optionsFireFox = new FirefoxOptions();

    private BrowserFactory() {
    }

    public static BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String browserName) {
        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    optionsChrome.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    optionsChrome.addArguments("--lang=en-en", "incognito");
                    driver = new ChromeDriver(optionsChrome);
                    break;
                case "firefox":
                    optionsFireFox.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    optionsFireFox
                            .addArguments("--lang=en-en", "-private");
                    driver = new FirefoxDriver(optionsFireFox);
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный браузер: " +
                            browserName);
            }
        }
        return driver;
    }
}
