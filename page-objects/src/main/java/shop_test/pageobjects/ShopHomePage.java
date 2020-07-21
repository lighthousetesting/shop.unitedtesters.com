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
	private static By homeHomePagelink = By.xpath("//div[@id='_desktop_logo']//h1//a");
	private static By homeContactlink = By.linkText("Contact us");
	private static By homeProduct = By.xpath("//article[i]");
	private static By homeProductImageLink = By.xpath("//article[i]/div[1]/a[1]");
	private static By homeProductTitleLink = By.xpath("//article[i]/div[1]/div[1]/h3[1]/a[1]");
	private static By homeProductPrice = By.xpath("//article[i]/div[1]/div[1]/div[1]/span[2]");

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
	 * Finds and returns particular products from the page.
	 *
	 * @return Product
	 */
	public WebElement getHomeProduct(int prodNo) {
		waitForElementToAppear(homeProduct);
		return this.driver.findElement(homeProduct);
	}

	/**
	 * Finds and returns link to product page of the product. Product is specified
	 * by ordinal number on the list of represented products. Link is represented by
	 * product image.
	 *
	 * @return Product image as a link
	 */
	public WebElement getHomeProductImageLink(int prodNo) {
		waitForElementToAppear(homeProductImageLink);
		return this.driver.findElement(homeProductImageLink);
	}

	/**
	 * Finds and returns link to product page of the product. Product is specified
	 * by ordinal number on the list of represented products. Link is represented by
	 * product name.
	 *
	 * @return Product name as a link
	 */
	public WebElement getHomeProductNameLink(int prodNo) {
		waitForElementToAppear(homeProductTitleLink);
		return this.driver.findElement(homeProductTitleLink);
	}

	/**
	 * Finds and returns element containing product price Product is specified by
	 * ordinal number on the list of represented products.
	 * 
	 * @return Product price
	 */
	public WebElement getHomeProductPrice(int prodNo) {
		waitForElementToAppear(homeProductPrice);
		return this.driver.findElement(homeProductPrice);
	}

	/**
	 * Finds and returns link to home page
	 * 
	 * @return Home page link
	 * 
	 */
	public WebElement getHomePageLink() {
		waitForElementToAppear(homeHomePagelink);
		return this.driver.findElement(homeHomePagelink);
	}

	/**
	 * Finds and returns link to contact page
	 * 
	 * @return Contact us link
	 * 
	 */
	public WebElement getHomeContactUsLink() {
		waitForElementToAppear(homeContactlink);
		return this.driver.findElement(homeContactlink);
	}

}