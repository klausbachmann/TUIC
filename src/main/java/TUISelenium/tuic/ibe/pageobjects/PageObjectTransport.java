package TUISelenium.tuic.ibe.pageobjects;

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
	List<WebElement> shipBoundAirportList;
	
	public PageObjectTransport(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "div[class='booking-pager bottom'] > div > div > a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	public void clickNextButton(){
		System.out.println("*** btnNextClick from Transport");
		new WebDriverWait(driver,45).until(ExpectedConditions.elementToBeClickable(buttonNext));
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
	}
	
	@FindBy(id="input_shipboundtransporttype_type_0")
	private WebElement btnAnreisemitFlugzeug;
	
	@FindBy(id="input_shipboundtransporttype_type_1")
	private WebElement btnEigeneAbreiseShipBound;
	
	@FindBy(id="input_homeboundtransporttype_type_0")
	private WebElement btnAbreisemitFlugzeug;
	
	@FindBy(id="input_homeboundtransporttype_type_1")
	private WebElement btnEigeneAbreiseHomeBound;
	
	@FindBy(id="input_shipboundairport_airportcode")
	private WebElement shipBoundAirports;

	@FindBy(id="input_homeboundairport_airportcode")
	private WebElement homeBoundAirports;
	
	@FindBy(css = "input[id^='train-upgrade']:first-child")
	private WebElement trainToPlaneShipBound;
	
	@FindBy(css = "input[id^='train-upgrade']:last-child")
	private WebElement trainToPlaneHomeBound;
	
	@FindBy(id = "input_shipboundbus_busid")
	private WebElement busShipBound;
	
	@FindBy(id = "input_homeboundbus_busid")
	private WebElement busHomeBound;
	
	@FindBy(id = "input_shipboundrailwaystation_stationname")
	private WebElement trainShipBound;
	
	@FindBy(id = "input_homeboundrailwaystation_stationname")
	private WebElement trainHomeBound;
	
	@FindBy(id = "input_shipboundtrain_1_serviceid_travel_class_2")
	private WebElement trainShipBound2ndClass;
	
	@FindBy(id = "input_shipboundtrain_1_serviceid_travel_class_1")
	private WebElement trainShipBound1stClass;
	
	@FindBy(id = "input_shipboundtrain_1_serviceid_reduction_fare")
	private WebElement trainBahncardPerson1;
	
	@FindBy(id = "input_shipboundtrain_2_serviceid_reduction_fare")
	private WebElement trainBahncardPerson2;
	
	@FindBy(id = "input_shipboundtrain_3_serviceid_reduction_fare")
	private WebElement trainBahncardPerson3;
	
	@FindBy(id = "input_shipboundtrain_4_serviceid_reduction_fare")
	private WebElement trainBahncardPerson4;
	
	public void outputAllAirports(){
		shipBoundAirportList = shipBoundAirports.findElements(By.tagName("option"));
		for( WebElement e:shipBoundAirportList){
			System.out.println(e.getText().trim());
		}
	}
	
	public void selectShipboundAirportByName(String airport){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(shipBoundAirports));
		Select dropdown = new Select(shipBoundAirports);
		dropdown.selectByVisibleText(airport);
		waitForSpinner();
	}
	
	
	public void selectHomeboundAirportByName(String airport){
		
		try {
			Select dropdown = new Select(homeBoundAirports);
			
			dropdown.selectByVisibleText(airport);
			
			waitForSpinner();
		} catch (Exception e) {
			org.testng.Assert.fail("Kann Fughafen " +  airport + " nicht finden");
			}

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
		waitForSpinner();
	}
	
	public void btnEigeneAbreiseHomeBoundClick(){
		Actions action = new Actions(driver);
		action.moveToElement(btnEigeneAbreiseHomeBound).click().perform();
		waitForSpinner();
	}
	
	public void btnEigeneAbreiseShipBoundClick(){
//		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btnEigeneAbreiseShipBound));
		Actions action = new Actions(driver);
		action.moveToElement(btnEigeneAbreiseShipBound).click().perform();
		waitForSpinner();
	}
	
	public void selectFirstClassShipBound(){
		new Actions(driver).moveToElement(trainToPlaneShipBound).click().perform();
		waitForSpinner();
	}
	
	public void selectFirstClassHomeBound(){
		new Actions(driver).moveToElement(trainToPlaneHomeBound).click().perform();
		waitForSpinner();
	}
	
	public void selectBusShipBoundByString(String busstop){
		new Select(busShipBound).selectByVisibleText(busstop);
		waitForSpinner();
	}
	
	public void selectBusHomeBoundByString(String busstop){
		new Select(busHomeBound).selectByVisibleText(busstop);
		waitForSpinner();
	}
	
	public void selectTrainShipBound(String trainstation){
		trainShipBound.clear();
		trainShipBound.sendKeys(trainstation);
		waitForSpinner();
		driver.findElement(By.cssSelector("li [id^='input_shipboundrailwaystation_stationname_suggestions'], [data-value='"+ trainstation+"']")).click();
		waitForSpinner();
	}
	
	public void selectTrainHomeBound(String trainstation){
		trainHomeBound.clear();
		trainHomeBound.sendKeys(trainstation);
		waitForSpinner();
		driver.findElement(By.cssSelector("li [id^='input_homeboundrailwaystation_stationname_suggestions'], [data-value='"+ trainstation+"']")).click();
		waitForSpinner();
	}
	
	public void selectShipBoundTrainFirstClass(){
	    new Actions(driver).moveToElement(trainShipBound1stClass).click().perform();
	    waitForSpinner();
	}
	
	public void selectShipBoundTrainSecondClass(){
	    new Actions(driver).moveToElement(trainShipBound2ndClass).click().perform();
	    waitForSpinner();
	}
	
	public void selectBahncardPerson1(){
		new Actions(driver).moveToElement(trainBahncardPerson1).click().perform();
		waitForSpinner();
	}
	
	public void selectBahncardPerson2(){
		new Actions(driver).moveToElement(trainBahncardPerson2).click().perform();
		waitForSpinner();
	}
	
	public void selectBahncardPerson3(){
		new Actions(driver).moveToElement(trainBahncardPerson3).click().perform();
		waitForSpinner();
	}
	
	public void selectBahncardPerson4(){
		new Actions(driver).moveToElement(trainBahncardPerson4).click().perform();
		waitForSpinner();
	}
	
	
}
