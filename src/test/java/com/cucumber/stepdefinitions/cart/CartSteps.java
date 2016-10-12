package com.cucumber.stepdefinitions.cart;

import org.openqa.selenium.WebDriver;

import com.cucumber.pages.checkout.CartPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.Constants;
import com.tools.Validations;

import cucumber.api.java.en.Then;

public class CartSteps {

	public WebDriver driver = new WebDriverCore().getDriver();
	public CartPage cartPage;
	
	public CartSteps(){
		cartPage = new CartPage(driver);
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
