package project.pages.bookingPages;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;


public class StartPage {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void openStartPage() {
        driver.get("https://www.booking.com");
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

    public void login(String emailAddress, String password) {
        driver.findElement(By.xpath("//*[@id='b2indexPage']/header/nav[1]/div[2]/div[6]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.cssSelector("form"))));
        driver.findElement(By.id("username")).sendKeys(emailAddress);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.id("new_password"))));
        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("new_password")).submit();
    }

    public void searchDestinationInput(String cityName) {
        driver.findElement(By.id("ss")).sendKeys(cityName);
    }

    public void dateFieldSelect() {
        driver.findElement(By.xpath("//div[@data-calendar2-title='Check-in']")).click();
    }

    public void guestsInput() {
        driver.findElement(By.id("xp__guests__toggle")).click();
    }

    public void increaseNumberOfAdults() {
        driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']/span")).click();
    }

    public void setDate(String date) {
        String xpath = String.format("//td[@data-date='%s']", date);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void submit() {
        driver.findElement(By.cssSelector("#ss")).submit();
    }

}
