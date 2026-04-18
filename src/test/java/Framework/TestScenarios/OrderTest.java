package Framework.TestScenarios;


import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Framework.BaseComponents.Base;
import Framework.PageObjects.CartsPage;
import Framework.PageObjects.CheckOutsPage;
import Framework.PageObjects.LoginPage;
import Framework.PageObjects.ProductsPage;

public class OrderTest extends Base
{
@Test(dataProvider="getData")
public void orderPlacement(String email,String password,List<String> clientProductName) throws Exception
{

	//List<String> expectedProductNames=Arrays.asList(productNames);
	
	LoginPage loginPage=goToApplication();
	
	ProductsPage product= loginPage.login(email, password);
	product.productSelectionFromList(clientProductName);
	
	CartsPage cartPage=product.goToCart();
	
	CheckOutsPage checkoutPage = cartPage.checkOutPage();
	
	checkoutPage.countrySelection("Ind");
	boolean val=checkoutPage.orderVerification(clientProductName);
	Assert.assertTrue(val);
	//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart']"))).click();
	
	checkoutPage.clickOnPlaceOrder();
	
	}

@DataProvider
public Object[][] getData()
{
	Object [][] data= {{"ram03@gmail.com","Abc@1234",Arrays.asList("ADIDAS ORIGINAL")},{"karan2003@gmail.com","Abc@1234",Arrays.asList("ADIDAS ORIGINAL","ZARA COAT 3")}};
	return data;
}
	
	
	
}
