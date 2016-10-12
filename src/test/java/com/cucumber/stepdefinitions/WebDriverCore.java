package com.cucumber.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverCore {

	public static WebDriver DRIVER;
	
	@Before
	public void startBrwser(){
		if(DRIVER == null){
			String browserType = System.getProperty("browser.type");
			if (browserType.contains("chrome")) {
				DRIVER = new ChromeDriver();
			} else {
				DRIVER = new FirefoxDriver();
			}
		}
	}
	
	public WebDriver getDriver(){
		return DRIVER;
	}
	
	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}

		if (DRIVER != null) {
			DRIVER.quit();
		}

	}


}
