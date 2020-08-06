package shop_test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shop_test.framework.core.BasePage;

public class ShoppingChartPage extends BasePage {

		public ShoppingChartPage(final WebDriver driver) {
			super(driver);
		}

		public static By arrowUpBtn = By.xpath("//i[@class='material-icons touchspin-up']");

		private static By proceedBtn = By.xpath("//a[@class='btn btn-primary']");

		private static By quantity = By.xpath("//input[@name='product-quantity-spin']");

		private static By deleteBtn = By.xpath("//i[@class='material-icons float-xs-left']");



		public WebElement getArrowUpBtn() {
			waitForElementToAppear(arrowUpBtn);
			return this.driver.findElement(arrowUpBtn);
		}


		public static void setArrowUpBtn(By arrowUpBtn) {
			ShoppingChartPage.arrowUpBtn = arrowUpBtn;
		}


		public static By getProceedBtn() {
			return proceedBtn;
		}


		public static void setProceedBtn(By proceedBtn) {
			ShoppingChartPage.proceedBtn = proceedBtn;
		}


		public static By getQuantity() {
			return quantity;
		}


		public static void setQuantity(By quantity) {
			ShoppingChartPage.quantity = quantity;
		}
		
		public static By getDeleteBtn() {
			return quantity;
		}
			}



