package com.tools;

import java.io.File;

import org.openqa.selenium.Dimension;

public class Constants {

	public static final String ONE_SIZE = "ONE SIZE";
//	public static final String ADD_TO_BAG = "ADD TO BAG";
	public static final String DELIVERY_PRICE = "10.00";

	public static final String RESOURCES_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
//	public static final String BASE_URL = "http://www.matchesfashion.com/intl";

	
	//webdriver browser setup
	public static final String BROWSER_TYPE_KEY = "browser.type";
	public static final String DEVICE_TYPE_KEY = "device.type";
	public static final Dimension DEVICE_SIZE = new Dimension(768, 1280);
//	public static final Dimension DEVICE_SIZE = new Dimension(1080, 1920);
	
	//webdriver timeouts
	public static final long WEBDRIVER_IMPLICIT_WAIT = 30;
	public static final long WAIT_TIME_LARGE_SEC = 40;

	public static final long WAIT_TIME_SMALL = 3000;
	public static final int PAGE_LOAD_MAX_RETRY = 20;
	public static final long WAIT_TIME_CONSTANT = 5000;
	
	//mongodb
	public static final String MONGO_URL = "localhost";
	public static final int MONGO_PORT = 27017;
	public static final String MONGO_DB = "mf-database";
	public static final String EXTRACTED_DATA = "ExtractedData";
	public static final String ADDED_DATA = "AddedData";
	

}
