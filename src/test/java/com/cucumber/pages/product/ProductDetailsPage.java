package com.cucumber.pages.product;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.pages.AbstractPage;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.data.ProductDetailModel;
import com.tools.data.cart.CartProductModel;
import com.tools.utils.FormatterUtils;

public class ProductDetailsPage extends AbstractPage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	private String addToCartButtonLocatorLocator = "div.pdp__description-wrapper #addToCartButton";
	private String productPriceContainerLocator = "div.pdp__header.hidden-mobile p.pdp-price";
	private String productDetailsContainerLocator = "div.pdp__header.hidden-mobile span.pdp-description";
	private String productCodeContainerLocator = "#mCSB_1_container span.pdp__product-code";
	private String productQuantitySelectorLocator = "div.pdp__description-wrapper #quantityDD";
	private String productSizeSelectorLocator = "div.pdp__description-wrapper #entrySizeVariant";
	private String productDesignerName = " div.pdp__description-wrapper h1 > a";

	public void addProductToCart() {
		scrollToPageTop();
		WebElement addToCart = waitForElementByCssLocator(addToCartButtonLocatorLocator);
		addToCart.click();
		waitForPageToLoad();
	}

	public void selectQuantity(String quantity) {
		waitForPageToLoad();
		new Select(driver.findElement(By.cssSelector(productQuantitySelectorLocator))).selectByVisibleText(quantity);
	}

	public void selectSize(String size) {
		waitForPageToLoad();
		new Select(driver.findElement(By.cssSelector(productSizeSelectorLocator))).selectByVisibleText(size);
	}

	private String getProductPrice() {
		String price = "";
		List<WebElement> hiliteList = waitForElementByCssLocator(productPriceContainerLocator).findElements(By.cssSelector("span.pdp-price__hilite"));
		if (hiliteList.size() > 0) {
			price = hiliteList.get(hiliteList.size() - 1).getText();
		} else {
			price = waitForElementByCssLocator(productPriceContainerLocator).getText().split("/")[1];
		}
		return FormatterUtils.parseValue(price, 0);
	}

	public CartProductModel getProductDetails(CartProductModel product) {
		String details = driver.findElement(By.cssSelector(productDetailsContainerLocator)).getText();
		String code = driver.findElement(By.cssSelector(productCodeContainerLocator)).getText();
		product.setName(details);
		product.setCode(code);
		product.setUnitPrice(getProductPrice());

		return product;
	}

	public ProductDetailModel grabProductData() {
		ProductDetailModel product = new ProductDetailModel();
		String title = driver.findElement(By.cssSelector(productDesignerName)).getText();
		String details = driver.findElement(By.cssSelector(productDetailsContainerLocator)).getText();
		String code = driver.findElement(By.cssSelector(productCodeContainerLocator)).getText();
		product.setTitle(title);
		product.setDetails(details);
		product.setCode(code);
		product.setPrice(getProductPrice());

		return product;

	}

	public void addProductToCart(String quantity, String size) {
		CartProductModel product = new CartProductModel();

		selectSize(size);
		product.setSize(size);

		selectQuantity(quantity);
		product = getProductDetails(product);
		product.setQuantity(quantity);

		product.setAskingPrice(String.valueOf(CartCalculations.calculateAskingPrice(product)));
		addProductToCart();

		CartDataHandler.addedProductList.add(product);
	}

	public String getProductCode() {
		String[] urlparts = driver.getCurrentUrl().split("-");
		return urlparts[urlparts.length - 1];
	}

	public void verifyProductDetails(String code, String title, String details, String price) {

		ProductDetailModel product = grabProductData();
		//		System.out.println("Expected: details- " + product.getDetails() + "---");
		//		System.out.println("Actual: details- " + details + "---");
		//		System.out.println("Expected: title- " + product.getTitle() + "---");
		//		System.out.println("Actual: title- " + title + "---");
		System.out.println(details);
		Assert.assertTrue("The product code is not correct", product.getCode().contains(code));
		Assert.assertTrue("The product details is not correct", product.getTitle().toUpperCase().contains(title));
		Assert.assertTrue("The product title is not correct", product.getDetails().trim().toUpperCase().contains(details.trim()));
		Assert.assertTrue("The product price is not correct", product.getPrice().contains(price));
	}
}
