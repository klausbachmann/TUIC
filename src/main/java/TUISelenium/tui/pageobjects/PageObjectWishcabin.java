package TUISelenium.tui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectWishcabin extends BasePageObjects{
	WebDriver driver;
	//static WebDriverWait wait;
	
	public PageObjectWishcabin(WebDriver driver){
		super(driver);
		this.driver = driver;
		//driver.manage().window().maximize();
	}
	            
	@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public void clickNextButton(){
		//buttonNext.click();
		System.out.println("*** btnNextClick from WishCabin");
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(buttonNext));
		System.out.println("*** ");
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
		//return this;
	}
	
	
	/*
	@FindBy(css="div[class='spinner-container']")
	private WebElement spinnerContainerClosed;
	
	public PageObjectWishcabin waitForSpinnerToBeClosed(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container']")));
		return this;
	}
	
	@FindBy(css="div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;
	
	public PageObjectWishcabin waitForSpinnerToBeOpened(){
		wait.until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		return this;
	}
	
	public PageObjectWishcabin waitForSpinner(){
		waitForSpinnerToBeOpened();
		waitForSpinnerToBeClosed();
		return this;
	}
	*/

	
}
