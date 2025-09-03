package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_LoginPage  extends BaseClass{

	WebDriver driver;
	public AE_LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="form[action='/login'] input[name='email']")
	public WebElement emailEle;
	
	@FindBy(css="form[action='/login'] input[name='password']")
	private WebElement passwordEle;
	
	@FindBy(css="form[action='/login'] .btn.btn-default")
	private WebElement loginbtnEle;
	
	@FindBy(css="input[name='name']")
	private WebElement nameEleSignup;
	
	@FindBy(css=".signup-form input[name='email']")
	private WebElement emailEleSignup;
	
	@FindBy(xpath="//button[text()='Signup']")
	private WebElement signupEle;
	
	@FindBy(css=".fa.fa-user +b")
	private WebElement loggedInUserEle;
	
	@FindBy(css="div.login-form p")
	private WebElement invalidCredentialsMSGEle;
	
	public void enterEmail(String userName)
	{
		emailEle.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordEle.sendKeys(password);
	}
	
	public String ClickOnLogin_btn()
	{
		loginbtnEle.click();
		String dashbord_url=driver.getCurrentUrl();
		return dashbord_url;
	}
	
	public String ClickSignup_btn()
	{
		signupEle.click();
		return driver.getCurrentUrl();
	}
	
	public void enterName(String name)
	{
		nameEleSignup.sendKeys(name);
	}
	
	public void enterEmailSignup(String email)
	{
		emailEleSignup.sendKeys(email);
	}
	
	
	public void getSomeText() {
		System.out.println("Im in AE_LoginPage");
	}
	
	public String getLoggedInUser()
	{
		return loggedInUserEle.getText();
	}
	
	public String getInvalidCredetialsMSG()
	{
		return invalidCredentialsMSGEle.getText();
	}

	
	


}