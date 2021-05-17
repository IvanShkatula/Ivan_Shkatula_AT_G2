package kronos.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"kronos"},
        features = {"src/test/resources/talisker.feature"},
        strict = true
)

public class CucumberRunner {

}
