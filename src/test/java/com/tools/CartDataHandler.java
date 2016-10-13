package com.tools;

import java.util.ArrayList;
import java.util.List;

import com.tools.data.cart.CartProductModel;
import com.tools.data.cart.CartTotalModel;

public class CartDataHandler {

	public static List<CartProductModel> addedProductList = new ArrayList<CartProductModel>();
	public static List<CartProductModel> grabbedProductList = new ArrayList<CartProductModel>();

	public static CartTotalModel calculatedtotal = new CartTotalModel();
	public static CartTotalModel grabbedtotal = new CartTotalModel();

}
