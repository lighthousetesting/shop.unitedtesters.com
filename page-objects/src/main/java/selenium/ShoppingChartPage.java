package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.BasePage;

public class ShoppingChartPage extends BasePage {

	public ShoppingChartPage(WebDriver driver) {
		super(driver);

	}

	private static By arrowUpBtn = By.xpath("//button[@class='btn btn-touchspin js-touchspin js-increase-product-quantity bootstrap-touchspin-up']");

	private static By arrowDwnBtn = By.xpath("//button[@class='btn btn-touchspin js-touchspin js-decrease-product-quantity bootstrap-touchspin-down']");
	
	private static By proceedBtn = By.xpath("//a[@class='btn btn-primary']");

	private static By quantity = By.xpath("//li[1]//div[1]//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]");

	private static By deleteBtn = By.xpath("//a[@class='remove-from-cart']");

	public WebElement getArrowUpBtn() {
		waitForElementToAppear(arrowUpBtn);
		return this.driver.findElement(arrowUpBtn);
	}
	
	public WebElement getArrowDwnBtn() {
		waitForElementToAppear(arrowDwnBtn);
		return this.driver.findElement(arrowDwnBtn);
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

	public void clickArrowUpBtn() {
		getArrowUpBtn().click();
	}

	public void clickArrowDwnBtn() {
		getArrowDwnBtn().click();
	}

	
	public void clickProceedBtn() {
		getProceedBtn().click();
	}

	public void clickDeleteBtn() {
		getDeleteBtn().click();
	}

	

}
