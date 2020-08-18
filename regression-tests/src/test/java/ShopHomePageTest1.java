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

public class ShopHomePageTest1 extends BaseTest{
  
	
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
	 * Test 1: Count products on home page and validate if the number matches
	 * expected size.
	 * 
	 */
	@Test
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

		sa.assertTrue(size <= expectedSize);
		
		sa.assertAll();
	}
}
