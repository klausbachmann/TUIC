package TUISelenium.tuic.ibe.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TUISelenium.tuic.ibe.pageobjects.PageObjectCabinSelection;
import TUISelenium.tuic.ibe.pageobjects.PageObjectCabinSelection.CabinType;
import TUISelenium.tuic.ibe.pageobjects.PageObjectInsurances;
import TUISelenium.tuic.ibe.pageobjects.PageObjectInsurances.PolicyType;
import TUISelenium.tuic.ibe.pageobjects.PageObjectOverview;
import TUISelenium.tuic.ibe.pageobjects.PageObjectPersonal;
import TUISelenium.tuic.ibe.pageobjects.PageObjectTransport;
import TUISelenium.tuic.ibe.pageobjects.PageObjectWishcabin;

public class Testszenario4 extends BaseTest{
	
	@Test
	public void testszanerio4() throws InterruptedException{
		driver.get("https://buchung.tuicruises.com/?tripCode=MSV1725SEE&ePackageCode=EPKATMSV171826");
		
		PageObjectCabinSelection cabin = PageFactory.initElements(driver, PageObjectCabinSelection.class);
		cabin.waitForHeaderItem();
		System.out.println("SESSION: " + getLocalStorage("ibe_store"));

		cabin.decreasePartyAdults();
		cabin.clickNextButton();
		
		PageObjectTransport transport = PageFactory.initElements(driver, PageObjectTransport.class);
		transport.waitForSpinner();
		transport.selectTrainShipBound("Köln Hbf");
		transport.selectBahncardPerson1();
		transport.selectShipBoundTrainFirstClass();
		transport.clickNextButton();
		
		PageObjectInsurances insurances = PageFactory.initElements(driver, PageObjectInsurances.class);
		insurances.btnOhneVersicherungsschutzClick();
		insurances.clickNextButton();
		
		PageObjectPersonal personal = PageFactory.initElements(driver, PageObjectPersonal.class);
		insurances.setSalutationCodePerson1("Herr");
		insurances.setFirstNameAdult1("Helge");
		insurances.setLastNameAdult1("Selenium");
		insurances.setDayOfBirthPerson1("01.06.1968");
		personal.setStreetandhousenumber("Selenium Strasse 343");
		personal.setiAdditionaladdress("Oben links");
		personal.setPostalcode("12345");
		personal.setCity("Seleniumhausen");
		personal.setTelephone("040-60001111");
		personal.setMobilenumber("0110- 099911111");
		personal.setEmail("stefan.baum@tuicruises.com");
		personal.setEmailrepeat("stefan.baum@tuicruises.com");
		personal.clickNextButton();
		
		PageObjectOverview overview = PageFactory.initElements(driver, PageObjectOverview.class);
		overview.paymentMasterCardClick();
		
		System.out.println(getLocalStorage("ibe_store"));
		
	}

}
