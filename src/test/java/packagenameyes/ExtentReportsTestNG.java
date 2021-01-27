package packagenameyes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testBase.Baseclass;

public class ExtentReportsTestNG extends Baseclass {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports extent;
    @BeforeClass
    public void intializereport() throws IOException
    {
    	ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\user\\projectnameyes\\test-output\\ProjectExtentReport.html");
    	//create extent reports and attach reports
    	ExtentReports extent=new ExtentReports();
    	extent.attachReporter(reporter);
    	test=extent.createTest("Google open","Verify opening of google test");
    	
    	
    }	
    @AfterClass
    public void reportclose()
    {
    /*	test.log(Status.INFO,"Going to initialize the driver");
    	test.pass("Opened the browser successfully");
    	//driver=initializeDriver();
    	test.log(Status.INFO,"initialization of driver is completed successfully");
    	
    	//driver.quit();
    	test.pass("Completed and closed the browser");
    	
    */	
    	extent.flush();
    	
    }
    
    /*@Test
    public void open()
    {
    	//run the case i.e create a new test
    	 
    }
    @AfterClass
    public void close()
    {
    	
    }*/
} 