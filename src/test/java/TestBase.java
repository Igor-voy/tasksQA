import config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.Browser;

public class TestBase {
    private final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private final Browser browser = new Browser();

    @BeforeMethod
    public void setUp() {
        logger.info("Настройка теста...");
        ConfigManager config = new ConfigManager("src/main/" +
                "resources/config.properties");
        browser.maximize();
        logger.info("Открываем браузер...");
        browser.open(config.getBaseUrl());
    }

    @AfterClass
    public void tearDown() {
        logger.info("Закрываем браузер...");
        browser.close();
    }
}
