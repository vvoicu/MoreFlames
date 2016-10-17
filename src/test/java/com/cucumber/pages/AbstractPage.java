package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tools.Constants;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateTo(String URL) {
		driver.get(URL);
	}

	/**
	 * Wait for document ready state for {@link Constants}.PAGE_LOAD_MAX_RETRY
	 * time.
	 */
	protected void waitForPageToLoad() {
		int retry = 0;

		String response = "";
		do {
			try {
				Thread.sleep(Constants.WAIT_TIME_CONSTANT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response = String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
			retry++;
		} while (retry <= Constants.PAGE_LOAD_MAX_RETRY && response.equals("complete") != true);
	}

	protected WebElement waitForElementByCssLocator(String cssLocator) {
		return (new WebDriverWait(driver, Constants.WAIT_TIME_LARGE_SEC)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssLocator)));
	}

	protected boolean isElementPresentByCssLocator(String cssLocator) {
		System.out.println(driver.findElements(By.cssSelector(cssLocator)).size());
		return driver.findElements(By.cssSelector(cssLocator)).size() != 0;
	}


	protected WebElement waitForElementByCssLocatorToBeClickable(String cssLocator) {
		return (new WebDriverWait(driver, Constants.WAIT_TIME_LARGE_SEC)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
	}

	protected List<WebElement> waitForElementsByCssLocator(String cssLocator) {
		return (new WebDriverWait(driver, Constants.WAIT_TIME_LARGE_SEC)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssLocator)));
	}

	protected void selectFromDropdownByVisibleText(String cssLocator, String textValue) {
		Select selectDropdown = new Select(waitForElementByCssLocator(cssLocator));
		selectDropdown.selectByVisibleText(textValue);
	}

	public void scrollToElement(String element) {
		((JavascriptExecutor) driver).executeScript("document.getElementById(\"" + element + "\").scrollIntoView();");
	}

	public void scrollToPageTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}

}
