import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShoppingChartPage;

/**
 * This class holds tests for home page
 * @version 0.1
 * @author Sinisa Vrhovac
 */
public class ShopHomePageTests extends BaseTest {

    private static SoftAssert sa = new SoftAssert();

    /**
     * Open home page, the URL is specified in Tests.xml as parameter
     * @version 0.1
     * @author Sinisa Vrhovac
     *
     * @param URL The page URL to open before each test
     */
    @BeforeTest
    @Parameters ("base-url")
    public void openPage (String URL){
        this.open(URL);
    }

    /**
     * Count number of products on home page and validate
     * if matches expected size provided as parameter.
     * @version 0.1
     * @author Sinisa Vrhovac
     *
     * @param expectedSize Number of products expected to be displayed on page
     */
    @Test
    @Parameters ("page-size")
    public void ShopHomePageProductCountTest (int expectedSize) {
        ShopHomePage homePage = new ShopHomePage(getDriver());
        int size = homePage.getHomeProducts().size();
        sa.assertEquals(size, expectedSize);
        sa.assertAll();
    }

    /**
     * Validates that product properties are present on page.
     * @version 0.1
     * @author Sinisa Vrhovac
     */
    @Test (dataProvider = "dp-product", dataProviderClass = DProvider.class)
    @Ignore
    public void ShopHomePageProductDetailsTest (){

    }

    @Test
    public void test1 (){
        ShoppingChartPage shp = new ShoppingChartPage(getDriver());
        shp.getArrowUpBtn().click();
        // shp.arrowUpBtn;
    }
}