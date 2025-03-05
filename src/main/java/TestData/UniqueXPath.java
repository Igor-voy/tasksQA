package TestData;

import org.openqa.selenium.By;

public class UniqueXPath {
    public static By unique_locator_home =
            By.xpath("//*[@class='gutter_header gutter_top']");
    public static By unique_locator_about =
            By.xpath("//*[@class='about_subtitle']");
    public static By unique_locator_store =
            By.xpath("//*[@class='gutter_header gutter_top']");
    public static By unique_locator_topSellers =
            By.xpath("//*[contains(@class, 'DialogButton _DialogLayout')]");
    public static By unique_locator_topSellersFilters =
            By.xpath("//div[@id='additional_search_options']");
}
