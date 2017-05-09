package TUISelenium.tui;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import au.com.bytecode.opencsv.CSVReader;

public class MassData {
	WebDriver driver;
	
	@Before
	public void beforeTest(){
		driver = new FirefoxDriver();
		//driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		driver.get("http://tuicruises:vj4oq4IH@meinereise-e2e.yourstruly.space/");

		
	}

	@Test
	public void insertMassData() throws Exception{
		
		//FileInputStream file = new FileInputStream(new File("testfile.xls"));
		CSVReader csvReader = new CSVReader(new FileReader("MSV1601.csv"),';');
		
		//HSSFWorkbook wb = new HSSFWorkbook(file);
		//HSSFSheet sheet = wb.getSheetAt(0);
		String vorname = "";
		String nachname = "";
		String[] row = null;
		
		//Iterator<Row> iterator = sheet.iterator();
		//while( iterator.hasNext()){
			//Row row = iterator.next();
		while((row = csvReader.readNext()) != null){	
			
			String[] split = row[1].split("/");
			vorname = split[1];
			nachname = split[0];
			String vorgang = row[0];
			
			System.out.println(vorgang+":"+vorname + ":" + nachname);
			
			//login
			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("bookingNumber")).clear();
			driver.findElement(By.id("firstname")).sendKeys(split[1]);
			driver.findElement(By.id("lastname")).sendKeys(split[0]);
			driver.findElement(By.id("bookingNumber")).sendKeys(vorgang);
			//Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/div/div[2]/div/form/div[4]/button")).click();
			
			Thread.sleep(3000);
			
			//book day0
			driver.get("https://meinereise-e2e.yourstruly.space/schoenheit-und-gesundheit/spa/9/MA002/0");
			WebElement selector = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label/select"));
			new Select(selector).selectByIndex(1);
			Thread.sleep(3000);
			
			WebElement sel2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label[2]/select"));
			new Select(sel2).selectByIndex(2);
			driver.findElement(By.cssSelector("#app > div > main > div > div.app-his-Booking > div:nth-child(3) > div.l-Col.right > div > div > button")).click();
			Thread.sleep(3000);
			
			// book day 1
			driver.get("https://meinereise-e2e.yourstruly.space/schoenheit-und-gesundheit/spa/9/MA002/1");
			selector = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label/select"));
			new Select(selector).selectByIndex(1);
			Thread.sleep(2000);
			
			sel2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label[2]/select"));
			new Select(sel2).selectByIndex(2);
			driver.findElement(By.cssSelector("#app > div > main > div > div.app-his-Booking > div:nth-child(3) > div.l-Col.right > div > div > button")).click();
			Thread.sleep(3000);
			
			//book day 2
			driver.get("https://meinereise-e2e.yourstruly.space/schoenheit-und-gesundheit/spa/9/MA002/2");
			selector = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label/select"));
			new Select(selector).selectByIndex(1);
			Thread.sleep(2000);
			
			sel2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label[2]/select"));
			new Select(sel2).selectByIndex(2);
			driver.findElement(By.cssSelector("#app > div > main > div > div.app-his-Booking > div:nth-child(3) > div.l-Col.right > div > div > button")).click();
			Thread.sleep(3000);		
			
			// book day 3
			driver.get("https://meinereise-e2e.yourstruly.space/schoenheit-und-gesundheit/spa/9/MA002/3");
			selector = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label/select"));
			new Select(selector).selectByIndex(1);
			Thread.sleep(2000);
			
			sel2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[3]/div[2]/div/fieldset[1]/label[2]/select"));
			new Select(sel2).selectByIndex(2);
			driver.findElement(By.cssSelector("#app > div > main > div > div.app-his-Booking > div:nth-child(3) > div.l-Col.right > div > div > button")).click();
			Thread.sleep(3000);	
			
			
			//logoff
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div[1]/div/div[2]/div/div[2]/a")).click();
		
		}
		
		//wb.close();
		csvReader.close();

	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
