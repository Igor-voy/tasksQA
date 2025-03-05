package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TopGamePage extends BasePage{

    private final By nameGame = By.xpath("//div[@id='appHubAppName']");
    private final By dateReleased = By.xpath("//div[@class='glance_ctn']" +
            "//div[@class='date']");
    private final By gamePrice = By.xpath("//div[@class=" +
            "'game_area_purchase_game']//div[@class='discount_final_price' " +
            "or @class='game_purchase_price price']");

    public TopGamePage(WebDriver driver){
        super(driver);
    }

    public ArrayList<String> getDataGame(){
        ArrayList<String> list = new ArrayList<>();
        list.add(super.getText(nameGame));
        list.add(super.getText(dateReleased));
        list.add(super.getText(gamePrice).replaceAll("\\.", ""));
        return list;
    }
}


//div[@class="game_area_purchase_game"]//div[@class="discount_final_price" or @class="game_purchase_price price"]