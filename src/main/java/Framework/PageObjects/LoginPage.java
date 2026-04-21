package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framwork.Utilities.Reuseable;

public class LoginPage extends Reuseable
{
WebDriver driver;

 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 super(driver);
	 PageFactory.initElements(driver, this);
 }
	
	@FindBy(id="userEmail")
	private WebElement userName;
	
	@FindBy(id="userPassword")
	private WebElement userPassword;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	

	public ProductsPage login(String username,String password)
	{
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginBtn.click();
		ProductsPage product= new ProductsPage(driver);
		return product;
				
				
	}


}
