package project.steps.jotform;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

public class CreateFormPage {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    private final String FORM_NAME_XPATH = "//div[@placeholder='Type a header']";

    @And("I'm waiting for the page to load")
    public void waitCreateFolderElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-new-folder")));
    }

    @And("I choose 'Start From Scratch'")
    public void chooseStartFromScratch() {
        driver.findElement(By.xpath("//div[@class='jfWizard-list']/div[1]")).click();
    }

    @And("I choose 'Classic Form'")
    public void chooseClassicForm() {
        driver.findElement(By.xpath("//div[@class='jfWizard-list']/div[1]")).click();
    }

    @And("I open list of elements")
    public void openListOfElements() {
        driver.findElement(By.xpath("//span[@name='plusNormal']")).click();
    }
    @And("I wait 'add header element'")
    public void waitHeaderElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='plusNormal']")));
    }

    @And("I add Header element")
    public void addHeaderToForm() {
        driver.findElement(By.xpath("//div[text() = 'Header']")).click();
    }

    @And("I set {string} header name")
    public void setHeaderName(String headerName) {
        driver.findElement(By.xpath("//*[@id='header_3']//div[@placeholder='Type a header']")).sendKeys(headerName);
    }

    @And("I set {string} form name")
    public void setFormName(String formName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORM_NAME_XPATH)));
        driver.findElement(By.xpath(FORM_NAME_XPATH)).clear();
        driver.findElement(By.xpath(FORM_NAME_XPATH)).sendKeys(formName);
    }
    @And("I add Full name element")
    public void addFullName() {
        driver.findElement(By.id("field_item_control_fullname")).click();
    }

    @And("I save new form")
    public void saveForm() {
        driver.findElement(By.xpath("//span[@class='formFooter-button']")).click();
    }

    @And("I choose 'Card Form'")
    public void chooseCardForm() {
        driver.findElement(By.xpath("//div[@class='jfWizard-list']/div[2]")).click();
    }


}
