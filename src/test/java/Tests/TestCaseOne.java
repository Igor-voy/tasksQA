package Tests;

import SeleniumWithSingleton.Driver;
import TestData.UniqueXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class TestCaseOne {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void testSetup(){
        Driver setup = Driver.getInstance();
        driver = setup.openBrowser();
        homePage = new HomePage(driver);
    }

    @Test
    public void testCaseOne(){
        homePage.open();
        Assert.assertTrue(homePage.isElementVisible(
                UniqueXPath.unique_locator_home), "Главная страница открыта");
        homePage.clickAboutBtn();
        AboutPage aboutPage = homePage.getAboutPage();
        Assert.assertTrue(aboutPage.isElementVisible(
                UniqueXPath.unique_locator_about), "Страница About открыта");
        Assert.assertTrue(aboutPage.outputCompare(),
                "Число игроков сейчас меньше, чем онлайн");
        aboutPage.clickStoreBtn();
        StorePage storePage = aboutPage.getStorePage();
        Assert.assertTrue(storePage.isElementVisible(
                UniqueXPath.unique_locator_store), "Страница магазина открыта");
    }

    @AfterClass
    public void testQuit(){
        driver.quit();
    }


}
