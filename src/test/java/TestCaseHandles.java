import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.HomePage;
import pages.LinksPage;
import utils.Handles;
import utils.SetToList;

import java.util.List;

public class TestCaseHandles extends TestBase{
    private final Logger logger = LoggerFactory.getLogger(TestCaseTables.class);

    @Test
    public void testHandles() {
        HomePage homePage = new HomePage("Home page");
        Assert.assertTrue(homePage.isOpenHomePage());
        homePage.clickOnAlertsFramesWindows();
        BrowserWindowsPage browserWindowsPage= homePage.getBrowserWindowsPage();
        browserWindowsPage.openBrowserWindows();
        Assert.assertTrue(browserWindowsPage.isBrowserWindowsPageOpen());
        browserWindowsPage.clickTabButton();
        Handles handlesController = new Handles();
        String mainWindowHandle = handlesController.getHadleThisWindow();
        SetToList converter = new SetToList();
        List<String> allWindowHandlesBrowser = converter.getList(handlesController
                .getHandles());
        handlesController.selectWindow(mainWindowHandle, allWindowHandlesBrowser);
        Assert.assertTrue(browserWindowsPage.isTabSamplePageOpen());
        handlesController.closeWindow();
        handlesController.windowSwitch(mainWindowHandle);
        Assert.assertTrue(browserWindowsPage.isBrowserWindowsPageOpen());
        browserWindowsPage.clickElementsButton();
        browserWindowsPage.openLinksPage();
        LinksPage linksPage = browserWindowsPage.getLinksPage();
        Assert.assertTrue(linksPage.isLinksPageOpen());
        linksPage.clickHomeButton();
        List<String> allWindowHandlesLinks = converter.getList(handlesController
                .getHandles());
        handlesController.selectWindow(mainWindowHandle, allWindowHandlesLinks);
        Assert.assertTrue(linksPage.isHomePageOpen());
        handlesController.windowSwitch(mainWindowHandle);
        Assert.assertTrue(linksPage.isLinksPageOpen());
    }
}
