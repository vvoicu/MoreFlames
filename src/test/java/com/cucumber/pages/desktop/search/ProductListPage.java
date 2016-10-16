package com.cucumber.pages.desktop.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.desktop.product.ProductDetailsPage;
import com.tools.data.search.SearchProductModel;

public class ProductListPage extends ProductDetailsPage {

	public ProductListPage(WebDriver driver) {
		super(driver);
	}

	private String listItemsLocator = ".lister__wrapper .lister__item";
	private String productsListLocator = "ul.lister__wrapper li div.lister__item__inner";

	private String itemDesignerNameLocator = "div.lister__item__title";
	private String itemDetailsLocator = "a div.lister__item__details";
	private String itemPriceLocator = "a div.lister__item__price";
	private String itemUrlLocator = "a[title]";

	private String nextButtonsLocator = ".redefine__right__pager > li.next a";
	
	private String errorLocator = ".slp__header";

	public List<SearchProductModel> grabSearchProductsList() {
		waitForPageToLoad();
		List<SearchProductModel> resultList = new ArrayList<SearchProductModel>();

		List<WebElement> productsList = waitForElementsByCssLocator(listItemsLocator);
		for (WebElement webElement : productsList) {
			SearchProductModel itemNow = new SearchProductModel();
			itemNow.setDetails(webElement.findElement(By.cssSelector(itemDetailsLocator)).getText());
			itemNow.setPrice(webElement.findElement(By.cssSelector(itemPriceLocator)).getText());
			itemNow.setTitle(webElement.findElement(By.cssSelector(itemDesignerNameLocator)).getText());
			itemNow.setUrl(webElement.findElement(By.cssSelector(itemUrlLocator)).getAttribute("href"));
			resultList.add(itemNow);
		}

		return resultList;
	}

	public void verifyProductCategory(String category) {
		boolean found = true;
		List<SearchProductModel> products = new ArrayList<SearchProductModel>();
		products.addAll(grabSearchProductsList());
		while (clickIfNextPresent()) {
			products.addAll(grabSearchProductsList());
		}
		System.out.println(products.size());

		for (SearchProductModel itemNow : products) {
			if (!itemNow.getDetails().contains(category)) {
				found = false;
				System.out.println(itemNow.getDetails());
				break;
			}
		}

		Assert.assertTrue("Search result doesn't matched search criteria", found);
	}

	public boolean clickIfNextPresent() {
		boolean isPresent = driver.findElements(By.cssSelector(nextButtonsLocator)).size() != 0;
		if (isPresent) {
			// driver.findElements(By.cssSelector(nextButtonsLocator)).get(0).click();
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
			if (!product.findElement(By.cssSelector(itemDesignerNameLocator)).getText().contains(designer)) {
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
				product.findElement(By.cssSelector(itemDesignerNameLocator)).click();
		}
	}

	public void verifyUniqueProduct() {
		List<WebElement> productList = getProductsList();
		if (productList.size() > 1) {
			Assert.assertTrue("More than one product found for the same code", productList.size() > 1);
		}
	}

	public void verifyItemDescriptionInProductListPage(String title, String details, String price) {

		List<SearchProductModel> products = grabSearchProductsList();
		for (SearchProductModel itemNow : products) {
			System.out.println("Expected: details- " + itemNow.getDetails() + "---");
			System.out.println("Actual: details- " + details + "---");
			System.out.println("Expected: title- " + itemNow.getTitle() + "---");
			System.out.println("Actual: title- " + title + "---");
			System.out.println("Expected: price- " + itemNow.getPrice() + "---");
			System.out.println("Actual: price- " + price + "---");

			Assert.assertTrue("The product title is not correct", itemNow.getTitle().contains(title));
			Assert.assertTrue("The product details is not correct", itemNow.getDetails().trim().contains(details));
			Assert.assertTrue("The product price is not correct", itemNow.getPrice().contains(price));
		}
	}
	
	public void verifyTheErrorMessage(String searachTerm){
		boolean found = true;
		String errorMessage = "We searched and found nothing for\n" + " "+ searachTerm + "\n"  + "Please search again";
		System.out.println(errorMessage);
		WebElement errorContainer = driver.findElement(By.cssSelector(errorLocator));
		System.out.println(errorContainer.getText());
		if(!errorContainer.getText().trim().contains(errorMessage)){
			found = false;
		}
		Assert.assertTrue("The error message isn't displayed", found);
	}

}
