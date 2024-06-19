package com.demowebshop.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.CommonAssertions;
import com.demowebshop.Utils.TestProperties;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToLoginWithValidCred() {
		
		
		String actualemail = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
	
		String expectedEmail=landingPage.validateEmailIsDisplayed();
		CommonAssertions.verifyEqual(actualemail, expectedEmail, "Email is diplayed");
	
	}
	
	
	
}
