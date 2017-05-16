package TUISelenium.tui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCabinSelection extends BasePageObjects {

	WebDriver driver;

	public PageObjectCabinSelection() {
	}

	public PageObjectCabinSelection(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void open(String url) {
		driver.get(url);
	}

	public void closeDriver() {
		driver.close();
	}

	@FindBy(css = "h1[class='booking-page-headline']")
	private WebElement headerItem;

	@FindBy(id = "input_party_adults")
	private WebElement inputPartyAdults;

	@FindBy(id = "input_cabintype_cabintype-feelgood-0")
	private WebElement btnFeelgoodPrice;

	@FindBy(css = "a[class='button button-plus']")
	private WebElement btnAdultsIncrease;

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
//	@CacheLookup
	private WebElement buttonNext;

	public void clickNextButton() {
		System.out.println("*** btnNextClick from CabinSelection");
		new WebDriverWait(driver,45).until(ExpectedConditions.elementToBeClickable(buttonNext));
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		//buttonNext.click();
//		waitForSpinner();
	}
	
	public PageObjectCabinSelection increasePartyAdults() {
		// wait.until(ExpectedConditions.elementToBeClickable(btnAdultsIncrease));
		// wait.until(ExpectedConditions.visibilityOf(btnAdultsIncrease));

		btnAdultsIncrease.click();
		return this;
	}

	public void btnFeelgoodPriceClick() {
		System.out.println("btnFeelgood CLICK");
		// if (!getBtnFeelgoodAttribute().equals("true")) {
		Actions action = new Actions(driver);
		action.moveToElement(btnFeelgoodPrice).click().perform();
		waitForSpinner();
		// btnFeelgoodPrice.click();
		// }
	}

	public String getBtnFeelgoodAttribute() {
		return btnFeelgoodPrice.getAttribute("data-initchecked");
	}

	public PageObjectCabinSelection waitForHeaderItem() {
		new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(headerItem));
		return this;
	}

}
