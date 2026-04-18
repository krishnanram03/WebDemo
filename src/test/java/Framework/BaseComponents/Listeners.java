package Framework.BaseComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Framwork.Utilities.Reports;
import Framwork.Utilities.Reuseable;

public class Listeners extends Reports implements ITestListener

{
ExtentReports report=Reports.getReport();;
ExtentTest extest;
Reuseable reuse;
WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) 
	{
		
		extest=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extest.log(Status.PASS,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String path = null;
		extest.fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reuse= new Reuseable(driver);
		try {
			path=reuse.getScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extest.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
	
	}

	@Override
	public void onStart(ITestContext context) 
	{
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}
