import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import pages.NestedFramesPage;

public class TestCaseFrames extends TestBase{
    private final Logger logger = LoggerFactory.getLogger(TestCaseFrames.class);

    @Test
    public void testFrames() {
        HomePage homePage = new HomePage("Home page");
        Assert.assertTrue(homePage.isOpenHomePage());
        homePage.clickOnAlertsFramesWindows();
        NestedFramesPage nestedFramesPage = homePage.getNestedFramesPage();
        nestedFramesPage.openNestedFrames();
        Assert.assertTrue(nestedFramesPage.isNestedPageOpen());
        Assert.assertTrue(nestedFramesPage.isTextInFrames());
        logger.info("В центре страницы присутствуют надписи 'Parent frame' " +
                "и 'Child Iframe'...");
        FramesPage framesPage = nestedFramesPage.getFramePage();
        framesPage.openFrames();
        Assert.assertTrue(framesPage.isFramesPageOpen());
        Assert.assertEquals(framesPage.getTextFrameOne(),
                framesPage.getTextFrameTwo());
        logger.info("Надпись из верхнего фрейма соответствует надписи из нижнего...");
    }
}
