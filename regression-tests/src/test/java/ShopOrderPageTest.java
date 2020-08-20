import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShopProductDetailPage;
import shop_test.pageobjects.ShoppingChartPage;

/**
 * This class holds tests for order page
 * 
 * @version 0.1
 * @author Ljiljana Vrhovac-Kapor
 */

public class ShopOrderPageTest extends BaseTest {
	@Test
	public void f() {
	}

	private static final SoftAssert sa = new SoftAssert();
	private static int prNo = 5;

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
	 * Note: for version 0.1 I am testing always on product no. 5.
	 */
	@BeforeTest
	public void chooseProduct() {
		ShopHomePage homePage = new ShopHomePage(getDriver());
		homePage.getHomeProductImageLink(prNo).click();
	}
	
	/**
	 * click on Add to Cart Btn
	 *
	 */
	@BeforeTest
	public void addToCart() {
		ShopProductDetailPage detailPage = new ShopProductDetailPage(getDriver());
		detailPage.addToCartBtn().click();
	}
	
	/**
	 * click on ProceedBtn Btn
	 *
	 */
	@BeforeTest
	public void Proceed1() {
		ShoppingChartPage cartPage = new ShoppingChartPage(getDriver());
		cartPage.getProceedBtn().click();
	}

}
