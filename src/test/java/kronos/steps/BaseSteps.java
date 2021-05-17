package kronos.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import kronos.driver.Config;
import kronos.driver.Driver;
import org.openqa.selenium.WebDriver;


public class BaseSteps {

    @Before
    public void initDriver() {
        Driver.setConfig(Config.CHROME);
    }

    @After
    public void closeDriver() {
        Driver.destroy();
    }

}
