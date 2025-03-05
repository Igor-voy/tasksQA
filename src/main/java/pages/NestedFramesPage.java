package pages;

import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage{
    AlertsFrameWindowsMenu menu;
    private By frameWrapper = By.id("frame1Wrapper");
    private By parentFrame = By.xpath("//body[contains(text(), " +
            "'Parent frame')]");
    private By childFrame = By.xpath("//p[contains(text(), " +
            "'Child Iframe')]");

    public NestedFramesPage(String pageName) {
        super(pageName);
        menu = new AlertsFrameWindowsMenu("Left menu");
    }

    public void openNestedFrames() {
        menu.clickOnNestedElem();
    }

    public boolean isTextInFrames() {
        waitForVisibility(frameWrapper);
        controllerFrame.getSwitchTo("frame1");
        boolean parent = isPageOpen(parentFrame);
        controllerFrame.getIndexFrame(0);
        boolean child = isPageOpen(childFrame);
        controllerFrame.getDefaultFrame();
        return parent && child;
    }

    public boolean isNestedPageOpen() {
        logger.info("Страница " + pageName + " открыта");
        return isPageOpen(frameWrapper);
    }

    public FramesPage getFramePage() {
        return new FramesPage("Page with frames");
    }
}
