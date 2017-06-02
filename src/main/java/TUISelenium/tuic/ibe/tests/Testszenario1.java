package TUISelenium.tuic.ibe.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TUISelenium.tuic.ibe.pageobjects.PageObjectCabinSelection;
import TUISelenium.tuic.ibe.pageobjects.PageObjectCabinSelection.CabinType;
import TUISelenium.tuic.ibe.pageobjects.PageObjectInsurances;
import TUISelenium.tuic.ibe.pageobjects.PageObjectInsurances.PolicyType;
import TUISelenium.tuic.ibe.pageobjects.PageObjectOverview;
import TUISelenium.tuic.ibe.pageobjects.PageObjectPersonal;
import TUISelenium.tuic.ibe.pageobjects.PageObjectTransport;
import TUISelenium.tuic.ibe.pageobjects.PageObjectWishcabin;

public class Testszenario1 extends BaseTest{
	
	@Test
	@Parameters({"reise1"})
	public void testszanerio1(String reise){
		//driver.get("https://buchung.tuicruises.com/?tripCode=MSD174041SEE&ePackageCode=EPKATMSD17361813");
		driver.get(reise);
		
		PageObjectCabinSelection cabin = PageFactory.initElements(driver, PageObjectCabinSelection.class);
		cabin.waitForHeaderItem();
		System.out.println("SESSION: " + getLocalStorage("ibe_store"));
		cabin.selectCabinCategory(CabinType.Balkonkabine);
		cabin.btnFeelgoodPriceClick();
		cabin.btnSelectCabinCategoryClick();
		cabin.clickNextButton();
		
		PageObjectWishcabin wishcabin = PageFactory.initElements(driver, PageObjectWishcabin.class);
		wishcabin.selectPriceCategoryByValue("BKCW");
		wishcabin.selectDeckNumber("9");
		wishcabin.selectCabinNumber(9124);
		wishcabin.clickNextButton();
		
		PageObjectTransport transport = PageFactory.initElements(driver, PageObjectTransport.class);
		transport.selectShipboundAirportByName("Düsseldorf");
		transport.selectFirstClassShipBound();
		transport.clickNextButton();
		
		PageObjectInsurances insurances = PageFactory.initElements(driver, PageObjectInsurances.class);
		insurances.btnCouplePlusClick();
		insurances.btnShowInsurancesClick();
		insurances.setPolicyTypePerson1(PolicyType.BasisschutzOhneSelbstbeteiligungFamily);
		insurances.btnAcceptInsuranceConditionsClick();
		insurances.clickNextButton();
		
		PageObjectPersonal personal = PageFactory.initElements(driver, PageObjectPersonal.class);
		insurances.setSalutationCodePerson1("Herr");
		insurances.setFirstNameAdult1("Helge");
		insurances.setLastNameAdult1("Selenium");
		insurances.setDayOfBirthPerson1("01.06.1968");
		insurances.setSalutationCodePerson2("Frau");
		insurances.setFirstNameAdult2("Margit");
		insurances.setLastNameAdult2("Selenium");
		insurances.setDayOfBirthPerson2("01.09.1988");
		
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
		overview.paymentVisaCardClick();
		
	}

}
