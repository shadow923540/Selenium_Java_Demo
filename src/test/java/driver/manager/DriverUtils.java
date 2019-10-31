package driver.manager;

import io.qameta.allure.Step;

public class DriverUtils {

    @Step("Maximizing browser window")
    public static void setInitialConfiguration(){

        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigate to : {pageUrl}")
    public static void navigateToPage(String pageUrl){
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }

}