package com.demowebshop.tests;


import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToLoginWithValidCred() {
		loginPage.Login();
	
	}
	
	
	
}
