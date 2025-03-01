package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public TodoSearchBox todoSearchBox;
	public LinkTitlePage linkTitlePage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public TodoSearchBox getTodoSearchBox() {
		
		todoSearchBox = new TodoSearchBox(driver);
		return todoSearchBox;
	}
	
	public LinkTitlePage LinkTitlePage() {

		linkTitlePage = new LinkTitlePage(driver);
		return linkTitlePage;
	}
}
