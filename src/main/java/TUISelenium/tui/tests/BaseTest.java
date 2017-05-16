package TUISelenium.tui.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	WebDriver driver;
	
	@BeforeTest
	public void init() throws MalformedURLException {
		System.out.println("INIT");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver();
		
		DesiredCapabilities caps = new DesiredCapabilities().chrome();
		caps.setVersion("58");
		driver = new RemoteWebDriver(new URL("http://10.234.253.101:4444/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@AfterTest
	public void down() {
		driver.quit();
	}
}
