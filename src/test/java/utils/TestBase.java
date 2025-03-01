package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver WebDriverManager() throws IOException {
				
				//Loading configuration file
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//global.properties");
				prop = new Properties();
				prop.load(fis);
				String url = prop.getProperty("QAUrl");
				
				if (driver == null) {
				
					if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
						//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
							driver = new ChromeDriver();
					} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver();
					} else {
						driver = new SafariDriver();
					
					}
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				driver.get(url); //reading URL from properties file
				driver.manage().window().maximize();
			}
			
			return driver;
	}
}
