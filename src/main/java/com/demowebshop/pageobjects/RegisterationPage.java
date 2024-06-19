package com.demowebshop.pageobjects;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.UniqueGenerator;
import com.demowebshop.enums.Locators;
import com.demowebshop.models.Person;

public class RegisterationPage extends BasePage{
     WebDriver driver;
     
	public RegisterationPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="gender-male")
	private WebElement maleCheckBox;
	
	@FindBy(id="FirstName")
	private WebElement firstNameInput;
	
	@FindBy(id="LastName")
	private WebElement lastNameInput;
	
	@FindBy(id="Email")
	private WebElement emailInput;
	
	@FindBy(id="Password")
	private WebElement passwordInput;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordInput;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	@FindBy(css="[class='result']")
	private WebElement alertMsg;
	
	
	@FindBy(css=".header-links [class='account']")
	private WebElement loggedEmail;
	
	@FindBy(css="[class='ico-logout']")
	private WebElement logout;
	
	
	
	

	public LinkedHashMap<String, Object> validateRegisteration(String fname, String lname, String emailId, String passwordValue, String confirmPassValue) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		setTextBox(firstNameInput, fname);
		setTextBox(lastNameInput, lname);
		setTextBox(emailInput, emailId);
		setTextBox(passwordInput, passwordValue);
		setTextBox(confirmPasswordInput, confirmPassValue);
		clickElement(registerBtn);
		map.put("alertMsg", getElementText(alertMsg));
		map.put("loggedEmail",  getElementText(loggedEmail));
		map.put("isLogoutDisplayed", isElementDisplayed(logout));
		return map;

	}
	
	public String registerUser(Person person) {
		String email =person.email+UniqueGenerator.getCurrentDateTime()+"@yopmail.com";
		setTextBox(firstNameInput, person.firstName);
		setTextBox(lastNameInput, person.lastName);
		setTextBox(emailInput, email);
		setTextBox(passwordInput, person.password);
		setTextBox(confirmPasswordInput, person.confirmPassword);
		clickElement(registerBtn);	
		return email;
	}
	
	public Object validateRegisteraionPageItems(Locators name) {
		
		switch(name){
		case REGISTERATIONALERTMSG:
			return getElementText(alertMsg);
		case LOGGEDEMAIL:
			return getElementText(loggedEmail);
		case LOGOUT:
			return isElementDisplayed(logout);
		default : 
			return "";
		}
		
	}
	
	public RegisterationPage logout() {
		clickElement(logout);
		return this;
		
	}
	
	public void navigateToRegisterationSection() {
		clickElement(register);
		
	}
	
	

	
	

}
