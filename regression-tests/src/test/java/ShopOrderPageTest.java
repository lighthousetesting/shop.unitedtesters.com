import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import shop_test.framework.core.BaseTest;

/**
 * This class holds tests for order page
 * @version 0.1
 * @author Ljiljana Vrhovac-Kapor
 */
public class ShopOrderPageTest extends BaseTest {
  @Test
  public void f() {
  }
  
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
   * click on one random product (product details page opens)
   *
   *
   */
  @BeforeTest
  public void chooseProduct() {
	  
  }
  
}
