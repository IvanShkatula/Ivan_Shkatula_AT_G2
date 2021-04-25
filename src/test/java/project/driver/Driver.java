package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static Config config;

    private Driver() {}

     public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = DriverManager.getDriver(config);
        }
        return driver;
    }

    public static void setConfig(Config config) {
        Driver.config = config;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    public static void destroy() {
        driver.quit();
        Driver.driver = null;
    }
}
