package day16HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemoqaChooseAnyValue extends WebDriverSettings {


    @Test
    public void chooseValuesFromDropdowns() {
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.xpath("//select[@id='oldSelectMenu']")).click();
        webElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(webElement);
        select.selectByValue("1");
        String colorsText = select.getFirstSelectedOption().getText();
        webElement = driver.findElement(By.id("cars"));
        select = new Select(webElement);
        select.selectByValue("saab");
        String carsText = select.getFirstSelectedOption().getText();
        Assert.assertTrue(colorsText.equalsIgnoreCase("blue") && carsText.equalsIgnoreCase("saab"));
    }
}
