package com.demowebshop.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demowebshop.pageobjects.LandingPage;
import com.demowebshop.pageobjects.LoginPage;

public class BaseTest {

	WebDriver driver = null;

	@BeforeMethod
	public void initializeDriver() {
		String browserName = "chrome";
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("msedge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("not a valid browser");
		}
    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		initPages();
		driver.get("https://demowebshop.tricentis.com/");

	}

	public LoginPage loginPage;
	public LandingPage landingPage;
	
	

	public void initPages() {
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
