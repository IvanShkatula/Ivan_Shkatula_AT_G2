package day16HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestBookingMoskow extends WebDriverSettings {

    @Test
    public void the10thHotelForMoskow() {
        String backgroundColorStandard = "rgba(0, 128, 0, 1)";
        String colorStandard = "rgba(255, 0, 0, 1)";
        driver.get("https://www.booking.com");
        driver.findElement(By.cssSelector("#ss")).sendKeys("москва");
        driver.findElement(By.cssSelector("#ss")).submit();
        webElement = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", webElement);
        String colorBackground = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]")).getCssValue("backgroundColor");
        String color = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]")).getCssValue("color");
        System.out.println(colorBackground);
        System.out.println(color);
        boolean wrightColors = colorBackground.equalsIgnoreCase(backgroundColorStandard) && color.equalsIgnoreCase(colorStandard);
        Assert.assertTrue("Expected background color: " + backgroundColorStandard + ", actual background color is: " + colorBackground +
                ".\n Expected color is: " + colorStandard + ", actual color is: " + color, wrightColors);
    }

    @Test
    public void availabilityOfHotels() {
        driver.get("https://www.booking.com");
        driver.findElement(By.cssSelector("#ss")).sendKeys("москва");
        driver.findElement(By.xpath("//div[@data-calendar2-title='Check-in']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-04-17']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-04-24']")).click();
        driver.findElement(By.cssSelector("#xp__guests__toggle")).click();
        driver.findElement(By.cssSelector("#ss")).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='hotellist_inner']/div")));
        int size = driver.findElements(By.xpath("//div[@id='hotellist_inner']/div")).size();
        Boolean isPresent = driver.findElements(By.xpath("//div[@id='hotellist_inner']")).size() > 0;
        Assert.assertTrue("There are no available hotels", isPresent);
    }

    @Test
    public void ratingOverNine() {
        driver.get("https://www.booking.com");
        driver.findElement(By.cssSelector("#ss")).sendKeys("москва");
        driver.findElement(By.cssSelector("#ss")).submit();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-id='class']")));
        driver.findElement(By.xpath("//li[@data-id='class']")).click();
        webElement = driver.findElement(By.xpath("//div[@class='bui-spinner bui-spinner--size-large']"));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
        String ratingOfHotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-review-score__badge']")).getText();
        double ratingOfHotelDouble = Double.parseDouble(ratingOfHotel);
        Assert.assertTrue("Actual rating of hotel is: " + ratingOfHotelDouble + ". It is less than 9 stars", ratingOfHotelDouble >= 9);
    }

}
