package project.objects.jotform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;

public class JotformObjects {

    WebDriver driver = Driver.getWebDriver();

    public String getHeaderText() {
        String headerName =
        driver.findElement(By.xpath("//ul[@id='formList']//div[@class='form-title']")).getText();
        System.out.println(headerName);
        return headerName;
    }

}
