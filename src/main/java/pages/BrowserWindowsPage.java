package pages;

import elements.Button;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BasePage{
    AlertsFrameWindowsMenu menu;
    private Button tabButton;
    private By samplePageOpen = By.id("sampleHeading");
    private Button elementsElemMenu;
    private By browserWindowsOpen = By.id("browserWindows");

    public BrowserWindowsPage(String pageName) {
        super(pageName);
        menu = new AlertsFrameWindowsMenu("Left menu");
        tabButton = new Button(By.id("tabButton"), "Кнопка New Tab");
        elementsElemMenu = new Button(By.xpath("//div[@class='element-group']" +
                "//div[text()='Elements']"), "Кнопка меню Elements");
    }

    public void openBrowserWindows() {
        menu.clickOnBrowserWindowsElem();
    }

    public void clickElementsButton() {
        elementsElemMenu.clickOnButton();
    }

    public boolean isBrowserWindowsPageOpen() {
        logger.info("Страница " + pageName + " открыта");
        return isPageOpen(browserWindowsOpen);
    }

    public void openLinksPage() {
        menu.clickOnLinksElem();
    }

    public void clickTabButton() {
        tabButton.clickOnButton();
    }

    public boolean isTabSamplePageOpen() {
        logger.info("Открыта новая вкладка /sample со страницей sample page...");
        return isPageOpen(samplePageOpen);
    }

    public LinksPage getLinksPage() {
        return new LinksPage("Page Links");
    }
}
