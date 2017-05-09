package TUISelenium.tui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParClass1 {

	WebDriver driver;
	
	@BeforeTest
	public void init(){
		driver = new FirefoxDriver();
		driver.get("http://www.haribo.de");
	}
	
	@Test
	public void haribo(){}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
