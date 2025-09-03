package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_HomePage extends BaseClass {
	
	WebDriver driver;
	public AE_HomePage(WebDriver driver)
	{   super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".nav.navbar-nav a[href='/login']")
	private WebElement loginEle;
	
	public String loginToAutomationExercise()
	{
		String actualUrl;
		//driver.get(url);
		loginEle.click();
		actualUrl=driver.getCurrentUrl();
		return actualUrl;
		
	}

	
	
}
