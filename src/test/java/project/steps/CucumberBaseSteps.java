package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import project.driver.Config;
import project.driver.Driver;


public class CucumberBaseSteps {
    @Before
    public void initDriver() {
        Driver.setConfig(Config.CHROME);
    }

    @After
    public void closeDriver() {
        Driver.destroy();
    }

}

