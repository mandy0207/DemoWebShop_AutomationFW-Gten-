package com.demowebshop.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.ExcelReader;
import com.demowebshop.enums.Locators;
import com.demowebshop.models.Person;

public class DataDrivenRegisteration extends BaseTest{

	
	@Test
	public void verifyUserisAbleToRegisterMultiplePersons() throws IOException {
		
		loginPage.navigateToRegisteration();
		List<Person> personList = ExcelReader.readData();
		for(Person person : personList) {
			String email = registerPage.registerUser(person);
			Assert.assertEquals(registerPage.validateRegisteraionPageItems(Locators.REGISTERATIONALERTMSG), "Your registration completed");
			Assert.assertEquals(registerPage.validateRegisteraionPageItems(Locators.LOGGEDEMAIL), email);
			Assert.assertTrue((boolean) registerPage.validateRegisteraionPageItems(Locators.LOGOUT),"Logout button is not displayed");
			registerPage.logout().navigateToRegisterationSection();
			
		}
			
	}
}
