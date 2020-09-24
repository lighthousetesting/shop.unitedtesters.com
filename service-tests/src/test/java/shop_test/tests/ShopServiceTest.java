package shop_test.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ShopServiceTest {

    private static String API_Key = "CUF1DM8ZE2S2SK1MKFE8991SVHEZJ15M";
    private static String productUrl = "https://shop.unitedtesters.com/api/products/{product}";

    @Test
    @Parameters({"id", "product_name"})
    @DisplayName("Product details API")
    @Description("Validate that correct product information is returned for supplied product ID")
    @Epic("TP1-8")
    @Story("R_001 - Retrieve product information by product ID")
    public void checkProductData(
            @Optional("1") String id,
            @Optional("Hummingbird printed t-shirt") String name){
        given()
            .pathParam("product", id)
            .header("Output-Format", "JSON")
            .auth()
                .preemptive()
                    .basic(API_Key, "")
        .when()
            .get(productUrl)
        .then()
            .assertThat()
                .statusCode(200)
                .body("product.name", equalTo(name));
    }

    @Test
    @Parameters ({"country", "zipcode", "city"})
    @DisplayName("Validate correct city name is returned")
    @Description("Validate that for specified country and postcode a correct city name is returned")
    @Epic("TP1-9")
    @Story("R_001 - Find city name by postcode")
    public void checkCityForZipCode(
            @Optional("us") String country,
            @Optional("90210") String zipcode,
            @Optional("Beverly Hills") String city) {
        given().
            pathParam("country",country).
            pathParam("zipcode",zipcode).
        when().
            get("http://api.zippopotam.us/{country}/{zipcode}").
        then().
            assertThat().
                body("places.'place name'[0]",equalTo(city));
    }
}
