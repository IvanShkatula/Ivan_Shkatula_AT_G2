package project.pages.workWithMails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

public class MailRu {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement webElement;


    public void confirmRegistration(String email){
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("//button[@class='ph-login svelte-h2te2i']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://account.mail.ru/login/?mode=simple&v=2.8.0&account_host=account.mail.ru&type=login&allow_external=1&app_id_mytracker=52848&success_redirect=https%3A%2F%2Fe.mail.ru%2Fmessages%2Finbox%3Fback%3D1&from=navi&parent_url=https%3A%2F%2Fmail.ru%2F']")));
        webElement = driver.findElement(By.xpath("//input[@name='username']"));
        webElement.sendKeys("ivan.sh.test@mail.ru");
        webElement.submit();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("QWEpoi123098!");
        driver.findElement(By.xpath("//input[@name='password']")).submit();

        driver.findElement(By.xpath("//span[contains(@title, '"+ email +"')]/..")).click();
        driver.findElement(By.xpath("//a[@class='button-link_mr_css_attr']")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.id("username"))));
//        driver.findElement(By.id("username")).sendKeys(registrationEmail);
//        driver.findElement(By.id("username")).submit();
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.id("new_password"))));
//        driver.findElement(By.id("new_password")).sendKeys("Password1!");
    }

}
