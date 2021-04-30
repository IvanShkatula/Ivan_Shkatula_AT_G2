package project.objects.booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;
import project.pages.booking.MainPage;

import java.util.ArrayList;
import java.util.List;


public class bookingObject {

    private static final Logger LOGGER = Logger.getLogger(bookingObject.class.getName());
    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);


    public bookingObject(WebDriver driver) {
        this.driver = driver;
    }

    public void findCity(String cityName) {
        String xpathSearshField = "ss";
        WebElement city = driver.findElement(By.id(xpathSearshField));
        LOGGER.trace("xpath of search field is " + xpathSearshField);
        city.clear();
        LOGGER.trace("cleared search field");
        city.sendKeys(cityName);
        LOGGER.trace("send city name " + cityName);
    }

    public void pickupLocation(String cityName) {
        String xpathSearshField = "ss_origin";
        WebElement city = driver.findElement(By.id("xpathSearshField"));
        LOGGER.trace("xpath of search field is " + xpathSearshField);
        city.clear();
        LOGGER.trace("cleared search field");
        city.sendKeys(cityName);
        LOGGER.trace("send city name " + cityName);
    }

    public void login(String emailAddress, String password) {
        String registerButton = "//*[@id='b2indexPage']/header/nav[1]/div[2]/div[6]/a";
        LOGGER.trace("xpath of register button is " + registerButton);
        driver.findElement(By.xpath(registerButton)).click();
        LOGGER.trace("click register button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
        LOGGER.trace("wait until 'form' element would be available");
        driver.findElement(By.id("username")).sendKeys(emailAddress);
        LOGGER.trace("enter " + emailAddress + " email address to username field");
        driver.findElement(By.id("username")).submit();
        LOGGER.trace("submit");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        LOGGER.trace("waited until password field appears");
        driver.findElement(By.id("password")).sendKeys(password);
        LOGGER.trace("enter " + password + " password to password field");
        driver.findElement(By.id("password")).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ss")));
        LOGGER.trace("main page is upload");
    }

    public boolean ifResultListContainsSearch(String value) {
        boolean isContains = true;
        List<WebElement> list = driver.findElements(By.xpath("//p[@class='bui-text bui-f-font-strong bui-f-color-black']"));
        List<String> stringsList = new ArrayList<>();
        for (WebElement webElement : list) {
            stringsList.add(webElement.getText());
        }
        for (String st : stringsList) {
            isContains = st.equalsIgnoreCase(value);
            if (!isContains) {
                return isContains;
            }
        }
        return isContains;
    }

    public String getSearchLocation() {
        String xpath = "//li[@data-i='0']//span[@class='search_hl_name']";
        LOGGER.trace("xpath of search location is " + xpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String searchLocationText = driver.findElement(By.xpath(xpath)).getText();
        LOGGER.trace("text of Search location is " + searchLocationText);
        return searchLocationText;
    }

    public void setStartCarUsingDate() {
        String xpath = "//*[@id='frm']/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/table/tbody/tr[2]/td[3]";
        driver.findElement(By.xpath(xpath)).click();
        LOGGER.trace("input start day of use car");
    }

    public void setEndCarUsingDate() {
        String xpath = "//*[@id='frm']/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[3]/table/tbody/tr[2]/td[6]";
        driver.findElement(By.xpath(xpath)).click();
        LOGGER.trace("input end day of use car");
    }

    public void filterByHighestPrice() {
        WebElement element=driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        String highestFilterPrice = String.format("//a[@data-id = 'pri-%s']", numberOfPriceFilters);
        driver.findElement(By.xpath(highestFilterPrice)).click();
    }

    public String maxPriceInFilter() {
        WebElement element = driver.findElement(By.xpath("//div[@id='filter_price']/div[@class='filteroptions filter_selected']"));
        List<WebElement> listOfPriceFilters = element.findElements(By.tagName("a"));
        int numberOfPriceFilters = listOfPriceFilters.size();
        String highestFilterPrice = String.format("//*[@id='filter_price']/div[3]/a[%s]/label/div/span", numberOfPriceFilters);
        return driver.findElement(By.xpath(highestFilterPrice)).getText();
    }
}
