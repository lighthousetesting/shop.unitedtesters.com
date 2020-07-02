
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;



public class ShopHomePageTests extends BaseTest {

    private String URL = "https://shop.unitedtesters.com/";
    private int expectedSize = 20;
    private static SoftAssert sa = new SoftAssert();

    @Test
    public void ShopHomePageTest() {
        ShopHomePage shopHomePage = new ShopHomePage(getDriver());
        this.open(URL);
        int size = shopHomePage.getHomeProducts().size();
        sa.assertEquals(size, expectedSize);
    }
}