package com.epam.automation.core;

import com.epam.automation.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase{

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setupTest() {
        driver.set(DriverFactory.getDriver(ConfigProperties.BROWSER));
        getDriver().manage().window().maximize();
        getDriver().get(ConfigProperties.URL);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().quit();
    }

    @AfterClass
    void terminate () {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}
