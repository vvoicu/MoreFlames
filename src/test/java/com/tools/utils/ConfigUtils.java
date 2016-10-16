package com.tools.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tools.Constants;

public class ConfigUtils {
	private static Properties prop = new Properties();
	private static InputStream input = null;

	public static String getBaseUrl() {
		return getProperty("baseUrl");
	}
	
	public static String getDeviceType(){
		return getProperty("deviceType");
	}

	private static String getProperty(String propertyKey) {
		String result = "";
		try {

			input = new FileInputStream(Constants.RESOURCES_PATH
					+ "dev-config.properties");
			prop.load(input);
			result = prop.getProperty(propertyKey);
			System.out.println("property: " + result);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
