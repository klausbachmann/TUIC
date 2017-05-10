package TUISelenium.tui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObjects {
	WebDriver driver;
	WebDriverWait wait;
	public BasePageObjects(){
	}
	
	public BasePageObjects(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public void clickNextButton(){
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
	}
	
	@FindBy(css = "div[class='spinner-container']")
	private WebElement spinnerContainerClosed;

	
	public BasePageObjects waitForSpinnerToBeClosed() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container']")));
		return this;
	}

	@FindBy(css = "div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;

	public void waitForSpinnerToBeOpened() {
		if(wait == null){
			org.testng.Assert.fail("moin");
		}
		wait.until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		//return this;
	}

	public void waitForSpinner() {
		waitForSpinnerToBeOpened();
		waitForSpinnerToBeClosed();
		//return this;
	}

}
