package TUISelenium.tui;

import junit.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest{
	WebDriver driver;
	
	@Before
	public void beforeTest() throws Exception{
		driver = new FirefoxDriver();
		//driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		
		driver.get("http://tuicruises:vj4oq4IH@meinereise-e2e.yourstruly.space/");
	}
	
	//@Test
	public void TheTest() throws Exception{
		//driver.get("http://tuicruises:vj4oq4IH@meinereise-e2e.yourstruly.space");
		
		driver.findElement(By.id("firstname")).sendKeys("Mario");
		driver.findElement(By.id("lastname")).sendKeys("Borg");
		driver.findElement(By.id("bookingNumber")).sendKeys("617816");
		//Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/div/div[2]/div/form/div[4]/button")).click();
		
		Thread.sleep(10000);

		//driver.findElement(By.name("Schönheit & Gesundheit")).click();
		driver.findElement(By.linkText("/schoenheit-und-gesundheit")).click();
		driver.findElement(By.linkText("/schoenheit-und-gesundheit/spa")).click();
		driver.findElement(By.linkText("/schoenheit-und-gesundheit/spa/9")).click();
		driver.findElement(By.linkText("/schoenheit-und-gesundheit/spa/9/MA002")).click();
		
		driver.findElement(By.linkText("/schoenheit-und-gesundheit/spa/9/MA002/2")).click();
		
		Select selector = new Select(driver.findElement(By.className("el-form-Dropdown__select")));
		selector.selectByVisibleText("Mario Borg");
		
		Thread.sleep(3000);
		
	}

	//@Test
	public void TestAnother() throws Exception{
		
		System.out.println("Anmeldung...");
		driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys("Mario");
	    driver.findElement(By.id("lastname")).clear();
	    driver.findElement(By.id("lastname")).sendKeys("Borg");
	    driver.findElement(By.id("bookingNumber")).clear();
	    driver.findElement(By.id("bookingNumber")).sendKeys("617816");
	    driver.findElement(By.cssSelector("button.el-Button.dark")).click();
	    System.out.println("Anmeldung lübbt");
	    driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[2]/div[2]/a[2]/div[2]")).click();
	    driver.findElement(By.linkText("SPA & Meer")).click();
	    driver.findElement(By.linkText("Massagen")).click();
	    driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[4]/a[2]/div/div")).click();
	    driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[4]/div/div/div/a[3]/ul")).click();
	    System.out.println("SPA Anwendung für Mario Borg buchen");
	    new Select(driver.findElement(By.cssSelector("select.el-form-Dropdown__select"))).selectByVisibleText("Mario Borg");
	    new Select(driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[3]/div[2]/div/fieldset/label[2]/select"))).selectByVisibleText("9:25");
	    
	    driver.findElement(By.xpath("//div[@id='app']/div/header/div/div/div[2]/div/div[2]/a/span")).click();
	    
	    Thread.sleep(5000);
	}
	
	@Test
	public void TestTableRes() throws Exception{
		driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys("Lothar");
	    driver.findElement(By.id("lastname")).clear();
	    driver.findElement(By.id("lastname")).sendKeys("Winter");
	    driver.findElement(By.id("bookingNumber")).clear();
	    driver.findElement(By.id("bookingNumber")).sendKeys("509309");
	    driver.findElement(By.cssSelector("button.el-Button.dark")).click();
	    /*driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[2]/div/a[3]/div")).click();
	    driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[2]/a/div")).click();
	    driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[4]/div/div/div/a[3]/div[2]")).click();
	    new Select(driver.findElement(By.cssSelector("select.el-form-Dropdown__select"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.xpath("//div[@id='app']/div/main/div/div[2]/div[3]/div[2]/div/fieldset/label[2]/select"))).selectByVisibleText("18:30");
	    Thread.sleep(10000);
	    */
	    List<WebElement> linksonstartpage;
	    linksonstartpage = driver.findElements(By.className("c-tiles-Tile"));
	    System.out.println(linksonstartpage.size());
	    Iterator<WebElement> it = linksonstartpage.iterator();
	    String currentURL = driver.getCurrentUrl();
	    while(it.hasNext()){
	    	WebElement web = it.next();
	    	System.out.println("Text: " + web.getText());
	    	
	    	web.click();
	    	Thread.sleep(2000);
	    	System.out.println(driver.getCurrentUrl());
	    	driver.navigate().to(currentURL);
	    }
	}
	
	@After
	public void AfterTest(){
		driver.quit();
	}
}
