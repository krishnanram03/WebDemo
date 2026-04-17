package Framework.TestScenarios;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Framework.PageObjects.LoginPage;
import Framework.PageObjects.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Original_Code 
{
@Test
public void orderPlacement()
{

	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
    String [] productNames= {"ADIDAS ORIGINAL","IPHONE 13 PRO"};
	driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	LoginPage loginPage= new LoginPage(driver);
	loginPage.login("ram03@gmail.com", "Abc@1234");
	

	List<String> expectedProductNames=Arrays.asList(productNames);
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add To Cart']")));
	
	List<WebElement> listOfProducts=driver.findElements(By.xpath("//section[@id='products']//div[@class='row']/div"));
	
	
	
	
	
	w.until(ExpectedConditions.visibilityOfAllElements(listOfProducts));
	
	//listOfProducts.stream().filter(expectedProductNames.contains(item->item.findElement(By.xpath(".//div[@class='card']//b")).getText())
	
	listOfProducts.stream().filter(item->expectedProductNames.contains(item.findElement(By.xpath(".//div[@class='card']//b")).getText())).forEach(item->{
        WebElement button = item.findElement(By.xpath(".//button[normalize-space()='Add To Cart']"));
	

        
        w.until(ExpectedConditions.elementToBeClickable(button)).click();
        
        // wait for toast/overlay to disappear before next iteration
        w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
    });
	
    
	ProductsPage product= new ProductsPage(driver);
	product.productSelectionFromList(expectedProductNames);
    
    
	   w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart']"))).click();
	
	}
	
	
	
}
