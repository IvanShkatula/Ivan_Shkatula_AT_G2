package day16HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemoqaChooseAnyValue extends WebDriverSettings {



    @Test
    public void chooseValuesFromDropdowns() {
        driver.get("https://demoqa.com/select-menu");
       driver.findElement(By.xpath("//div[@class='accordion']/div[1]")).click();
       webElement = driver.findElement(By.id("react-select-2-input"));
       Select select = new Select(webElement);
       select.selectByValue("Mouse");

    }
}
