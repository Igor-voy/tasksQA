import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import utils.ParserJson;

public class TestCaseAlerts extends TestBase {
    private final Logger logger = LoggerFactory.getLogger(TestCaseAlerts.class);
    @Test
    public void testAlerts() {
        HomePage homePage = new HomePage("Home page");
        Assert.assertTrue(homePage.isOpenHomePage());
        homePage.clickOnAlertsFramesWindows();
        AlertsPage alertsPage = homePage.getAlertsPage();
        alertsPage.openAlerts();
        Assert.assertTrue(alertsPage.isAlertPageOpen());
        Assert.assertEquals(alertsPage.clickAlertButton(),
                ParserJson.getTextJson("AlertButton"));
        logger.info("Открыт alert с текстом 'You clicked a button'...");
        Assert.assertFalse(alertsPage.isAlertOpen());
        Assert.assertEquals(alertsPage.clickConfirmAlertButton(),
                ParserJson.getTextJson("ConfirmAlertButton"));
        Assert.assertFalse(alertsPage.isAlertOpen());
        Assert.assertEquals(alertsPage.confirmAlertReturnResult(),
                "You selected Ok");
        logger.info("Рядом с кнопкой появилась надпись 'You selected Ok'...");
        Assert.assertEquals(alertsPage.clickPromtAlertButton(),
                ParserJson.getTextJson("PromtAlertButton"));
        logger.info("Открыт alert с текстом 'Please enter your name'...");
        Assert.assertFalse(alertsPage.isAlertOpen());
        Assert.assertTrue(alertsPage.promptAlertReturnResult()
                .contains(alertsPage.nameReturnAlert()));
        logger.info("Появившийся текст соответствует введенному в alert...");
    }
}
