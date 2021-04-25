package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        switch (config != null ? config : Config.CHROME) {
           case FIRE_FOX -> {
                return getFFDriver();
           }
            case REMOTE -> {
                return getRemoteDriver();
            }
            default -> {
                return getChromeDriver();
           }
        }
    }

    private static WebDriver getRemoteDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");

        try {
                    return new RemoteWebDriver(new URL("http://localhost:9515"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        return null;
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }
    private static WebDriver getFFDriver() {
        return null;
    }
}
