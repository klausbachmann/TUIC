package TUISelenium.tui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCabinSelection extends BasePageObjects {

	WebDriver driver;
	WebDriverWait wait;

	public PageObjectCabinSelection() {
	}

	public PageObjectCabinSelection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
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
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(buttonNext));
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
		wait.until(ExpectedConditions.visibilityOf(headerItem));
		return this;
	}

//	@FindBy(css = "div[class='spinner-container']")
//	private WebElement spinnerContainerClosed;
//
//	public void waitForSpinnerToBeClosed() {
//		System.out.println("WAIT FOR CLOSE");
//		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container']")));
//		//return this;
//	}
//
//	@FindBy(css = "div[class^='spinner-container']")
//	private WebElement spinnerContainerOpen;
//
//	public void waitForSpinnerToBeOpened() {
//		System.out.println("WAIT FOR SPINNER");
//		wait.until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
//		//return this;
//	}
//
//	public void waitForSpinner() {
//		waitForSpinnerToBeOpened();
//		waitForSpinnerToBeClosed();
//		//return this;
//	}

}
