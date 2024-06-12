package com.demowebshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {
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

	@FindBy(xpath = "//*[@class='top-menu']/li/a")
	private List<WebElement> headerItems;

	public String Login() {
		clickElement(headerLogin);
		setTextBox(email, "obsqura24@gmail.com");
		setTextBox(password, "mypassword");
		clickElement(loginBtn);

		return "obsqura24@gmail.com";
	}

	public List<String> getHeaders() {
		return getListofTextFromWebElements(headerItems);
	}

}
