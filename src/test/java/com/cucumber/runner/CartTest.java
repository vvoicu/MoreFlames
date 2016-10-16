package com.cucumber.runner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

//import com.cucumber.listener.ExtentCucumberFormatter;

import com.sitture.ExtentFormatter;
import com.tools.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The reporting class will initialize some properties that will be displayed in
 * the extent report
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/cart/CheckProductsFrInCart.feature" }, glue = { "com.cucumber.stepdefinitions" }, plugin = { "com.sitture.ExtentFormatter" })
public class CartTest {

	@BeforeClass
	public static void setup() {

		ExtentFormatter.initiateExtentFormatter();

		ExtentFormatter.loadConfig(new File(Constants.RESOURCES_PATH
				+ "extent-config.xml"));

		// ExtentFormatter.addSystemInfo("Browser", "Chrome");
		ExtentFormatter.addSystemInfo("Selenium", "v2.53.1");

		Map<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("Cucumber", "v1.2.5");
		systemInfo.put("Extent Reports", "v2.41.1");
		ExtentFormatter.addSystemInfo(systemInfo);
	}

	// private static void setEnvironmentVariables(){
	// System.setProperty("webdriver.chrome.driver", "resources" +
	// File.separator + "chromedriver.exe");
	// // System.setProperty("webdriver.chrome.driver", "resources" +
	// File.separator + "chromedriver");
	// System.setProperty("browser.type", "chrome");
	// System.getProperty("webdriver.chrome.path");
	// }

}
