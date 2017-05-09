package TUISelenium.tui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NGeneration {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void beforeSuite(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.de");
	}
	
	@Test
	public void firstTest() throws Exception{
		driver.findElement(By.name("q")).sendKeys("ableton");
		driver.findElement(By.className("sbico")).click();
		//wait.until(ExpectedConditions.tion)vsibilityOf(driver.findElement(By.className("srg"))));
		List<WebElement> entryList = new ArrayList<WebElement>();
		
		entryList = driver.findElements(By.className("g"));
		
		for(WebElement g : entryList){
			WebElement r = g.findElement(By.className("r")); 
			System.out.println(r.getText());
		}
		
	}
	
	@After
	public void testDown(){
		driver.quit();
	}
}
