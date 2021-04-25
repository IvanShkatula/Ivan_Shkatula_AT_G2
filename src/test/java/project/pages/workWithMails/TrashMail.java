package project.pages.workWithMails;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

public class TrashMail {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement webElement;

    public String registerMailOnTrashmail() {
        driver.get("https://trashmail.com/");
        driver.findElement(By.id("fe-forward")).sendKeys("ivan.sh.test@mail.ru");
        driver.findElement(By.xpath("//*[@id='tab-quick']/form/div[3]/div/button")).click();
        webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='5']/..")));
        webElement.click();
        driver.findElement(By.id("fe-submit")).click();
        String mailName = driver.findElement(By.id("fe-dea")).getAttribute("value");
        System.out.println(mailName);
        return mailName;
    }



}
