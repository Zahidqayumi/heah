package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import Utilities.cucumberReporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//you create testrunner class after you fill out the base class
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "\\src\\test\\resources",
		glue = "stepDefinitions",
		tags = "@Test",
		dryRun = false,
		monochrome = true,
		strict = true,
		plugin = {"pretty",
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json"	},
		publish = true

		)
public class testrunner {
@AfterClass
 
public static void generateReport() {
	cucumberReporting.reportConfig();
}

}
