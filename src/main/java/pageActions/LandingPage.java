package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
   public WebDriver driver;
   
  public  LandingPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
    @FindBy(xpath="//div[@class='sumome-react-wysiwyg-popup-animation-group']/span/div/div[7]/div")
	private WebElement popup;
   
	@FindBy(xpath="//nav[@class='pull-right']/ul/li[4]/a/i")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement featured;
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	private WebElement navigation;
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']/ul/li[5]/a")
	private WebElement practice;
	
	public WebElement navigation()
	{
		return navigation;
	}
	
	public WebElement featured()
	{
		return featured;
	}
	
	public WebElement popup()
	{
		return popup;
		
	}
	
	public WebElement practice()
	{
		return practice;
	}
	
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	
	
}
