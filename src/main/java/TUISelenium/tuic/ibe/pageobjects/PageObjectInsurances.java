package TUISelenium.tuic.ibe.pageobjects;

import org.openqa.selenium.By;
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
		BasisschutzOhneSelbstbeteiligung, 
		PremiumschutzMitSelbstbeteiligung, 
		PremiumschutzOhneSelbstbeteiligung, 
		ReiserücktrittMitSelbstbeteiligung, 
		ReiserücktrittOhneSelbstbeteiligung,
		BasisschutzOhneSelbstbeteiligungFamily, 
		PremiumschutzMitSelbstbeteiligungFamily, 
		PremiumschutzOhneSelbstbeteiligungFamily, 
		ReiserücktrittMitSelbstbeteiligungFamily, 
		ReiserücktrittOhneSelbstbeteiligungFamily
	}

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;

	private WebElement input_insurance_option_0;
	private WebElement input_insurance_option_1;

	private WebElement input_insurancepolicies_individualcount;
	private WebElement input_insurancepolicies_groupcount_couple;
	private WebElement input_insurancepolicies_groupcount_family;

	@FindBy(css = "div[class='number-input-element js-input-element-couple']")
	private WebElement input_couple;

	@FindBy(css = "div[class='number-input-element js-input-element-family']")
	private WebElement input_family;

	@FindBy(css = "div[class='number-input-element js-input-element-family_0_adults']")
	private WebElement input_family_adults;

	@FindBy(css = "div[class='number-input-element js-input-element-family_0_children']")
	private WebElement input_family_children;

	private WebElement input_policytype_1_policy;
	private WebElement input_policytype_2_policy;
	private WebElement input_policytype_3_policy;

	private WebElement input_adult_1_salutationcode;
	private WebElement input_adult_2_salutationcode;
	private WebElement input_adult_3_salutationcode;
	private WebElement input_adult_4_salutationcode;

	private WebElement input_adult_1_firstname;
	private WebElement input_adult_2_firstname;
	private WebElement input_adult_3_firstname;
	private WebElement input_adult_4_firstname;

	private WebElement input_adult_1_lastname;
	private WebElement input_adult_2_lastname;
	private WebElement input_adult_3_lastname;
	private WebElement input_adult_4_lastname;

	private WebElement input_adult_1_dateofbirth;
	private WebElement input_adult_2_dateofbirth;
	private WebElement input_adult_3_dateofbirth;
	private WebElement input_adult_4_dateofbirth;
	
	private WebElement input_child_1_firstname;
	private WebElement input_child_2_firstname;
	private WebElement input_child_3_firstname;

	private WebElement input_child_1_lastname;
	private WebElement input_child_2_lastname;
	private WebElement input_child_3_lastname;
	
	private WebElement input_child_1_dateofbirth;
	private WebElement input_child_2_dateofbirth;
	private WebElement input_child_3_dateofbirth;

	@FindBy(id = "input_insurancetermsandconditions_approvalofterms")
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

	public void btnMitVersicherungsschutzClick() {
		new Actions(driver).moveToElement(input_insurance_option_1).click().perform();
		waitForSpinner();
	}

	public void btnOhneVersicherungsschutzClick() {
		new Actions(driver).moveToElement(input_insurance_option_0).click().perform();
		waitForSpinner();
	}

	public void btnAcceptInsuranceConditionsClick() {
		new Actions(driver).moveToElement(accept_insurance_conditions).click().perform();
	}

	public void setIndividualCount(int count) throws InterruptedException {
		Thread.sleep(2000);
		input_insurancepolicies_individualcount.clear();
		input_insurancepolicies_individualcount.sendKeys(String.valueOf(count));
		input_insurancepolicies_individualcount.sendKeys(Keys.TAB);
	}

	public void setCoupleCount(int count) throws InterruptedException {
		Thread.sleep(2000);
		input_insurancepolicies_groupcount_couple.clear();
		input_insurancepolicies_groupcount_couple.sendKeys(String.valueOf(count));
		input_insurancepolicies_groupcount_couple.sendKeys(Keys.TAB);
	}

	public void btnCouplePlusClick() {
		WebElement btnPlus = input_couple.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnPlus));
		btnPlus.click();
	}

	public void btnCoupleMinusClick() {
		WebElement btnMinus = input_couple.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnMinus));
		btnMinus.click();
	}

	public void setFamilyCount(int count) throws InterruptedException {
		Thread.sleep(2000);
		input_insurancepolicies_groupcount_family.clear();
		input_insurancepolicies_groupcount_family.sendKeys(String.valueOf(count));
		input_insurancepolicies_groupcount_family.sendKeys(Keys.TAB);
	}

	public void btnFamilyPlusClick() {
		WebElement btnPlus = input_family.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnPlus));
		btnPlus.click();
	}

	public void btnFamilyMinusClick() {
		WebElement btnMinus = input_family.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnMinus));
		btnMinus.click();
	}

	public void btnFamilyAdultsPlusClick() {
		WebElement btnPlus = input_family_adults.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnPlus));
		btnPlus.click();
	}

	public void btnFamilyAdultsMinusClick() {
		WebElement btnMinus = input_family_adults.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnMinus));
		btnMinus.click();
	}

	public void btnFamilyChildrenPlusClick() {
		WebElement btnPlus = input_family_children.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnPlus));
		btnPlus.click();
	}

	public void btnFamilyChildrenMinusClick() {
		WebElement btnMinus = input_family_children.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnMinus));
		btnMinus.click();
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
			
		case BasisschutzOhneSelbstbeteiligungFamily:
			return "BOF";

		case PremiumschutzMitSelbstbeteiligungFamily:
			return "PSP";

		case PremiumschutzOhneSelbstbeteiligungFamily:
			return "POP";

		case ReiserücktrittMitSelbstbeteiligungFamily:
			return "RPV";

		case ReiserücktrittOhneSelbstbeteiligungFamily:
			return "RPO";

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

	public void setFirstNameAdult4(String firstname) {
		input_adult_4_firstname.sendKeys(firstname);
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

	public void setLastNameAdult4(String firstname) {
		input_adult_4_lastname.sendKeys(firstname);
	}

	public void setDayOfBirthPerson1(String birthday) {
		input_adult_1_dateofbirth.sendKeys(birthday);
	}

	public void setDayOfBirthPerson2(String birthday) {
		input_adult_2_dateofbirth.sendKeys(birthday);
	}

	public void setDayOfBirthPerson3(String birthday) {
		input_adult_3_dateofbirth.sendKeys(birthday);
	}

	public void setDayOfBirthPerson4(String birthday) {
		input_adult_4_dateofbirth.sendKeys(birthday);
	}

	public void setFirstNameChild1(String firstname) {
		input_child_1_firstname.sendKeys(firstname);
	}

	public void setFirstNameChild2(String firstname) {
		input_child_2_firstname.sendKeys(firstname);
	}

	public void setFirstNameChild3(String firstname) {
		input_child_3_firstname.sendKeys(firstname);
	}

	public void setLastNameChild1(String firstname) {
		input_child_1_lastname.sendKeys(firstname);
	}

	public void setLastNameChild2(String firstname) {
		input_child_2_lastname.sendKeys(firstname);
	}

	public void setLastNameChild3(String firstname) {
		input_child_3_lastname.sendKeys(firstname);
	}

	public void setDayOfBirthChild1(String birthday) {
		input_child_1_dateofbirth.sendKeys(birthday);
	}

	public void setDayOfBirthChild2(String birthday) {
		input_child_2_dateofbirth.sendKeys(birthday);
	}

	public void setDayOfBirthChild3(String birthday) {
		input_child_3_dateofbirth.sendKeys(birthday);
	}
}
