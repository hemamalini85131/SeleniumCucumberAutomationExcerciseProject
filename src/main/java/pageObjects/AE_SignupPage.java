package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AE_SignupPage extends BaseClass{
	
	WebDriver driver;
	
	public AE_SignupPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="#password")
	private WebElement passwordEle;
	
	@FindBy(id="days")
	private WebElement dobDayEle;
	
	@FindBy(id="months")
	private WebElement dobMonth;
	
	@FindBy(id="years")
	private WebElement dobYear;
	
	@FindBy(id="first_name")
	private WebElement firstNameEle;
	
	@FindBy(id="last_name")
	private WebElement lastNameEle;
	
	@FindBy(id="address1")
	private WebElement addressEle;
	
	@FindBy(id="state")
	private WebElement stateEle;
	
	@FindBy(id="city")
	private WebElement cityEle;
	
	@FindBy(id="zipcode")
	private WebElement zCodeEle;
	
	@FindBy(id="mobile_number")
	private WebElement mobileNumEle;
	
	@FindBy(css="button[data-qa='create-account']")
	private WebElement createAccountEle;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']  //b ")
	private WebElement accCreatedMsg;
	
	public void enterPassword(String password) throws InterruptedException
	{
		Thread.sleep(2000);
		jsScrollToElement(passwordEle);
		typeAndWaitForValue(passwordEle,password);
	}
	
	public void enterDOB(String day, String month, String year) throws InterruptedException
	{
		jsScrollToElement(dobDayEle);
		Thread.sleep(2000);
		selectDropdownbyVisibleText(dobDayEle, day);
		
		selectDropdownbyVisibleText(dobMonth, month);
		
		selectDropdownbyVisibleText(dobYear, year);

	}
	
	public void enterFirstName(String firstName)
	{
		typeAndWaitForValue(firstNameEle,firstName);

	}
	
	public void enterLastName(String lastName)
	{
		typeAndWaitForValue(lastNameEle,lastName);

	}
	
	public void enterAddress(String address)
	{
		typeAndWaitForValue(addressEle,address);

	}
	
	public void enterState(String state)
	{
		typeAndWaitForValue(stateEle,state);

	}
	public void enterCity(String city)
	{
		typeAndWaitForValue(cityEle,city);

	}
	public void enterZCode(String zCode)
	{
		typeAndWaitForValue(zCodeEle,zCode);

	}
	public void enterMobileNo(String mobileNo)
	{
		typeAndWaitForValue(mobileNumEle,mobileNo);

	}
	
	public void clickCreateAccBtn()
	{
		createAccountEle.click();
			
	}
	
	public String getAccountCreationMessage()
	{
		return accCreatedMsg.getText();
	}
	
	
	
	
	

	

}
