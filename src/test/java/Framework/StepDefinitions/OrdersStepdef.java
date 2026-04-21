package Framework.StepDefinitions;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Framework.BaseComponents.Base;
import Framework.PageObjects.CartsPage;
import Framework.PageObjects.CheckOutsPage;
import Framework.PageObjects.LoginPage;
import Framework.PageObjects.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrdersStepdef extends Base
{


   WebDriver driver;
	LoginPage loginPage;
	ProductsPage product;
	CheckOutsPage checkoutPage;
	CartsPage cartPage;
	boolean val;
	@Given("I landed on login page")
	public void I_landed_on_login_page() throws Exception
	{
		driver=setup();
		loginPage=goToApplication();
	}
	
	@Given ("login with the {string} and {string}")
	public void login_with_the_username_and_password(String username,String password)
	{
		product= loginPage.login(username, password);
		
	}
	
	@When("I click on {string} to add to cart")
	public void when_I_click_on_product_to_add_to_cart(String prodName) throws Exception
	{
		List<String> expectedProdName=Arrays.asList(prodName);
		product.productSelectionFromList(expectedProdName);
		
		cartPage=product.goToCart();
		
		checkoutPage = cartPage.checkOutPage();
		checkoutPage.countrySelection("Ind");
		val=checkoutPage.orderVerification(expectedProdName);
	}
	
	@Then("Click on the cart button and proceed to checkout page for payment")
	public void click_on_the_cart_button_and_proceed_to_checkout_page_for_payment() 
	{
		Assert.assertTrue(val);
		checkoutPage.clickOnPlaceOrder();
	}
	
	
	
	@And("product order should be displayed on the order page")
	public void product_order_should_be_displayed_on_the_order_page()
	{

		tearDown();
	}
	
	
}
