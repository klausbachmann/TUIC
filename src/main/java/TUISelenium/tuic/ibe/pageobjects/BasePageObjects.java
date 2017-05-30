package TUISelenium.tuic.ibe.pageobjects;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObjects {
	WebDriver driver;
	public long webdriverWait = 45;

	public BasePageObjects() {
	}

	public BasePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div[class='spinner-container']")
	private WebElement spinnerContainerClosed;

	public void waitForSpinnerToBeClosed() {
		System.out.println("*** SPINNER: WAIT FOR CLOSE");
		new WebDriverWait(driver, 30).until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class^='spinner-container']")));
		System.out.println("*** SPINNER: CLOSED!");
	}

	@FindBy(css = "div[class^='spinner-container']")
	private WebElement spinnerContainerOpen;

	public void waitForSpinnerToBeOpened() {
		System.out.println("*** SPINNER: WAIT FOR OPEN");
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(spinnerContainerOpen));
		System.out.println("*** SPINNER: OPEN!");
	}

	/**
	 * <b>Ladekringel Bildschirm</b><p>
	 * Nach einigen Operationen in der IBE wird<p>
	 * der Ladekringel "Spinner" ausgelöst. Diese Funktion
	 * wartet, bis der Ladekringel geöffnet und wieder geschlossen wird
	 */
	public void waitForSpinner() {
		try {
			waitForSpinnerToBeOpened();
			waitForSpinnerToBeClosed();
		} catch (Exception e) {
			System.out.println("Spinner Exception");
		}
		
	}

	public void takeScreenshot() {
		try {
			DateFormat df = new SimpleDateFormat("'Screenshot_'dd.MM.YYYY-HH-mm-ss'.png'");
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("./target/Screenshots/" + df.format(new Date())));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
