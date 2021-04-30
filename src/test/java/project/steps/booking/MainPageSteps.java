package project.steps.booking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;
import project.objects.booking.bookingObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainPageSteps {

    private static final Logger LOGGER = Logger.getLogger(MainPageSteps.class.getName());
    private final String TOOLTIP_XPATH = "//div[@class='bui-tooltip__content']";

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement webElement;
    Actions actions = new Actions(driver);
    bookingObject page = new bookingObject(driver);

    @Given("I open a site")
    public void openMainPage() {
        String url = "https://www.booking.com";
        driver.get(url);
        LOGGER.debug("Opening url" + url);
    }

    @When("I type {string} as name of the city")
    public void typeCity(String theCity) {
        LOGGER.debug("typed city is " + theCity);
        page.findCity(theCity);
    }

    @And("I open calendar")
    public void dateFieldSelect() {
        driver.findElement(By.xpath("//div[@data-calendar2-title='Check-in']")).click();
    }

    @And("I open dropdown to add guests")
    public void guestsInput() {
        driver.findElement(By.id("xp__guests__toggle")).click();
    }

    @And("I add adult guest")
    public void increaseNumberOfAdults() {

        driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']/span")).click();
    }

    @And("I choose date which is {int} days later than the current date")
    public void setDate(int increaseByNumberOfDays) {
        Calendar calendarDate = Calendar.getInstance();
        LOGGER.debug("current date is" + calendarDate);
        calendarDate.add(Calendar.DATE, increaseByNumberOfDays);
        LOGGER.debug("new date is later than current on " + increaseByNumberOfDays + " days");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(calendarDate.getTime());
        String xpath = String.format("//td[@data-date='%s']", date);
        driver.findElement(By.xpath(xpath)).click();
        LOGGER.debug("new date set by xpath " + xpath);
    }

    public void hoverOnCurrencyTooltip() {
        webElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your currency']"));
        actions.moveToElement(webElement);
        actions.perform();
    }

    public String getTextOfToolTip() {
        String tooltipText = driver.findElement(By.xpath(TOOLTIP_XPATH)).getText();
        LOGGER.debug("chosen tooltip is " + tooltipText);
        return tooltipText;
    }

    public void hoverOnLanguageTooltip() {
        webElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your language']"));
        actions.moveToElement(webElement);
        actions.perform();
    }

    @And("I tap enter button")
    public void submit() {
        driver.findElement(By.cssSelector("#ss")).submit();
    }

    public void login(String emailAddress, String password) {
        driver.findElement(By.xpath("//*[@id='b2indexPage']/header/nav[1]/div[2]/div[6]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.cssSelector("form"))));
        driver.findElement(By.id("username")).sendKeys(emailAddress);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.id("new_password"))));
        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("new_password")).submit();
    }

    public void registration(String emailAddress) {
        driver.findElement(By.xpath("//*[@id='b2indexPage']/header/nav[1]/div[2]/div[5]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.cssSelector("form"))));
        driver.findElement(By.id("username")).sendKeys(emailAddress);
        driver.findElement(By.id("username")).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.id("new_password"))));
        driver.findElement(By.id("new_password")).sendKeys("Password1!");
        driver.findElement(By.id("confirmed_password")).sendKeys("Password1!");
        driver.findElement(By.id("confirmed_password")).submit();
    }
}
