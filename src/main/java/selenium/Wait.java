package selenium;



import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.FileReaderManager;

public class Wait {
    
    // Waits until jQuery AJAX requests are completed
    public static void untilJqueryIsDone(WebDriver driver) {
        untilJqueryIsDone(driver, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
    }

    // Customizable timeout version for jQuery AJAX wait
    public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
        until(driver, new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver d) {
                Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver)
                    .executeScript("return jQuery.active == 0");
                if (!isJqueryCallDone) System.out.println("JQuery call is in progress");
                return isJqueryCallDone;
            }
        }, timeoutInSeconds);
    }

    // Waits until the web page load is complete
    public static void untilPageLoadComplete(WebDriver driver) {
        untilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
    }

    // Customizable timeout version for page load wait
    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds) {
        until(driver, new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver d) {
                Boolean isPageLoaded = ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete");
                if (!isPageLoaded) System.out.println("Document is loading");
                return isPageLoaded;
            }
        }, timeoutInSeconds);
    }

    // Core waiting method, which accepts a custom wait condition
    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
        until(driver, waitCondition, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
    }

    // Overloaded until method with customizable timeout
    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
