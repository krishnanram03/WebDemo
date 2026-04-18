package Framework.TestScenarios;


import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import Framework.BaseComponents.Base;
import Framework.PageObjects.CartsPage;
import Framework.PageObjects.CheckOutsPage;
import Framework.PageObjects.LoginPage;
import Framework.PageObjects.ProductsPage;

public class OrderTest extends Base
{
@Test
public void orderPlacement() throws Exception
{
    String [] productNames= {"ADIDAS ORIGINAL","IPHONE 13 PRO"};
	List<String> expectedProductNames=Arrays.asList(productNames);
	
	LoginPage loginPage=goToApplication();
	
	ProductsPage product= loginPage.login("ram03@gmail.com", "Abc@1234");
	product.productSelectionFromList(expectedProductNames);
	
	CartsPage cartPage=product.goToCart();
	
	CheckOutsPage checkoutPage = cartPage.checkOutPage();
	
	checkoutPage.countrySelection("Ind");
	boolean val=checkoutPage.orderVerification(expectedProductNames);
	Assert.assertTrue(val);
	//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart']"))).click();
	
	checkoutPage.clickOnPlaceOrder();
	
	}

/*@DataProvider
public void getData()
{
	Object [][] data= {{"",""},{"",""}};
	
	
}*/
	
	
	
}
