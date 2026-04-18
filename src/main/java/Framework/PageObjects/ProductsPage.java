package Framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framwork.Utilities.Reuseable;

public class ProductsPage extends Reuseable
{
	
	WebDriver driver;

	public ProductsPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section[@id='products']//div[@class='row']/div")
	List<WebElement> listOfProducts;
	
	By productText=By.xpath(".//div[@class='card']//b");
	
	By addtoCart = By.xpath(".//button[normalize-space()='Add To Cart']");
	
    By toastMessage=By.cssSelector(".toast-container");
    
    By loginErrorToast=By.cssSelector(".ng-tns-c4-5.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error");
    
    
  
    
    By cartBtn=By.cssSelector("button[routerlink='/dashboard/cart']");
	
	public List<WebElement> getProductList()
	{
		visibilityOfElementLocated(addtoCart);
		return listOfProducts;
	}
	

	public void productSelectionFromList(List<String> expectedProductName)
	{
	
		visibilityOfAllElements(listOfProducts);
		
		getProductList().stream().filter(item->expectedProductName.contains(item.findElement(productText).getText())).forEach(item->
		{
		
	        WebElement button = item.findElement(addtoCart);
	        elementToBeClickable(button);
	        button.click();
	    	//WebElement toastMessage=driver.findElement(By.cssSelector(".toast-container"));
	       invisibilityOfElementLocated(toastMessage);
		}
		);
	}	
		
	public CartsPage goToCart()
	{
		By loader=By.cssSelector(".ng-animating");
		invisibilityOfElementLocated(loader);
		visibilityOfElementLocated(cartBtn);
		driver.findElement(cartBtn).click();
		CartsPage cartPage= new CartsPage(driver);
		
		return cartPage;
	}
	
	public String incorrectLoginMessage()
	{
		return driver.findElement(loginErrorToast).getText();
		
	}
		
}