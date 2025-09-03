package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AE_CartPage extends BaseClass{
	public WebDriver driver;
	
	public AE_CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

    }
	
	@FindAll(@FindBy(how=How.CSS, using=".cart_description a" ))
	private List<WebElement> onCartProductDescription;
	
	@FindBy(css="cart_total_price")
	private WebElement totalPriceofProduct;
	
	@FindAll(@FindBy(css="tbody>tr"))
	private List<WebElement> cartItemsEle;
	
	
	
	
	
	public List<String> productsOnCart()
	{
		List<String> listOfProductsOnCart= new ArrayList();
		for(WebElement product:onCartProductDescription)
		{
			
			listOfProductsOnCart.add(product.getText());
		}
		return listOfProductsOnCart;
		
	}
	
	public void deletItemfromCart(String product)
	{
		for(WebElement item :cartItemsEle)
		{
			if(item.findElement(By.cssSelector("td:nth-child(2)>h4>a")).getText().equalsIgnoreCase(product))
			{
				WebElement deleteBtn=item.findElement(By.cssSelector("td:nth-child(6)>a.cart_quantity_delete"));
				Actions action=new Actions(driver);
				action.moveToElement(deleteBtn).click().perform();
			}
		}
	}	
	/*public String getProductNamefromCart(String product)
	{
		WebElement productEle=driver.findElement((By.xpath("//td[@class='cart_description'] //a[text='"+product+"']")));
		return productEle.findElement(By.cssSelector("td:nth-child(2)>h4>a")).getText();
				
	}*/
	
	public String getQunatity(String product)
	{ 		
		WebElement productEle=driver.findElement((By.xpath("//td[@class='cart_description'] //a[text()='"+product+"']/parent::h4/parent::td/parent::tr")));

		return productEle.findElement(By.cssSelector("td:nth-child(4)>button")).getText();
	}
	

	
	
	
}