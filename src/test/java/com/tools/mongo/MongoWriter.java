package com.tools.mongo;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.tools.data.cart.CartProductModel;
import com.tools.data.cart.CartTotalModel;

public class MongoWriter extends MongoConnector{
	
	public static void writeCartProductModel(String name, CartProductModel cartProductModel){
		MongoCollection<Document> table = connectToDB(name).getCollection("CartProductModel");
		table.insertOne(cartProductModel.toDocument());
	}
	
	public static void writeCartTotalModel(String name, CartTotalModel cartTotalModel){
		MongoCollection<Document> table = connectToDB(name).getCollection("CartTotalModel");
		table.insertOne(cartTotalModel.toDocument());
	}

}
