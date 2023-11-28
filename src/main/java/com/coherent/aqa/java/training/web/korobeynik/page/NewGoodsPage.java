package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.goods.Goods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.time.Duration.ofSeconds;


public class NewGoodsPage extends BasePage {

    @FindBy(css = ".product-item:first-of-type")
    private WebElement firstGoodItem;

    @FindBy(css = ".action.towishlist:first-of-type")
    private WebElement addToWishList;


    @FindAll(@FindBy(how = How.XPATH, using = "//*[contains(@class, 'product-items')]/li"))
    private List<WebElement> productItems;

    @FindBy(css = ".swatch-option.text:first-of-type")
    private WebElement firstSize;

    @FindBy(css = ".swatch-option.color:first-of-type")
    private WebElement firstColour;

    @FindBy(css = ".product-info-main span.base")
    private WebElement nameLabel;

    @FindBy(css = ".product-info-main span.price")
    private WebElement priceLabel;

    @FindBy(css = "button.action.tocart.primary")
    private WebElement addToCartButton;

    @FindBy(css = ".message-success")
    private WebElement successMessage;

    @FindBy(css = ".action.showcart")
    private WebElement cartIcon;

    @FindBy(css = ".counter-number")
    private WebElement goodsAmount;

    @FindBy(xpath = "//span[contains(text(),'View and Edit Cart')]")
    private WebElement viewAndEditCart;

    public NewGoodsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverFistGoodItem() {
        hoverOverWebElement(firstGoodItem);
    }

    public WishListPage addToWishList() {
        wait.waitForElementDisplayed(addToWishList, ofSeconds(5));
        addToWishList.click();
        return new WishListPage(driver);
    }

    public List<Goods> getThreeGoodsToCart() {
        List<Goods> goods = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            productItems.get(i).click();
            wait.waitForElementDisplayed(firstSize, ofSeconds(3));
            firstSize.click();
            firstColour.click();
            addToCartButton.click();
            Goods goodItem = new Goods(nameLabel.getText(),
                    parseDouble(priceLabel.getText().trim().replace("$", "")));
            goods.add(goodItem);
            wait.waitForElementDisplayed(successMessage, ofSeconds(5));
            driver.navigate().back();
            wait.waitForElementDisplayed(productItems.get(i), ofSeconds(3));
        });
        return goods;
    }

    public CartPage navigateToCart(){
        cartIcon.click();
        wait.waitForElementDisplayed(viewAndEditCart, ofSeconds(5));
        viewAndEditCart.click();
        return new CartPage(driver);
    }

}
