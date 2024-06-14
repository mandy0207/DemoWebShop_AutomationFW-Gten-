package com.demowebshop.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToLoginWithValidCred() {
		String actualemail = loginPage.Login();
	
		String expectedEmail=landingPage.validateEmailIsDisplayed();
		Assert.assertEquals(actualemail, expectedEmail,"Email is diplayed");
		
	
	}
	
	
	
}
