package TUISelenium.tui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TUISelenium.tui.pageobjects.PageObjectCabinSelection;
import TUISelenium.tui.pageobjects.PageObjectInsurances;
import TUISelenium.tui.pageobjects.PageObjectInsurances.PolicyType;
import TUISelenium.tui.pageobjects.PageObjectOverview;
import TUISelenium.tui.pageobjects.PageObjectPersonal;
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
	public void start() throws NoSuchElementException, InterruptedException {
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
//		transport.selectShipboundAirportByIndex(1);
//		transport.selectShipboundAirportByIndex(2);
//		transport.btnEigeneAbreiseClick();
//		transport.btnAbreiseMitFlugzeugClick();
		transport.clickNextButton();

		PageObjectInsurances insurance = PageFactory.initElements(driver, PageObjectInsurances.class);
		insurance.setIndividualCount(3);
		insurance.btnShowInsurancesClick();
		insurance.waitForSpinner();
		
		insurance.setPolicyTypePerson1(PolicyType.BasisschutzOhneSelbstbeteiligung);
		insurance.setSalutationCodePerson1("Herr");
		insurance.setFirstNameAdult1("Frank Peter");
		insurance.setLastNameAdult1("Usinger");
		insurance.setDayOfBirthPerson1("01.09.1988");
		insurance.setPolicyTypePerson2(PolicyType.PremiumschutzMitSelbstbeteiligung);
		insurance.setSalutationCodePerson2("Frau");
		insurance.setFirstNameAdult2("Ulrike");
		insurance.setLastNameAdult2("Powerjon");
		insurance.setDayOfBirthPerson2("01.08.1988");
		insurance.setPolicyTypePerson3(PolicyType.ReiserücktrittMitSelbstbeteiligung);
		insurance.setSalutationCodePerson3("Frau");
		insurance.setFirstNameAdult3("Jenny");
		insurance.setLastNameAdult3("Franklyn");
		insurance.setDayOfBirthPerson3("01.10.1988");
		insurance.clickNextButton();
		
		PageObjectPersonal personal = PageFactory.initElements(driver, PageObjectPersonal.class);
		personal.setStreetandhousenumber("Waidmannsruh 24");
		personal.setiAdditionaladdress("Unten links");
		personal.setPostalcode("24119");
		personal.setCity("Crowntown");
		personal.setCountrycode("Belgien");
		personal.setTelephone("0431-1233445");
		personal.setMobilenumber("0198-999999999");
		personal.setEmail("martin.wolters@tuicruises.com");
		personal.setEmailrepeat("martin.wolters@tuicruises.com");
		
		personal.clickNextButton();
		
		PageObjectOverview overview = PageFactory.initElements(driver, PageObjectOverview.class);
		overview.outputOverview();
		
	}

//	@AfterTest
//	public void down() {
//		driver.quit();
//	}

}
