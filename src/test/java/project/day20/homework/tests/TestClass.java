package project.day20.homework.tests;


import org.junit.Test;
import project.day20.homework.steps.JUnitSteps;

import java.io.IOException;
import java.net.URISyntaxException;

public class TestClass {

    JUnitSteps jUnitSteps = new JUnitSteps();

    @Test
    public void searchByNotFullUsername() {
        try {
            jUnitSteps.sendRequest("bert", false);
            jUnitSteps.getResponse();
            jUnitSteps.getUser(1);
            jUnitSteps.compareAccounts();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByFullUsername() {
        try {
            jUnitSteps.sendRequest("berta", true);
            jUnitSteps.getResponse();
            jUnitSteps.getUser(1);
            jUnitSteps.compareAccounts();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

}