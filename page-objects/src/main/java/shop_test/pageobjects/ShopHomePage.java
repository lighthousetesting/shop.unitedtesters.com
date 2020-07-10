package shop_test.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shop_test.framework.core.BasePage;

import java.util.List;
/**p */
/**
 * This is a page object model for Home page
 * @author  Sinisa Vrhovac
 * @version 0.1
 */
public class ShopHomePage extends BasePage {

    private static By homeCartBtn = By.cssSelector("div#_desktop_cart a");
    private static By homeProducts = By.cssSelector("section#content div.products  article");

    /**
     * Instantiate an object instance and its parent
     *
     * @param driver An instance of web driver
     */
    public ShopHomePage(final WebDriver driver) {
        super(driver);
    }


    /**
     * Finds and returns Cart button.
     *
     * @return Cart Button
     */
    public WebElement getHomeCartBtn(){
        waitForElementToAppear(homeCartBtn);
        return this.driver.findElement(homeCartBtn);
    }

    /**
     * Finds and returns list of products identified on page.
     *
     * @return List of products
     */
    public List<WebElement> getHomeProducts(){
        return this.driver.findElements(homeProducts);
    }

}