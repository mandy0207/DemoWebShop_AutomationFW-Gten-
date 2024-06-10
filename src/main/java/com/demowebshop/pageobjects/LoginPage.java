package com.demowebshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
     WebDriver driver;
     
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement headerLogin;
	
	@FindBy(css="[class='email']")
	private WebElement email;

	@FindBy(css="[class='password']")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='buttons']//input[@value='Log in']")
	private WebElement loginBtn;
	
	
	public void Login() {
		headerLogin.click();
		email.sendKeys("obsqura24@gmail.com");
		password.sendKeys("mypassword");
		loginBtn.click();
	}
	
	
	
}
