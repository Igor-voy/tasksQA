package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

public class AboutPage extends BasePage{

    private By online_users = By.xpath("//*[@class='online_stat'][1]");
    private By playing_users = By.xpath("//*[@class='online_stat'][2]");
    private By storeBtn = By.xpath("//*[contains(@class, 'supernav_container')]" +
            "//a[contains(@class, 'menuitem ')][1]");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getTextAbout(By locator) {
       return super.getText(locator);
    }

    public boolean compare(String online, String playing){
        int onlineInt = parseInt(online.replaceAll("[^\\d.]+", ""));
        int playingInt = parseInt(playing.replaceAll("[^\\d.]+", ""));
        return onlineInt >= playingInt;
    }

    public boolean outputCompare(){
        return compare(this.getTextAbout(this.online_users),
                this.getTextAbout(this.playing_users));
    }

    public void clickStoreBtn(){
        super.click(storeBtn);
    }

    public StorePage getStorePage(){
        return new StorePage(driver);
    }

}
