package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TodoSearchBox {
	
	private WebDriver driver;
	
	public TodoSearchBox(WebDriver driver) {
		
		this.driver = driver; //initialize the driver
	}
	
	By txtSearch = By.xpath("//input[@class='new-todo']");
	By txtname = By.xpath("//label[@data-testid='todo-item-label']");
	By todoList = By.xpath("//*[@class='todo-list']/*/div/label");
	By clkRadiobtn = By.xpath("//main[@class='main']/ul/li/div/input[@type='checkbox']");
	By displayTxt = By.xpath("//span[@class='todo-count']");
	By clkDelete = By.xpath("//div[@class='view']/button[@class='destroy']");
	By clkAll = By.xpath("//ul[@class='filters'] /li/a[text()='All']");
	By clkActive = By.xpath("//a[text()='Active']");
	By clkCompleted = By.xpath("//a[text()='Completed']");
	By clkclearCompleted = By.xpath("//button[text()='Clear completed']");
	By radioBtns = By.xpath("//ul[@class='todo-list']/li");
	
	public void setSearch(String todoName) {
	    
		WebElement SearchBox = driver.findElement(txtSearch);
		SearchBox.sendKeys(todoName);
	}
	
	public String getSearchName() {
		return driver.findElement(txtname).getText();
	}
	public List<String> getTodoList() {
		return driver.findElements(todoList).stream().map(WebElement::getText).collect(java.util.stream.Collectors.toList());
	}
	
	public String getDisplayTxt() {
		return driver.findElement(displayTxt).getText();
	}
	
	public void clickRadioBtn() {
	    driver.findElements(clkRadiobtn).get(0).click();
	}
	
	public void clickAll() {
		driver.findElement(clkAll).click();
	}
	
	public void clickActive() {
		driver.findElement(clkActive).click();
	}
	
	public void clickCompleted() {
		driver.findElement(clkCompleted).click();
	}
	
	public void clickClearCompleted() {
		driver.findElement(clkclearCompleted).click();
	}
	
	public void clickDelete() {
		driver.findElements(clkDelete).get(0).click();
	}
	
}
