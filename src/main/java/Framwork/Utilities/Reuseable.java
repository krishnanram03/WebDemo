package Framwork.Utilities;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reuseable {

WebDriver driver;
WebDriverWait wait;

	public Reuseable(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	
	
	public void visibilityOfElementLocated(By locator)
	{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 
	}
	
	
	
	public void visibilityOfAllElements(List<WebElement> elements)
	{
	 wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}


	
	public void invisibilityOfElementLocated(By locator)
	{
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	

	public void elementToBeClickable(WebElement element)
	{
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	  public void goToCheckOut(By locator)
	  {
		  visibilityOfElementLocated(locator);
		  driver.findElement(locator).click();
	  }
	  
	  public String getScreenshot(String methodName) throws Exception
	  {
		  File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      File createFile= new File(System.getProperty("user.dir")+"\\Screenshots\\"+methodName+".png");
	      FileUtils.copyFile(source,createFile);
	      return System.getProperty("user.dir")+"\\Screenshots\\"+methodName+".png";
	  }
}
