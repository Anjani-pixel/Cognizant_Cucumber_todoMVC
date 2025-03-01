package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.TodoSearchBox;
import utils.TestContextSetup;

public class VerifyTitleStepDefinition {
	
	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public TodoSearchBox todoSearchBox;

	public VerifyTitleStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Given("user is in todo application page")
	public void user_is_in_todo_application_page() {
	    
	}
	@When("user click on the one of the hyperlink")
	public void user_click_on_the_one_of_the_hyperlink() {
		
		//Click on hyperlink
	    testContextSetup.pageObjectManager.LinkTitlePage().clickLink1();;
	}
	@Then("user should verify the page title")
	public void user_should_verify_the_page_title() {
		
		// Get the current page title
        String pageTitle = testContextSetup.pageObjectManager.LinkTitlePage().getLinkTitle();
        
        // Verify that the page title matches the expected title
        String expectedTitle = "Quick Start – React";
        Assert.assertEquals(expectedTitle, pageTitle);
	}

}
