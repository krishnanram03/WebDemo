package Framework.BaseComponents;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Framework.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 

{
public WebDriver driver;
public FileInputStream fistream;
public Properties prop;
public String url;
public LoginPage loginPage;

@BeforeMethod
public WebDriver setup() throws Exception
{
	fistream= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Framework\\Resources\\Global.properties");
	prop= new Properties();
	prop.load(fistream);
	String browser=prop.getProperty("browser");
	url=prop.getProperty("url");
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();

	}
	else if(browser.equalsIgnoreCase("safari"))
	{
		WebDriverManager.safaridriver().setup();
		driver= new SafariDriver();
		
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();

	}
	else
	{
		System.out.println("Please select a valid browser for execution");
	}
	
	return driver;
}


public LoginPage goToApplication() throws Exception
{
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	loginPage= new LoginPage(driver);
	return loginPage;
}


@AfterMethod
public void tearDown()
{
	driver.close();	
}
}