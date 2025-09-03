package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AE_SignupPage;

public class AE_SignupPage_Steps {
	
	WebDriver driver;
	AE_SignupPage ae_SignupPage;
	TestContext testContext;
	
	public AE_SignupPage_Steps(TestContext context)
	{
		testContext=context;
		driver=testContext.getWebDriverManager().getDriver();
		ae_SignupPage=testContext.getPageObjectManager().getAE_signupPage();
		
	}
	
	@When("User fills personal details: {string}, {string}, {string},{string},{string},{string} {string}, {string}, {string}, {string}, {string}")
	public void user_fills_personal_details(String password, String firstName, String lastName, String day, 
			String month, String year, String address, 	String city, String state, String zipcode, String mobile) throws InterruptedException 
	{
		ae_SignupPage.enterPassword(password);
		ae_SignupPage.enterDOB(day, month, year);
		ae_SignupPage.enterFirstName(firstName);
		ae_SignupPage.enterLastName(lastName);
		ae_SignupPage.enterAddress(address);
		ae_SignupPage.enterCity(city);
		ae_SignupPage.enterState(state);
		ae_SignupPage.enterZCode(zipcode);
		ae_SignupPage.enterMobileNo(mobile);
		
	}
	
	
	@When("User clicks on Create Account")
	public void user_clicks_on_create_account() {
		ae_SignupPage.clickCreateAccBtn();
	}
	
	@Then("Account should be created successfully")
	public void account_should_be_created_successfully() {
		String accountCreationSuccessMsg = ae_SignupPage.getAccountCreationMessage();
		Assert.assertEquals( accountCreationSuccessMsg,"ACCOUNT CREATED!");
	}
	
	
	

		
	
	

}
