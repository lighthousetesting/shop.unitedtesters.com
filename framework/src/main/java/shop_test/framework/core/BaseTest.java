package shop_test.framework.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * This is a page object model for Home page
 * @author  Sinisa Vrhovac
 * @version 0.1
 */
public class BaseTest {

    private WebDriver driver;

    /**
     * Instantiate a Chrome web driver
     */
    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
    }

    /**
     * Close web driver after all test suite is executed.
     */
    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    /**
     * Instantiate an object instance and its parent
     *
     * @param URL URL of page to open
     */
    public void open(String URL){
        driver.get(URL);
    }

    /**
     * Instantiate an object instance and its parent
     *
     * @return A web driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
}