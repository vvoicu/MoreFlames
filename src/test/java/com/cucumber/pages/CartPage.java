package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tools.CartDataHandler;
import com.tools.Constants;
import com.tools.entities.CartProductModel;
import com.tools.entities.CartTotalModel;
import com.tools.utils.FormatterUtils;

public class CartPage extends AbstractPage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	private String totalContainerListLocator = "div.spb__totals-sum table tr";

	public void getCartProducts() {

		List<WebElement> list = waitForElementsByCssLocator("#spb__items-list div.spb__items-list-row__inner");

		for (WebElement item : list) {

			CartProductModel product = new CartProductModel();

			String[] nameAndCode = item.findElement(By.cssSelector("p.description__name")).getText().split("\\(");
			product.setName(nameAndCode[0].trim());
			product.setCode(nameAndCode[1].replace(")", "").trim());

			WebElement sizeElement = item.findElement(By.cssSelector("div.items-list-row__size div.data-variantDD-container"));

			product.setSize(sizeElement.getText().contains(Constants.ONE_SIZE) ? Constants.ONE_SIZE
					: sizeElement.findElement(By.cssSelector("span.cs__selected.default-opt")).getText().trim());

			product.setQuantity(item.findElement(By.cssSelector("#quantity option[selected='selected']")).getText());

			String unitPrice = item.findElement(By.cssSelector("div.items-list-row__unit-price p.price span:last-child")).getText().trim();
			product.setUnitPrice(FormatterUtils.parseValue(unitPrice, 2));

			String itemPrice = item.findElement(By.cssSelector("div.items-list-row__item-price p.price")).getText().trim();
			product.setAskingPrice(FormatterUtils.parseValue(itemPrice, 2));

			CartDataHandler.grabbedProductList.add(product);
		}
	}

	public void getCartTotals() {
		CartTotalModel total = new CartTotalModel();
		for (WebElement element : waitForElementsByCssLocator(totalContainerListLocator)) {
			if (element.findElement(By.cssSelector("td:first-child")).getText().contains("Unit total")) {
				total.setUnitTotal(FormatterUtils.parseValue(element.findElement(By.cssSelector("td:last-child")).getText(), 2));
			}
			if (element.findElement(By.cssSelector("td:first-child")).getText().contains("Delivery")) {
				total.setDelivery(FormatterUtils.parseValue(element.findElement(By.cssSelector("td:last-child")).getText(), 2));
			}
			if (element.findElement(By.cssSelector("td:first-child")).getText().contains("TOTAL")) {
				total.setTotal(FormatterUtils.parseValue(element.findElement(By.cssSelector("td:last-child")).getText(), 2));
			}
		}
		CartDataHandler.grabbedtotal = total;
	}
}
