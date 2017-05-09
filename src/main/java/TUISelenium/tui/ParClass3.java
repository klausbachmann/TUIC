package TUISelenium.tui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParClass3 {

	WebDriver driver;
	
	@BeforeTest
	public void init(){
		driver = new FirefoxDriver();
		driver.get("http://www.maoam.de");
	}
	
	@Test
	public void maoam(){}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
