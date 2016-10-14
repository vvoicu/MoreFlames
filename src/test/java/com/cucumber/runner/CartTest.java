package com.cucumber.runner;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The reporting class will initialize some properties that will be displayed in
 * the extent report
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/cart/CheckProductsFrInCart.feature" }, glue = {
		"com.cucumber.stepdefinitions" }, plugin = { "com.cucumber.listener.ExtentCucumberFormatter" })
public class CartTest {

	@BeforeClass
	public static void setup() {
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
		setEnvironmentVariables();
		ExtentCucumberFormatter.addSystemInfo("Browser Name", System.getProperty("browser.type"));
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

//		Map<String, String> systemInfo = new HashMap<String, String>();
//		systemInfo.put("Cucumber version", "v1.2.3");
//		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
//		ExtentCucumberFormatter.addSystemInfo(systemInfo);
		
//		Injector injector = Guice.createInjector(new DriverModule());
//		WebDriverFirerox webDriverCore = injector.getInstance(WebDriverFirerox.class);
	}
	
	private static void setEnvironmentVariables(){
		System.setProperty("webdriver.chrome.driver", "resources" + File.separator + "chromedriver");
		System.setProperty("browser.type", "Firefox");
		System.getProperty("webdriver.chrome.path");
	}

}
