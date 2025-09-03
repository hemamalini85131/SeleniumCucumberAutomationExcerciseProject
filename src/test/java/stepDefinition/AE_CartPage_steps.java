package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.collect.Multiset.Entry;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pageObjects.AE_CartPage;
import pageObjects.BaseClass;

public class AE_CartPage_steps {
	
	private WebDriver driver;
	private TestContext testContext ;
	private AE_CartPage ae_CartPage;
	private ScenarioContext scenarioContext;
	public AE_CartPage_steps(TestContext testContext)
	{
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		scenarioContext = testContext.getScenarioContext();
		ae_CartPage=testContext.getPageObjectManager().getAE_CartPage();
	}
	
	@Then("{string} should be added successfully to the cart")
	public void should_be_added_successfully_to_the_cart(String string) throws InterruptedException {
		
		List<String> productOnCart=ae_CartPage.productsOnCart();
		List<String> prodAddedToCart= (List<String>)scenarioContext.getContext("product");
		System.out.println("The Products added to cart are" + prodAddedToCart.get(0));
		Assert.assertTrue(productOnCart.size() == 1 , "Cart should have exactly 1 product, but it has: " + productOnCart.size());

		Assert.assertEquals(productOnCart.get(0),prodAddedToCart.get(0),
					"Expected product not found in the cart. Found: " + productOnCart.get(0));
	
		ae_CartPage.deletItemfromCart(prodAddedToCart.get(0));

    }
	
	
	@Then("All added products should reflect in the cart with correct details")
	public void all_added_products_should_reflect_in_the_cart_with_correct_details() {
	   
		List<String> productsOnCart=ae_CartPage.productsOnCart();
		Map<String,Integer> productsAddedToCart=(Map<String,Integer>)scenarioContext.getContext("PRODUCTS_ADDEDTOCART");
		
		Assert.assertTrue(productsOnCart.size() == productsAddedToCart.size() , "Cart should have " + productsAddedToCart.size() + " products, but it has: " + productsOnCart.size());

		for(Map.Entry<String, Integer> entry:productsAddedToCart.entrySet())
			
		{
			String expectedProduct=entry.getKey();
			Integer expectedQuantity=entry.getValue();
			System.out.println("fetching product data from scanrio context using Map.Entry<> "+expectedProduct +","+expectedQuantity);
	
			

	        // Check if the product exists in the cart
	        Assert.assertTrue(productsOnCart.contains(expectedProduct),
	                "Expected product not found in cart: " + expectedProduct);

	        // Fetch actual quantity
	        Integer actualQty = Integer.parseInt(ae_CartPage.getQunatity(expectedProduct));

	        Assert.assertEquals(
	                actualQty,
	                expectedQuantity,
	                
	                "Quantity mismatch for product: " + expectedProduct
	        );
		}
		
		
		
	}

	

}
