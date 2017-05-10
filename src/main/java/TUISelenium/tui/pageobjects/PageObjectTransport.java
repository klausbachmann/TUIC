package TUISelenium.tui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTransport extends BasePageObjects{
	WebDriver driver;
	WebDriverWait wait;
	
	public PageObjectTransport(WebDriver driver){
		this.driver = driver;
		driver.manage().window().maximize();
		this.wait = new WebDriverWait(driver, 30);
	}

	/*@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public PageObjectWishcabin clickNextButton(){
		buttonNext.click();
		return this;
	}*/
	
	@FindBy(id="input_shipboundtransporttype_type_0")
	private WebElement btnAnreisemitFlugzeug;
	
	@FindBy(id="input_homeboundtransporttype_type_0")
	private WebElement btnAbreisemitFlugzeug;
	
	@FindBy(id="input_homeboundtransporttype_type_1")
	private WebElement btnEigeneAbreise;
	
	@FindBy(id="input_shipboundairport_airportcode")
	private WebElement shipBoundAirports;

	@FindBy(id="input_homeboundairport_airportcode")
	private WebElement homeBoundAirports;
	
	
	public void outputAllAirports(){
		List<WebElement> shipBoundAirportList = shipBoundAirports.findElements(By.tagName("option"));
		for( WebElement e:shipBoundAirportList){
			System.out.println(e.getText());
		}
	}
	
	
	public void selectShipboundAirportByName(String airport){
		Select dropdown = new Select(shipBoundAirports);
		dropdown.selectByVisibleText(airport);
		waitForSpinner();
	}
	
	public void selectHomeboundAirportByName(String airport){
		Select dropdown = new Select(homeBoundAirports);
		dropdown.selectByVisibleText(airport);
		waitForSpinner();
	}
	
	public void btnAbreiseMitFlugzeugClick(){
		Actions action = new Actions(driver);
		action.moveToElement(btnAbreisemitFlugzeug).click().perform();
		//btnAbreisemitFlugzeug.click();
		waitForSpinner();
	}
	
	public void btnEigeneAbreiseClick(){
		Actions action = new Actions(driver);
		action.moveToElement(btnEigeneAbreise).click().perform();
		waitForSpinner();
	}
	
	/*
	
	@FindBy(css="div[class='spinner-container']")
	private WebElement spinnerContainerClosed;
	
	public PageObjectTransport waitForSpinnerToBeClosed(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='spinner-container']")));
		return this;
	}
	
	@FindBy(css="div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;
	
	public PageObjectTransport waitForSpinnerToBeOpened(){
		wait.until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		return this;
	}
	
	public PageObjectTransport waitForSpinner(){
		waitForSpinnerToBeOpened();
		waitForSpinnerToBeClosed();
		return this;
	}
*/
	
}
