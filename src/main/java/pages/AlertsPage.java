package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.RandomTextGenerator;

public class AlertsPage extends BasePage{
    AlertsFrameWindowsMenu menu;
    private final Button alertButton;
    private final Button confirmButton;
    private final Button promtButton;
    private final String nameReturnAlert;
    private final By alertPageOpen = By.id("javascriptAlertsWrapper");
    private final Label confirmAlertResult;
    private final Label promptAlertResult;

    public AlertsPage(String pageName) {
        super(pageName);
        menu = new AlertsFrameWindowsMenu("Left menu");
        alertButton = new Button(By.id("alertButton"), "Кнопка alert");
        confirmButton = new Button(By.id("confirmButton"), "Кнопка confirm alert");
        promtButton = new Button(By.id("promtButton"), "Кнопка prompt alert");
        confirmAlertResult = new Label(By.id("confirmResult"), "Результат confirm alert");
        promptAlertResult = new Label(By.id("promptResult"), "Результат prompt alert");
        nameReturnAlert = RandomTextGenerator.generator();
    }

    public void openAlerts() {
        logger.info("Открываем страницу " + pageName);
        menu.clickOnAlertElem();
    }

    public void alertWait() {
        logger.info("Ожидаем alert");
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean isAlertOpen() {
        try {
            alertWait();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String confirmAlertReturnResult() {
        return confirmAlertResult.getText();
    }

    public String promptAlertReturnResult() {
        return promptAlertResult.getText();
    }

    public String clickAlertButton() {
        alertButton.clickOnButton();
        alertWait();
        Alert alert = getAlert();
        String alertText = alert.getText();
        logger.info("Alert закрыт...");
        alert.accept();
        return alertText;
    }

    public String clickConfirmAlertButton() {
        confirmButton.clickOnButton();
        alertWait();
        Alert alert = getAlert();
        String alertText = alert.getText();
        logger.info("Alert закрыт...");
        alert.accept();
        return alertText;
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    public String nameReturnAlert(){
        return nameReturnAlert;
    }

    public String clickPromtAlertButton(){
        promtButton.clickOnButton();
        alertWait();
        Alert alert = getAlert();
        String alertText = alert.getText();
        alert.sendKeys(nameReturnAlert);
        logger.info("Alert закрыт...");
        alert.accept();
        return alertText;
    }

    public boolean isAlertPageOpen() {
        logger.info("Страница " + pageName + " открыта");
        return isPageOpen(alertPageOpen);
    }
}
