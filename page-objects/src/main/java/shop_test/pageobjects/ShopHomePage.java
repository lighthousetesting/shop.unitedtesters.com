package shop_test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shop_test.framework.core.BasePage;
import java.util.List;

/**p */
/**
 * This is a page object model for Home page
 * 
 * @author Sinisa Vrhovac
 * @version 0.1
 */

public class ShopHomePage extends BasePage {

	private static By homeCartBtn = By.cssSelector("div#_desktop_cart a");
	private static By homeProducts = By.cssSelector("section#content div.products article");
	private static By homeHomePageLink = By.xpath("//div[@id='_desktop_logo']/h1/a");
	private static By homeContactLink = By.linkText("Contact us");
	private static By homeProductImageLink = By.xpath("//div[@class='thumbnail-container']/a/img");
	private static By homeProductTitleLink = By.xpath("//h3[@class='h3 product-title']/a");
	private static By homeProductPrice = By.xpath("//span[@class='price']");

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
	public WebElement getHomeCartBtn() {
		waitForElementToAppear(homeCartBtn);
		return this.driver.findElement(homeCartBtn);
	}

	/**
	 * Finds and returns list of products identified on page.
	 *
	 * @return List of products
	 */
	public List<WebElement> getHomeProducts() {
		return this.driver.findElements(homeProducts);
	}

	/**
	 * Finds and returns particular product from the page. The product is specified
	 * by it's ordinal number on page.
	 *
	 * @return Product
	 */
	public WebElement getHomeProduct(int prodNo) {
		return this.getHomeProducts().get(prodNo);
	}

	/**
	 * Finds and returns links to product page of all the product identified on
	 * page. Link is represented by product image.
	 *
	 * @return List of image links
	 */
	public List<WebElement> getHomeProductImageLinks() {
		return this.driver.findElements(homeProductImageLink);

	}

	/**
	 * Finds and returns link to product page of the particular product. Product is
	 * specified by ordinal number on the list of represented products. Link is
	 * represented by product image.
	 *
	 * @return Product image as a link
	 */
	public WebElement getHomeProductImageLink(int prodNo) {
		return this.getHomeProductImageLinks().get(prodNo);
	}

	/**
	 * Finds and returns links to product page of all the product identified on
	 * page. Link is represented by product name.
	 *
	 * @return List of name links
	 */
	public List<WebElement> getHomeProductNameLinks() {
		return this.driver.findElements(homeProductTitleLink);
	}

	/**
	 * Finds and returns link to product page of the product. Product is specified
	 * by ordinal number on the list of represented products. Link is represented by
	 * product name.
	 *
	 * @return Product name as a link
	 */
	public WebElement getHomeProductNameLink(int prodNo) {
		return this.getHomeProductNameLinks().get(prodNo);
	}

	/**
	 * Finds and returns elements containing product prices, for all products
	 * identified on page.
	 * 
	 * @return List of product prices
	 */
	public List<WebElement> getHomeProductPrices() {
		return this.driver.findElements(homeProductPrice);

	}

	/**
	 * Finds and returns element containing product price of the particular product.
	 * Product is specified by ordinal number on the list of represented products.
	 * 
	 * @return Product price
	 */
	public WebElement getHomeProductPrice(int prodNo) {
		return this.getHomeProductPrices().get(prodNo);
	}

	/**
	 * Finds and returns link to home page
	 * 
	 * @return Home page link
	 * 
	 */
	public WebElement getHomePageLink() {
		waitForElementToAppear(homeHomePageLink);
		return this.driver.findElement(homeHomePageLink);
	}

	/**
	 * Finds and returns link to contact page
	 * 
	 * @return Contact us link
	 * 
	 */
	public WebElement getHomeContactUsLink() {
		waitForElementToAppear(homeContactLink);
		return this.driver.findElement(homeContactLink);
	}

    public void clickHomeProduct(int prNo) {
    }
}