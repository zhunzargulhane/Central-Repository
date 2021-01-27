package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public  Loginpage(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver,this);
	   }
	
	public WebDriver driver;
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement Email;
	
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Log In']")
    WebElement LogIn;	

	
	public WebElement Email()
	{
		return Email;
		
	}
	
	public WebElement Password()
	{
		return Password;
	}
	public WebElement LogIn()
	{
		return LogIn;
	}
	
	
}
