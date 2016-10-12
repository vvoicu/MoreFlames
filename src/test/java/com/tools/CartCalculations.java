package com.tools;

import java.math.BigDecimal;
import java.util.List;

import com.tools.entities.CartProductModel;
import com.tools.entities.CartTotalModel;

public class CartCalculations {

	public static BigDecimal calculateAskingPrice(CartProductModel product) {

		BigDecimal qty = BigDecimal.valueOf(Double.parseDouble(product.getQuantity()));
		BigDecimal uPrice = BigDecimal.valueOf(Double.parseDouble(product.getUnitPrice()));

		return qty.multiply(uPrice);
	}

	private static BigDecimal calculateGrandTotal(BigDecimal unitTotal, BigDecimal delivery) {
		return unitTotal.add(delivery);
	}

	public static CartTotalModel calculateCartTotals(List<CartProductModel> cartProducts, String delivery) {
		CartTotalModel totalModel = new CartTotalModel();

		BigDecimal itemTotal = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;

		for (CartProductModel product : cartProducts) {
			itemTotal = itemTotal.add(calculateAskingPrice(product));
		}
		total = calculateGrandTotal(itemTotal, BigDecimal.valueOf(Double.parseDouble(delivery)));

		totalModel.setUnitTotal(String.valueOf(itemTotal));
		totalModel.setDelivery(delivery);
		totalModel.setTotal(String.valueOf(total));

		return totalModel;
	}

}
