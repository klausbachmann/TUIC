package TUISelenium.tuic.ibe.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectWishcabin extends BasePageObjects{
	WebDriver driver;
	
	public PageObjectWishcabin(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public enum CategoryCode {INAW, INBW, INCW, 
								AUAW, AUBW,
								BAAW, BABW, BACW, BADW, BAEW, BAFW, BAGW, BASW,
								VEPW,
								FAAW, FABW, FAMW,
								JBAW, SUSW}
	
	            
	@FindBy(css="a[class='button button-cta button-next-page ']")
	@CacheLookup
	private WebElement buttonNext;
	
	private WebElement input_cabincategory_categorycode;
	
	private WebElement input_cabindeck_decknumber;
	
	private WebElement input_cabinselection_cabinnumber;
	
	private WebElement CabinNumberValidate;
	
	@FindBy(css = "a[class='js-check-cabin-availability button']")
	private WebElement btnCheckCabin;
	
	@FindBy(css = "div[class^='alert-container']")
	private WebElement alertContainer;
	
	public void selectPriceCategoryByCode(CategoryCode code){
		new Select(input_cabincategory_categorycode).selectByValue(code.toString());
		waitForSpinner();
	}
	
	public void selectPriceCategoryByIndex(int index){
		new Select(input_cabincategory_categorycode).selectByIndex(index);
		waitForSpinner();
	}
	
	public void selectDeckNumber(String decknumber){
		new Select(input_cabindeck_decknumber).selectByValue(decknumber);
		waitForSpinner();
	}
	
	public void selectCabinNumber(int cabinNumber){
		new Select(input_cabinselection_cabinnumber).selectByValue(Integer.toString(cabinNumber));
		waitForSpinner();
	}
	
	public void setWishCabin(int cabinNumber){
		CabinNumberValidate.sendKeys(Integer.toString(cabinNumber));
	}
	
	public void btnCheckCabinClick(){
		btnCheckCabin.click();
	}
	
	public void btnSelectCabinClick(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(alertContainer)); 
		alertContainer.findElement(By.cssSelector("a[class='button js-confirm']")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(alertContainer));
	}
	
	public void clickNextButton(){
		System.out.println("*** btnNextClick from WishCabin");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonNext));
		System.out.println("*** ");
		Actions action = new Actions(driver);
		action.moveToElement(buttonNext).click().perform();
		waitForSpinner();
	}
	
}
