package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.TestContext;
import dataProviders.JsonDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.AE_HomePage;
import pageObjects.AE_LoginPage;
import testDataTypes.UserCredentials;

public class AE_HomePage_Steps {
	
	private WebDriver driver;
	private TestContext testContext;
	private AE_HomePage ae_HomePage;	
	private AE_LoginPage ae_LoginPage;
	
	
	public AE_HomePage_Steps(TestContext context)
	{
		testContext=context;
		this.driver=testContext.getWebDriverManager().getDriver();
		ae_HomePage = testContext.getPageObjectManager().getAE_HomePage();
		ae_LoginPage = testContext.getPageObjectManager().getAE_LoginPage();
		
	}
	
	@Given("User launches the AutomationExercise website")
	public void user_launches_the_automation_exercise_website() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
	}
	
	@When("User clicks on Signup\\/Login link")
	public void user_clicks_on_signup_login_link() {
		String actualUrl=ae_HomePage.loginToAutomationExercise();
		Assert.assertEquals("https://automationexercise.com/login", actualUrl);
	}
	
	@Given("User is on the Login page")
	public void user_is_on_the_login_page() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
		String actualUrl=ae_HomePage.loginToAutomationExercise();
		Assert.assertEquals("https://automationexercise.com/login", actualUrl);
	}
	
	@Given("User logs in with valid credentials from {string}")
	public void user_logs_in_with_valid_credentials_from(String String) throws InterruptedException {
	    
		String actualUrl=ae_HomePage.loginToAutomationExercise();
		Assert.assertEquals("https://automationexercise.com/login", actualUrl);
		
		JsonDataReader<UserCredentials> reader=new JsonDataReader<>("src\\test\\resources\\testData\\Usercredentials.json" , UserCredentials[].class);
		  
		UserCredentials user= reader.getByField("email", "hema1@test.com");
		ae_LoginPage.enterEmail(user.email);
		ae_LoginPage.enterPassword(user.password);
		ae_LoginPage.ClickOnLogin_btn();
		
	}
	
	

}
