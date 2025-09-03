package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AE_DashboardPage;
import pageObjects.AE_LoginPage;
import pageObjects.AE_SignupPage;

public class AE_LoginPage_Steps {
	
	private WebDriver driver;
	private AE_LoginPage ae_LoginPage;
	private AE_DashboardPage ae_DashboardPage;
	private TestContext testContext;
	
	public AE_LoginPage_Steps(TestContext context)
	{
		testContext =context;
		driver=testContext.getWebDriverManager().getDriver();
		ae_LoginPage= testContext.getPageObjectManager().getAE_LoginPage();
		ae_DashboardPage = testContext.getPageObjectManager().getAE_DashboardPage();

		
	}
	

@When("User enters name {string} and email {string} for signup")
public void user_enters_name_and_email_for_signup(String name, String email) {

	ae_LoginPage.enterName(name);
	ae_LoginPage.enterEmailSignup(email);
	String actualUrl= ae_LoginPage.ClickSignup_btn();
	Assert.assertEquals(
			actualUrl, "https://automationexercise.com/signup", "Login/Signup button did not redirect to signup page" );	
}

@When("User enters email {string} and password {string}")
public void user_enters_email_and_password(String email, String password) {
	ae_LoginPage.enterEmail(email);
	ae_LoginPage.enterPassword(password);
	
	
}

@When("User clicks on Login")
public void user_clicks_on_login() {
	 ae_LoginPage.ClickOnLogin_btn();
}

@Then("{string} should be logged in successfully")
public void should_be_logged_in_successfully(String user) {
	String loginPageURL = driver.getCurrentUrl();
	Assert.assertEquals(loginPageURL, "https://automationexercise.com/" , "Login button did not redirect to Login page");
	
	//String loggedInUserName=ae_LoginPage.getLoggedInUser();
	Assert.assertEquals(ae_DashboardPage.loggedinUserCheck(), user , "Logged in user did not appear!");
}

@Then("Error message should be displayed")
public void error_message_should_be_displayed() {
	 ae_LoginPage.ClickOnLogin_btn();
	 String errorMSG = ae_LoginPage.getInvalidCredetialsMSG();
	 Assert.assertEquals(errorMSG, "Your email or password is incorrect!");
	
}
	
	

        

}
