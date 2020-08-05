package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.BasePage;

public class ShoppingChartPage extends BasePage {

	public ShoppingChartPage(WebDriver driver) {
		super(driver);

	}

	private static By arrowUpBtn = By.xpath("//i[@class='material-icons touchspin-up']");

	private static By proceedBtn = By.xpath("//a[@class='btn btn-primary']");

	private static By quantity = By.xpath("//input[@name='product-quantity-spin']");

	private static By deleteBtn = By.xpath("//i[@class='material-icons float-xs-left']");

	public WebElement getArrowUpBtn() {
		waitForElementToAppear(arrowUpBtn);
		return this.driver.findElement(arrowUpBtn);
	}

	public WebElement getProceedBtn() {
		waitForElementToAppear(proceedBtn);
		return this.driver.findElement(proceedBtn);
	}

	public WebElement getQuantity() {
		waitForElementToAppear(quantity);
		return this.driver.findElement(quantity);

	}

	public WebElement getDeleteBtn() {
		waitForElementToAppear(deleteBtn);
		return this.driver.findElement(deleteBtn);
	}

	public void clickgetArrowUpBtn() {
		getProceedBtn().click();
	}

	public void clickProceedBtn() {
		getProceedBtn().click();
	}

	public void clickDeleteBtn() {
		getDeleteBtn().click();
	}

}
