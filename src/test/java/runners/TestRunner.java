package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src\\test\\resources\\features\\AddProductsToCart.feature",
glue = {"stepDefinition"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed.txt","pretty"})
public class TestRunner extends AbstractTestNGCucumberTests 
{

	
}
