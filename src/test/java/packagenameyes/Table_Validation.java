package packagenameyes;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.LandingPage;
import testBase.Baseclass;

public class Table_Validation extends Baseclass {
	boolean bb=false;
	public static WebDriver driver;
	@BeforeMethod
    public void initialzedriver() throws IOException
    {
    	driver=initializeDriver();
    }
	
	@Test
	public void test()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		LandingPage l=new LandingPage(driver);
		l.popup().click();
	    l.practice().click();
	    List<WebElement> rownum=driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
	    int a=rownum.size();
	    System.out.println(a);
	    List<WebElement> colnum=driver.findElements(By.xpath("//table[@id='product']/tbody/tr[1]/th"));
	    int b=colnum.size();
	    System.out.println(b);
	    String temp="";

	    for(int i=2;i<=a;i++)
	    {
	    	for(int j=1;j<=b;j++)
	    	{
	    		temp=driver.findElement(By.xpath("//table[@id='product']/tbody/tr["+i+"]/td["+j+"]")).getText();
	    		if(temp.contains("Appium (Selenium) - Mobile Automation Testing from Scratch"))
	    		{
	    			bb=true;
	    			break;
	    		}
	    	}
	    }
	    
	   if(bb==true)
	   {
		  System.out.println("Data");
	   }
	   else
	  {
		  System.out.println("No Data");
	  }
	    
 } 
}




/*WebDriver driver;
Baseclass jd=new Baseclass();
@BeforeMethod
public void initializedriver() throws IOException
{
	driver=initializeDriver();
}
@Test
public void Fetchdata() throws SQLException
{
	LandingPage lp=new LandingPage(driver);
	lp.popup().click();
	jd.jdbc();
	ResultSet rs=s.executeQuery("select * from employeeinfo where id=2000");
	rs.next();
	lp.loginbutton().click();
	Loginpage lp1=new Loginpage(driver);
	//Thread.sleep(5000);
    lp1.Email().sendKeys(rs.getString("name"));
	lp1.Password().sendKeys(rs.getString("location"));
	lp1.LogIn().submit();
}
@AfterMethod
public void closebrowser()
{
	driver.close();
}

*/
