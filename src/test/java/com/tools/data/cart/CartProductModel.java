package com.tools.data.cart;

import org.bson.Document;

public class CartProductModel {

	private String name;
	private String code;
	private String unitPrice;
	private String askingPrice;
	private String quantity;
	private String size;

	public CartProductModel() {
		name = "";
		code = "";
		unitPrice = "";
		askingPrice = "";
		quantity = "";
		size = "";
	}

	public CartProductModel(Document doc) {
		name = doc.getString("name");
		code = doc.getString("code");
		unitPrice = doc.getString("unitPrice");
		askingPrice = doc.getString("askingPrice");
		quantity = doc.getString("quantity");
		size = doc.getString("size");
	}

	public Document toDocument() {
		Document doc = new Document();
		doc.put("name", name);
		doc.put("code", code);
		doc.put("unitPrice", unitPrice);
		doc.put("askingPrice", askingPrice);
		doc.put("quantity", quantity);
		doc.put("size", size);
		return doc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(String askingPrice) {
		this.askingPrice = askingPrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String toString() {
		return "{name:" + name + ", code: " + code + ", unitPrice: " + unitPrice + ", askingPrice: " + askingPrice + ", quantity: " + quantity + ", size:" + size + "}";
	}
}
