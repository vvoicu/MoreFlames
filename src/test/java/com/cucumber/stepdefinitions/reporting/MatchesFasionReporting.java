package com.cucumber.stepdefinitions.reporting;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.pages.AbstractPage;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.HeaderPage;
import com.cucumber.pages.ProductDetailsPage;
import com.cucumber.pages.ProductListPage;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.Constants;
import com.tools.Validations;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The class has a small adjustment in the after class to include some reporting
 * actions
 * 
 *
 */
public class MatchesFasionReporting {

	WebDriver driver;
	HeaderPage headerPage;
	AbstractPage abstractPage;
	ProductListPage productListPage;
	ProductDetailsPage productDetailsPage;
	CartPage cartPage;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage(driver);
		headerPage = new HeaderPage(driver);
		productListPage = new ProductListPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		cartPage = new CartPage(driver);
	}

	@Given("the user is in home page")
	public void givenTheUserIsOnTheHomePage() {
		driver.get(Constants.BASE_URL);
	}

	@Given("searches for '(.*)' in '(.*)' section")
	public void givenTheUserSearchesForProduct(String product, String gender) {
		headerPage.expandSearch();
		headerPage.selectGender(gender);
		headerPage.typeSearchValue(product);
		headerPage.submitSearch();
	}

	@Given("selects the product '(.*)'")
	public void givenTheUserSelectsTheProduct(String product) {
		productListPage.openProductDetails(product);
	}

	@Given("adds to cart '(.*)' products of size '(.*)'")
	public void givenTheUserAddsProductToCart(String quantity, String size) {
		productDetailsPage.addProductToCart(quantity, size);

	}

	@When("the user goes to cart")
	public void goToCart() {
		headerPage.goToCart();
	}

	@Then("the products should be correctly displayed")
	public void validateProductsInCart() {
		cartPage.getCartProducts();
		Validations.validateProducts();
	}

	@Then("the totals should be correctly calculated")
	public void validateTotalsInCart() {
		cartPage.getCartTotals();
		CartDataHandler.calculatedtotal = CartCalculations.calculateCartTotals(CartDataHandler.addedProductList, Constants.DELIVERY_PRICE);
		Validations.verifyTotals();
	}
	
	@Then("all the products displayed should be from '(.*)'")
	public void thenTheUserShouldBeOfSearchedDesigner(String designer) {
		productListPage.verifyProductDesigner(designer);
	}

	@Then("the displayed product code should be '(.*)'")
	public void verifyThatProductCodeIsCorrect(String productCode) {
		productListPage.verifyUniqueAndOpenProduct();
		Assert.assertTrue("The product code is not correct",
				productDetailsPage.getProductCode().contentEquals(productCode));
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}

		if (driver != null) {
			driver.quit();
		}

	}

}
