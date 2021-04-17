package day16HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestBookingToolTips extends WebDriverSettings {

    @Test
    public void testsWithToolTipsCurrency() {
        driver.get("https://www.booking.com");
        webElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your currency']"));
        make.moveToElement(webElement);
        make.perform();
        String currencyText = driver.findElement(By.xpath("//div[@class='bui-tooltip__content']")).getText();
        Assert.assertEquals("Choose your currency", currencyText);
    }

    @Test
    public void testsWithToolTipsLanguage() {
        driver.get("https://www.booking.com");
        webElement = driver.findElement(By.xpath("//button[@data-modal-aria-label='Select your language']"));
        make.moveToElement(webElement);
        make.perform();
        String currencyText = driver.findElement(By.xpath("//div[@class='bui-tooltip__content']")).getText();
        Assert.assertEquals("Choose your language", currencyText);
    }

}
