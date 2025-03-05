package elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement{
    public TextBox(By locator, String elementName) {
        super(locator, elementName);
    }

    public void enterText(String text) {
        logger.info("Вводим данные в поле " + this.elementName);
        findElement().sendKeys(text);
    }
}
