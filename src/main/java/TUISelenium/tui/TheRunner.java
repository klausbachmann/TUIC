package TUISelenium.tui;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class TheRunner {

	@Test
	public void theRun(){
		Class[] cls = {ParClass1.class, ParClass2.class, ParClass3.class,
				ParClass1.class, ParClass2.class, ParClass3.class};
		JUnitCore.runClasses(ParallelComputer.classes(), cls);
	}
}
