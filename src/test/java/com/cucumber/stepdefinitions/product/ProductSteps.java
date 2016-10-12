package com.cucumber.stepdefinitions.product;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.pages.checkout.CartPage;
import com.cucumber.pages.product.ProductDetailsPage;
import com.cucumber.pages.search.ProductListPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.Constants;
import com.tools.Validations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProductSteps {

	public WebDriver driver = new WebDriverCore().getDriver();
	public ProductListPage productListPage;
	public ProductDetailsPage productDetailsPage;
	public CartPage cartPage;

	public ProductSteps() {
		productListPage = new ProductListPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		cartPage = new CartPage(driver);
	}
	

	@Given("selects the product '(.*)'")
	public void givenTheUserSelectsTheProduct(String product) {
		productListPage.openProductDetails(product);
	}

	@Given("adds to cart '(.*)' products of size '(.*)'")
	public void givenTheUserAddsProductToCart(String quantity, String size) {
		productDetailsPage.addProductToCart(quantity, size);
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
		Assert.assertTrue("The product code is not correct", productDetailsPage.getProductCode().contentEquals(productCode));
	}

}
