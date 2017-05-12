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
	//WebDriverWait wait;
	//Actions action;

	public BasePageObjects() {
	}

	public BasePageObjects(WebDriver driver) {
		this.driver = driver;
		//this.wait = wait;//new WebDriverWait(driver, 10);
		//action = new Actions(driver);
	}

	@FindBy(css = "div[class='spinner-container']")
	private WebElement spinnerContainerClosed;

	public void waitForSpinnerToBeClosed() {
		System.out.println("*** SPINNER: WAIT FOR CLOSE");
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class^='spinner-container']")));
		System.out.println("*** SPINNER: CLOSED!");
		// return this;
	}

	@FindBy(css = "div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;

	public void waitForSpinnerToBeOpened() {
		System.out.println("*** SPINNER: WAIT FOR OPEN");
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		System.out.println("*** SPINNER: OPEN!");
		// return this;
	}

	public void waitForSpinner() {
		waitForSpinnerToBeOpened();
		waitForSpinnerToBeClosed();
		// return this;
	}

}
