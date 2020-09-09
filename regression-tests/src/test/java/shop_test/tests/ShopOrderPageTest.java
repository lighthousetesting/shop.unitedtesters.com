package shop_test.tests;

import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShopOrderPage;
import shop_test.pageobjects.ShopProductDetailPage;
import shop_test.pageobjects.ShoppingChartPage;

/**
 * This class holds tests for order page
 * 
 * @version 2.0
 * @author Ljiljana Vrhovac-Kapor
 */

class ShopOrderPageTest extends BaseTest {

	private static final SoftAssert sa = new SoftAssert();
	private static ShopOrderPage orderPage;

	/**
	 * Open home page, the URL is specified in Tests.xml as parameter
	 *
	 * @param URL The page URL to open before each test
	 */
	@BeforeTest
	@Parameters("base-url")
	public void openPage(@Optional("https://shop.unitedtesters.com/") String URL) {
		this.open(URL);
	}

	/**
	 * click on one random product (product details page opens)
	 *
	 * Note: for version 2.0 I introduces system to choose random number of product
	 */
	@BeforeTest(dependsOnMethods = "openPage")
	public void chooseProduct() {
		ShopHomePage homePage = new ShopHomePage(getDriver());

		// GEt the number of products on page, -1, to get into range of indexes:
		int numberOfProducts = homePage.getHomeProducts().size() - 1;
		// get a random double in range 0..1, multiple by numberOfProducts and casting
		// into integer by (int).
		int prNo = (int) (Math.random() * numberOfProducts);

		homePage.clickHomeProduct(prNo);
		this.logger.info("chooseProduct");
		//System.out.println("chooseProduct");
	}

	/**
	 * click on Add to Cart Btn on product detail page
	 * 
	 * 
	 */
	@BeforeTest(dependsOnMethods = "chooseProduct")
	public void addToCart() {
		ShopProductDetailPage detailPage = new ShopProductDetailPage(getDriver());
		detailPage.addToCartBtn().click();
		System.out.println("addToCart");

	}

	/**
	 * click on ProceedBtn on product detail page
	 * 
	 * 
	 */
	@BeforeTest(dependsOnMethods = "addToCart")
	public void Proceed1() {
		ShopProductDetailPage detailPage = new ShopProductDetailPage(getDriver());
		detailPage.proceedToCOBtn().click();
		System.out.println("Proceed1");
	}

	/**
	 * click on ProceedBtn on Shopping Cart Page
	 * 
	 * 
	 */
	@BeforeTest(dependsOnMethods = "Proceed1")
	public void Proceed2() {
		ShoppingChartPage cartPage = new ShoppingChartPage(getDriver());
		cartPage.getProceedBtn().click();
		System.out.println("Proceed2");
	}

	/**
	 * Fill in mandatory fields in personal info form
	 * 
	 * @param firstName to fill in personal info form
	 * @param lastName  to fill in personal info form
	 * @param eMail     to fill in personal info form
	 */
	@BeforeTest(dependsOnMethods = "Proceed2")
	@Parameters({ "first-name", "last-name", "e-mail" })
	public void fillInPersonalInfo(
			@Optional("John") String firstName,
			@Optional("Doe") String lastName,
			@Optional("john.doe@mail.com") String eMail
	) {
		orderPage = new ShopOrderPage(getDriver());
		orderPage.getFirstNameField().sendKeys(firstName);
		orderPage.getLastNameField().sendKeys(lastName);
		orderPage.getEmailField().sendKeys(eMail);
		System.out.println("fillInPersonalInfo");

	}

	@Test(priority = 0)
	@DisplayName("checkBoxPrivacyFalse")
	@Description("Validate that check-box 'I agree to the terms and conditions and the privacy policy' is mandatory")
	@Epic("TP1-10")
	@Story("R_003 - As a customer, I want to complete the purchase of the selected product")
	@Link(name = "JIRA Issue TP1-10", url = "https://lighthousetesting.atlassian.net/browse/TP1-10")
	@Feature("AC06 - Validate that agreeing to \"I agree to the terms and conditions and the privacy policy\" is mandatory;")
	public void checkBoxPrivacyFalse() {
		orderPage = new ShopOrderPage(getDriver());
		boolean checkBoxStatus = orderPage.getIAgreePrivacy().isSelected();
		if (checkBoxStatus) {
			orderPage.CheckIAgreePrivacy();
		}
		orderPage.getContinueBtnPersonal().click();
		System.out.println("nulti");
		boolean isDisplayed = orderPage.getContinueBtnPersonal().isDisplayed();
		System.out.println("prvi");
		sa.assertEquals(isDisplayed, true);
		orderPage.CheckIAgreePrivacy();
		orderPage.getContinueBtnPersonal().click();
		isDisplayed = orderPage.getContinueBtnAddress().isDisplayed();
		System.out.println("drugi");
		sa.assertEquals(isDisplayed, true);

		sa.assertAll();
	}

	@Test(priority = 1)
	@DisplayName("checkBoxToSFalse")
	@Description("Validate that check-box 'I agree to the terms and conditions and the privacy policy' is mandatory")
	@Epic("TP1-15")
	@Story("R_003 - As a customer, I want to complete the purchase of the selected product")
	@Link(name = "JIRA Issue TP1-15", url = "https://lighthousetesting.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=TP1&modal=detail&selectedIssue=TP1-15")
	@Feature("AC07 - Validate that it is not possible to complete a purchase if the customer has not agreed with \"I agree to the terms of service and will adhere to them unconditionally.\" by checking checkbox")
	@Parameters({ "address", "city", "postal-code" })
	public void checkBoxToSFalse(String address, String city, String postalCode) {
		orderPage = new ShopOrderPage(getDriver());

		// fill in mandatory address field - part of test precondition
		orderPage.getAddressField().sendKeys(address);
		orderPage.getCityField().sendKeys(city);
		orderPage.clickStateDropDownOption();
		orderPage.getPostalCodeField().sendKeys(postalCode);
		orderPage.getContinueBtnAddress().click();
		System.out.println("fillInAddress");

		// shipping method continue - part of test precondition

		orderPage.getContinueBtnShipping().click();
		System.out.println("fillInShipping");

		// Validate that Pay by Bank Wire Check Box is selected - part of test
		// precondition

		boolean checkBoxStatus = orderPage.getBankWireChechBox().isSelected();
		if (!checkBoxStatus) {
			orderPage.getBankWireChechBox().click();
		}
		System.out.println("BankWire kliknuto");

		/*
		 * validate that when
		 * "I agree to the terms of service and will adhere to them unconditionally.\"
		 * is not checked,order button is disabled
		 */
		checkBoxStatus = orderPage.getIAgreeTandC().isSelected();
		if (checkBoxStatus) {
			orderPage.getIAgreeTandC().click();
		}
		System.out.println("ToS nije cekirano");

		sa.assertFalse(orderPage.getOrderBtn().isEnabled());

		/*
		 * validate that when
		 * "I agree to the terms of service and will adhere to them unconditionally.\"
		 * is checked,order button is enabled
		 */
		orderPage.getIAgreeTandC().click();

		sa.assertTrue(orderPage.getOrderBtn().isEnabled());

		sa.assertAll();
	}

}
