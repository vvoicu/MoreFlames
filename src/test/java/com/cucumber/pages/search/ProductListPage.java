package com.cucumber.pages.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.AbstractPage;
import com.tools.data.search.SearchProductModel;

public class ProductListPage extends AbstractPage {

	public ProductListPage(WebDriver driver) {
		super(driver);
	}

	private String listItemsLocator = ".lister__wrapper .lister__item";
	private String productsListLocator = "ul.lister__wrapper li div.lister__item__inner";

	private String itemTitleLocator = "div.lister__item__title";
	private String itemDetailsLocator = "a div.lister__item__details";
	private String itemPriceLocator = "a div.lister__item__details";
	private String itemUrlLocator = "a[title]";
	
	private String nextButtonsLocator = ".redefine__right__pager > li.next a";

	public List<SearchProductModel> grabSearchProductsList() {
		waitForPageToLoad();
		List<SearchProductModel> resultList = new ArrayList<SearchProductModel>();

		List<WebElement> productsList = waitForElementsByCssLocator(listItemsLocator);
		for (WebElement webElement : productsList) {
			SearchProductModel itemNow = new SearchProductModel();
			itemNow.setDetails(webElement.findElement(By.cssSelector(itemDetailsLocator)).getText());
			itemNow.setPrice(webElement.findElement(By.cssSelector(itemPriceLocator)).getText());
			itemNow.setTitle(webElement.findElement(By.cssSelector(itemTitleLocator)).getText());
			itemNow.setUrl(webElement.findElement(By.cssSelector(itemUrlLocator)).getAttribute("href"));
			resultList.add(itemNow);
		}

		return resultList;
	}
	
	public boolean clickIfNextPresent(){
		boolean isPresent = driver.findElements(By.cssSelector(nextButtonsLocator)).size() != 0;
		if (isPresent) {
//			driver.findElements(By.cssSelector(nextButtonsLocator)).get(0).click();
			String url = driver.findElements(By.cssSelector(nextButtonsLocator)).get(0).getAttribute("href");
			driver.get(url);
		}

		return isPresent;
	}
	
	public List<WebElement> getProductsList() {
		return driver.findElements(By.cssSelector(productsListLocator));
	}

	public void openProductDetails(String productName) {
		List<WebElement> productList = waitForElementsByCssLocator(productsListLocator);
		System.out.println("size list: " + productList.size());
		boolean found = false;
		for (WebElement product : productList) {
			if (product.findElement(By.cssSelector(itemDetailsLocator)).getText().contains(productName)) {
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
			if (!product.findElement(By.cssSelector(itemTitleLocator)).getText().contains(designer)) {
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
				product.findElement(By.cssSelector(itemTitleLocator)).click();
		}
	}

}
