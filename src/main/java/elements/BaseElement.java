package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverContext;

public class BaseElement {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By locator;
    protected String elementName;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseElement() {
        this.driver = DriverContext.getDriver();
        this.wait = DriverContext.getWait();
    }

    public BaseElement(By locator, String elementName) {
        this();
        this.locator = locator;
        this.elementName = elementName;
    }

    protected WebElement findElement() {
        logger.info("Ищем элемент " + elementName + " по локатору " + locator);
        waitForVisibility(locator);
        return driver.findElement(locator);
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementVisible(By locator) {
        try {
            waitForVisibility(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }
}
