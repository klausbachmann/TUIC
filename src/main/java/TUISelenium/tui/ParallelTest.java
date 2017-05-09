package TUISelenium.tui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelTest {

	@DataProvider(name="dp1", parallel=true)
	public Object[][] dp1(){
		return new Object[][] {{"Martin", "Wolters"}, {"Stefan", "Baum"},
			{"Stefan", "Wolters"}, {"Martin", "Baum"}};
		
	}
	
	@BeforeTest
	public void init(){
		System.out.println("BEFORE TEST");
	}
	
	@Test(dataProvider="dp1")
	public void ptest(String vorname, String nachname){
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.de");
		driver.findElement(By.name("q")).sendKeys(vorname + " " + nachname);
		driver.quit();
	}
}
