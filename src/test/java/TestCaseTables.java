import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TablesPage;
import utils.UserData;

public class TestCaseTables extends TestBase{
    private final Logger logger = LoggerFactory.getLogger(TestCaseTables.class);

    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)
    public void testTables(UserData userData) {
        HomePage homePage = new HomePage("Home page");
        Assert.assertTrue(homePage.isOpenHomePage());
        homePage.clickElements();
        TablesPage tablesPage = homePage.getTablesPage();
        tablesPage.openTables();
        Assert.assertTrue(tablesPage.isTablePageOpen());
        int beforeState = tablesPage.countRows();
        tablesPage.clickAddUser();
        Assert.assertTrue(tablesPage.isForamRegistrationOpen());
        tablesPage.inputAllFields(
                userData.getFirstName(),
                userData.getLastName(),
                userData.getAge(),
                userData.getEmail(),
                userData.getSalary(),
                userData.getDepartment()
        );
        tablesPage.clickOnSubmit();
        int interState = tablesPage.countRows();
        logger.info("Форма регистрации закрыта...");
        Assert.assertNotEquals(interState, beforeState);
        logger.info("В таблице появились данные пользователя...");
        tablesPage.getElements();
        Assert.assertEquals(userData.getFirstName(),
                tablesPage.textInFileds.get(0));
        Assert.assertEquals(userData.getLastName(),
                tablesPage.textInFileds.get(1));
        Assert.assertEquals(userData.getAge(),
                tablesPage.textInFileds.get(2));
        Assert.assertEquals(userData.getEmail(),
                tablesPage.textInFileds.get(3));
        Assert.assertEquals(userData.getSalary(),
                tablesPage.textInFileds.get(4));
        Assert.assertEquals(userData.getDepartment(),
                tablesPage.textInFileds.get(5));
        logger.info("Введеные данные соответствуют данным в таблице...");
        tablesPage.clickDeleteUser();
        int afterState = tablesPage.countRows();
        Assert.assertEquals(afterState, beforeState);
        logger.info("Количество записей в таблице изменилось...");
        logger.info("Добавленный пользователь удалился из таблицы...");
    }
}
