package com.tools;

import java.util.List;

import org.junit.Assert;

import com.tools.data.cart.CartProductModel;
import com.tools.utils.PrintUtils;

public class Validations {

	public static void validateProducts() {
		PrintUtils.printCartProductModelList(CartDataHandler.addedProductList);
		PrintUtils.printCartProductModelList(CartDataHandler.grabbedProductList);

		for (CartProductModel productNow : CartDataHandler.addedProductList) {
			CartProductModel compared = findProduct(productNow.getCode(), CartDataHandler.grabbedProductList);

			if (compared.getName() != null) {
				validateName(productNow.getName(), compared.getName());
				validateSize(productNow.getSize(), compared.getSize());
				validateQuantity(productNow.getQuantity(), compared.getQuantity());
				validateUnitPrice(productNow.getUnitPrice(), compared.getUnitPrice());
				validateQuantity(productNow.getAskingPrice(), compared.getAskingPrice());
			} else {
				Assert.assertTrue("Failure: Could not validate all products in the list", compared != null);
			}

			int index = CartDataHandler.grabbedProductList.indexOf(compared);
			if (index > -1) {
				CartDataHandler.grabbedProductList.remove(index);
			}
		}
		Assert.assertTrue("Failure: Not all products have been validated . ", CartDataHandler.grabbedProductList.size() == 0);

	}

	/**
	 * Helper method used in validate products.
	 * 
	 * @param productCode
	 * @param cartProducts
	 * @return
	 */
	public static CartProductModel findProduct(String productCode, List<CartProductModel> cartProducts) {
		CartProductModel result = new CartProductModel();
		theFor: for (CartProductModel cartProductModel : cartProducts) {
			if (cartProductModel.getCode().contains(productCode)) {
				result = cartProductModel;
				break theFor;
			}
		}
		return result;
	}

	public static void verifyTotals() {
		PrintUtils.printCartTotalModel(CartDataHandler.calculatedtotal);
		PrintUtils.printCartTotalModel(CartDataHandler.grabbedtotal);

		validateUnitTotal(CartDataHandler.calculatedtotal.getUnitTotal(), CartDataHandler.grabbedtotal.getUnitTotal());
		validateDelivery(CartDataHandler.calculatedtotal.getDelivery(), CartDataHandler.grabbedtotal.getDelivery());
		validateTotal(CartDataHandler.calculatedtotal.getTotal(), CartDataHandler.grabbedtotal.getTotal());

	}

	public static void validateQuantity(String productNow, String compare) {
		Assert.assertTrue("Failure: Quantity doesn't match: " + productNow + " - " + compare, productNow.contentEquals(compare));
	}

	public static void validateFinalPrice(String productNow, String compare) {
		Assert.assertTrue("Failure: Final price doesn't match: " + productNow + " - " + compare, productNow.contentEquals(compare));
	}

	public static void validateUnitPrice(String productNow, String compare) {
		Assert.assertTrue("Failure: Unit price doesn't match: " + productNow + " - " + compare, compare.contains(productNow));
	}

	public static void validateSize(String productNow, String compare) {
		Assert.assertTrue("Failure: Size doesn't match:  " + productNow + " - " + compare, productNow.contentEquals(compare));
	}

	public static void validateName(String productNow, String compare) {
		Assert.assertTrue("Failure: Name doesn't match: " + productNow + " - " + compare, productNow.contentEquals(compare));
	}

	public static void validateUnitTotal(String calculated, String actual) {
		Assert.assertTrue("Failure: Unit Total doesn't match: " + calculated + " - " + actual, calculated.contentEquals(actual));
	}

	public static void validateTotal(String calculated, String actual) {
		Assert.assertTrue("Failure: Total doesn't match: " + calculated + " - " + actual, calculated.contentEquals(actual));
	}

	public static void validateDelivery(String calculated, String actual) {
		Assert.assertTrue("Failure: Delivery doesn't match: " + calculated + " - " + actual, calculated.contentEquals(actual));
	}

	public static void validateVoucherDiscount(String calculated, String actual) {
		Assert.assertTrue("Failure: Voucher Discount doesn't match: " + calculated + " - " + actual, calculated.contentEquals(actual));
	}
}
