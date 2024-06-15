package com.demowebshop.tests;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		Assert.assertEquals(map.get("alertMsg"), "Your registration completed");
		Assert.assertEquals(map.get("loggedEmail"), email);
		Assert.assertEquals(map.get("isLogoutDisplayed"), true);
	
	}
	
	
}
