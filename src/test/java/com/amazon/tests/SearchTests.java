package com.amazon.tests;

import com.amazon.pages.HomePage;
import com.amazon.pages.ItemPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ResultsPage;
import com.epam.automation.core.ConfigProperties;
import com.epam.automation.core.PageBase;
import com.epam.automation.core.TestBase;
import com.epam.utilities.PropertyUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.ArrayList;

public class SearchTests extends TestBase {

    @Test(description = "Search for a book and add to cart.")
    public void testSearchABook(){
        PropertyUtil testdata = new PropertyUtil(".\\src\\test\\resources\\testdata\\searchdata.txt");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigProperties.USERNAME, ConfigProperties.PASSWORD);

        HomePage homePage = new HomePage(getDriver());
        homePage.searchForProduct(testdata.get("category"), testdata.get("searchtext") );

        ResultsPage resultsPage = new ResultsPage(getDriver());
        resultsPage.chooseAnItemByName(testdata.get("bookname"));

/*
        ArrayList<String> handles = new ArrayList<String>(getDriver().getWindowHandles());
        if (handles.size()>1) {
            getDriver().switchTo().window(handles.get(1));
        }

        ItemPage itemPage = new ItemPage(getDriver());
        itemPage.addTheItemToCart();

        Assert.assertTrue(itemPage.isItemAddedToCart());
*/

    }

    @Test(description = "Simple Login Test")
    public void testLogin(){
        PropertyUtil testdata = new PropertyUtil(".\\src\\test\\resources\\testdata\\searchdata.txt");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(ConfigProperties.USERNAME, ConfigProperties.PASSWORD);
        takeScreenshot();

        Assert.assertTrue(true);

    }


    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
