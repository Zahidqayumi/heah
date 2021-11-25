package Stepdefinitions;




import core.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class initializer  extends base{
// reason for initializer class is to store before and after hook within same package
	@Before 
	public void Beforehooks(Scenario scenario) {
		logger.info(scenario.getName() + "started");
		scenario.log(scenario.getName() + "started");
		selectbrowser();
		openbrowser();
	}
	@After
	public void afterhooks(Scenario scenario) {
		teardown();
		logger.info(scenario.getName() + " " + scenario.getStatus());
		scenario.log(scenario.getName()+ " " + scenario.getStatus());
	}
}
