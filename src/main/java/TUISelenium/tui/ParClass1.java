package TUISelenium.tui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParClass1 {

	WebDriver driver;
	
	@Before
	public void init(){
		driver = new FirefoxDriver();
		driver.get("http://www.haribo.de");
	}
	
	@Test
	public void haribo(){}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
