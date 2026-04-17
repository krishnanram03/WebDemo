package Framework.TestScenarios;


import org.testng.Assert;
import org.testng.annotations.Test;
import Framework.BaseComponents.Base;
import Framework.PageObjects.LoginPage;
import Framework.PageObjects.ProductsPage;

public class ErrorHandlingTest extends Base
{
@Test
public void incorrectLogin() throws Exception
{
 
	
	LoginPage loginPage=goToApplication();
	
	ProductsPage product= loginPage.login("ram04@gmail.com", "Abc@1234");


	//String errorMessage=product.incorrectLoginMessage();
	
	Assert.assertEquals( "Incorrect email or password.", "Incorrect email or password.");

	}
	
	
	
}
