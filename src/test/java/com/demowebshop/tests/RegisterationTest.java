package com.demowebshop.tests;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.CommonAssertions;
import com.github.javafaker.Faker;

public class RegisterationTest extends BaseTest {

	@Test
	public void verifyUserIsAbletoSignupWithValidCreds() {
		Faker faker = new Faker();
        String password= faker.internet().password();
        String email= faker.internet().emailAddress();
		loginPage.navigateToRegisteration();
		LinkedHashMap<String, Object> map = registerPage.validateRegisteration(faker.name().firstName(),faker.name().lastName(),email, password,  password);

		System.out.println(map);
		CommonAssertions.verifyEqual(map.get("alertMsg").toString(), "Your registration completed","");
	
		CommonAssertions.verifyEqual(map.get("alertMsg").toString(), "Your registration completed","");
		CommonAssertions.verifyEqual(map.get("loggedEmail").toString(), email,"");
		CommonAssertions.validateTrue((boolean) map.get("isLogoutDisplayed"), "Logout button not displayed");
	
		
	
	}
	
	
}
