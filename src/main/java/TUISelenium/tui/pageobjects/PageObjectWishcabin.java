package TUISelenium.tui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectWishcabin extends BasePageObjects{
	WebDriver driver;
	
	public PageObjectWishcabin(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	            
	@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public void clickNextButton(){
		System.out.println("*** btnNextClick from WishCabin");
		new WebDriverWait(driver, 45).until(ExpectedConditions.elementToBeClickable(buttonNext));
		System.out.println("*** ");
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
	}
	
}
