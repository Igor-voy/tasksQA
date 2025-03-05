package pages;

import TestData.TopGame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;


public class TopSellersPage extends BasePage{

    private final By moreTopSellersBtn = By.xpath("//*[contains(@class, " +
            "'DialogButton _DialogLayout')]");
    private final By checkBoxAction = By.xpath("//span[@data-loc=" +
            "'Action'][1]");
    private final By checkBoxCoopLan = By.xpath("//span[contains(@data-loc, " +
            "'LAN Co-op')]");
    private final By checkBoxLinux = By.xpath("//span[@data-loc=" +
            "'SteamOS + Linux']");
    private final By resultCountGames = By.xpath("//div[contains(@class, " +
            "'search_results_count')]");

    private final By titleGame = By.xpath("//a[contains(@data-gpnav, " +
            "'item')][1]//span[@class='title']");
    private final By releasedGame = By.xpath("//a[contains(@data-gpnav, 'item')][1]" +
            "//div[contains(@class, 'search_released')]");
    private final By priceGame = By.xpath("//a[contains(@data-gpnav, 'item')][1]" +
            "//div[contains(@class, 'discount_final_price')]");

    private final By topGameBtn = By.xpath("//a[contains(@data-gpnav, " +
            "'item')][1]");

    public TopSellersPage(WebDriver driver) {
        super(driver);
    }

    public void moveToMore(){
        super.moveToElem(moreTopSellersBtn);
    }

    public void clickCheckBoxLinux(){
        super.click(checkBoxLinux);
    }

    public boolean activeCheckBoxLinux(){
        String str = driver.findElement(checkBoxLinux).getAttribute("class");
        return str.contains("checked");
    }

    public void clickCheckBoxCoopLan(){
        super.click(checkBoxCoopLan);
    }

    public boolean activeCheckBoxCoopLan(){
        String str = driver.findElement(checkBoxCoopLan).getAttribute("class");
        return str.contains("checked");
    }

    public void openNumOfPlayers(){
       super.click(By.xpath("//*[contains(text(), " +
                "'Narrow by number of players')]"));
    }

    private String getTextTop(By locator) {
        return super.getText(locator);
    }

    private int countGames() {
        super.waitForVisibility(By.xpath("//div[contains(@class, 'search_results_count')]"));
        return driver.findElements(By.xpath("//a[contains(@class, " +
                "'search_result_row ds_collapse_flag ')]")).size();
    }

    private int parseInteger(){
        return parseInt(this.getTextTop(resultCountGames).
                replaceAll("[^0-9]+", ""));
    }

    public boolean compareCountGames(){
        return parseInteger() == countGames();
    }

    public void clickCheckBoxAction(){
        driver.findElement(By.xpath("//input[contains(@id, 'TagSuggest')]")).sendKeys("Action");
        super.click(checkBoxAction);
    }

    public boolean activeCheckBoxAction(){
        String str = driver.findElement(checkBoxAction).getAttribute("class");
        return str.contains("checked");
    }

    public void clickMoreTop(){
        super.click(moreTopSellersBtn);
    }

    public TopGame returnTopGame(){
        String title = super.getText(this.titleGame);
        String released = super.getText(this.releasedGame);
        String price = super.getText(this.priceGame);
        return new TopGame(title, released, price);
    }

    public void clickTopGame(){
        super.click(topGameBtn);
    }

    public TopGamePage getTopGamePage(){
        return new TopGamePage(driver);
    }

}
