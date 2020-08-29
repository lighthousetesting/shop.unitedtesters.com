package shop_test.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShoppingChartPage;

import java.util.List;
import java.util.Scanner;

/**
 * This class holds tests for home page
 * @version 0.1
 * @author Sinisa Vrhovac
 */
class ShopHomePageTests extends BaseTest {

    private static final SoftAssert sa = new SoftAssert();

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
   
    public void ShopHomePageProductCountTest (@Optional("20") int expectedSize) {
        
    	ShopHomePage homePage = new ShopHomePage(getDriver());
        
    	int size = homePage.getHomeProducts().size();  
    	
    	sa.assertTrue(size <= expectedSize);
        sa.assertAll();
    }

    @Test
    @Parameters ("product-index")
    
    public void clickProductTest (@Optional("1") int index){
        ShopHomePage hp = new ShopHomePage(getDriver());
        String productName = hp.getHomeProductName(index).toLowerCase();
        hp.clickHomeProduct(index);
        sa.assertEquals(hp.getTitle().toLowerCase(), productName);
        sa.assertAll();
    }

    /**
     * Validates that product properties are present on page.
     */
    @Test (dataProvider = "dp-product", dataProviderClass = shop_test.dataProviders.DProvider.class)
    @Ignore
   
    public void ShopHomePageProductDetailsTest (){

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
	@Test (priority = 3)
	@DisplayName("Home Page Product Display Test")
	@Description("Validate that products are displayed as a matrix on page, in four columns")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-12", url = "https://lighthousetesting.atlassian.net/browse/TP1-12")
	@Feature("AC01 - Products are displayed in 4-column matrix")

	public void testProductsDisplay() {

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

}