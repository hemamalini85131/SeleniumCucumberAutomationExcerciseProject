package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AE_CartPage;
import pageObjects.AE_DashboardPage;
import pageObjects.AE_HomePage;
import pageObjects.AE_LoginPage;
import pageObjects.AE_ProductsPage;
import pageObjects.AE_SignupPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private AE_HomePage ae_HomePage;
	private AE_LoginPage ae_LoginPage;	
	private AE_SignupPage ae_SignupPage;
	private AE_DashboardPage ae_DashboardPage;
	private AE_ProductsPage ae_ProductsPage;
	private AE_CartPage ae_CartPage;
	
	public PageObjectManager(WebDriver driver)
	{
      this.driver=driver;
	}
	

	public  AE_HomePage getAE_HomePage()
	{
	
	return (ae_HomePage==null)?  ae_HomePage=new AE_HomePage(driver) :ae_HomePage;
	
	}
	public AE_LoginPage getAE_LoginPage()
	{
		
		return (ae_LoginPage==null)?  ae_LoginPage=new AE_LoginPage(driver) :ae_LoginPage;	
	
	}
	public AE_SignupPage getAE_signupPage()
	{
		if(ae_SignupPage==null)
		{
			ae_SignupPage=new AE_SignupPage(driver);
		}
		
		return ae_SignupPage;
	}
	public AE_DashboardPage getAE_DashboardPage()
	{
		return (ae_DashboardPage==null)?ae_DashboardPage=new AE_DashboardPage(driver) : ae_DashboardPage;
	}
	
	public AE_ProductsPage getAE_ProductsPage()
	{
		return (ae_ProductsPage==null)? ae_ProductsPage=new AE_ProductsPage(driver) :ae_ProductsPage;
	}
	public AE_CartPage getAE_CartPage()
	{
		return (ae_CartPage==null)? ae_CartPage=new AE_CartPage(driver) :ae_CartPage;
	}
	
	
}

