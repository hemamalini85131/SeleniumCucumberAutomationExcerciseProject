package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("===== Starting Scenario: " + scenario.getName() + " =====");
        if (driver == null) {
            driver = testContext.getWebDriverManager().getDriver();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("===== Ending Scenario: " + scenario.getName() + " =====");
        testContext.getWebDriverManager().closeDriver();
        
    }
}
