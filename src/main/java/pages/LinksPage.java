package pages;

import elements.Button;
import org.openqa.selenium.By;

public class LinksPage extends BasePage{
    private Button homeButton;
    private By linksPageOpen = By.id("linkWrapper");
    private By homePageOpen = By.xpath("//img[@class='banner-image']");

    public LinksPage(String pageName) {
        super(pageName);
        homeButton = new Button(By.id("simpleLink"), "Кнопка Home");
    }

    public void clickHomeButton() {
        homeButton.clickOnButton();
    }

    public boolean isHomePageOpen() {
        logger.info("Открыта новая вкладка с главной страницей...");
        return isPageOpen(homePageOpen);
    }

    public boolean isLinksPageOpen() {
        logger.info("Страница " + pageName + " открыта");
        return isPageOpen(linksPageOpen);
    }
}
