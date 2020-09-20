package shop_test.dataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

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
    public Object[][] dpProduct() {
        return new Object[][]{
            {
                19,
                "Customizable Mug",
                "$13.90",
                "https://shop.unitedtesters.com/22-home_default/customizable-mug.jpg"
            },
            {
                17,
                "Brown Bear Notebook",
                "$12.90",
                "https://shop.unitedtesters.com/19-home_default/brown-bear-notebook.jpg"
            },
        };
    }

    @DataProvider(name = "dp-user")
    public Object[][] dpUser(Method m) {

        switch (m.getName()) {
            case "checkBoxPrivacyFalse":
                return new Object[][]{
                    {
                        "Marko",
                        "Markovic",
                        "Marko.Markovic@gmail.com"
                    }
                };

            case "checkBoxToSFalse":
                return new Object[][]{
                    {
                        "Adresa probna",
                        "Grad",
                        "11000"
                    },
                };
        }
        return null;
    }
}