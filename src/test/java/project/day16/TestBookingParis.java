package project.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBookingParis extends WebDriverSettings {
    @Test
    public void priceTest() throws InterruptedException {
//        Calendar startDateCalendar = Calendar.getInstance();
//        Calendar endDateCalendar = Calendar.getInstance();
//        startDateCalendar.add(Calendar.DATE, 1);
//        endDateCalendar.add(Calendar.DATE,8);
//        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(startDateCalendar.getTime());
//        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(endDateCalendar.getTime());
//        long differenceMilliseconds = endDateCalendar.getTimeInMillis() - startDateCalendar.getTimeInMillis();
//        int differenceDays = (int) (differenceMilliseconds / (24 * 60 * 60 * 1000));


        //driver.get("https://www.booking.com");
       // driver.findElement(By.id("#ss"))
    //            .sendKeys("париж");
       // driver.findElement(By.xpath("//div[@data-calendar2-title='Check-in']"))
      //          .click();
       // driver.findElement(By.xpath("//td[@data-date='" + startDate + "']"))
      //          .click();
        //driver.findElement(By.xpath("//td[@data-date='" + endDate + "']"))
      //          .click();
        //driver.findElement(By.id("#xp__guests__toggle"))
      //          .click();
//        driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']/span"))
    //    .click();
//        driver.findElement(By.xpath("//button[@aria-label='Increase number of Adults']/span"))
    //    .click();
      //  driver.findElement(By.cssSelector("#ss"))
    //            .submit();
       // driver.findElement(By.xpath("//a[@data-id = 'pri-5']"))
   //             .click();
        Thread.sleep(3000);

        String priceString = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@class='bui-price-display__value prco-inline-block-maker-helper ']/following-sibling::span")).getText();
//        String numberOnly = priceString.replaceAll("[^0-9]", "");
//        int priceInt = Integer.parseInt(numberOnly);
//        System.out.println(priceInt);

        String minMaxPrice = driver.findElement(By.xpath("//*[@id='filter_price']/div[3]/a[5]/label/div/span")).getText();
//        String numberOnlyMinMax = minMaxPrice.replaceAll("[^0-9]", "");
//        int minMaxPriceInt = Integer.parseInt(numberOnlyMinMax);
//        System.out.println(minMaxPriceInt);

//        Assert.assertTrue("expect price per day > " + minMaxPrice +
//                "\n actual price per day is " + priceInt / differenceDays,
//                minMaxPriceInt < priceInt / differenceDays);

    }
}
