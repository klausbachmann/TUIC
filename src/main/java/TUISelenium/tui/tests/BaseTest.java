package TUISelenium.tui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	WebDriver driver;
	
	@BeforeTest
	public void init() {
		System.out.println("INIT");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1400,600));

	}
	
	@AfterTest
	public void down() {
		driver.quit();
	}
}
