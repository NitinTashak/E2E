package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(name="commit")
	private WebElement login;
	
	@FindBy(linkText="Forgot Password?")
	private WebElement ForgotPassword;
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLogin()
	{
		return login;
	}
	
	public ForgotPasswordPage getForgotPassword()
	{
		ForgotPassword.click();
		return new ForgotPasswordPage(driver); 
	}

}
