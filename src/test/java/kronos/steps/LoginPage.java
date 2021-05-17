package kronos.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import kronos.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver = Driver.getWebDriver();
    //WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @Given("I open {string} server with {string} SP company")
    public void openLoginPage(String serverName, String companyName) {
        String url = String.format("https://%s.int.kronos.com/ta/%s.login", serverName, companyName);
        driver.get(url);
    }

    @When("I enter {string} username and {string} password")
    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys("SSOUser");
        driver.findElement(By.id("password")).sendKeys("Password1!");
    }

    @And("I click OK button")
    public  void clickLoginButton() {
        driver.findElement(By.cssSelector("[class=\"btn btn-block btn-submit\"]")).click();
    }





}
