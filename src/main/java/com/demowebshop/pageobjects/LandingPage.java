package com.demowebshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
     WebDriver driver;
     
	public LandingPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id="small-searchterms")
	private WebElement searchBox;
	
	@FindBy(css="[value='Search']")
	private WebElement searchBtn;
	
	
	
	
	public void searchProduct(String name) {
		searchBox.sendKeys(name);
		searchBtn.click();
	}

	

	
	
	
}
