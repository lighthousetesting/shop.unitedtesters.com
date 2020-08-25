package shop_test.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShopOrderPage;
import shop_test.pageobjects.ShopProductDetailPage;
import shop_test.pageobjects.ShoppingChartPage;

/**
 * This class holds tests for order page
 * 
 * @version 0.3
 * @author Ljiljana Vrhovac-Kapor
 */

public class ShopOrderPageTest extends BaseTest {

	private static final SoftAssert sa = new SoftAssert();
	private static int prNo = 5;
	private static ShopOrderPage orderPage;
	private boolean checkBoxStatus = true;
	private boolean isDisplayed;

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
	 * Note: for version 0.2 I am testing always on product no. 5.
	 */
	@BeforeTest(dependsOnMethods = "openPage")
	public void chooseProduct() {
		ShopHomePage homePage = new ShopHomePage(getDriver());
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
	 * Fill in mandatory fields in personal info form
	 * 
	 * @param first-name, last-name and email, to fill in personal info form
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
	public void checkBoxFalse() {
		orderPage = new ShopOrderPage(getDriver());
		checkBoxStatus = orderPage.getIAgreePrivacy().isSelected();
		if (checkBoxStatus) {
			orderPage.CheckIAgreePrivacy();
		}
		orderPage.getContinueBtnPersonal().click();
		isDisplayed = orderPage.getContinueBtnAddress().isDisplayed();
		System.out.println("prvi");
		sa.assertEquals(isDisplayed, false);
		
		orderPage.CheckIAgreePrivacy();
		orderPage.getContinueBtnPersonal().click();
		isDisplayed = orderPage.getContinueBtnAddress().isDisplayed();
		System.out.println("drugi");
		sa.assertEquals(isDisplayed, true);
		
		sa.assertAll();
	}

}
