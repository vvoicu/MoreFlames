package com.tools.entities;

public class CartTotalModel {

	private String unitTotal;
	private String delivery;
	private String discount;
	private String total;

	public String getUnitTotal() {
		return unitTotal;
	}

	public void setUnitTotal(String unitTotal) {
		this.unitTotal = unitTotal;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}