package shop_test.framework.core;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * This is a page object model for Home page
 * @author  Sinisa Vrhovac
 * @version 0.1
 */
public class BaseTest {

    private static WebDriver driver;
    protected final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    /**
     * Instantiate a Chrome web driver
     */
    @BeforeSuite
    public static void beforeSuite() {
        //System.setProperty("headless", "true"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
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
    public static void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    /**
     * Instantiate an object instance and its parent
     *
     * @param url URL of page to open
     */
    public void open(String url){
        driver.get(url);
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    public void clear() {
        driver.manage().deleteAllCookies();
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