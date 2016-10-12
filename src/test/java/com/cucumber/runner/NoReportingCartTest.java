package com.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = { /*"src/test/resources/features/cart/CheckProductsInCart.feature",*/
		"src/test/resources/features/search/Search.feature" }, format = { "pretty", "html:target/site/cucumber-pretty",
				"json:target/cucumber.json" }, glue = { "com.cucumber.stepdefinitions.fashion" })
public class NoReportingCartTest {

}
