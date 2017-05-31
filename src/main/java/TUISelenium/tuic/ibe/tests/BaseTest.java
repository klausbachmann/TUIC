package TUISelenium.tuic.ibe.tests;

import java.lang.ref.PhantomReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void init(String browser) throws MalformedURLException {

		DesiredCapabilities caps;
		
		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "chromedriver");
			//driver = new ChromeDriver();

			// System.setProperty("phantomjs.binary.path", "phantomjs");
			// driver = new PhantomJSDriver();

			caps = new DesiredCapabilities().chrome();
			caps.setVersion("58");
			driver = new RemoteWebDriver(new URL("http://10.234.253.101:4444/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
			caps = new DesiredCapabilities().firefox();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		default:
			break;
		}
		System.out.println(browser);

	}

	@AfterTest
	public void down() {
		driver.quit();
	}
}
