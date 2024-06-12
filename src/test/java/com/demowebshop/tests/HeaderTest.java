package com.demowebshop.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

	
	@Test
	public void verifyUserIsAbleToAddProductToCart() {
	
		//Test Data
		List<String> expectedHeaders= new ArrayList<>(List.of("Computers","Books" ,"Digital Downloads","Electronics", "Apparel & Shoes", "Jewelry", "Gift Cards"));
		
		expectedHeaders.replaceAll(String :: toLowerCase);
		
//		for(int i =0;i<expectedHeaders.size();i++) {
//			expectedHeaders.set(i, expectedHeaders.get(i).toLowerCase());
//		}
	
		
		List<String> actualHeaders = loginPage.getHeaders();
		
		//sorting lists
		Collections.sort(expectedHeaders);
		Collections.sort(actualHeaders);
		
		System.out.println(actualHeaders);
		System.out.println(expectedHeaders);
		
		
		Assert.assertEquals(actualHeaders, expectedHeaders, "Headers Mismatch");
				
	}
	

}
