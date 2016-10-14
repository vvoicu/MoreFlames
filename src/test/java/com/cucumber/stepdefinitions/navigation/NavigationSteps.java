package com.cucumber.stepdefinitions.navigation;

import com.cucumber.pages.AbstractPage;
import com.cucumber.pages.HeaderPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * The class has a small adjustment in the after class to include some reporting
 * actions
 * 
 *
 */
public class NavigationSteps {
	public HeaderPage headerPage;
	public AbstractPage abstractPage;

	public NavigationSteps(WebDriverCore driver) {
		abstractPage = new AbstractPage(driver.getDriver());
		headerPage = new HeaderPage(driver.getDriver());
	}

	@Given("the user is in home page")
	public void givenTheUserIsOnTheHomePage() {
		abstractPage.navigateTo(Constants.BASE_URL);
	}

	@Given("searches for '(.*)' in '(.*)' section")
	public void givenTheUserSearchesForProduct(String product, String gender) {
		headerPage.expandSearch();
		headerPage.selectGender(gender);
		headerPage.typeSearchValue(product);
		headerPage.submitSearch();
		
	}

	@When("the user goes to cart")
	public void goToCart() {
		headerPage.goToCart();
	}


}
