package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AE_ProductsPage extends BaseClass {
	
	private WebDriver driver;
	
	
	
	public AE_ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}
		@FindBy(how=How.CSS,using="a[href='#Women']")
		private WebElement womenCategoryEle;
		
		@FindBy(how=How.XPATH,using="//div[@id='Women'] //a[text()='Dress ']")
		private WebElement women_DressEle;
		
		@FindBy(how=How.XPATH,using="//div[@id='Women'] //a[text()='Tops ']")
		private WebElement women_TopsEle;
		
		@FindBy(xpath="//div[@id='Women'] //a[text()='Saree ']")
		private WebElement women_SareeEle;
		
		@FindBy(how=How.CSS,using="a[href='#Men']")
		private WebElement menCategoryEle;
		
		@FindBy(how=How.XPATH,using="//div[@id='Men'] //a[text()='Tshirts ']")
		private WebElement men_TshirtsEle;
		

	    @FindBy(css="a[href='#Kids']")
		private WebElement kidsCategoryEle;
	    
	    @FindBy(xpath="//div[@id='Kids'] //a[text()='Dress ']")
	    private WebElement kids_DressEle;
	    
	    @FindBy(how=How.XPATH,using="//div[@id='Kids'] //a[text()='Tops & Shirts ']")
	    private WebElement kids_Tops_ShirtsEle;
		
	    @FindBy(css=".single-products")
	    private WebElement singleProductEle;
	    
	    @FindAll(@FindBy(css=".single-products"))
	    private List<WebElement> allPRoductsEle;
	    
	    
	    @FindBy(css=".overlay-content  .btn.btn-default.add-to-cart")
	    private WebElement addToCartEle;
	    
	    @FindBy(css=".modal-footer button")
	    private WebElement continueShoppingEle;
	    
	    @FindBy(how=How.CSS , using=".nav.navbar-nav  a[href='/view_cart']")
		private WebElement cartEle;
	    
	    @FindBy(xpath = "//div[@class='features_items'] /h2")
	    private WebElement categoryProductHeaderEle;
	    
	    public WebElement getwomenCategoryEle()
	    {
	    	return womenCategoryEle;
	    }
	    
	    public WebElement getwomen_DressEle()
	    {
	    	return women_DressEle;
	    }
	    public WebElement getwomen_TopsEle()
	    {
	    	return women_TopsEle;
	    	
	    }
	    
	    public WebElement getwomen_SareeEle()
	    {
	    	return women_SareeEle;
	    }
	    
	    public WebElement getmenCategoryEle()
	    {
	    	return menCategoryEle;
	    }
	    
	    public WebElement getmen_TshirtsEle()
	    {
	    	return men_TshirtsEle;
	    }
	    
	    public WebElement getkidsCategoryEle()
	    {
	    	return kidsCategoryEle;
	    }
	    public WebElement getkids_DressEle()
	    {
	    	return kids_DressEle;
	    }
	    public WebElement getkids_Tops_ShirtsEle()
	    {
	    	return kids_Tops_ShirtsEle;
	    }
	    
	    public List<WebElement> getallPRoductsEle() 
	    {
	    	return allPRoductsEle;
	    }
	    public WebElement getAddProductToCartEle()
	    {
	    	return addToCartEle;
	    }
	    
	    public WebElement getCartEle()
	    {
	    	return cartEle;
	    }
	
	
	public WebElement getCategoryEle(String categoryName)
	{
		return  driver.findElement(By.cssSelector("a[href= '#"+categoryName+ "']"));
		
	}
	
	public WebElement getProductTypeEle(String categoryName, String productType)
	{
		return driver.findElement(By.xpath(" //div[@id='"+categoryName+"']//following-sibling::div//a[normalize-space()= '"+productType+"']"));
		 
	}
	public List<String> getListofAllProductsFromSelectedCategory(String categoryName, String productType)
	{
		 WebElement categoryEle=getCategoryEle(categoryName);
		 WebElement produtctTypeEle=getProductTypeEle(categoryName,productType);
		 
		    waitForElementToBeClickable(categoryEle);
		    categoryEle.click();
		    
		    waitForElementToBeClickable(produtctTypeEle);
		    produtctTypeEle.click();
		    
		    List<String> productNames= new ArrayList<String>();
		    for(WebElement prod: allPRoductsEle)
		    {
		    	String prodName=prod.findElement(By.tagName("p")).getText();
		    	  System.out.println(prodName);
		          productNames.add(prodName);
		      }
		      return productNames;
	         }
	
	public List<String> addProductsToCart(List<String> productsToAdd) {
	    List<String> productsAddedToCart = new ArrayList<>();

	    for (String productText : productsToAdd) {
	        for (WebElement product : allPRoductsEle) {
	            String productName = product.findElement(By.tagName("p")).getText();
	            System.out.println("Trying to add product: " + productText);
	            System.out.println("Found product on page: " + productName);

	            if (productText.equalsIgnoreCase(productName)) {
	                WebElement addToCartBtn = product.findElement(
	                    By.cssSelector(".overlay-content .btn.btn-default.add-to-cart")
	                );

	                Actions action = new Actions(driver);
	                action.moveToElement(product).perform();

	                waitForElementToBeClickable(addToCartBtn);
	                System.out.println("Clicking on Add to Cart for: " + productName);
	                jsClick(addToCartBtn);

	                productsAddedToCart.add(productName);

	                waitForElementToBeClickable(continueShoppingEle);
	                continueShoppingEle.click();

	                break; // Move to next productText after successful add
	            }
	        }
	    }
	    return productsAddedToCart;
	}
	
	public String clickOnCart()
    {
    	waitForElementToBeClickable(cartEle);
    	cartEle.click();
    	
    	return driver.getCurrentUrl();
    }

	public String selectCategoryAndProductType(String categoryName, String productType)
	{		
		WebElement categoryEle=getCategoryEle(categoryName);

		jsScrollToElement(categoryEle);
		 WebElement produtctTypeEle=getProductTypeEle(categoryName,productType);
		 
		    waitForElementToBeClickable(categoryEle);
		    categoryEle.click();
		    
		    waitForElementToBeClickable(produtctTypeEle);
		    produtctTypeEle.click();
		    
		    return categoryProductHeaderEle.getText();
	}

	public String addProductToCart(String product) throws InterruptedException
	{
        WebElement productEle = driver.findElement(By.xpath("//div[@class='single-products'] //p[text()= '" +product+ "']"));
        jsScrollToElement(productEle);
		WebElement addToCartEle=driver.findElement(By.xpath("//div[@class='single-products'] //p[text()= '" +product+ "'] /following-sibling::a"));


        Actions action = new Actions(driver);
        action.moveToElement(productEle).perform();


        waitForElementToBeClickable(addToCartEle);
        
        System.out.println("Clicking on Add to Cart for: " + productEle.getText());
        jsClick(addToCartEle);
        waitForElementToBeClickable(continueShoppingEle);
        continueShoppingEle.click();
        
        return product;

	}
		 
	}
    
    
