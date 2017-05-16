package TUISelenium.tui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectOverview extends BasePageObjects {
	WebDriver driver;

	public PageObjectOverview(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")	
	@CacheLookup
	private WebElement buttonNext;

	@FindBy(className="booking-status")
	private WebElement bookingStatus;
	
	@FindBy(className="form-group  content")
	private WebElement paymentBox;
	
	private WebElement input_overviewandapproval_approvalofterms;

	public void clickNextButton() {

		System.out.println("*** btnNextClick from Transport");

		new WebDriverWait(driver, 45).until(ExpectedConditions.elementToBeClickable(buttonNext));

		Actions action = new Actions(driver);

		action.moveToElement(buttonNext).click().perform();

		waitForSpinner();
	}

	public void outputOverview(){
		System.out.println(bookingStatus.getText());
	}
	
	public void paymentLastschriftClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(1)")).click();
		waitForSpinner();
	}
	
	public void paymentMasterCardClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(2)")).click();
		waitForSpinner();
	}
	
	public void paymentVisaCardClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(3)")).click();
		waitForSpinner();
	}
	
	public void paymentAmericanexpressClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(4)")).click();
		waitForSpinner();
	}
	
	public void paymentTUICardClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(5)")).click();
		waitForSpinner();
	}
	
	public void paymentGuteReiseCardClick(){
		driver.findElement(By.cssSelector("label[class^='js-item item ']:nth-child(6)")).click();
		waitForSpinner();
	}
	
	public void AGBClick(){
		Actions action = new Actions(driver);
		action.moveToElement(input_overviewandapproval_approvalofterms).click().perform();
	}

}
