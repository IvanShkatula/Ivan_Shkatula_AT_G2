package project.pages.booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;
import project.objects.booking.bookingObject;

import java.util.List;

public class ResultPage {

    private final Logger LOGGER = Logger.getLogger(ResultPage.class.getName());

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement webElement;
    bookingObject page = new bookingObject(driver);

    public void filterByHighestPrice() {
        page.filterByHighestPrice();
        LOGGER.debug("page was filtered by the highest price");
    }

    public void waitSpinnerPass() {
        String spinnerXpath = "//div[@class='bui-spinner bui-spinner--size-large']";
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(spinnerXpath))));

        LOGGER.debug("spinner with xpath" + spinnerXpath + " passed");
    }

    public String maxPriceInFilter() {
        String filterPrice = page.maxPriceInFilter();
        LOGGER.debug("price in filter is " + filterPrice);
        return filterPrice;
    }

    public String hotelMaxPrice() {
        String hotelPrice = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-price-display__value prco-inline-block-maker-helper ']/following-sibling::span")).getText();
        LOGGER.debug("hotel price is " + hotelPrice);
        return hotelPrice;
    }

    public void sortLowPriceFirst() {
        driver.findElement(By.xpath("//li[@data-id='price']")).click();
        LOGGER.debug("filter 'Low Price First' was enabled");
    }

    public void sortHighestRating() {
        String sortHighestRatingXpath= "//li[@data-id='class']";
        driver.findElement(By.xpath(sortHighestRatingXpath)).click();
        LOGGER.debug("sorted by highest rating using xpath " + sortHighestRatingXpath);
    }

    public WebElement chooseRaw(int lineNumber) {
        String xpathOfLineNumber = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        return webElement = driver.findElement(By.xpath(xpathOfLineNumber));
    }

    public void scrollToRequiredLine(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public String getBackgroundColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("backgroundColor");
        return color;
    }

    public void setBackgroundColorOfRequiredLine(String color, WebElement webElement) {
        String argument = String.format("arguments[0].style.backgroundColor = '%s'", color);
        ((JavascriptExecutor) driver).executeScript(argument, webElement);
    }

    public String getHeaderColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("color");
        return color;
    }

    public void setHeaderColorOfRequiredLine(String color, WebElement webElement) {
        String argument = String.format("arguments[0].style.color = '%s'", color);
        ((JavascriptExecutor) driver).executeScript(argument, webElement);
    }

    public double getHotelRatingByLineNumber(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]//div[@class='bui-review-score__badge']", lineNumber);
        String ratingOfHotel = driver.findElement(By.xpath(argument)).getText();
        return Double.parseDouble(ratingOfHotel);
    }

    public boolean isColorEqualsExpectedColor(String color, String expectedColor) {
        return color.equalsIgnoreCase(expectedColor);
    }

    public boolean isHotelsPresented() {
        return driver.findElements(By.xpath("//div[@id='hotellist_inner']")).size() > 0;
    }


}
