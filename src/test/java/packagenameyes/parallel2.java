package packagenameyes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.Baseclass;

public class parallel2 extends Baseclass {
	public static WebDriver driver;
	@Test
	public void test1()
	{
		driver=parallel("chrome");
		driver.get("https://facebook.com");
		
		
	}


}
