package project.day20.homework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"project"},
        features = {
                "src/test/resources/features/myApi.feature"
        },
        strict = true
)

public class CucumberRunner {

}
