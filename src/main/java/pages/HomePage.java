package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By unique_locator = By.xpath("//*[@class='gutter_header gutter_top']");
    private By aboutBtn = By.xpath("//*[contains(@class, 'supernav_container')]" +
            "//a[contains(@class, 'menuitem ')][3]");
    private final By newTab = By.xpath("//*[@id='noteworthy_tab']");
    private final By topSellers = By.xpath("//*[contains(@class, 'popup_menu_browse')]" +
            "//a[contains(text(), 'Top Sellers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        super.open("https://store.steampowered.com/");
        waitForVisibility(unique_locator);
    }

    public void clickAboutBtn(){
        super.click(aboutBtn);
    }

    public void moveToNew(){
        super.moveToElem(newTab);
    }

    public void clickTopSellers(){
        super.click(topSellers);
    }

    public AboutPage getAboutPage(){
        return new AboutPage(driver);
    }

    public TopSellersPage getTopSellersPage(){
        return new TopSellersPage(driver);
    }
}
