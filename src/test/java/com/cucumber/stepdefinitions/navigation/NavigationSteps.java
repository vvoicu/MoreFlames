package com.cucumber.stepdefinitions.navigation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.cucumber.pages.AbstractPage;
import com.cucumber.pages.HeaderPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.Constants;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The class has a small adjustment in the after class to include some reporting
 * actions
 * 
 *
 */
public class NavigationSteps {

	public WebDriver driver = new WebDriverCore().getDriver();
	public HeaderPage headerPage;
	public AbstractPage abstractPage;

	public NavigationSteps() {
		abstractPage = new AbstractPage(driver);
		headerPage = new HeaderPage(driver);
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
