package TUISelenium.tui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCabinSelection extends BasePageObjects{

	WebDriver driver;
	WebDriverWait wait;
	
	public PageObjectCabinSelection(){}
	
	public PageObjectCabinSelection(WebDriver driver){
		this.driver = driver;
		driver.manage().window().maximize();
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public void open(String url){ driver.get(url); }
	public void closeDriver(){ driver.close(); }
	
	/*@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public PageObjectCabinSelection clickNextButton(){
		buttonNext.click();
		return this;
	}*/
	
	@FindBy(id="input_party_adults")
	private WebElement inputPartyAdults;
	
	
	/*
	 * btnAdultsIncrease Element and Methods
	 */
	//@FindBy(css="class[name='api-input api-input-adults'] > div > div > a[class='button button-plus']")
	@FindBy(css="a[class='button button-plus']")
	private WebElement btnAdultsIncrease;
	
	public PageObjectCabinSelection increasePartyAdults(){
		//wait.until(ExpectedConditions.elementToBeClickable(btnAdultsIncrease));
		//wait.until(ExpectedConditions.visibilityOf(btnAdultsIncrease));
		
		btnAdultsIncrease.click();
		return this;
	}
	
	
	/*
	 * headerItem
	 * */
	@FindBy(css="h1[class='booking-page-headline']")
	private WebElement headerItem;
	
	public PageObjectCabinSelection waitForHeaderItem(){
		wait.until(ExpectedConditions.visibilityOf(headerItem));
		return this;
	}
	
	@FindBy(css="div[class='spinner-container']")
	private WebElement spinnerContainerClosed;
	
	public PageObjectCabinSelection waitForSpinnerToBeClosed(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container']")));
		return this;
	}
	
	@FindBy(css="div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;
	
	public PageObjectCabinSelection waitForSpinnerToBeOpened(){
		wait.until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		return this;
	}
	
	public PageObjectCabinSelection waitForSpinner(){
		waitForSpinnerToBeOpened();
		waitForSpinnerToBeClosed();
		return this;
	}
	
}
