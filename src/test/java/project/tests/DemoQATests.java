package project.tests;

import org.junit.Assert;
import org.junit.Test;
import project.pages.demoqa.MainPage;

public class DemoQATests {

    MainPage mainPage = new MainPage();

    @Test
    public void chooseValuesFromOldSelectMenuDropdowns() {
        mainPage.openMainPage();
        Assert.assertEquals(mainPage.chooseElementOfOldSelectMenu("1"),"Blue");
    }

    @Test
    public void chooseValuesFromCarsMenuDropdowns() {
        mainPage.openMainPage();
        Assert.assertEquals(mainPage.chooseValuesFromCarsDropdown("saab"),"Saab");
    }

}
