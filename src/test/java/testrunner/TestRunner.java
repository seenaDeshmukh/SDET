package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue={"stepdefination"},
		monochrome=true,
		dryRun=false,
		tags="@All",
		plugin={"pretty"}
	
		)
public class TestRunner {

}
