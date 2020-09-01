package shop_test.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import shop_test.framework.core.BaseTest;
import shop_test.pageobjects.ShopHomePage;
import shop_test.pageobjects.ShopProductDetailPage;
import shop_test.pageobjects.ShoppingChartPage;

    /**
     * This class holds tests for Shopping cart page
     *
     * @version 0.1
     * @author Vesna Zivanovic Vukmirica
     */

    public class ShopCartPageTest extends BaseTest {



        private static final SoftAssert sa = new SoftAssert();
        private static int prNo = 2;

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

        


       /* @BeforeTest
        public void chooseProduct(int prNo) {
            ShopHomePage homePage = new ShopHomePage(getDriver());
            homePage.clickHomeProduct(prNo);

        }
*/

            @Test
               public void checkProductPrice(@Optional("2") int prNo){
                ShopHomePage hp = new ShopHomePage(getDriver());
                String proPrice = hp.getHomeProductName(2);
                hp.clickHomeProductPrice(2);
                ShopProductDetailPage dp= new ShopProductDetailPage(getDriver());
                dp.addToCartBtn().click();
              //  dp.
            // ShopProductDetailPage detailPage = new ShopProductDetailPage(getDriver());


               /* ShoppingChartPage scp = new ShoppingChartPage(getDriver());
                String productPrice = hp.getHomeProductPrice(prNo);
                String ShopCartProductPrice = scp.getShopCartProductPrice(prNo);
                sa.assertEquals(proPrice, NOVA CENA);
                sa.assertAll();*/
            }



    }




