package TUISelenium.tui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    }
}
