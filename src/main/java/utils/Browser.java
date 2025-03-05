package utils;

import config.ConfigManager;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Browser {
    private WebDriver driver;
    private WebDriverWait wait;
    private static ConfigManager config = new ConfigManager("src/main/" +
            "resources/config.properties");
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Browser() {
        this.driver = DriverContext.getDriver();
        this.wait = DriverContext.getWait();
    }

    public void open(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public Set<String> getHandles() {
        return driver.getWindowHandles();
    }

    public String getHandleThisWindow() {
        return driver.getWindowHandle();
    }

    public void controlFrames(String name) {
        driver.switchTo().frame(name);
    }

    public void setDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public void setIndexFrame(int index) {
        driver.switchTo().frame(index);
    }

    public SearchContext windowSwitch(String discriptor) {
        return driver.switchTo().window(discriptor);
    }

    public void closeWindow() {
        driver.close();
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
