package SeleniumWithSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static Driver instance = null;
    private WebDriver driver;

    ChromeOptions chromeOptions = new ChromeOptions();

    private Driver() {
    }

    public WebDriver openBrowser() {
        driver = new ChromeDriver(chromeOptions.addArguments("--lang=en-en", "incognito"));
        driver.manage().window().maximize();
        return driver;
    }

    public static Driver getInstance() {
        if(instance == null) {
            instance = new Driver();
        }

        return instance;
    }

}
