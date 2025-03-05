package pages;

import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class TablesPage extends BasePage{
    AlertsFrameWindowsMenu menu;
    private Button addUser;
    private TextBox firstName;
    private TextBox lastName;
    private TextBox email;
    private TextBox age;
    private TextBox salary;
    private TextBox department;
    private Button submitData;
    private By tableFields = By.xpath("//div[@class='rt-tbody']" +
            "//div[text()]");
    private By tableDataFields = By.xpath("//div[@class='rt-tbody']" +
            "//div[@class='rt-tr-group'][4]//div[@class='rt-td']");
    private Button deleteUeserButton;
    private By webTablesWrapper = By.xpath("//div[@class='web-tables-wrapper']");
    private By formRegistration = By.xpath("//div[@class='modal-content']");
    private ArrayList<WebElement> dataAddUser = new ArrayList<>();
    public ArrayList<String> textInFileds = new ArrayList<>();

    public TablesPage(String pageName) {
        super(pageName);
        menu = new AlertsFrameWindowsMenu("Left menu");
        addUser = new Button(By.id("addNewRecordButton"), "Кнопка add");
        firstName = new TextBox(By.id("firstName"), "Имя пользователя");
        lastName = new TextBox(By.id("lastName"), "Фамилия пользователя");
        email = new TextBox(By.id("userEmail"), "Почта пользователя");
        age = new TextBox(By.id("age"), "Возраст пользователя");
        salary = new TextBox(By.id("salary"), "Зарплата пользователя");
        department = new TextBox(By.id("department"), "Отдел пользователя");
        submitData = new Button(By.id("submit"), "Кнопка submit");
        deleteUeserButton = new Button(By.xpath("//div[@class='rt-tbody']" +
                "//div[@class='rt-tr-group'][4]//span[@id='delete-record-4']"),
                "Кнопка delete");
    }

    public void inputAllFields(String firstNameU, String lastNameU,
                               String ageU, String emailU, String salaryU,
                               String departmentU){
        firstName.enterText(firstNameU);
        lastName.enterText(lastNameU);
        age.enterText(ageU);
        email.enterText(emailU);
        salary.enterText(salaryU);
        department.enterText(departmentU);
    }

    public int countRows(){
        return (driver.findElements(tableFields).size())/7;
    }

    public void getElements() {
        dataAddUser.addAll(driver.findElements(tableDataFields));
        for(WebElement data : dataAddUser) {
            textInFileds.add(data.getText());
        }
    }

    public boolean isForamRegistrationOpen() {
        logger.info("Форма регистрации появилась...");
        return isPageOpen(formRegistration);
    }

    public boolean isTablePageOpen() {
        logger.info("Страница " + pageName + " открыта" );
        return isPageOpen(webTablesWrapper);
    }

    public void clickDeleteUser() {
        deleteUeserButton.clickOnButton();
    }

    public void clickOnSubmit() {
        submitData.clickOnButton();
    }

    public void openTables() {
        menu.clickTablesElem();
    }

    public void clickAddUser(){
        addUser.clickOnButton();
    }
}
