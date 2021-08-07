package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='sign_in']")
	private WebElement login;
	
	@FindBy(css="[class='text-center'] h2")
	private WebElement title;
	
	@FindBy(css="[class='navbar navbar-default navbar-static-top'] ")
	private WebElement NavBar;
	
	@FindBy(css="[class*='video-banner'] h3")
	private WebElement header;
	
	public LoginPage getLogin()
	{
		login.click();
		return new LoginPage(driver);
	}
	
	
	public WebElement getTitle()
	{
		return title;
	}
	
	public WebElement getNavigationBar()
	{
		return NavBar;
	}
	
	public WebElement getHeader()
	{
		return header;
	}

}
