package com.demowebshop.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demowebshop.Context.DriverManager;
import com.demowebshop.Utils.TestProperties;
import com.demowebshop.pageobjects.LandingPage;
import com.demowebshop.pageobjects.LoginPage;
import com.demowebshop.pageobjects.RegisterationPage;


public class BaseTest {

	WebDriver driver =null;
	Properties prop ;
	

	@BeforeMethod
	@Parameters({"browserName"})
	public void initializeDriver(@Optional String browserName) throws IOException {
		prop = TestProperties.getProperties();
		
		if(browserName==null || browserName.isEmpty()) {
		 browserName = prop.getProperty("browserName");
		}
	  
	   String env= prop.getProperty("Envrionment");
	   String URL=prop.getProperty(env);
	   System.out.println("Executing in : "+env);
	    
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions ops =new ChromeOptions();
			ops.addArguments("--headless=new");
			driver = new ChromeDriver(ops);

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("not a valid browser");
		}
		initPages();
		DriverManager.setDriver(driver);
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(URL);

	}
	
	

	
	/**
	 * Initializing pages
	 */

	public LoginPage loginPage;
	public LandingPage landingPage;
	public  RegisterationPage registerPage;
	
	public void initPages() {
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		registerPage = new  RegisterationPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
