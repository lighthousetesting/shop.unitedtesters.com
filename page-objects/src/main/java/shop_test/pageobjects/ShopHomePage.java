package shop_test.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shop_test.framework.core.BasePage;

import java.util.List;

public class ShopHomePage extends BasePage {

    private static WebElement element = null;
    private static By homeCartBtn = By.cssSelector("div#_desktop_cart a");
    private static By homeProducts = By.cssSelector("section#content div.products  article");

    public ShopHomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHomeChartBtn(){
        waitForElementToAppear(homeCartBtn);
        return this.driver.findElement(homeCartBtn);
    }

    public List<WebElement> getHomeProducts(){
        return this.driver.findElements(homeProducts);
    }

}