package kronos.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import kronos.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = Driver.getWebDriver();

    @And("I switch to frame")
    public void switchToFrame() {
        driver.switchTo().frame((WebElement) By.id("ss"));
    }

    @And("I open hamburger menu")
    public void openHamburgerMenu() {
        driver.findElement(By.cssSelector("[class=\"icon-Menu\"]")).click();
    }

    @And("I open dropdown in hamburger menu")
    public void openDropdownInHamburgerMenu() {
        driver.findElement(By.cssSelector("[class=\"dropdown_arrow\"]")).click();
    }

    @Then("I get username")
    public void getUsername() {
        String userName = driver.findElement(By.cssSelector("[class=\"dropdown_menu_link not_selectable\"]")).getTagName();
        System.out.println(userName);
    }
}
