package org.seleniumhq.selenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppiumTest {
     @Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void automate(String URL) {
    	 System.out.println(URL);
		System.out.println("automate");
	}
	@Test
	public void UI() {
		System.out.println("UI");
	}
	
	
	
	
}
