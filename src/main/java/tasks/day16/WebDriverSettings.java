package day16HomeWork;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    ChromeDriver driver;
    WebElement webElement;
    Actions make;
    WebDriverWait wait;
     @Before
    public void setUp() {
        driver = new ChromeDriver();
        make = new Actions(driver);
        wait = new WebDriverWait(driver, 20);
    }
    @After
    public void close() {
        driver.quit();
    }

    public void setTimeouts(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

}
