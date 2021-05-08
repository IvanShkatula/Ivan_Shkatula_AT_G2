//package project.steps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.apache.log4j.Logger;
//import project.driver.Config;
//import project.driver.Driver;
//
//public class CucumberBaseSteps {
//
//    private static final Logger LOGGER = Logger.getLogger(CucumberBaseSteps.class.getName());
//
//    @Before
//    public void initDriver() {
//        Driver.setConfig(Config.CHROME);
//        LOGGER.info("Test has been started");
//    }
//
//    @After
//    public void closeDriver() {
//        Driver.destroy();
//        LOGGER.info("Test has been finished");
//    }
//
//}

