package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://trello.com/");
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
