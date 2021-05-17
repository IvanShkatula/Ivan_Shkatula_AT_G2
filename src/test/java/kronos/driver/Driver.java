package kronos.driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver;
    private static Config config;

    private Driver() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = DriverManager.getDriver(config);
        }
        return driver;
    }

    public static void setConfig(Config config) {
        Driver.config = config;
    }

    public static void destroy() {
        driver.quit();
        Driver.driver = null;
    }
}
