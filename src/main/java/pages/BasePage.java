package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public void open(String url){
        driver.get(url);
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    public void moveToElem(By locator) {
        waitForVisibility(locator);
        WebElement elem = driver.findElement(locator);
        action.moveToElement(elem).perform();
    }

    public String getText(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public boolean isElementVisible(By locator) {
        try {
            waitForVisibility(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
