package com.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class HeaderPage extends AbstractPage {

	public HeaderPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private String expandSearchButtonLocator = "a[data-mf-expand*='Search'] span";
	private String womenRadioButtonLocator = "[for*='Womens']";
	private String menRadioButtonLocator = "[for*='Mens']";
	private String cartButtonLocator = "a.miniCart--hover";
	private String searchInputLocator = "input#search";
	private String searchSubmitButtonLocator = "#searchSubmit";

	public void expandSearch() {
		waitForElementByCssLocator(expandSearchButtonLocator).click();
	}

	public void goToCart() {
		waitForElementByCssLocator(cartButtonLocator).click();
	}

	public void selectGender(String gender) {
		waitForPageToLoad();
		if (gender.contentEquals("men")) {
			waitForElementByCssLocator(menRadioButtonLocator).click();
		} else if (gender.contentEquals("women")) {
			waitForElementByCssLocator(womenRadioButtonLocator).click();
		}
	}

	public void typeSearchValue(String searchValue) {
		waitForElementByCssLocator(searchInputLocator).sendKeys(searchValue);
	}

	public void submitSearch() {
		waitForElementByCssLocator(searchSubmitButtonLocator).click();
	}
}
