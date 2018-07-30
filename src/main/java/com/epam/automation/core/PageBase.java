package com.epam.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase {
	private static final Logger logger = LoggerFactory.getLogger(PageBase.class);
	
	protected WebDriver driver;

	public PageBase(WebDriver driver){
	    this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
