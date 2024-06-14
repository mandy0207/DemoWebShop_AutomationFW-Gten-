package com.demowebshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{
     WebDriver driver;
     
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="small-searchterms")
	private WebElement searchBox;
	
	@FindBy(css="[value='Search']")
	private WebElement searchBtn;
	
	
	@FindBy(css=".header-links li:nth-child(1) a")
	private WebElement emailHeader;
	
	
	public void searchProduct(String name) {
		setTextBox(searchBox, name);
		clickElement(searchBtn);
		
	}
	
	public String validateEmailIsDisplayed() {
		return emailHeader.getText();
		
	}

	

	
	
	
}
