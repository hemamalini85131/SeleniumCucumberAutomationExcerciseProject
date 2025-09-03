package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class BaseClass {
	private WebDriver driver;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	private ConfigFileReader configFileReader;
	
	
	public BaseClass(WebDriver driver)
	{
		this.driver=driver;
		configFileReader= FileReaderManager.getInstance().getConfigFileReader();
		wait=new WebDriverWait(driver,Duration.ofSeconds(configFileReader.getImplicitlyWait()));
		this.js=(JavascriptExecutor) driver;
	}
	

    // Explicit wait for visibility of an element
    public WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Explicit wait for element to be clickable
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void jsScrollToElement(WebElement element)
    {
    	js.executeScript("arguments[0].scrollIntoView('true');", element);
    }
    
    public void jsClick(WebElement element)
    {
    	js.executeScript("arguments[0].click();", element);
    }
    
    public void selectDropdownbyVisibleText(WebElement element, String value)
    
    {
    	//waitForElementToBeClickable(element);
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(element));
    	new Select(element).selectByVisibleText(value);
    }
    
    public void typeAndWaitForValue(WebElement element, String value) {
        element.sendKeys(value);
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.attributeToBe(element, "value", value));
    }


}
