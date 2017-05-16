package TUISelenium.tui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectPersonal extends BasePageObjects {
	WebDriver driver;

	public PageObjectPersonal(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public enum PolicyType {
		BasisschutzOhneSelbstbeteiligung, PremiumschutzMitSelbstbeteiligung, PremiumschutzOhneSelbstbeteiligung, ReiserücktrittMitSelbstbeteiligung, ReiserücktrittOhneSelbstbeteiligung
	}

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;

	private WebElement input_invoice_streetandhousenumber;
	private WebElement input_invoice_additionaladdress;
	private WebElement input_invoice_postalcode;
	private WebElement input_invoice_city;
	private WebElement input_invoice_countrycode;
	private WebElement input_invoice_telephone;
	private WebElement input_invoice_mobilenumber;
	private WebElement input_invoice_email;
	private WebElement input_invoice_emailrepeat;


	@FindBy(css = "a[class='button button-show-insurances js-button-show-insurances ']")
	private WebElement btnInsurancesShow;

	public void clickNextButton() {

		System.out.println("*** btnNextClick from Transport");

		new WebDriverWait(driver, 45).until(ExpectedConditions.elementToBeClickable(buttonNext));

		Actions action = new Actions(driver);

		action.moveToElement(buttonNext).click().perform();

		waitForSpinner();
	}

	public void setStreetandhousenumber(String string) {
		input_invoice_streetandhousenumber.clear();
		input_invoice_streetandhousenumber.sendKeys(string);
	}

	public void setiAdditionaladdress(String string) {
		input_invoice_additionaladdress.clear();
		input_invoice_additionaladdress.sendKeys(string);
	}
	
	public void setPostalcode(String string) {
		input_invoice_postalcode.clear();
		input_invoice_postalcode.sendKeys(string);
	}
	
	public void setCity(String string) {
		input_invoice_city.clear();
		input_invoice_city.sendKeys(string);	}
	
	public void setCountrycode(String string) {
		new Select(input_invoice_countrycode).selectByVisibleText(string);
	}
	
	public void setTelephone(String string) {
		input_invoice_telephone.clear();
		input_invoice_telephone.sendKeys(string);
	}
	
	public void setMobilenumber(String string) {
		input_invoice_mobilenumber.clear();
		input_invoice_mobilenumber.sendKeys(string);
	}
	
	public void setEmail(String string) {
		input_invoice_email.clear();
		input_invoice_email.sendKeys(string);
	}
	
	public void setEmailrepeat(String string) {
		input_invoice_emailrepeat.clear();
		input_invoice_emailrepeat.sendKeys(string);
	}


}
