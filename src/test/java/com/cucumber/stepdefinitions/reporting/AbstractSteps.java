package com.cucumber.stepdefinitions.reporting;

import org.openqa.selenium.WebDriver;

import com.cucumber.pages.AbstractPage;
import com.cucumber.pages.HeaderPage;
import com.cucumber.pages.checkout.CartPage;
import com.cucumber.pages.product.ProductDetailsPage;
import com.cucumber.pages.search.ProductListPage;

public class AbstractSteps {
	
	public WebDriver driver;
	public HeaderPage headerPage;
	public AbstractPage abstractPage;
	public ProductListPage productListPage;
	public ProductDetailsPage productDetailsPage;
	public CartPage cartPage;



}
