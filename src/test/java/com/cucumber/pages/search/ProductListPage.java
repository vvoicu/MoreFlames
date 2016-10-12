package com.cucumber.pages.search;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.AbstractPage;

public class ProductListPage extends AbstractPage {

	public ProductListPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getProductsList() {
		return driver.findElements(By.cssSelector("ul.lister__wrapper li div.lister__item__inner"));
	}

	public void openProductDetails(String productName) {
		List<WebElement> productList = waitForElementsByCssLocator("ul.lister__wrapper li div.lister__item__inner");
		System.out.println("size list: " + productList.size());
		boolean found = false;
		for (WebElement product : productList) {
			if (product.findElement(By.cssSelector("a div.lister__item__details")).getText().contains(productName)) {
				found = true;
				product.click();
				break;
			}
		}
		Assert.assertTrue("The product '" + productName + "' hasn't been found", found);
	}

	public void verifyProductDesigner(String designer) {
		boolean found = true;
		List<WebElement> productList = getProductsList();
		for (WebElement product : productList)
			if (!product.findElement(By.cssSelector("div.lister__item__title")).getText().contains(designer)) {
				found = false;
				break;
			}
		Assert.assertTrue("Search result doesn't matched search criteria", found);
	}

	public void verifyUniqueAndOpenProduct() {
		List<WebElement> productList = getProductsList();
		if (productList.size() > 1) {
			Assert.assertTrue("More than one product found for the same code", productList.size() > 1);
		} else {
			for (WebElement product : productList)
				product.findElement(By.cssSelector("div.lister__item__title")).click();
		}
	}

}
