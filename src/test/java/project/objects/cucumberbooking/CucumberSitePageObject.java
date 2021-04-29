package project.objects.cucumberbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CucumberSitePageObject {

    WebDriver driver;

    public CucumberSitePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void findCity (String cityName) {
        WebElement city = driver.findElement(By.id("ss"));
        city.clear();
        city.sendKeys(cityName);
    }


}
