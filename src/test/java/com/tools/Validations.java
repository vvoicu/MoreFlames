package com.tools;

import org.junit.Assert;

public class Validations {

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
