package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkTitlePage {
	
public WebDriver driver;
	
	public LinkTitlePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By clklink1 = By.xpath("//a[text()='Quick Start']");
	
	public void clickLink1() {
		driver.findElement(clklink1).click();
	}
	
	public String getLinkTitle()
	{
		return driver.getTitle();
		
	}

}
