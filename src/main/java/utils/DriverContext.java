package utils;

import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverContext {
    private static BrowserFactory browserFactory = BrowserFactory.getInstance();
    private static ConfigManager config = new ConfigManager("src/main/" +
            "resources/config.properties");

    public static WebDriver getDriver() {
        return browserFactory.getDriver(config.getBrowserName());
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(),
                Duration.ofSeconds(config.getTimeout()));
    }
}
