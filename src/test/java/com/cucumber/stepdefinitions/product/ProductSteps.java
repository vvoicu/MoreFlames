package com.cucumber.stepdefinitions.product;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.pages.product.ProductDetailsPage;
import com.cucumber.pages.search.ProductListPage;
import com.cucumber.stepdefinitions.WebDriverCore;
import com.tools.data.search.SearchProductModel;

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

	@Then("the displayed products details should contain the '(.*)'")
	public void verifyTheCategoryOfTheDisplayedProducts(String category) {
		productListPage.verifyProductCategory(category);
	}

	@Then("^all the products are displayed$")
	public void all_the_products_are_displayed() {

		List<SearchProductModel> searchList = new ArrayList<SearchProductModel>();
		searchList.addAll(productListPage.grabSearchProductsList());
		System.out.println("All products: " + searchList.size());
		while (productListPage.clickIfNextPresent()) {
			//			productListPage.clickOnNext();
			searchList.addAll(productListPage.grabSearchProductsList());
		}
		System.out.println("All products: " + searchList.size());

	}

	@Then("the displayed product should have code: '(.*)', title: '(.*)', details: '(.*)', price '(.*)'")
	public void displayedProductCodeTitleDetailsAndPrice(String code, String title, String details, String price) throws Throwable {
		productListPage.verifyUniqueAndOpenProduct();
		productDetailsPage.verifyProductDetails(code, title, details, price);
	}

}
