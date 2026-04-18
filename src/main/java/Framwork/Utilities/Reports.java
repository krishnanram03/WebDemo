package Framwork.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports 
{
	
	public static ExtentReports getReport()
	{
    String reportsPath = System.getProperty("user.dir")+"\\reports\\index"+".html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(reportsPath);
	
	reporter.config().setDocumentTitle("Test Automation Result");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setReportName("Framework Automation Result");
	
	ExtentReports report= new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("OS", "Windows 11");
	report.setSystemInfo("QA Reporter", "Ramkumar");
	report.setSystemInfo("Browser", "chrome");
	//report.createTest(reportsPath);
	return report;
}
}