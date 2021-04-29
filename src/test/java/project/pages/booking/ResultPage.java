package project.pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.util.List;

public class ResultPage {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement webElement;

    public void filterByHighestPrice() {
        WebElement element=driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        String highestFilterPrice = String.format("//a[@data-id = 'pri-%s']", numberOfPriceFilters);
        driver.findElement(By.xpath(highestFilterPrice)).click();
    }

    public void waitSpinnerPass() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='bui-spinner bui-spinner--size-large']"))));
    }

    public void waitFilterElement() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-id='price']"))));
    }

    public String maxPriceInFilter() {
        WebElement element=driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions filter_selected']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        String highestFilterPrice = String.format("//*[@id='filter_price']/div[3]/a[%s]/label/div/span", numberOfPriceFilters);
        return driver.findElement(By.xpath(highestFilterPrice)).getText();
    }

    public String hotelMaxPrice() {
        return driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-price-display__value prco-inline-block-maker-helper ']/following-sibling::span")).getText();
    }

    public void sortLowPriceFirst() {
        driver.findElement(By.xpath("//li[@data-id='price']")).click();
    }

    public void sortHighestRating() {
        driver.findElement(By.xpath("//li[@data-id='class']")).click();
    }

    public WebElement chooseRaw(int lineNumber) {
        String xpathOfLineNumber = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        return webElement = driver.findElement(By.xpath(xpathOfLineNumber));
    }

    public void scrollToRequiredLine(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public String getBackgroundColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]",lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("backgroundColor");
        return color;
    }

    public void setBackgroundColorOfRequiredLine(String color, WebElement webElement) {
        String argument = String.format("arguments[0].style.backgroundColor = '%s'",color);
        ((JavascriptExecutor) driver).executeScript(argument, webElement);
    }

    public String getHeaderColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]",lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("color");
        return color;
    }

    public void setHeaderColorOfRequiredLine(String color, WebElement webElement) {
        String argument = String.format("arguments[0].style.color = '%s'",color);
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
