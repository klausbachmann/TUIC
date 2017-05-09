package TUISelenium.tui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParClass3 {

	WebDriver driver;
	
	@Before
	public void init(){
		driver = new FirefoxDriver();
		driver.get("http://www.maoam.de");
	}
	
	@Test
	public void maoam(){}
	@After
	public void tearDown(){
		driver.quit();
	}
}
