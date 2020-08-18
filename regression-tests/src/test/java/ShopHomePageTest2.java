import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;

public class ShopHomePageTest2 extends BaseTest {
	
	private static SoftAssert sa = new SoftAssert();

	/**
	 * Open home page
	 *
	 * @param URL of home page, specified in testng.xml as a global parameter
	 */
	@BeforeMethod
	// @Parameters("base-url")
	public void openPage() {
		this.open("https://shop.unitedtesters.com/");

	}

	/**
	 * Test 1: Check element position and validate if product are displayed in
	 * 4-columns matrix
	 * 
	 * @author Marija Rajak
	 */
	@Test
	
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
