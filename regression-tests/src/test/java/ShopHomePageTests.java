import org.testng.annotations.Test;
import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.homepage.ShopHomePage;

public class ShopHomePageTests extends BaseTest {

    @Test
    public void ShopHomePageTests() {
        ShopHomePage shopHomePage = new ShopHomePage(getDriver());
    }
}