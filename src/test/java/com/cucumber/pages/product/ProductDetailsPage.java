package com.cucumber.pages.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.pages.AbstractPage;
import com.tools.CartCalculations;
import com.tools.CartDataHandler;
import com.tools.entities.CartProductModel;
import com.tools.utils.FormatterUtils;

public class ProductDetailsPage extends AbstractPage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	private String addToCartButtonLocatorLocator = "div.pdp__description-wrapper #addToCartButton";
	private String productPriceContainerLocator = "div.pdp__header.hidden-mobile p.pdp-price";
	private String productNameContainerLocator = "div.pdp__header.hidden-mobile span.pdp-description";
	private String productCodeContainerLocator = "#mCSB_1_container span.pdp__product-code";
	private String productQuantitySelectorLocator = "div.pdp__description-wrapper #quantityDD";
	private String productSizeSelectorLocator = "div.pdp__description-wrapper #entrySizeVariant";

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
		String name = driver.findElement(By.cssSelector(productNameContainerLocator)).getText();
		String code = driver.findElement(By.cssSelector(productCodeContainerLocator)).getText();
		product.setName(name);
		product.setCode(code);
		product.setUnitPrice(getProductPrice());

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

}
