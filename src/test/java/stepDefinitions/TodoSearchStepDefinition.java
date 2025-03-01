package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.TodoSearchBox;
import utils.TestContextSetup;

public class TodoSearchStepDefinition {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public String extractName;
	public TodoSearchBox todoSearchBox;

	public TodoSearchStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on todos application page")
	public void user_is_on_todos_application_page() {

	}

	@When("the user adds the following todo items:")
	public void the_user_adds_the_following_todo_items(DataTable dataTable) throws Exception {

		// Convert the DataTable to a list of Todo items
		List<String> todoItems = dataTable.asList(String.class);

		// Iterate through the list of Todo items and add them
		for (String todoItem : todoItems) {
			if (todoItem == null || todoItem.trim().isEmpty()) {
				System.out.println("Skipping empty or null Todo item");
				continue; // Skip empty or invalid todo items
			}

			// Set the search term in the search box
			testContextSetup.pageObjectManager.getTodoSearchBox().setSearch(todoItem);

			// Click the search button 
			testContextSetup.genericUtils.clkSearchBtn();

			Thread.sleep(2000);

		}

	}

	@Then("the new todo items should appear in the todo list")
	public void user_should_see_in_todos_list() {

		// Expected list of todo items
		List<String> expectedTodos = List.of("Learn Cucumber", "Learn Java", "Learn Jenkins");

		// Retrieve the list of todo items from the page 
		List<String> actualTodos = testContextSetup.pageObjectManager.getTodoSearchBox().getTodoList(); 
																									

		// Check if the actual list matches the expected list
		Assert.assertEquals(expectedTodos, actualTodos);
	}

	@Then("It should be moved to the completed todo section when select the todo item")
	public void select_the_todo_item_once_completed_the_task_and_it_should_be_moved_to_the_completed_todo_section() throws Exception {

		Thread.sleep(2000);

		// Click the radio button for the first todo item
		testContextSetup.pageObjectManager.getTodoSearchBox().clickRadioBtn();

		Thread.sleep(2000);

		// Click the "Completed" link
		testContextSetup.pageObjectManager.getTodoSearchBox().clickCompleted();

		Thread.sleep(4000);

		// Click the "Clear Completed" button

		testContextSetup.pageObjectManager.getTodoSearchBox().clickClearCompleted();
	}
	
	@Then("Delete the active todo item from the todo list when user verified the active todo list")
	public void user_verified_the_active_todo_list() {
	    
		// Verify the active todo list
		testContextSetup.pageObjectManager.getTodoSearchBox().clickActive();
		
		
		// delete the todo item
		testContextSetup.pageObjectManager.getTodoSearchBox().clickDelete();
		
		Assert.assertEquals(testContextSetup.pageObjectManager.getTodoSearchBox().getDisplayTxt(), "1 item left!");
		
	}
}
