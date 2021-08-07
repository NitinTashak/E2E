package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;



public class HomePage extends base
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL");

		LandingPage l = new LandingPage(driver);
		LoginPage lp=l.getLogin();
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(text);
		lp.getLogin().click();
		ForgotPasswordPage fpp=lp.getForgotPassword();
		fpp.getEmail().sendKeys("nitintrerji@jf.com");
		fpp.getSendmeinstructions().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "nonrestrices@gmail.com";
		data[0][1] = "3242342343";
		data[0][2] = "Nitin";
		
		data[1][0] = "restrices@gmail.com";
		data[1][1] = "54344435345";
		data[1][2] = "Ayush";
		
		return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
