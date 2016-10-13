package com.tools.utils;

import java.util.List;

import com.tools.data.cart.CartProductModel;
import com.tools.data.cart.CartTotalModel;

public class PrintUtils {

	public static void printCartProductModelList(List<CartProductModel> list) {
		System.out.println("printCartProductModelList");
		for (CartProductModel product : list) {
			System.out.println("-------------------------");
			System.out.println(product.getName());
			System.out.println(product.getCode());
			System.out.println(product.getSize());
			System.out.println(product.getQuantity());
			System.out.println(product.getUnitPrice());
			System.out.println(product.getAskingPrice());
			System.out.println("-------------------------");
		}
	}

	public static void printCartTotalModel(CartTotalModel total) {
		System.out.println("printCartProductModelList");
		System.out.println("-------------------------");
		System.out.println(total.getUnitTotal());
		System.out.println(total.getDelivery());
		System.out.println(total.getDiscount());
		System.out.println(total.getTotal());
		System.out.println("-------------------------");

	}
	
	

}
