package Tests;

import SeleniumWithSingleton.Driver;
import TestData.TopGame;
import TestData.UniqueXPath;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopGamePage;
import pages.TopSellersPage;

import java.util.ArrayList;

public class TestCaseTwo {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void testSetup(){
        Driver setup = Driver.getInstance();
        driver = setup.openBrowser();
        homePage = new HomePage(driver);
    }

    @Test
    public void testCaseTwo(){
        homePage.open();
        Assert.assertTrue(homePage.isElementVisible(
                UniqueXPath.unique_locator_home), "Главная страница открыта");
        homePage.moveToNew();
        homePage.clickTopSellers();

        TopSellersPage topPage = homePage.getTopSellersPage();
        Assert.assertTrue(topPage.isElementVisible(
                UniqueXPath.unique_locator_topSellers),
                "Открыта страница с продуктами - лидеры продаж");
        topPage.moveToMore();
        topPage.clickMoreTop();
        Assert.assertTrue(topPage.isElementVisible(
                        UniqueXPath.unique_locator_topSellersFilters),
                "Открыта страница с продуктами - лидеры продаж, фильтрами и " +
                        "поиском");
        topPage.clickCheckBoxLinux();
        Assert.assertTrue(topPage.activeCheckBoxLinux(),
                "Чекбокс 'SteamOs + Linux' выбран");
        topPage.openNumOfPlayers();
        topPage.clickCheckBoxAction();;
        Assert.assertTrue(topPage.activeCheckBoxAction(),
                "Чекбокс 'Экшен' выбран");
        topPage.clickCheckBoxCoopLan();
        Assert.assertTrue(topPage.activeCheckBoxCoopLan(),
                "Чекбокс 'Кооператив(LAN)' выбран");
        Assert.assertTrue(topPage.compareCountGames(), "Указанное количество " +
                "результатов по запросу соответствует " +
                "количеству игр в списке");
        TopGame gameTop = topPage.returnTopGame();
        topPage.clickTopGame();

        TopGamePage topGamePage = topPage.getTopGamePage();
        ArrayList<String> dataGame = topGamePage.getDataGame();
        Assert.assertEquals(gameTop.getTitle(), dataGame.get(0),
                "Название соответствует");
        Assert.assertEquals(gameTop.getReleased(), dataGame.get(1),
                "Дата релиза соответствует");
        Assert.assertEquals(gameTop.getPrice(), dataGame.get(2),
                "Цена соответствует");
    }

    @AfterClass
    public void testQuit(){
        driver.quit();
    }
}
