import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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

/**
 * This class holds tests for home page
 * 
 * @version 0.1
 * @author Sinisa Vrhovac
 */
public class ShopHomePageTests extends BaseTest {

	private static SoftAssert sa = new SoftAssert();

	/**
	 * Open home page
	 *
	 * @param URL of home page, specified in testng.xml as a global parameter
	 */
	@BeforeMethod
	//@Parameters("base-url")
	public void openPage() {
		this.open("https://shop.unitedtesters.com/");

	}

	/**
	 * Test 2: Count products on home page and validate if the number matches
	 * expected size provided as parameter.
	 *
	 * @param expectedSize Number of products expected to be displayed on page,
	 *                     specified in testng.xml as global parameter
	 */
	@Test(priority = 2)
	//@Parameters({"page-size"})
	@DisplayName("Home Page Product Count Test")
	@Description("Validate that expected number of products is displayed on page")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-3", url = "https://lighthousetesting.atlassian.net/browse/TP1-3")
	@Feature("AC02 - Maximum number of products displayed is 20;")

	public void testProductsNumber() {

		int expectedSize = 20;
		ShopHomePage homePage = new ShopHomePage(getDriver());
		int size = homePage.getHomeProducts().size();

		sa.assertEquals(size, expectedSize);

		sa.assertAll();
	}

	/**
	 * Test 1: Check element position and validate if product are displayed in
	 * 4-columns matrix
	 * 
	 * @author Marija Rajak
	 */
	@Test(priority = 1)
	// @Parameters("page-size")
	@DisplayName("Home Page Product Display Test")
	@Description("Validate that products are displayed as a matrix on page, in four columns")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-3", url = "https://lighthousetesting.atlassian.net/browse/TP1-3")
	@Feature("AC01 - Products are displayed in 4-column matrix")

	public void testProductsDisplay() {

		ShopHomePage homePage = new ShopHomePage(getDriver());
		List<WebElement> products = homePage.getHomeProducts();

		int[] positionsY = new int[products.size()];

		for (int i = 0; i < products.size(); i++) {
			positionsY[i] = products.get(i).getLocation().getY();
		}

		for (int j = 0; j < products.size(); j += 4) {
			for (int k = j + 1; k < j + 4; k++) {

				sa.assertEquals(positionsY[j], positionsY[k]);
			}

		}
		sa.assertAll();
	}
}