package driver.manager;

import driver.manager.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){
    }

    public static WebDriver  getWebDriver(){
        if (driver == null){
//            System.setProperty("webdriver.chrome.driver", "/home/pawel/Drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
            driver = new ChromeDriver();
            driver = WebDriverEventListenerRegistrar.registerWebDriverEventListener(driver);
        }
        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
