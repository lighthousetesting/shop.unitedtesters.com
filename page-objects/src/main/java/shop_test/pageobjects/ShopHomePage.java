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

	// Locators for finf=ding elements on the home page
	private static By homeCartBtn = By.cssSelector("div#_desktop_cart a"); // Alt. //*[@id="_desktop_cart"]/div/div/a
	private static By homeProducts = By.cssSelector("section#content div.products article");
	private static By homeHomePageLink = By.xpath("//div[@id='_desktop_logo']/h1/a");
	private static By homeContactLink = By.linkText("Contact us");
	private static By homeProductImageLink = By.xpath("//div[@class='thumbnail-container']/a/img");
	private static By homeProductTitleLink = By.xpath("//h3[@class='h3 product-title']/a");
	private static By homeProductPrice = By.xpath("//span[@class='price']"); 

	// Locators for finding elements inside product element
	private static By homeProductLink = By.xpath("./div/a");
	private static By homeProductName = By.xpath("./div/div[1]/h3");
	private static By homeProductPriceText = By.xpath("./div/div[1]/div/span[2]");
	private static By homeProductImage = By.xpath("./div/a/img");
	
	// List of all products displayed on home page
	private List<WebElement> homePageProducts = this.getHomeProducts();

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
	 * Finds and clicks particular product's link to product page. The product is specified
	 * by it's ordinal number on page.
	 *
	 */
	public void clickHomeProduct(int prodNo) {
		this.getHomeProduct(prodNo).findElement(homeProductLink).click();
	}

	/**
	 * Finds and returns particular product's title from the product element. The product is specified
	 * by it's ordinal number on page.
	 *
	 * @return Product Title
	 */
	public String getHomeProductName(int prodNo) {
		return homePageProducts.get(prodNo).findElement(homeProductName).getText();
	}

	/**
	 * Finds and returns particular product's price from the product element. The product is specified
	 * by it's ordinal number on page.
	 *
	 * @return Product Price
	 */
	public String getHomeProductPrice(int prodNo) {
		return homePageProducts.get(prodNo).findElement(homeProductPriceText).getText();
	}

	/**
	 * Finds and returns particular product's image link from the product element. The product is specified
	 * by it's ordinal number on page.
	 *
	 * @return Product Image Link
	 */
	public String getHomeProductImageSrc(int prodNo) {
		return homePageProducts.get(prodNo).findElement(homeProductImage).getAttribute("src");
	}

	/**
	 * Finds and returns link to product page of the particular product. Product is
	 * specified by ordinal number on the list of represented products. Link is
	 * represented by product image.
	 *
	 * @return Product image as a link
	 */
	public WebElement getHomeProductImageLink(int prodNo) {
		return this.driver.findElements(homeProductImageLink).get(prodNo);
	}

	
	/**
	 * Finds and returns link to product page of the product. Product is specified
	 * by ordinal number on the list of represented products. Link is represented by
	 * product name.
	 *
	 * @return Product name as a link
	 */
	public WebElement getHomeProductNameLink(int prodNo) {
		return this.driver.findElements(homeProductTitleLink).get(prodNo);
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
	
	/**
	 * Returns list of products displayed on home page.
	 *
	 * @return Product List
	 */
	public List<WebElement> getProductsList() {
		return homePageProducts;
	}

}