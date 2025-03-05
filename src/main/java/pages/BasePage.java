package pages;

import elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverContext;
import utils.FramesController;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected FramesController controllerFrame;
    protected String pageName;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePage(String pageName) {
        this.driver = DriverContext.getDriver();
        this.wait = DriverContext.getWait();
        this.pageName = pageName;
        this.controllerFrame = new FramesController();
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isPageOpen(By locator) {
        logger.info("Ожидание открытия страницы " + pageName);
        BaseElement openPage = new BaseElement();
        return openPage.isElementVisible(locator);
    }
}
