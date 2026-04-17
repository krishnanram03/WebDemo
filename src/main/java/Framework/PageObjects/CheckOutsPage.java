package Framework.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framwork.Utilities.Reuseable;

public class CheckOutsPage extends Reuseable
{
	WebDriver driver;
	String []actualProd;

	public CheckOutsPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrySelectionBox;

	By placeOrder =By.cssSelector(".btnn.action__submit.ng-star-inserted");


	//@FindBy(xpath="//div[@class='item__details']//div[@class='item__title']")
	//WebElement orderDetails;


	public void countrySelection(String country) throws Exception
	{
		countrySelectionBox.sendKeys(country);
		By countryDropdown=By.cssSelector(".ta-item.list-group-item.ng-star-inserted");
		visibilityOfElementLocated(countryDropdown);
		List<WebElement> dropdown=driver.findElements(countryDropdown);
		//System.out.println(dropdown);

		WebElement identified=dropdown.stream().filter(item->item.findElement(By.xpath(".//span")).getText().trim().equalsIgnoreCase("India")).findFirst().orElse(null);
		identified.click();

	}

	public boolean orderVerification(List<String> expectedProductNames)
	{
     
	List<WebElement> orderPageList=driver.findElements(By.xpath("//div[@class='item__details']"));
	
	boolean val=orderPageList.stream().anyMatch(item->expectedProductNames.contains(item.findElement(By.xpath(".//div[@class='item__title']")).getText().trim().toUpperCase()));
 
	System.out.println(val);
     return val;
	}

	public void clickOnPlaceOrder()
	{
		driver.findElement(placeOrder).click();
	}

}
