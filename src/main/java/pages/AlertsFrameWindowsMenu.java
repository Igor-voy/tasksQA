package pages;

import elements.Button;
import org.openqa.selenium.By;

public class AlertsFrameWindowsMenu extends BasePage{
    private Button alertsElemMenu;
    private Button framesElemMenu;
    private Button nestedFramesElemMenu;
    private Button tablesElemMenu;
    private Button browserWindowsElemMenu;
    private Button linksElemMenu;

    public AlertsFrameWindowsMenu(String pageName) {
        super(pageName);
        alertsElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[contains(text(), 'Alerts')]"), "Кнопка меню Alerts");
        nestedFramesElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[text()='Nested Frames']"), "Кнопка меню Nested Frames");
        framesElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[text()='Frames']"), "Кнопка меню Frames");
        tablesElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[text()='Web Tables']"), "Кнопка меню Web Tables");
        browserWindowsElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[text()='Browser Windows']"), "Кнопка меню Browser Windows");
        linksElemMenu = new Button(By.xpath("//ul[@class='menu-list']" +
                "//span[text()='Links']"), "Кнопка меню Links");
    }

    public void clickOnAlertElem() {
        alertsElemMenu.clickOnButton();
    }

    public void clickOnBrowserWindowsElem() {
        browserWindowsElemMenu.clickOnButton();
    }

    public void clickOnNestedElem() {
        nestedFramesElemMenu.clickOnButton();
    }

    public void clickOnLinksElem() {
        linksElemMenu.clickOnButton();
    }

    public void clickOnFrameElem() {
        framesElemMenu.clickOnButton();
    }

    public void clickTablesElem() {
        tablesElemMenu.clickOnButton();
    }
}
