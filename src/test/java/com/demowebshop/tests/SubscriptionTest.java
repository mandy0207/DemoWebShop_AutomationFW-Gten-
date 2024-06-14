package com.demowebshop.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.TestProperties;
import com.demowebshop.Utils.UniqueGenerator;

public class SubscriptionTest extends BaseTest{

	@Test
	public void verifyUserIsAbleToSubscribe() throws IOException {
		
		Properties prop = TestProperties.getProperties();
		
		String actualnewsLetterText = loginPage.validateNewsLetterSubscription(UniqueGenerator.getUniqueEmail());
		System.out.println(actualnewsLetterText);
		Assert.assertEquals(actualnewsLetterText, prop.getProperty("subscriptionMsg"));
		
		
		
	}
}
