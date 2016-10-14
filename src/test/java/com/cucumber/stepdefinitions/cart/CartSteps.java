package com.cucumber.stepdefinitions.cart;

import com.cucumber.pages.checkout.CartPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.Constants;
import com.tools.Validations;

import cucumber.api.java.en.Then;

public class CartSteps {
	public CartPage cartPage;
	
	public CartSteps(WebDriverCore driver) {
		cartPage = new CartPage(driver.getDriver());
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
}
