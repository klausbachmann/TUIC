package TUISelenium.tui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DateFormat df = new SimpleDateFormat("'Screenshot_'dd.MM.YYYY-HH:mm:ss'.png'");
    	System.out.println(df.format(new Date()));
    	
    	WebDriver driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    	System.out.println(driver.manage().timeouts());
    	
    	driver.quit();
    }
}
