package com.amazon.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultsPage extends PageBase {

    public ResultsPage(WebDriver driver){
        super(driver);
    }

    protected static final String LISTITEM_GENERIC_ELEMENT_PATH = "//ul[contains(@id, 'results-list')]//li//a[descendant::*[contains(text(),'%%')]]";
    protected static final String REPLACE_TOKEN = "%%";

    @Step("Choose the item: {0} from the results")
    public void chooseAnItemByName(String itemName) {
        WebElement element = getDriver().findElement(By.xpath(
                LISTITEM_GENERIC_ELEMENT_PATH.replace(REPLACE_TOKEN, itemName)
        ));
        element.click();
    }
}
