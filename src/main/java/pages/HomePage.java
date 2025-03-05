package pages;

import elements.Button;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private Button alertsFramesWindowsButton;
    private By homePageElement = By.xpath("//img[@class='banner-image']");
    private Button elementsButton;

    public HomePage(String pageName) {
        super(pageName);
        alertsFramesWindowsButton = new Button(By.xpath("//div[@class='card-body']" +
                "//h5[contains(text(), 'Alerts')]"), "Кнопка Alerts," +
                "Frames, Windows");
        elementsButton = new Button(By.xpath("//div[@class='card-body']" +
                "//h5[contains(text(), 'Elements')]"), "Кнопка Elements");
    }

    public void clickOnAlertsFramesWindows() {
        alertsFramesWindowsButton.clickOnButton();
    }

    public void clickElements() {
        elementsButton.clickOnButton();
    }

    public boolean isOpenHomePage() {
        logger.info("Открываем страницу " + pageName);
        return isPageOpen(homePageElement);
    }

    public AlertsPage getAlertsPage() {
        return new AlertsPage("Page with alerts");
    }

    public NestedFramesPage getNestedFramesPage() {
        return new NestedFramesPage("Page with nested frames");
    }

    public BrowserWindowsPage getBrowserWindowsPage() {
        return new BrowserWindowsPage("Page with handles");
    }

    public TablesPage getTablesPage() {
        return new TablesPage("Page with tables");
    }
}
