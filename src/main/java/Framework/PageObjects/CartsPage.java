package Framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framwork.Utilities.Reuseable;

public class CartsPage extends Reuseable

{
WebDriver driver;
	public CartsPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}

  private By checkOutBtn=By.xpath("//button[text()='Checkout']");

  public CheckOutsPage checkOutPage()
  {
	  goToCheckOut(checkOutBtn);
	  
	  CheckOutsPage checkoutPage = new CheckOutsPage(driver);
	  
	  return checkoutPage;
  }

}
