package com.amazon.pages;

import com.epam.automation.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "nav-link-yourAccount")
    private WebElement linkSignIn;

    @FindBy(id = "ap_email")
    private WebElement textboxEmailOrMobilePhoneNumber;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement buttonContinue;

    @FindBy(id = "ap_password")
    private WebElement textboxPassword;

    @FindBy(xpath = "//*[@id='signInSubmit']")
    private WebElement buttonLogin;

    @Step("Login to the application with username: {0}")
    public void login(String username, String password) {
        linkSignIn.click();
        textboxEmailOrMobilePhoneNumber.sendKeys(username);
        buttonContinue.click();
        textboxPassword.sendKeys(password);
        buttonLogin.click();
    }

}
