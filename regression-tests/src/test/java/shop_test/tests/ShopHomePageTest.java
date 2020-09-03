package shop_test.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShopProductDetailPage;
import shop_test.pageobjects.ShoppingChartPage;

import java.util.List;
import java.util.Scanner;

/**
 * This class holds tests for home page
 * @version 0.1
 * @author Sinisa Vrhovac
 */
class ShopHomePageTest extends BaseTest {

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
	@Test (priority = 1)
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

		ShopHomePage homePage = new ShopHomePage(getDriver());
		
		String imageSrc;
		String title;
		String price;
		
		int numberOfProducts = homePage.getProductsList().size();

		for (int i = 0; i < numberOfProducts; i++) {

			imageSrc = homePage.getHomeProductImageSrc(i);
			sa.assertNotEquals(imageSrc, "");

			title = homePage.getHomeProductName(i);
			sa.assertNotEquals(title, "");

			price = homePage.getHomeProductPrice(i);
			sa.assertNotEquals(price, "");
		}
		
		sa.assertAll();
	}
	
	/**
	 * Check if product image is link to Product detail page
	 *
	 * 
	 */
	@Test(priority = 4)
	@DisplayName("Product image as a link")
	@Description("Validate that clicling on the product image navigates to the product's detail page")
	@Epic("TP1-2")
	@Story("R_001 - Display products on home page")
	@Link(name = "JIRA Issue TP1-16", url = "https://lighthousetesting.atlassian.net/browse/TP1-16")
	@Feature("R001(discussion)-Product image and title are clickable links ")

	public void imageLinkTest() {
		
		ShopHomePage homePage = new ShopHomePage(getDriver());
		int prodNumber = homePage.getHomeProducts().size();
		
		for (int i = 0; i < prodNumber; i++) {
			
			String prodName = homePage.getHomeProductName(i).toLowerCase();
			homePage.getHomeProductImageLink(i).click();
			ShopProductDetailPage prodDetailPage = new ShopProductDetailPage(getDriver());
			
			//String pageTitle = homePage.getTitle().toLowerCase();
			//sa.assertEquals(prodName, pageTitle); test pada jer naslov stranice nije identican s nazivom proizvoda, iako se prava stranica otvara
			
			String prodName2 = prodDetailPage.getProductTitle().toLowerCase();
			
			sa.assertEquals(prodName, prodName2);
			
			this.getDriver().navigate().back();
			homePage = new ShopHomePage(getDriver());
			}
		
		sa.assertAll();
	}


}