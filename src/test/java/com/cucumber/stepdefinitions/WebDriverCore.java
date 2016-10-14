package com.cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverCore {
	private static boolean initialized = false;
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		if (!initialized) {
			initialized = true;
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
