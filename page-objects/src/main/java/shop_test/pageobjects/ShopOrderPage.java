package shop_test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shop_test.framework.core.BasePage;

/**
 * This is a page object model for Order page
 * 
 * @author Ljiljana Vrhovac-Kapor
 * @version 0.2
 */

public class ShopOrderPage extends BasePage {

	// Personal info form - mandatory fields locators
	private static By firstNameField = By.xpath("//input[@name='firstname']");
	private static By lastNameField = By.xpath("//input[@name='lastname']");
	private static By emailField = By.xpath("//form[@id='customer-form']//input[@name='email']");
	private static By iAgreePrivacy = By.xpath("//input[@name='psgdpr']");
	private static By continueBtn1 = By
			.xpath("//footer[@class='form-footer clearfix']//button[@name='continue'][contains(text(),'Continue')]");

	// Address form - mandatory fields locators
	private static By addressField = By.xpath("//input[@name='address1']");
	private static By cityField = By.xpath("//input[@name='city']");
	private static By stateDropDown = By.xpath("//select[@name='id_state']");
	private static By postalCodeField = By.xpath("//input[@name='postcode']");
	private static By continueBtn2 = By.xpath("//button[@name='confirm-addresses']");

	// Shipping method form - Locators
	private static By MyCarrierCB = By.id("delivery_option_2");
	private static By continueBtn3 = By.xpath("//button[@name='confirmDeliveryOption']");

	// Payment FOrm - Locators
	private static By bankWireCB = By.id("payment-option-2");
	private static By iAgreeTandC = By.id("conditions_to_approve[terms-and-conditions]");
	private static By orderBtn = By.xpath("//button[@class='btn btn-primary center-block']");

	/**
	 * Instantiate an object instance and its parent
	 *
	 * @param driver An instance of web driver
	 */
	public ShopOrderPage(final WebDriver driver) {
		super(driver);

	}

	// Elements geters methods
	/**
	 * Finds and returns First Name Field.
	 *
	 * @return First Name Field
	 */
	public WebElement getFirstNameField() {
		waitForElementToAppear(firstNameField);
		return this.driver.findElement(firstNameField);
	}

	/**
	 * Finds and returns Last Name Field.
	 *
	 * @return Last Name Field
	 */
	public WebElement getLastNameField() {
		waitForElementToAppear(lastNameField);
		return this.driver.findElement(lastNameField);
	}

	/**
	 * Finds and returns email Field.
	 *
	 * @return email Field
	 */
	public WebElement getEmailField() {
		waitForElementToAppear(emailField);
		return this.driver.findElement(emailField);
	}

	/**
	 * Finds and returns I Agree Privacy Check Box.
	 *
	 * @return I Agree Privacy Check Box
	 */
	public WebElement getIAgreePrivacy() {
		waitForElementToAppear(iAgreePrivacy);
		return this.driver.findElement(iAgreePrivacy);
	}

	/**
	 * Finds and returns Continue Button on Personal Info form.
	 *
	 * @return Continue Button on Personal Info form
	 */
	public WebElement getContinueBtnPersonal() {
		waitForElementToAppear(continueBtn1);
		return this.driver.findElement(continueBtn1);
	}

	/**
	 * Finds and returns Address Field.
	 *
	 * @return Address Field
	 */
	public WebElement getAddressField() {
		waitForElementToAppear(addressField);
		return this.driver.findElement(addressField);
	}

	/**
	 * Finds and returns City Field.
	 *
	 * @return City Field
	 */
	public WebElement getCityField() {
		waitForElementToAppear(cityField);
		return this.driver.findElement(cityField);
	}

	/**
	 * Finds and returns State Dropdown.
	 *
	 * @return State Dropdown
	 */
	public WebElement getStateDropDown() {
		waitForElementToAppear(stateDropDown);
		return this.driver.findElement(stateDropDown);
	}

	/**
	 * Finds and returns Postal Code Field.
	 *
	 * @return Postal Code Field
	 */
	public WebElement getPostalCodeField() {
		waitForElementToAppear(postalCodeField);
		return this.driver.findElement(postalCodeField);
	}

	/**
	 * Finds and returns Continue Button on Address form.
	 *
	 * @return Continue Button on Address form
	 */
	public WebElement getContinueBtnAddress() {
		waitForElementToAppear(continueBtn2);
		return this.driver.findElement(continueBtn2);
	}

	/**
	 * Finds and returns Cerrier CheckBox.
	 *
	 * @return returns Cerrier CheckBox
	 */
	public WebElement getCerrierChechBox() {
		waitForElementToAppear(MyCarrierCB);
		return this.driver.findElement(MyCarrierCB);
	}

	/**
	 * Finds and returns Continue Button on Shipping form.
	 *
	 * @return Continue Button on Shipping form
	 */
	public WebElement getContinueBtnShipping() {
		waitForElementToAppear(continueBtn3);
		return this.driver.findElement(continueBtn3);
	}

	/**
	 * Finds and returns Bank Wire CheckBox.
	 *
	 * @return returns Bank Wire CheckBox
	 */
	public WebElement getBankWireChechBox() {
		waitForElementToAppear(bankWireCB);
		return this.driver.findElement(bankWireCB);
	}

	/**
	 * Finds and returns I Agree Terms and Conditions Check Box.
	 *
	 * @return I Agree Terms and Conditions Check Box
	 */
	public WebElement getIAgreeTandC() {
		waitForElementToAppear(iAgreeTandC);
		return this.driver.findElement(iAgreeTandC);
	}

	/**
	 * Finds and returns Order Button on Payment form.
	 *
	 * @return Order Button on Payment form
	 */
	public WebElement getOrderBtn() {
		waitForElementToAppear(orderBtn);
		return this.driver.findElement(orderBtn);
	}
}
