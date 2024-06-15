package com.demowebshop.tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.demowebshop.Utils.ExcelReader;
import com.demowebshop.models.Person;

public class DataDrivenRegisteration extends BaseTest{

	
	@Test
	public void verifyUserisAbleToRegisterMultiplePersons() throws IOException {
		
		loginPage.navigateToRegisteration();
		List<Person> personList = ExcelReader.readData();
		for(Person person : personList) {
			registerPage.registerMultipleUsers(person);
			
		}
		
		
		
	}
}
