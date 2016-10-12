package com.cucumber.stepdefinitions.product;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.pages.product.ProductDetailsPage;
import com.cucumber.pages.search.ProductListPage;
import com.cucumber.stepdefinitions.WebDriverCore;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProductSteps {

	public WebDriver driver = new WebDriverCore().getDriver();
	public ProductListPage productListPage;
	public ProductDetailsPage productDetailsPage;


	public ProductSteps() {
		productListPage = new ProductListPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
	}

	@Given("selects the product '(.*)'")
	public void givenTheUserSelectsTheProduct(String product) {
		productListPage.openProductDetails(product);
	}

	@Given("adds to cart '(.*)' products of size '(.*)'")
	public void givenTheUserAddsProductToCart(String quantity, String size) {
		productDetailsPage.addProductToCart(quantity, size);
	}

	@Then("all the products displayed should be from '(.*)'")
	public void thenTheUserShouldBeOfSearchedDesigner(String designer) {
		productListPage.verifyProductDesigner(designer);
	}

	@Then("the displayed product code should be '(.*)'")
	public void verifyThatProductCodeIsCorrect(String productCode) {
		productListPage.verifyUniqueAndOpenProduct();
		Assert.assertTrue("The product code is not correct", productDetailsPage.getProductCode().contentEquals(productCode));
	}

}
