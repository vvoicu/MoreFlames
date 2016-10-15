package com.tools.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.tools.data.cart.CartProductModel;
import com.tools.data.cart.CartTotalModel;

public class MongoReader extends MongoConnector {

	public static List<CartProductModel> grabCartProductModels(String name){
		List<CartProductModel> resultList = new ArrayList<CartProductModel>();
		MongoCollection<Document> table = connectToDB(name).getCollection("CartProductModel");
		FindIterable<Document> cursor = table.find();
		for (Document document : cursor) {
			resultList.add(new CartProductModel(document));
		}
		return resultList;
	}

	public static List<CartTotalModel> grabCartTotalModels(String name) {
		List<CartTotalModel> resultList = new ArrayList<CartTotalModel>();
		MongoCollection<Document> table = connectToDB(name).getCollection("CartTotalModel");
		FindIterable<Document> cursor = table.find();
		for (Document document : cursor) {
			resultList.add(new CartTotalModel(document));
		}
		return resultList;
	}

}
