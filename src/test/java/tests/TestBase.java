package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
