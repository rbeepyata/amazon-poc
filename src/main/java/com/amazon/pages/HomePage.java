package com.amazon.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "searchDropdownBox")
    private WebElement dropdownSearchIn;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement textboxSearch;

    public void setCategory(String categoryName) {
        new Select(dropdownSearchIn).selectByVisibleText(categoryName);
    }

    @Step("Search for the product: {1} in the {0} category")
    public void searchForProduct(String categoryName, String searchText) {
        setCategory(categoryName);
        textboxSearch.sendKeys(searchText, Keys.ENTER);
    }

}
