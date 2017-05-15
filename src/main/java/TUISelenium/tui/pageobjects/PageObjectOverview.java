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
	
	private WebElement input_invoice_additionaladdress;
	private WebElement input_invoice_postalcode;
	private WebElement input_invoice_city;
	private WebElement input_invoice_countrycode;
	private WebElement input_invoice_telephone;
	private WebElement input_invoice_mobilenumber;
	private WebElement input_invoice_email;
	private WebElement input_invoice_emailrepeat;


	public void clickNextButton() {

		System.out.println("*** btnNextClick from Transport");

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonNext));

		Actions action = new Actions(driver);

		action.moveToElement(buttonNext).click().perform();

		waitForSpinner();
	}

	public void outputOverview(){
		System.out.println(bookingStatus.getText());
	}

}
