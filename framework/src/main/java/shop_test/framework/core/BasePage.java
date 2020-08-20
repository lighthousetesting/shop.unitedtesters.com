package shop_test.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a page object model for Home page
 * @author  Sinisa Vrhovac
 * @version 0.1
 */
public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private static WebDriverWait wait;

    /**
     * Instantiate an object instance and its parent
     *
     * @param driver An instance of web driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    /**
     * Instruct driver to wait until specified element appear on page.
     *
     * @param locator Locator used to identify element
     */
    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getTitle(){
        return this.driver.getTitle();
    }

    /**
     * Instruct driver to wait until specified element disappear from page.
     *
     * @param locator Locator used to identify element
     */
    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Instruct driver to wait until specified text disappear from page.
     *
     * @param locator Locator used to identify element
     * @param text Text to monitor
     */
    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}