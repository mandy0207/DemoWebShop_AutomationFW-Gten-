package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToLoginWithValidCred() {
		
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys("obsqura24@gmail.com");
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("mypassword");
		driver.findElement(By.xpath("//*[@class='buttons']//input[@value='Log in']")).click();
		
		
	}
	
	
	
}
