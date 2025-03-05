package pages;

import elements.Label;
import org.openqa.selenium.By;

public class FramesPage extends BasePage{
    AlertsFrameWindowsMenu menu;
    private final By frameOneWrapper = By.id("frame1Wrapper");
    private By frameTwoWrapper = By.id("frame2Wrapper");
    private Label sampleHeading;

    public FramesPage(String pageName){
        super(pageName);
        menu = new AlertsFrameWindowsMenu("Left menu");
        sampleHeading = new Label(By.id("sampleHeading"), "Название страницы");
    }

    public void openFrames() {
        menu.clickOnFrameElem();
    }

    public boolean isFramesPageOpen() {
        logger.info("Страница " + pageName + " открыта");
        return isPageOpen(frameOneWrapper);
    }

    public String getTextFrameOne() {
        waitForVisibility(frameOneWrapper);
        controllerFrame.getSwitchTo("frame1");
        String text = sampleHeading.getText();
        controllerFrame.setDefaultFrame();
        return text;
    }

    public String getTextFrameTwo() {
        waitForVisibility(frameTwoWrapper);
        controllerFrame.getSwitchTo("frame1");
        String text = sampleHeading.getText();
        controllerFrame.setDefaultFrame();
        return text;
    }
}