package com.cucumber.pages.desktop.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.pages.AbstractPage;
import com.tools.data.ProductDetailModel;
import com.tools.data.contactus.ContactUsFormModel;

public class ProductContactUsPage extends AbstractPage {

	public ProductContactUsPage(WebDriver driver) {
		super(driver);
	}

	private String fisrtNameInput = "input#name";
	private String surnameInput = "input#last-name";
	private String emailInput = "input#email";
	private String phoneInput = "input#phone";
	private String countryDropDown = "#countrySelect span.cs__selected";
	private String enquiryDropDown = "#typeOfEnquiry span.cs__selected";
	private String subjectInput = "input#subject";
	private String messageInput = "textarea[name='description']";

	private String radioContactByEmail = "label[for='contactByEmail_sg']";
	private String radioContactByPhone = "label[for='contactByPhone_sg']";

	private String submitButton = ".pdp__contact-us__contact-from #sfSubmitButton";

	private String formContainerLocator = "div[class=contact-form]";
	private String productContainerLocator = "div.wrapper .pdp__contact-us__product";

	private String productTitle = ".pdp__contact-us__product__designer";
	private String productDetails = ".pdp__contact-us__product__name";
	private String productPrice = ".pdp__contact-us__product__price";
	private String productCode = ".pdp__contact-us__product__code";
	private String producteSize = "span.cs__selected.valid";

	public ContactUsFormModel grabContactUsForm() {
		waitForPageToLoad();
		ContactUsFormModel contactForm = new ContactUsFormModel();
		WebElement formInputList = waitForElementByCssLocator(formContainerLocator);
		contactForm.setFisrtNameInput(formInputList.findElement(By.cssSelector(fisrtNameInput)).getText());
		contactForm.setSurnameInput(formInputList.findElement(By.cssSelector(surnameInput)).getText());
		contactForm.setEmailInput(formInputList.findElement(By.cssSelector(emailInput)).getText());
		contactForm.setPhoneInput(formInputList.findElement(By.cssSelector(phoneInput)).getText());
		contactForm.setCountryDropDown(formInputList.findElement(By.cssSelector(countryDropDown)).getText());
		contactForm.setEnquiryDropDown(formInputList.findElement(By.cssSelector(enquiryDropDown)).getText());
		contactForm.setSubjectInput(formInputList.findElement(By.cssSelector(subjectInput)).getText());
		contactForm.setMessageInput(formInputList.findElement(By.cssSelector(messageInput)).getText());
		contactForm.setRadioContactByEmail(formInputList.findElement(By.cssSelector(radioContactByEmail)).getText());
		contactForm.setRadioContactByPhone(formInputList.findElement(By.cssSelector(radioContactByPhone)).getText());
		return contactForm;
	}

	public ProductDetailModel grabProductContactUsDetails() {
		waitForPageToLoad();
		ProductDetailModel productDetailModel = new ProductDetailModel();
		WebElement productDetailsList = waitForElementByCssLocator(productContainerLocator);
		productDetailModel.setTitle(productDetailsList.findElement(By.cssSelector(productTitle)).getText());
		productDetailModel.setDetails(productDetailsList.findElement(By.cssSelector(productDetails)).getText());
		productDetailModel.setPrice(productDetailsList.findElement(By.cssSelector(productPrice)).getText());
		productDetailModel.setCode(productDetailsList.findElement(By.cssSelector(productCode)).getText());

		return productDetailModel;
	}

}
