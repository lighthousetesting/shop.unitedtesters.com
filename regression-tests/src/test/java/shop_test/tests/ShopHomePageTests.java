package shop_test.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShoppingChartPage;

import java.util.List;
import java.util.Scanner;

/**
 * This class holds tests for home page
 * 
 * @version 0.1
 * @author Sinisa Vrhovac
 */
public class ShopHomePageTests extends BaseTest {

	private static final SoftAssert sa = new SoftAssert();

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
	 * Count number of products on home page and validate if matches expected size
	 * provided as parameter.
	 *
	 * @param expectedSize Number of products expected to be displayed on page
	 */
	@Test(priority = 3)
	@DisplayName("Home Page Product representation")
	@Description("Validate that every products is represented by image, title and price")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-3", url = "https://lighthousetesting.atlassian.net/browse/TP1-3")
	@Feature("AC03 - Product is represented by image, title and price")

	public void ShopHomePageProductCountTest() {

		ShopHomePage homePage = new ShopHomePage(getDriver());
		List<WebElement> products = homePage.getHomeProducts();

		WebElement image;
		String title;
		String price;

		for (int i = 0; i < products.size(); i++) {
			try {
				image = homePage.getHomeProductImage(products, i);
			} catch (Exception e) {
				image = null;
			}
			sa.assertNotNull(image);
			
			try {
				title = homePage.getHomeProductName(products, i);
			} catch (Exception e) {
				title = null;
			}
			sa.assertNotNull(title);
			
			try {
				price = homePage.getHomeProductName(products, i);
			} catch (Exception e) {
				price = null;
			}
			sa.assertNotNull(price);
			
			System.out.println(i);
			
			
		}
		sa.assertAll();
	}

}