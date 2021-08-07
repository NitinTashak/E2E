package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage
{
	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(name="commit")
	private WebElement Sendmeinstructions;
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getSendmeinstructions()
	{
		return Sendmeinstructions;
	}
	

}
