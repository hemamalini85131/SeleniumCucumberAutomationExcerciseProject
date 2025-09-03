package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.AE_DashboardPage;

public class AE_DashboardPage_Steps {
	
	private WebDriver driver;
	private TestContext testContext ;
	private AE_DashboardPage ae_DashboardPage;
	
	public AE_DashboardPage_Steps(TestContext testContext)
	{
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		ae_DashboardPage = testContext.getPageObjectManager().getAE_DashboardPage();
				
	}
	@And("User is on the Products page")
	public void user_is_on_the_products_page() {
		ae_DashboardPage.clickOnProducts();
	    
	}
	

	
	
	
	

}
