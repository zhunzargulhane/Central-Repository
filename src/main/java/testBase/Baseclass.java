package testBase;


import static testBase.Baseclass.extent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Baseclass {
	//ExcelReader excel;
     public static WebDriver driver;
     public Properties prop;
	 public static Statement s;
	 public static Connection connect;
	 protected static org.apache.logging.log4j.Logger log=LogManager.getLogger(Baseclass.class.getName());
	 public static ExtentTest test;
	 public static ExtentReports extent;
	 public static ExtentHtmlReporter reporter;
	 
	 
	
	
	
	 @BeforeSuite
	 public void intializereport() throws IOException
	 {
		 
		 //System.getProperty("user.dir") +"/test-output/
	//	reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\ProjectExtentReport.html");
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ProjectExtentReport.html");
    	//create extent reports and attach reports
    	extent=new ExtentReports();
    	extent.attachReporter(reporter);
    	System.out.println("This is beforesuite");
	    	
	}
	 @AfterSuite
	 public void reportclose()
	 {
	     extent.flush();
	     System.out.println("This is after suite");
	 } 
	 
	 @BeforeMethod
	public WebDriver initializeDriver() throws IOException
	{
		
		prop=new Properties();
		//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/data.properties");
		prop.load(fis);
		//String browser=System.getProperty("browser");
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/Resources/chromedriver");
			ChromeOptions options=new ChromeOptions();
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			//options.setHeadless(true);
                        options.addArguments("--disable-gpu");
			options.addArguments("--dns-prefetch-disable");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-setuid-sandbox");
                       	options.addArguments("--disable-dev-shm-usage");
                        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        //options.addArguments("--disable-extensions");

                        options.addArguments("--headless");
			//options.addArguments("--window-size=1280x800");
			driver=new ChromeDriver(options);
			//driver=new RemoteWebDriver(new URL("http://3.134.103.191:4444/wd/hub"),options);
		
		}
		else if(browser.equals("firefox"))
		{
		     System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
		     driver=new FirefoxDriver();
			
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String url=prop.getProperty("URL");
		driver.get(url);
		return driver;
		
		
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"\\src\\main\\java\\screenshot\\"+result+"photo.png"));
	}
	public void jdbc() throws SQLException
	{
		String host="localhost";
		String port="330";
		connect=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/zhunzar", "root","Winter@1");
		s=connect.createStatement();
		
	}
	public static String browser;
	
	public WebDriver parallel(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Desktop\\geckodriver.exe");
		     driver=new FirefoxDriver();
	    }
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		return driver;
	}
	//public String[][] getData(String excelName, String sheetName)
	//{ 
		// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
		//String path = System.getProperty("user.dir")+ "/src/main/java/DataSource/"+ excelName;w
		//excel = new ExcelReader(path);
	    //String[][] data = excel.getDataFromSheet(sheetName, excelName);
	    //return data;
	//}
	/*@BeforeMethod
    public void initialzedriver() throws IOException
    {
    	driver=initializeDriver();
    }
	*/
	@AfterMethod
	public void browserclose()
	{
		driver.quit();
	}
}
