package TUISelenium.tui.tests;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TUISelenium.tui.pageobjects.PageObjectCabinSelection;
import TUISelenium.tui.pageobjects.PageObjectTransport;
import TUISelenium.tui.pageobjects.PageObjectWishcabin;

public class RandomPage extends BaseTest{
	//WebDriver driver;

	PageObjectCabinSelection page;

//	@BeforeTest
//	public void init() {
//		System.out.println("INIT");
//		driver = new ChromeDriver();
//		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}

	@Test(testName="Standard Buchungstestfall")
	public void start() throws InterruptedException {
		page = PageFactory.initElements(driver, PageObjectCabinSelection.class);
		//page.open("https://tuic-ibe-test.stage.cellular.de/?tripCode=MSZ1812SEE&ePackageCode=EPKATMSZ1812");
		page.open("https://buchung.tuicruises.com/?tripCode=MSD180506SEE&ePackageCode=EPKATMSD17361813");
		// page.setSearchField("Meine Suche");
		page.waitForHeaderItem();
		// Thread.sleep(3000);
		page.increasePartyAdults();

		page.waitForSpinnerToBeOpened();
		page.waitForSpinnerToBeClosed();
		//page.waitForSpinner();
		page.btnFeelgoodPriceClick();
		page.clickNextButton();
		//page.waitForSpinner();

		PageObjectWishcabin cabin = PageFactory.initElements(driver, PageObjectWishcabin.class);
		cabin.clickNextButton();
		//cabin.waitForSpinner();

		PageObjectTransport transport = PageFactory.initElements(driver, PageObjectTransport.class);
		transport.outputAllAirports();
		transport.selectShipboundAirportByName("München");
		transport.selectShipboundAirportByName("Basel");
		transport.btnEigeneAbreiseClick();
		transport.btnAbreiseMitFlugzeugClick();
		transport.selectHomeboundAirportByName("Hamburg");
	}

//	@AfterTest
//	public void down() {
//		driver.quit();
//	}

}
