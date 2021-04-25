package project.pages.bookingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.util.List;

public class PageWithResults {

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

}
