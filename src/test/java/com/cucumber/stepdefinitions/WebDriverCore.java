package com.cucumber.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverCore {
	private static boolean initialized = false;
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		if (!initialized) {

			initialized = true;
			String webdriverDriver = System.getProperty("browser.type");
			if (webdriverDriver != null
					&& webdriverDriver.toLowerCase().contains("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				if (Boolean
						.parseBoolean(System.getProperty("webdriver.remote"))) {
					System.out
							.println("Using remote webdriver take screenshot! (Augmenter)");
					driver = new Augmenter().augment(driver);
				}
				final byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}
}
