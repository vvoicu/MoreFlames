package com.cucumber.pages.mobile;

import org.openqa.selenium.WebDriver;

import com.cucumber.pages.AbstractPage;

public class HeaderMPage extends AbstractPage{

	public HeaderMPage(WebDriver driver) {
		super(driver);
	}

	private String expandSearchButtonLocator = "a[data-mf-expand]";
	
	public void expandSearch() {
		waitForElementByCssLocator(expandSearchButtonLocator).click();
	}
}
