package project.pages.booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;
import project.objects.booking.bookingObject;

import java.util.ArrayList;
import java.util.List;

public class CarRentalsPage {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    bookingObject page = new bookingObject(driver);
    private final Logger LOGGER = Logger.getLogger(CarRentalsPage.class.getName());

    public void pickupLocation(String cityName) {
        LOGGER.debug("name of the transferred city is " + cityName);
        page.pickupLocation(cityName);
    }

    public void chooseTarget() {
        String xpath = "//li[@data-i='0']";
        LOGGER.debug("target xpath is " + xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getSearchLocation() {
        return page.getSearchLocation();
    }

    public boolean ifResultContainsSearch(String searchValue) {
        return page.ifResultListContainsSearch(searchValue);
    }

    public void showAllResults() {
        driver.findElement(By.xpath("//a[contains(text(), 'Show all results')]")).click();
    }

    public void setStartCarUsingDate() {
        page.setStartCarUsingDate();
    }

    public void setEndCarUsingDate() {
        page.setEndCarUsingDate();
    }
}
