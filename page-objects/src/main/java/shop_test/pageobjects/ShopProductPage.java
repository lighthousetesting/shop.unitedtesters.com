package shop_test.pageobjects;

import org.openqa.selenium.WebDriver;
import shop_test.framework.core.BasePage;

/**
 * This is a page object model for Product page
 * @author  Sinisa Vrhovac
 * @version 0.1
 */
public class ShopProductPage extends BasePage {

    /**
     * Instantiate an object instance and its parent
     *
     * @param driver An instance of web driver
     */
    public ShopProductPage(WebDriver driver) {
        super(driver);
    }
}
