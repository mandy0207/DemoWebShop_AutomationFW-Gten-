package com.demowebshop.tests;

import org.testng.annotations.Test;

public class AddToCart extends BaseTest {

	
	@Test
	public void verifyUserIsAbleToAddProductToCart() {
	
		loginPage.Login();
		landingPage.searchProduct("Jeans");
			
	}
}
