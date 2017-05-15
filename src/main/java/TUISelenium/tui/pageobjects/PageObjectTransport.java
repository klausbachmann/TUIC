package TUISelenium.tui.pageobjects;

import java.util.List;
import java.util.Random;

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
	List<WebElement> shipBoundAirportList;
	
	public PageObjectTransport(WebDriver driver){
		super(driver);
		this.driver = driver;
		driver.manage().window().maximize();
		this.wait = new WebDriverWait(driver, 30);
	}

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public void clickNextButton(){
		System.out.println("*** btnNextClick from Transport");
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(buttonNext));
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
	}
	
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
		shipBoundAirportList = shipBoundAirports.findElements(By.tagName("option"));
		for( WebElement e:shipBoundAirportList){
			System.out.println(e.getText().trim());
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
	
	
	public void selectShipboundAirportByIndex(int index){
		
		Select dropdown = new Select(shipBoundAirports);
		
		dropdown.selectByIndex(index);
		
		waitForSpinner();
	}
	
	
	public void selectHomeboundAirportByIndex(int index){
		
		Select dropdown = new Select(homeBoundAirports);
		
		dropdown.selectByIndex(index);
		
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
	
	
}
