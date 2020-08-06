import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.support.PageFactory;
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

    private static final SoftAssert sa = new SoftAssert();

    /**
     * Open home page, the URL is specified in Tests.xml as parameter
     *
     * @param URL The page URL to open before each test
     */
    @BeforeTest
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
    @Test
    @Parameters ("page-size")
    @DisplayName("Home Page Product Count Test")
    @Description("Validate that expected number of products is displayed on page")
    @Epic("TP1-2")
    @Story("R_001 - Display products on home page")
    @Link(name = "JIRA Issue TP1-3", url = "https://lighthousetesting.atlassian.net/browse/TP1-3")
    @Feature("AC02 - Maximum number of products displayed is 20;")
    public void ShopHomePageProductCountTest (@Optional("20") int expectedSize) {
        //ShopHomePage homePage = new ShopHomePage(getDriver());
        ShopHomePage hp = PageFactory.initElements(getDriver(), ShopHomePage.class);

        sa.assertEquals(hp.getHomeProducts().size(), expectedSize);

        //int size = homePage.getHomeProducts().size();
        //sa.assertEquals(size, expectedSize);
        sa.assertAll();
    }

    /**
     * Validates that product properties are present on page.
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