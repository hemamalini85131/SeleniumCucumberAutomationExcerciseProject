package stepDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AE_CartPage;
import pageObjects.AE_DashboardPage;
import pageObjects.AE_ProductsPage;

public class AE_ProductsPage_Steps {
	private WebDriver driver;
	private TestContext testContext ;
	private AE_ProductsPage ae_ProductsPage;
	private AE_CartPage ae_CartPage;
	private ScenarioContext  scenarioContext;
	
	public AE_ProductsPage_Steps(TestContext testContext)
	{
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		ae_ProductsPage = testContext.getPageObjectManager().getAE_ProductsPage();
		scenarioContext= testContext.getScenarioContext();
		ae_CartPage=testContext.getPageObjectManager().getAE_CartPage();		
	}

@When("User selects {string} category and {string} productType")
public void user_selects_category_and_product_type(String category, String productType) throws InterruptedException {
	String categoryProductType = 
	
	ae_ProductsPage.selectCategoryAndProductType(category, productType);
	Assert.assertTrue(categoryProductType.equalsIgnoreCase(category +" - "+ productType +" PRODUCTS"));
   }
	
	@And("User adds {string} to cart")
	public void user_adds_to_cart(String product) throws InterruptedException {
		String addedProduct = ae_ProductsPage.addProductToCart(product);
		scenarioContext.addToListContext("product", addedProduct);
		
		System.out.println("THe Product added to Cart is " + scenarioContext.getContext("product"));
		Assert.assertEquals(ae_ProductsPage.clickOnCart(), "https://automationexercise.com/view_cart");
		
	}
	
	
	@When("User adds following products to cart:")
	public void user_adds_following_products_to_cart(DataTable dataTable) throws InterruptedException {
		
		List<Map<String , String>> data=dataTable.asMaps(String.class,String.class);
		Map<String,Integer> products= new HashMap<String,Integer>();
		
		for(Map<String , String> prodData: data)
		{
			String product=prodData.get("Product Name");
			int quantity=Integer.parseInt(prodData.get("Quantity"));
			
			System.out.println("Product Name "+product);
			System.out.println("Product Name "+quantity);
			
            for(int i=1;i<=quantity;i++)
            {
            	ae_ProductsPage.addProductToCart(product);
            }
            products.put(product, quantity);
                        
		}
	    scenarioContext.setContext("PRODUCTS_ADDEDTOCART",products);
	    System.out.println("fetching the prodtsus details saved in scanrsioContext "+scenarioContext.getContext("PRODUCTS_ADDEDTOCART"));
	}

	@When("User navigates to the Cart page")
	public void user_navigates_to_the_cart_page() {
	   
		Assert.assertEquals(ae_ProductsPage.clickOnCart(), "https://automationexercise.com/view_cart");

	}
	
	
}