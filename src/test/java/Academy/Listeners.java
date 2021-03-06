package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener 
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> tlextentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		
		test=extent.createTest(result.getMethod().getMethodName());
		tlextentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		tlextentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result)
	{
		tlextentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try 
		{
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try 
		{
			tlextentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver) ,result.getMethod().getMethodName());
		
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}
