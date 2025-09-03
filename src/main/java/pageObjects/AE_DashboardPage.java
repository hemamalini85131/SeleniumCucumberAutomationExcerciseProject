package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AE_DashboardPage extends BaseClass{
	
	private WebDriver driver;
	
	public AE_DashboardPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using=".col-sm-8 b")
	private WebElement loggedinUserEle;
	
	@FindBy(how=How.CSS,using=".nav.navbar-nav a[href='/products']")
	private WebElement productEle;
	
	public String loggedinUserCheck()
	{
		String loggedinUserName=loggedinUserEle.getText();
		return loggedinUserName;
	}
	
	public String clickOnProducts()
	{
		productEle.click();
		String productPageUrl=driver.getCurrentUrl();
		return productPageUrl;
	}
	public WebElement getproductEle()
	{
		return productEle;
	}

	
}

