package packagenameyes;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageActions.LandingPage;
import testBase.Baseclass;

public class TextValidationTest extends Baseclass{
	public static ExtentTest test;
	public static ExtentReports extent;
	
	
	@Test
	public void textvalidation() throws IOException, InterruptedException
	{
		
		//LandingPage aa=new LandingPage(driver);
    	
		LandingPage lp=new LandingPage(driver);
		
		log.debug("Trying to close the pop up window");
		//Thread.sleep(5000*6);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(lp.popup()));
		lp.popup().click();
		log.info("pop up window is closed successfully");
		/*super.browserclose();
		Thread.sleep(5000);
		super.initializeDriver();
		LandingPage lp1=new LandingPage(driver);
		wait.until(ExpectedConditions.visibilityOf(lp1.popup()));
		lp1.popup().click();*/
		//compare the text from browser with our actual value 
		// and if anything fails then it should stop the execution
		log.debug("comparing the title");
		String gettext=lp.featured().getText();
		Assert.assertEquals(gettext,"FEATURED COURSES");
		log.info("done successfully");
		
		//boolean boo=lp1.navigation().isDisplayed();
		//Assert.assertTrue(boo);
	//	Assert.assertFalse(boo);
		//System.out.println(gettext);
	}
	
	
	
}
