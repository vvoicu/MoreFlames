package com.tools.data.cart;

import org.bson.Document;

public class CartTotalModel {

	private String unitTotal;
	private String delivery;
	private String discount;
	private String total;

	public CartTotalModel() {
		unitTotal = "";
		delivery = "";
		discount = "";
		total = "";
	}

	public CartTotalModel(Document document) {
		unitTotal = document.getString("unitTotal");
		delivery = document.getString("delivery");
		discount = document.getString("discount");
		total = document.getString("total");
	}

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

	public Document toDocument() {
		Document doc = new Document();
		doc.put("unitTotal", unitTotal);
		doc.put("delivery", delivery);
		doc.put("discount", discount);
		doc.put("total", total);
		return doc;
	}
}