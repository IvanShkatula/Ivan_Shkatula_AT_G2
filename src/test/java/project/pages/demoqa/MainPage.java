package project.pages.demoqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import project.driver.Driver;

public class MainPage {

    WebDriver driver = Driver.getWebDriver();
    WebElement webElement;

    public void openMainPage() {
        driver.get("https://demoqa.com/select-menu");

    }

    public String chooseElementOfOldSelectMenu(String valueOfElementToSelect) {
        webElement = driver.findElement(By.id("oldSelectMenu"));
        webElement.click();
        Select select = new Select(webElement);
        select.selectByValue(valueOfElementToSelect);
        String colorsText = select.getFirstSelectedOption().getText();
        return colorsText;
    }


    public String chooseValuesFromCarsDropdown(String valueOfElementToSelect) {
        webElement = driver.findElement(By.id("cars"));
        Select select = new Select(webElement);
        select.selectByValue(valueOfElementToSelect);
        String carsText = select.getFirstSelectedOption().getText();
        return  carsText;
    }
}
