package project.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestGoogleSearchTutorial extends WebDriverSettings{

    @Test
    public void actionsTest() {
        driver.get("https://www.w3schools.com/java");
        webElement = driver.findElement(By.xpath("//*[@id='leftmenuinnerinner']/h2[1]"));
        make.doubleClick(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).click();
        make.keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='g']"));
        list.forEach(webElement -> webElement.findElement(By.xpath("//em")).getText());

        Assert.assertTrue(list.stream()
                .allMatch(webElement -> webElement
                        .findElement(By.xpath("//em"))
                        .getText().equalsIgnoreCase("tutorial")));
    }
}
