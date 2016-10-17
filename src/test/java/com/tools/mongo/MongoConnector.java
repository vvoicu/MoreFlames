package com.tools.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.tools.Constants;

public class MongoConnector {

	private static MongoClient mongoClient = new MongoClient(
			Constants.MONGO_URL, Constants.MONGO_PORT);

	public static MongoDatabase connectToDB() {
		return mongoClient.getDatabase(Constants.MONGO_DB);
	}

	public static MongoDatabase connectToDB(String db) {
		return mongoClient.getDatabase(db);
	}

	public static MongoIterable<String> grabAllDbs() {
		return mongoClient.listDatabaseNames();
	}
	
	public static void deleteAllDbs(){
		for (String db : grabAllDbs()) {
			connectToDB(db).drop();
		}
	}

	public static void deleteAllCartProductModel() {
		for (String db : grabAllDbs()) {
			deleteCartProductModel(db);
		}
	}

	public static void deleteAllCartTotalModel() {
		for (String db : grabAllDbs()) {
			deleteCartTotalModel(db);
		}
	}

	public static void deleteCartProductModel(String db) {
		connectToDB(db).getCollection("CartProductModel").drop();
	}

	public static void deleteCartTotalModel(String db) {
		connectToDB(db).getCollection("CartTotalModel").drop();
	}

}
