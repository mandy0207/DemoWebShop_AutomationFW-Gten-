package com.demowebshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement headerLogin;

	@FindBy(css = "[class='email']")
	private WebElement email;

	@FindBy(css = "[class='password']")
	private WebElement password;

	@FindBy(xpath = "//*[@class='buttons']//input[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(id = "newsletter-email")
	private WebElement emailInput;
	
	@FindBy(id = "newsletter-subscribe-button")
	private WebElement susbcribeBtn;
	
	@FindBy(css = "[id='newsletter-result-block']")
	private WebElement newsLetterText;
	
	
	
	public String Login(String emailID, String Password) {
		clickElement(headerLogin);
		setTextBox(email, emailID);
		setTextBox(password, Password);
		clickElement(loginBtn);

		return emailID;
	}

	public List<String> getHeaders() {
		return getListofTextFromWebElements(headerItems);
	}
	
	public String validateNewsLetterSubscription(String email) {
		setTextBox(emailInput, email);
		clickElement(susbcribeBtn);
		shortWait();
		return getElementText(newsLetterText);
		
	}
	
	public void navigateToRegisteration() {
		
		clickElement(register);
	}

}
