package elements;

import org.openqa.selenium.By;

public class Button extends BaseElement{
    public Button(By locator, String elementName) {
        super(locator, elementName);
    }

    public void clickOnButton() {
        logger.info("Нажимаем на кнопку " + this.elementName);
        click();
    }
}
