package com.cucumber.stepdefinitions.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.cucumber.pages.desktop.checkout.CartPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.CartCalculations;
import com.tools.Constants;
import com.tools.Validations;
import com.tools.data.cart.CartProductModel;
import com.tools.data.cart.CartTotalModel;
import com.tools.mongo.MongoReader;
import com.tools.utils.PrintUtils;

import cucumber.api.java.en.Then;

public class CartSteps {
	public CartPage cartPage;

	public List<CartProductModel> addedProductList = new ArrayList<CartProductModel>();
	public List<CartProductModel> grabbedProductList = new ArrayList<CartProductModel>();

	public CartTotalModel calculatedtotal = new CartTotalModel();
	public CartTotalModel grabbedtotal = new CartTotalModel();

	public CartSteps(WebDriverCore driver) {
		cartPage = new CartPage(driver.getDriver());
	}

	@Then("the products should be correctly displayed")
	public void validateProductsInCart() {
		cartPage.getCartProducts();
		validateProducts();
	}

	@Then("the totals should be correctly calculated")
	public void validateTotalsInCart() {
		cartPage.getCartTotals();

		addedProductList = MongoReader.grabCartProductModels(Constants.ADDED_DATA);
		grabbedProductList = MongoReader.grabCartProductModels(Constants.EXTRACTED_DATA);
		grabbedtotal = MongoReader.grabCartTotalModels(Constants.EXTRACTED_DATA).get(0);

		calculatedtotal = CartCalculations.calculateCartTotals(MongoReader.grabCartProductModels(Constants.ADDED_DATA), Constants.DELIVERY_PRICE);
		verifyTotals();
	}

	private void validateProducts() {
		PrintUtils.printCartProductModelList(addedProductList);
		PrintUtils.printCartProductModelList(grabbedProductList);

		for (CartProductModel productNow : addedProductList) {
			CartProductModel compared = findProduct(productNow.getCode(), grabbedProductList);

			if (compared.getName() != null) {
				Validations.validateName(productNow.getName(), compared.getName());
				Validations.validateSize(productNow.getSize(), compared.getSize());
				Validations.validateQuantity(productNow.getQuantity(), compared.getQuantity());
				Validations.validateUnitPrice(productNow.getUnitPrice(), compared.getUnitPrice());
				Validations.validateQuantity(productNow.getAskingPrice(), compared.getAskingPrice());
			} else {
				Assert.assertTrue("Failure: Could not validate all products in the list", compared != null);
			}

			int index = grabbedProductList.indexOf(compared);
			if (index > -1) {
				grabbedProductList.remove(index);
			}
		}
		Assert.assertTrue("Failure: Not all products have been validated . ", grabbedProductList.size() == 0);
	}

	/**
	 * Helper method used in validate products.
	 * 
	 * @param productCode
	 * @param cartProducts
	 * @return
	 */
	private CartProductModel findProduct(String productCode, List<CartProductModel> cartProducts) {
		CartProductModel result = new CartProductModel();
		theFor: for (CartProductModel cartProductModel : cartProducts) {
			if (cartProductModel.getCode().contains(productCode)) {
				result = cartProductModel;
				break theFor;
			}
		}
		return result;
	}

	private void verifyTotals() {
		PrintUtils.printCartTotalModel(calculatedtotal);
		PrintUtils.printCartTotalModel(grabbedtotal);

		Validations.validateUnitTotal(calculatedtotal.getUnitTotal(), grabbedtotal.getUnitTotal());
		Validations.validateDelivery(calculatedtotal.getDelivery(), grabbedtotal.getDelivery());
		Validations.validateTotal(calculatedtotal.getTotal(), grabbedtotal.getTotal());
	}
}
