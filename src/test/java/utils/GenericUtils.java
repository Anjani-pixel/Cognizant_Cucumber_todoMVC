package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clkSearchBtn() {
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
        return generatedstring+"@"+ generatednumber;
	}

	public void assertTodoName(String extractName, String todoItem) {
		
		if (extractName.equals(todoItem)) {
			System.out.println("Todo item added successfully");
		} else {
			System.out.println("Todo item not added successfully");
		}
		
	}

}
