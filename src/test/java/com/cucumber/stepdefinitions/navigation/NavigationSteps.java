package com.cucumber.stepdefinitions.navigation;

import java.util.List;
import java.util.Map;

import com.cucumber.pages.AbstractPage;
import com.cucumber.pages.desktop.HeaderPage;
import com.cucumber.pages.mobile.HeaderMPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.utils.ConfigUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The class has a small adjustment in the after class to include some reporting
 * actions
 */
public class NavigationSteps {
	public HeaderPage headerPage;
	public AbstractPage abstractPage;

	public HeaderMPage headerMPage;

	public String deviceType;

	public NavigationSteps(WebDriverCore driver) {
		deviceType = driver.getDeviceType();
//		System.out.println("DEVICE: " + deviceType);
		//desktop pages
		abstractPage = new AbstractPage(driver.getDriver());
		headerPage = new HeaderPage(driver.getDriver());
		
		//mobile pages
		headerMPage = new HeaderMPage(driver.getDriver());
	}

	@Given("the user is in home page")
	public void givenTheUserIsOnTheHomePage() {
		abstractPage.navigateTo(ConfigUtils.getBaseUrl());
	}

	@Given("searches for '(.*)' in '(.*)' section")
	public void givenTheUserSearchesForProduct(String product, String gender) {
		if (deviceType != null && deviceType.contains("mobile")) {
			headerMPage.expandSearch();
		} else {

			headerPage.expandSearch();
			headerPage.selectGender(gender);
			headerPage.typeSearchValue(product);
			headerPage.submitSearch();

		}
	}

	@And("click the items and verify the pageUrls")
	public void clickTheItems(Map<String, String> items) {
		for (String itemKey : items.keySet()) {
			System.out.println("key: " + itemKey);
			System.out.println("value: " + items.get(itemKey));
			headerPage.selectMenuOption(itemKey);
			headerPage.verifyTheUrlPage(items.get(itemKey));
		}
	}

	@And("click the items")
	public void clickTheItems(List<String> items, List<String> pageNames) {
		for (String string : items) {
			headerPage.selectMenuOption(string);
		}
	}

	@Then("select the '(.*)' option")
	public void givenTheUserSelectsTheSpecificSection(String section) {
		headerPage.selectSection(section);
	}

	@Given("click the '(.*)'")
	public void givenTheUserSelectsAMenuOption(String menuOption) {
		headerPage.selectMenuOption(menuOption);
	}

	@When("the user goes to cart")
	public void goToCart() {
		headerPage.goToCart();
	}
}
