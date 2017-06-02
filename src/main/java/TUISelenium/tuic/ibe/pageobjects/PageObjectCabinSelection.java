package TUISelenium.tuic.ibe.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCabinSelection extends BasePageObjects {

	WebDriver driver;

	public enum CabinType {
		Innenkabine, Außenkabine, Balkonkabine, Verandakabine, Familienkabine
	};

	public PageObjectCabinSelection() {
	}

	public PageObjectCabinSelection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.out.println(driver.getCurrentUrl());
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

	// @FindBy(css = "a[class='button button-plus']")
	// private WebElement btnAdultsIncrease;

	@FindBy(css = "div[class='api-input api-input-adults']")
	private WebElement selectorAdults;

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	// @CacheLookup
	private WebElement buttonNext;

	@FindBy(css = "div[class='api-input api-input-children']")
	private WebElement selectorChildren;

	@FindBy(css = "div[class='swiper-button-next level-1']")
	private WebElement swiperButtonNext;

	@FindBy(css = "div[class~='swiper-slide level-1'],[class$='swiper-slide-active']")
	private WebElement activeCabin;

	@FindBy(css = "a[class='js-selection button swiper-no-swiping ']")
	private WebElement unused;
	
	public void clickNextButton() {
		System.out.println("*** btnNextClick from CabinSelection");
		new WebDriverWait(driver, 45).until(ExpectedConditions.elementToBeClickable(buttonNext));
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		// buttonNext.click();
		// waitForSpinner();
	}

	public PageObjectCabinSelection increasePartyAdults() {
		System.out.println("*** INCREASE PARTY ADULTS ***");
		// new WebDriverWait(driver,
		// 35).until(ExpectedConditions.elementToBeClickable(btnAdultsIncrease));
		WebElement btnAdultsIncrease = selectorAdults.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 35).until(ExpectedConditions.elementToBeClickable(btnAdultsIncrease));
		btnAdultsIncrease.click();
		waitForSpinner();
		return this;
	}

	public PageObjectCabinSelection decreasePartyAdults() {
		System.out.println("*** DECREASE PARTY ADULTS ***");
		// new WebDriverWait(driver,
		// 35).until(ExpectedConditions.elementToBeClickable(btnAdultsIncrease));
		WebElement btnAdultsDecrease = selectorAdults.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 35).until(ExpectedConditions.elementToBeClickable(btnAdultsDecrease));
		btnAdultsDecrease.click();
		waitForSpinner();
		return this;
	}

	public PageObjectCabinSelection increasePartyChildren() {
		System.out.println("*** INCREASE PARTY ADULTS ***");
		WebElement btnChildrenIncrease = selectorChildren.findElement(By.cssSelector("a[class='button button-plus']"));
		new WebDriverWait(driver, 35).until(ExpectedConditions.elementToBeClickable(btnChildrenIncrease));
		btnChildrenIncrease.click();
		waitForSpinner();
		return this;
	}

	public PageObjectCabinSelection decreasePartyChildren() {
		System.out.println("*** DECREASE PARTY ADULTS ***");
		WebElement btnChildrenDecrease = selectorChildren.findElement(By.cssSelector("a[class='button button-minus']"));
		new WebDriverWait(driver, 35).until(ExpectedConditions.elementToBeClickable(btnChildrenDecrease));
		btnChildrenDecrease.click();
		waitForSpinner();
		return this;
	}

	public void btnFeelgoodPriceClick() {
		System.out.println("btnFeelgood CLICK");
		WebElement btnFeelgoodPrice2 = activeCabin.findElement(By.cssSelector("input[id^='input_cabintype_cabintype-feelgood']"));
		Actions action = new Actions(driver);
		action.moveToElement(btnFeelgoodPrice2).click().perform();
		
		/*
		 * ACHTUNG:
		 * Wenn die Kabine die aktive Kabine ist, wird der Spinner ausgeloest.
		 * Nur wenn eine neue Kabinenkategorie ausgewaehlt wird, muss nicht auf den Spinner gewartet werden*/
		
		// waitForSpinner();
	}
	
	public void btnFlexPriceClick() {
		System.out.println("btnFlexprice CLICK");
		WebElement btnFlexPrice2 = activeCabin.findElement(By.cssSelector("input[id^='input_cabintype_cabintype-flex']"));
		Actions action = new Actions(driver);
		action.moveToElement(btnFlexPrice2).click().perform();
		
		/*
		 * ACHTUNG:
		 * Wenn die Kabine die aktive Kabine ist, wird der Spinner nicht ausgeloest.
		 * Nur wenn eine neue Kabinenkategorie ausgewaehlt wird, muss auf den Spinner gewartet werden*/
		
		// waitForSpinner();
	}

	public void swiperButtonNextClick() throws InterruptedException {
		swiperButtonNext.click();
		Thread.sleep(500);
	}

	public WebElement getActiveCabin() {
		return activeCabin;
	}

	public String getCabinname() {
		WebElement c = getActiveCabin();
		return c.findElement(By.cssSelector("h3[class='cabin-slide-headline']")).getText();
	}

	public void selectCabinCategory(CabinType category) {
		System.out.println("Suche Kabine <" + category.toString() + ">");
		boolean found = false;
		for (int i = 0; i < 20; i++) {
			if (category.toString().equals(getCabinname())) {
				System.out.println("Kabine <" + category.toString() + "> gefunden");
				found = true;
				break;
			}
			try {
				swiperButtonNextClick();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!found){
			org.testng.Assert.fail("Kann Kabinenkategorie <"+ category +"> nach 20 Versuchen nicht finden");
		}
	}

	public void selectCabinCategory(String category) {
		System.out.println("Suche Kabine <" + category + ">");
		boolean found = false;
		for (int i = 0; i < 20; i++) {
			if (category.equals(getCabinname())) {
				System.out.println("Kabine <" + category + "> gefunden");
				found = true;
				break;
			}
			try {
				swiperButtonNextClick();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!found){
			org.testng.Assert.fail("Kann Kabinenkategorie <"+ category +"> nach 20 Versuchen nicht finden");
		}
	}

	public String getBtnFeelgoodAttribute() {
		return btnFeelgoodPrice.getAttribute("data-initchecked");
	}

	public void btnSelectCabinCategoryClick(){
		WebElement btnSelectCabinCategory = activeCabin.findElement(By.cssSelector("a[class='js-selection button swiper-no-swiping ']"));
		Actions action = new Actions(driver);
		action.moveToElement(btnSelectCabinCategory).click().perform();
		waitForSpinner();
	}
	
	public PageObjectCabinSelection waitForHeaderItem() {
		new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(headerItem));
		return this;
	}

}
