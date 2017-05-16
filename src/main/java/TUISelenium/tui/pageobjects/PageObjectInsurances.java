package TUISelenium.tui.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectInsurances extends BasePageObjects {
	WebDriver driver;

	public PageObjectInsurances(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public enum PolicyType {
		BasisschutzOhneSelbstbeteiligung, PremiumschutzMitSelbstbeteiligung, PremiumschutzOhneSelbstbeteiligung, ReiserücktrittMitSelbstbeteiligung, ReiserücktrittOhneSelbstbeteiligung
	}

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;

	private WebElement input_insurancepolicies_individualcount;

	private WebElement input_policytype_1_policy;
	private WebElement input_policytype_2_policy;
	private WebElement input_policytype_3_policy;

	private WebElement input_adult_1_salutationcode;
	private WebElement input_adult_2_salutationcode;
	private WebElement input_adult_3_salutationcode;

	private WebElement input_adult_1_firstname;
	private WebElement input_adult_2_firstname;
	private WebElement input_adult_3_firstname;

	private WebElement input_adult_1_lastname;
	private WebElement input_adult_2_lastname;
	private WebElement input_adult_3_lastname;

	private WebElement input_adult_1_dateofbirth;
	private WebElement input_adult_2_dateofbirth;
	private WebElement input_adult_3_dateofbirth;

	@FindBy(id = "accept-insurance-conditions")
	private WebElement accept_insurance_conditions;

	@FindBy(css = "a[class='button button-show-insurances js-button-show-insurances ']")
	private WebElement btnInsurancesShow;

	public void clickNextButton() {

		System.out.println("*** btnNextClick from Transport");

		new WebDriverWait(driver, 45).until(ExpectedConditions.elementToBeClickable(buttonNext));

		Actions action = new Actions(driver);

		action.moveToElement(buttonNext).click().perform();

		waitForSpinner();
	}

	public void setIndividualCount(int count) {
		input_insurancepolicies_individualcount.clear();
		input_insurancepolicies_individualcount.sendKeys(String.valueOf(count));
		input_insurancepolicies_individualcount.sendKeys(Keys.TAB);

	}

	public void btnShowInsurancesClick() {

		btnInsurancesShow.click();

	}

	public String getPolicyType(PolicyType policy) {
		switch (policy) {
		case BasisschutzOhneSelbstbeteiligung:
			return "BOS";

		case PremiumschutzMitSelbstbeteiligung:
			return "PMS";

		case PremiumschutzOhneSelbstbeteiligung:
			return "POS";

		case ReiserücktrittMitSelbstbeteiligung:
			return "RRV";

		case ReiserücktrittOhneSelbstbeteiligung:
			return "SRV";

		default:
			return "BOS";
		}
	}

	public void setPolicyTypePerson1(PolicyType policy) {
		new Select(input_policytype_1_policy).selectByValue(getPolicyType(policy));
	}

	public void setPolicyTypePerson2(PolicyType policy) {
		new Select(input_policytype_2_policy).selectByValue(getPolicyType(policy));
	}

	public void setPolicyTypePerson3(PolicyType policy) {
		new Select(input_policytype_3_policy).selectByValue(getPolicyType(policy));
	}

	public void setSalutationCodePerson1(String salutation) {
		new Select(input_adult_1_salutationcode).selectByVisibleText(salutation);
	}

	public void setSalutationCodePerson2(String salutation) {
		new Select(input_adult_2_salutationcode).selectByVisibleText(salutation);
	}

	public void setSalutationCodePerson3(String salutation) {
		new Select(input_adult_3_salutationcode).selectByVisibleText(salutation);
	}

	public void setFirstNameAdult1(String firstname) {
		input_adult_1_firstname.sendKeys(firstname);
	}

	public void setFirstNameAdult2(String firstname) {
		input_adult_2_firstname.sendKeys(firstname);
	}

	public void setFirstNameAdult3(String firstname) {
		input_adult_3_firstname.sendKeys(firstname);
	}
	
	public void setLastNameAdult1(String firstname) {
		input_adult_1_lastname.sendKeys(firstname);
	}

	public void setLastNameAdult2(String firstname) {
		input_adult_2_lastname.sendKeys(firstname);
	}

	public void setLastNameAdult3(String firstname) {
		input_adult_3_lastname.sendKeys(firstname);
	}
	
	public void setDayOfBirthPerson1(String birthday){
		input_adult_1_dateofbirth.sendKeys(birthday);
	}
	
	public void setDayOfBirthPerson2(String birthday){
		input_adult_2_dateofbirth.sendKeys(birthday);
	}
	
	public void setDayOfBirthPerson3(String birthday){
		input_adult_3_dateofbirth.sendKeys(birthday);
	}

}
