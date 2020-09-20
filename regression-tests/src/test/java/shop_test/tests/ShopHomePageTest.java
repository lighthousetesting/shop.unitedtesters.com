package shop_test.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.WebElement;

import shop_test.domain.core.Product;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShoppingChartPage;

import java.util.List;

/**
 * This class holds tests for home page
 * @version 0.1
 * @author Sinisa Vrhovac
 */
class ShopHomePageTest extends BaseTest {

    /**
     * Open home page, the URL is specified in Tests.xml as parameter
     *
     * @param URL The page URL to open before each test
     */
    @BeforeMethod ()
    @Parameters ("base-url")
    public void openPage (@Optional("https://shop.unitedtesters.com/") String URL){
        this.open(URL);
    }

    /**
     * Count number of products on home page and validate
     * if matches expected size provided as parameter.
     *
     * @param expectedSize Number of products expected to be displayed on page
     */
    @Test (priority = 2)
    @Parameters ("page-size")
    @DisplayName("Home Page Product Count Test")
    @Description("Validate that expected number of products is displayed on page")
    @Epic("TP1-2")
    @Story("R_001 - Display products on home page")
    @Link(name = "JIRA Issue TP1-11", url = "https://lighthousetesting.atlassian.net/browse/TP1-11")
    @Feature("AC02 - Maximum number of products displayed is 20;")
	@Severity(SeverityLevel.CRITICAL)
    public void ShopHomePageProductCountTest (@Optional("20") int expectedSize) {
		SoftAssert sa = new SoftAssert();
    	ShopHomePage homePage = new ShopHomePage(getDriver());
    	int size = homePage.getHomeProducts().size();
    	sa.assertEquals(size, expectedSize);
        sa.assertAll();
    }

    @Test
    @Parameters ("product-index")
	@DisplayName("Validate product link leads to detail page")
	@Description("Validate that home page product link leads to product details page")
	@Epic("TP1-1")
	@Story("R_001 - Display products on home page")
	@Feature("R001 TC005 Product title is link to product detail page")
	@Link(name = "JIRA Issue TP1-17", url = "https://lighthousetesting.atlassian.net/browse/TP1-17")
	@Severity(SeverityLevel.MINOR)
	public void clickProductTest (@Optional("1") int index){
		SoftAssert sa = new SoftAssert();
        ShopHomePage hp = new ShopHomePage(getDriver());
        String productName = hp.getHomeProductName(index).toLowerCase();
        hp.clickHomeProduct(index);
        sa.assertEquals(hp.getTitle().toLowerCase(), productName);
        sa.assertAll();
    }

    /**
     * Validates that product properties are present on page.
	 * @param id Product ID, find product by ID
	 * @param name Name of the product
	 * @param price Price string of product including currency
	 * @param image Full URL of product image
     */
    @Test (priority = 1, dataProvider = "dp-product", dataProviderClass = shop_test.dataProviders.DProvider.class)
	@DisplayName("Display products on home page")
	@Description("Validate that product is presented with correct name, price and image")
	@Epic("TP1-1")
	@Story("R_001 - Display products on home page")
	@Feature("AC03 - Proizvod je predstavljen sa slikom proizvoda, nazivom proizvoda i cenom;")
	@Link(name = "JIRA Issue TP1-13", url = "https://lighthousetesting.atlassian.net/browse/TP1-13")
	@Severity(SeverityLevel.BLOCKER)
	public void ShopHomePageProductDetailsTest (int id, String name, String price, String image){
		SoftAssert sa = new SoftAssert();
		ShopHomePage hp = new ShopHomePage(getDriver());
		Product product = hp.getHomeProductById(id);

		sa.assertEquals(product.getName(), name);
		sa.assertEquals(product.getPrice(), price);
		sa.assertEquals(product.getImage(), image);
		sa.assertAll();
    }

    @Test
    @Ignore
    public void test1 (int size){
        ShoppingChartPage shp = new ShoppingChartPage(getDriver());
        shp.getArrowUpBtn().click();
        int sq = size * size;
        // shp.arrowUpBtn;
    }
    
    /**
	 * Check element position and validate if product are displayed in
	 * 4-columns matrix
	 * 
	 * @author Marija Rajak
	 */
	@Test (priority = 1)
	@DisplayName("Home Page Product Display Test")
	@Description("Validate that products are displayed as a matrix on page, in four columns")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-12", url = "https://lighthousetesting.atlassian.net/browse/TP1-12")
	@Feature("AC01 - Products are displayed in 4-column matrix")
	public void testProductsDisplay() {
		SoftAssert sa = new SoftAssert();
		this.fullscreen();
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
	
	/**
	 * Check if product is represented by image, title and price.
	 *
	 * 
	 */
	@Test(priority = 3)
	@DisplayName("Home Page Product representation")
	@Description("Validate that every products is represented by image, title and price")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-13", url = "https://lighthousetesting.atlassian.net/browse/TP1-13")
	@Feature("AC03 - Product is represented by image, title and price")
	public void ShopHomePageProductRepresentationTest() {
		SoftAssert sa = new SoftAssert();
		ShopHomePage homePage = new ShopHomePage(getDriver());
		int numberOfProducts = homePage.getProductsList().size();
		for (int i = 0; i < numberOfProducts; i++) {
			sa.assertNotEquals(homePage.getHomeProductName(i), "");
			sa.assertNotEquals(homePage.getHomeProductPrice(i), "");
			sa.assertNotEquals(homePage.getHomeProductImageSrc(i), "");
		}
		sa.assertAll();
	}
	
}