package project.steps.booking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.util.List;

public class ResultPageSteps {

    private static final Logger LOGGER = Logger.getLogger(ResultPageSteps.class.getName());
    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement webElement;

    @And("I filter by highest price")
    public void filterByHighestPrice() {
        WebElement element = driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        LOGGER.debug("the size of Price filter is " + numberOfPriceFilters);
        String highestFilterPrice = String.format("//a[@data-id = 'pri-%s']", numberOfPriceFilters);
        LOGGER.debug("xpath for the highest price filter is" + highestFilterPrice);
        driver.findElement(By.xpath(highestFilterPrice)).click();
    }

    @And("I wait until spinner pass")
    public void waitSpinnerPass() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='bui-spinner bui-spinner--size-large']"))));
        LOGGER.debug("spinner pass");
    }

    public void waitFilterElement() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-id='price']"))));
    }

    public String maxPriceInFilter() {
        WebElement element = driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions filter_selected']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        String highestFilterPrice = String.format("//*[@id='filter_price']/div[3]/a[%s]/label/div/span", numberOfPriceFilters);
        return driver.findElement(By.xpath(highestFilterPrice)).getText();
    }

    public String hotelMaxPrice() {
        return driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-price-display__value prco-inline-block-maker-helper ']/following-sibling::span")).getText();
    }

    @And("I sort low price first")
    public void sortLowPriceFirst() {
        driver.findElement(By.xpath("//li[@data-id='price']")).click();
        LOGGER.debug("sort 'low price first' is enable");
    }

    public void sortHighestRating() {
        driver.findElement(By.xpath("//li[@data-id='class']")).click();
    }

    public WebElement chooseRaw(int lineNumber) {
        LOGGER.debug("raw №" + lineNumber + " was chosen");
        String xpathOfLineNumber = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        LOGGER.debug("xpath of chosen raw is " + xpathOfLineNumber);
        return webElement = driver.findElement(By.xpath(xpathOfLineNumber));
    }

    @And("I scroll to {int}th hotel")
    public void scrollToRequiredLine(int lineNumber) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chooseRaw(lineNumber));
        LOGGER.debug("scrolled to hotel №" + lineNumber);
    }

    public String getBackgroundColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("backgroundColor");
        return color;
    }

    @And("I change background color to {string} to hotel number {int}")
    public void setBackgroundColorOfRequiredLine(String color, int lineNumber) {
        String argument = String.format("arguments[0].style.backgroundColor = '%s'", color);
        ((JavascriptExecutor) driver).executeScript(argument, chooseRaw(lineNumber));
        LOGGER.debug("new background color set to" + color + " in line number " + lineNumber);
    }

    public String getHeaderColorOfRequiredLine(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        String color = driver.findElement(By.xpath(argument)).getCssValue("color");
        return color;
    }

    @And("I change header color to {string} to hotel number {int}")
    public void setHeaderColorOfRequiredLine(String color, int lineNumber) {
        String argument = String.format("arguments[0].style.color = '%s'", color);
        ((JavascriptExecutor) driver).executeScript(argument, chooseRaw(lineNumber));
        LOGGER.debug("new background color set to" + color + " in line number " + lineNumber);
    }

    public double getHotelRatingByLineNumber(int lineNumber) {
        String argument = String.format("//div[@id='hotellist_inner']/div[%s]//div[@class='bui-review-score__badge']", lineNumber);
        String ratingOfHotel = driver.findElement(By.xpath(argument)).getText();
        return Double.parseDouble(ratingOfHotel);
    }

    public boolean isColorEqualsExpectedColor(String color, String expectedColor) {
        return color.equalsIgnoreCase(expectedColor);
    }

    @Then("I see list of Hotels")
    public boolean isHotelsPresented() {
        int numberOfHotels = driver.findElements(By.xpath("//div[@id='hotellist_inner']")).size();
        LOGGER.debug("number of hotels on the list is " + numberOfHotels);
        return numberOfHotels > 0;
    }

    @Then("I see that header color become red and background color become green in hotel number {int}")
    public void areColorsSame(int lineNumber) {
        String xpath = String.format("//div[@id='hotellist_inner']/div[%s]", lineNumber);
        String backGroundColor = driver.findElement(By.xpath(xpath)).getCssValue("backgroundColor");
        String headerColor = driver.findElement(By.xpath(xpath)).getCssValue("color");
        boolean result = backGroundColor.equalsIgnoreCase("rgba(0, 128, 0, 1)") && headerColor.equalsIgnoreCase("rgba(255, 0, 0, 1)");
        Assert.assertTrue(result);
    }

    @Then("I expect hotel per day price for {int} days will be higher than price in price filter")
    public void comparePrices(int numberOfStayDays) {
        String hotelPrice = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-price-display__value prco-inline-block-maker-helper ']/following-sibling::span")).getText();
        String numberOnly = hotelPrice.replaceAll("[^0-9]", "");
        int hotelPriceInt = Integer.parseInt(numberOnly);
        System.out.println(hotelPriceInt);

        String priceInFilter = driver.findElement(By.xpath("//*[@id='filter_price']/div[3]/a[5]/label/div/span")).getText();
        String numberOnlyFilter = priceInFilter.replaceAll("[^0-9]", "");
        int priceInFilterInt = Integer.parseInt(numberOnlyFilter);
        System.out.println(priceInFilterInt);
        Assert.assertTrue("expect price per day > " + priceInFilter +
                        "\n actual price per day is " + hotelPriceInt / numberOfStayDays,
                priceInFilterInt < hotelPriceInt / numberOfStayDays);
    }


}
