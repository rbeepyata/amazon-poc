package com.amazon.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends PageBase {

    public ItemPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "add-to-cart-button")
    private WebElement buttonAddToCart;

    protected static final String TEXT_ADDED_TO_CART_PATH = "//h1[contains(text(), 'Added to Cart')]";

    @FindBy(xpath= "//h1[contains(text(), 'Added to Cart')]")
    private WebElement textAddedToCart;

    public void addTheItemToCart() {
        buttonAddToCart.click();
    }

    public boolean isItemAddedToCart(){
        return !getDriver().findElements(By.xpath(TEXT_ADDED_TO_CART_PATH)).isEmpty();
    }
}
