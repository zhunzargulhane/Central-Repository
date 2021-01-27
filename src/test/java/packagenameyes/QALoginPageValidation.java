package packagenameyes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageActions.LandingPage;
import pageActions.Loginpage;
import testBase.Baseclass;
import testBase.Excelutility;

public class QALoginPageValidation extends Baseclass {
	
	


    @Test(dataProvider="getData")
	public void basepagenavigation(String Email,String Password) throws IOException, InterruptedException
	{
   		LandingPage l=new LandingPage(driver);
		l.popup().click();
		l.loginbutton().click();
		Loginpage lp=new Loginpage(driver);
		Thread.sleep(5000);
	    lp.Email().sendKeys(Email);
		lp.Password().sendKeys(Password);
		lp.LogIn().submit();
		Thread.sleep(5000);
		//driver.close();
		
	}
	
	
    @DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types of values 
		//column stands for how many values for each test case
		Object[][] obj=new Object[2][2];
		obj[0][0]="nonrestricteduser@gmail.com";
		obj[0][1]="6516156";
		
		obj[1][0]="restricteduser@gmail.com";
		obj[1][1]="5644645";
		return obj;
	}

    /*@DataProvider(name="getData")
    public String[][] getTestData()
	{
		String[][] testRecords = getData("test12.xlsx","Sheet1");
		return testRecords;
	}*/
	/*@DataProvider(name="getData")
    public Object[][] getTestData() throws IOException
	{
		Object[][] testRecords = Excelutility.Getexcel("E:\\test12.xlsx", "Sheet1","login");
		return testRecords;
	}*/
	
}
