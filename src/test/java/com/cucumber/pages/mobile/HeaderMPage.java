package com.cucumber.pages.mobile;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.AbstractPage;

public class HeaderMPage extends AbstractPage {

	public HeaderMPage(WebDriver driver) {
		super(driver);
	}

	private String expandSearchButtonLocator = "a[data-mf-expand]";

	private String menSectionLocator = "span.men";
	private String womenSectionLocator = "span.women";
	private String menuOptionLocator = "div#nav_main .main-menu__wrapper>li";

	public void expandSearch() {
		waitForElementByCssLocator(expandSearchButtonLocator).click();
	}

	public void selectSection(String section) {
		waitForPageToLoad();
		if (section.equals("men")) {
			waitForElementByCssLocator(menSectionLocator).click();
		} else if (section.equals("women")) {
			waitForElementByCssLocator(womenSectionLocator).click();
		}
	}

	public void selectMenuOption(String menuOption) {
		waitForPageToLoad();
		List<WebElement> menuOptionList = driver.findElements(By.cssSelector(menuOptionLocator));
		for (WebElement itemNow : menuOptionList) {
			if (itemNow.getText().contains(menuOption)) {
				itemNow.click();
				waitForPageToLoad();
				break;
			}
		}
	}

	public void verifyTheUrlPage(String url) {
		boolean found = true;
		String pageURL = driver.getCurrentUrl().toString();
		System.out.println(driver.getCurrentUrl().toString());
		if (!pageURL.contains(url)) {
			found = false;
		}
		Assert.assertTrue("The page isn't loaded correctly", found);
	}
}
