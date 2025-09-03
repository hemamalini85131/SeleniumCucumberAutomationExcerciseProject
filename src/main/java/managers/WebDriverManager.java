package managers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import managers.FileReaderManager;

public class WebDriverManager {
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 private static DriverType driverType;
	 
	 public WebDriverManager() {
	        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
	    }
	 
	 public WebDriver getDriver() {
	        if (driver.get() == null) {
	            driver.set(createDriver());
	        }
	        return driver.get();
	    }
	 private WebDriver createDriver() {
	        WebDriver driverInstance = null;

	        switch (driverType) {
            case FIREFOX:
                driverInstance = new FirefoxDriver();
                break;

            case CHROME:
            	ChromeOptions options = new ChromeOptions();
            	Map<String, Object> prefs = new HashMap<>();
            	prefs.put("autofill.profile_enabled", false);
            	prefs.put("credentials_enable_service", false);
            	prefs.put("profile.password_manager_enabled", false);
            	options.setExperimentalOption("prefs", prefs);
                driverInstance = new ChromeDriver(options);
                break;

            case INTERNETEXPLORER:
                driverInstance = new InternetExplorerDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigFileReader().getWindowMaximize()) {
            driverInstance.manage().window().maximize();
        }

        driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait()));

        return driverInstance;
    }
	 
	 public void closeDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	  
	 }
	
	 
}


	 


