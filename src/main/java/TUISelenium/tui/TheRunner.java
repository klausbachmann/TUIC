package TUISelenium.tui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TheRunner {

	@Test
	public void theRun(){
		Class[] cls = {ParClass1.class, ParClass2.class, ParClass3.class,
				ParClass1.class, ParClass2.class, ParClass3.class};
		//JUnitCore.runClasses(ParallelComputer.classes(), cls);
	}
}
