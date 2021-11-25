package Stepdefinitions;

import org.junit.Assert;

import core.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HotalHomePageObject;




public class stepdefinitions extends base {

	HotalHomePageObject hotelHomepage = new HotalHomePageObject();
	//each step in scenario should have 
		//one java method associated with that step 
		//we can't have duplicate method for steps in scenario steps
		@Given("^user is on Retail website$")
		public void user_name_is_on_Retail_website() {
		String actualpagetitle = driver.getTitle(); 
			String expectedpagetitle = "TEK SCHOOL";
			Assert.assertEquals(expectedpagetitle, actualpagetitle);
			logger.info("actual title is matching with expected title");
			
		}

}
