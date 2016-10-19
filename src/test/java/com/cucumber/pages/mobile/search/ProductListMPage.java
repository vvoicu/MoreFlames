package com.cucumber.pages.mobile.search;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.AbstractPage;

public class ProductListMPage extends AbstractPage {

	public ProductListMPage(WebDriver driver) {
		super(driver);
	}

	private String errorLocator = ".slp__header";

	public void verifyTheErrorMessage(String searachTerm) {
		boolean found = true;
		String errorMessage = "We searched and found nothing for\n" + " " + searachTerm + "\n" + "Please search again";
		System.out.println(errorMessage);
		WebElement errorContainer = driver.findElement(By.cssSelector(errorLocator));
		System.out.println(errorContainer.getText());
		if (!errorContainer.getText().trim().contains(errorMessage)) {
			found = false;
		}
		Assert.assertTrue("The error message isn't displayed", found);
	}
}
