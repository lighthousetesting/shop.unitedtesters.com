import org.testng.annotations.DataProvider;

/**
 * This is a data provider class to feed data into test on test execution.
 * The data provide returns a 2D array of object where first dimension represent
 * distinct test data objects and second is options.
 * Data provider is referenced in tests by annotations.
 * @version 0.1
 * @author Sinisa Vrhovac
 */
public class DProvider {

    @DataProvider(name = "dp-product")
    public Object[][] dpMethod() {
        return new Object[][]{{"Value Passed"}};
    }

}