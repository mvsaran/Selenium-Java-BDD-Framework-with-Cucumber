package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(
		
		features = ".//Features/CartCheckout.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome =true,
		plugin = {"pretty", "html:test-output/cucumber-reports.html", "json:target/cucumber.json"}


)

public class TestRun {

}
