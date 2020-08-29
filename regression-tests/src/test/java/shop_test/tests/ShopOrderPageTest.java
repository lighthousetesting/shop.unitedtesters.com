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
 * @version 1.0
 * @author Ljiljana Vrhovac-Kapor
 */

class ShopOrderPageTests extends BaseTest {

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
	 * Note: for version 1.0 I am testing always on product no. 5.
	 */
	@BeforeTest(dependsOnMethods = "openPage")
	public void chooseProduct() {
		ShopHomePage homePage = new ShopHomePage(getDriver());
		int prNo = 5;
		homePage.clickHomeProduct(prNo);
		System.out.println("chooseProduct");
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
	 * @param lastName to fill in personal info form
	 * @param eMail to fill in personal info form
	 */
	@BeforeTest(dependsOnMethods = "Proceed2")
	@Parameters({ "first-name", "last-name", "e-mail" })
	public void fillInPersonalInfo(String firstName, String lastName, String eMail) {
		orderPage = new ShopOrderPage(getDriver());
		orderPage.getFirstNameField().sendKeys(firstName);
		orderPage.getLastNameField().sendKeys(lastName);
		orderPage.getEmailField().sendKeys(eMail);
		System.out.println("fillInPersonalInfo");

	}
	
	@Test 
	@DisplayName("checkBoxFalse")
	@Description("Validate that check-box 'I agree to the terms and conditions and the privacy policy' is mandatory")
	@Epic("TP1-10")
	@Story("R_003 - As a customer, I want to complete the purchase of the selected product")
	@Link(name = "JIRA Issue TP1-10", url = "https://lighthousetesting.atlassian.net/browse/TP1-10")
	@Feature("AC06 - Validate that agreeing to \"I agree to the terms and conditions and the privacy policy\" is mandatory;")
	public void checkBoxFalse() {
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

}
