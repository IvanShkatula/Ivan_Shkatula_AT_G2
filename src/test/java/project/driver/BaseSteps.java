package project.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    static WebDriver driver;


    @Before
    public void initDriver() {
        Driver.setConfig(Config.CHROME);
        driver = Driver.getWebDriver();


    }

//    @Before
//    public void initDriver() {
//        Driver.setConfig(Config.valueOf(System.getProperty("BROWSER")));
//        driver = Driver.getWebDriver();
//    }

    @After
    public void closeDriver() {
        Driver.destroy();
    }

}
