package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {
    private Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        driver = DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
        logger.info("Navigate To Page: " + APPLICATION_URL);
    }

//    @AfterMethod
//    public void afterTest(){
//        DriverManager.disposeDriver();
//    }
}
