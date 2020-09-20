package shop_test.tests;

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

		ShopHomePage homePage = new ShopHomePage(getDriver());

		// GEt the number of products on page, -1, to get into range of indexes:
		int numberOfProducts = homePage.getHomeProducts().size() - 1;
		// get a random double in range 0..1, multiple by numberOfProducts and casting
		// into integer by (int).
		int prNo = (int) (Math.random() * numberOfProducts);

		homePage.clickHomeProduct(prNo);
		this.logger.info("chooseProduct");
		//System.out.println("chooseProduct");

		ShopProductDetailPage detailPage = new ShopProductDetailPage(getDriver());
		detailPage.addToCartBtn().click();
		this.logger.info("addToCartBtn");
		//System.out.println("addToCart");

		detailPage.proceedToCOBtn().click();
		this.logger.info("proceedToCOBtn");
		//System.out.println("Proceed1");

		ShoppingChartPage cartPage = new ShoppingChartPage(getDriver());
		cartPage.getProceedBtn().click();
		this.logger.info("getProceedBtn");
		//System.out.println("Proceed2");
	}

	/**
	 * Fill in mandatory fields in personal info form
	 * Validate that privacy agreement is checked
	 * 
	 * @param firstName to fill in personal info form
	 * @param lastName  to fill in personal info form
	 * @param eMail     to fill in personal info form
	 */
	@Test(priority = 1, dataProvider = "dp-user", dataProviderClass = shop_test.dataProviders.DProvider.class)
	@DisplayName("checkBoxPrivacyFalse")
	@Description("Validate that check-box 'I agree to the terms and conditions and the privacy policy' is mandatory")
	@Epic("TP1-10")
	@Story("R_003 - As a customer, I want to complete the purchase of the selected product")
	@Link(name = "JIRA Issue TP1-10", url = "https://lighthousetesting.atlassian.net/browse/TP1-10")
	@Feature("AC06 - Validate that agreeing to \"I agree to the terms and conditions and the privacy policy\" is mandatory;")
	public void checkBoxPrivacyFalse(
			@Optional("John") String firstName,
			@Optional("Doe") String lastName,
			@Optional("john.doe@mail.com") String eMail)
	{
		SoftAssert sa = new SoftAssert();
		orderPage = new ShopOrderPage(getDriver());
		orderPage.getFirstNameField().sendKeys(firstName);
		orderPage.getLastNameField().sendKeys(lastName);
		orderPage.getEmailField().sendKeys(eMail);
		this.logger.info("fillInPersonalInfo");
		//System.out.println("fillInPersonalInfo");

		boolean checkBoxStatus = orderPage.getIAgreePrivacy().isSelected();
		if (checkBoxStatus) {
			orderPage.CheckIAgreePrivacy();
		}
		orderPage.getContinueBtnPersonal().click();
		this.logger.info("nulti");
		//System.out.println("nulti");

		boolean isDisplayed = orderPage.getContinueBtnPersonal().isDisplayed();
		this.logger.info("prvi");
		//System.out.println("prvi");
		sa.assertEquals(isDisplayed, true);
		orderPage.CheckIAgreePrivacy();
		orderPage.getContinueBtnPersonal().click();
		isDisplayed = orderPage.getContinueBtnAddress().isDisplayed();
		this.logger.info("drugi");
		//System.out.println("drugi");
		sa.assertEquals(isDisplayed, true);
		sa.assertAll();
	}

	@Test(priority = 2, dataProvider = "dp-user", dataProviderClass = shop_test.dataProviders.DProvider.class)
	@DisplayName("checkBoxToSFalse")
	@Description("Validate that check-box 'I agree to the terms and conditions and the privacy policy' is mandatory")
	@Epic("TP1-15")
	@Story("R_003 - As a customer, I want to complete the purchase of the selected product")
	@Link(name = "JIRA Issue TP1-15", url = "https://lighthousetesting.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=TP1&modal=detail&selectedIssue=TP1-15")
	@Feature("AC07 - Validate that it is not possible to complete a purchase if the customer has not agreed with \"I agree to the terms of service and will adhere to them unconditionally.\" by checking checkbox")
	public void checkBoxToSFalse(
			@Optional("Adresa 1") String address,
			@Optional("City") String city,
			@Optional("100000") String postalCode) {

		SoftAssert sa = new SoftAssert();
		orderPage = new ShopOrderPage(getDriver());

		// fill in mandatory address field - part of test precondition
		orderPage.getAddressField().sendKeys(address);
		orderPage.getCityField().sendKeys(city);
		orderPage.clickStateDropDownOption();
		orderPage.getPostalCodeField().sendKeys(postalCode);
		orderPage.getContinueBtnAddress().click();
		this.logger.info("fillInAddress");
		//System.out.println("fillInAddress");

		// shipping method continue - part of test precondition

		orderPage.getContinueBtnShipping().click();
		this.logger.info("fillInShipping");
		//System.out.println("fillInShipping");

		// Validate that Pay by Bank Wire Check Box is selected - part of test
		// precondition

		boolean checkBoxStatus = orderPage.getBankWireChechBox().isSelected();
		if (!checkBoxStatus) {
			orderPage.getBankWireChechBox().click();
		}
		this.logger.info("BankWire kliknuto");
		//System.out.println("BankWire kliknuto");

		/*
		 * validate that when
		 * "I agree to the terms of service and will adhere to them unconditionally.\"
		 * is not checked,order button is disabled
		 */
		checkBoxStatus = orderPage.getIAgreeTandC().isSelected();
		if (checkBoxStatus) {
			orderPage.getIAgreeTandC().click();
		}
		this.logger.info("ToS nije cekirano");
		//System.out.println("ToS nije cekirano");

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
