package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){
    }

    public static WebDriver  getWebDriver(){
        if (driver == null){
            System.setProperty("webdriver.gecko.driver", "C:/DRIVERS/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver = null;
    }
}
