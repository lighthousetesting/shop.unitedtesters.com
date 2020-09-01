package shop_test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shop_test.framework.core.BasePage;

/**
 * This is a page object model for Product detail page
 * 
 * @author Ljiljana Vrhovac-Kapor
 * @version 0.1
 */

public class ShopProductDetailPage extends BasePage {
	
	/**
	 * Instantiate an object instance and its parent
	 *
	 * @param driver An instance of web driver
	 */
	public ShopProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static By addBtn = By.className("btn btn-primary add-to-cart");
	private static By qtyUp = By.className("btn btn-touchspin js-touchspin bootstrap-touchspin-up");
	private static By qtyDown = By.className("btn btn-touchspin js-touchspin bootstrap-touchspin-down");
	
	private static By productTitle = By.xpath("//h1[@class='h1']");
	
	// Elements geters methods
	
	/**
	 * Finds and returns touchspin up btn.
	 *
	 * @return touchspin up btn
	 */
	public WebElement addToCartBtn() {
		waitForElementToAppear(addBtn);
		return this.driver.findElement(addBtn);
	}
	
		/**
		 * Finds and returns touchspin up btn.
		 *
		 * @return touchspin up btn
		 */
		public WebElement getQtyUp() {
			waitForElementToAppear(qtyUp);
			return this.driver.findElement(qtyUp);
		}
		
		/**
		 * Finds and returns touchspin up btn.
		 *
		 * @return touchspin up btn
		 */
		public WebElement getQtyDown() {
			waitForElementToAppear(qtyDown);
			return this.driver.findElement(qtyDown);
		}
		
		/** Finds and returns product title
		 * 
		 * @return Product Title
		 */

		public String getProductTitle() {
			waitForElementToAppear(productTitle);
			return this.driver.findElement(productTitle).getText();
		}
}
