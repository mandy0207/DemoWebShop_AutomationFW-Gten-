package com.demowebshop.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {

	WebDriver driver;
	WebDriverWait wait;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickElement(WebElement element) {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.click();

	}

	public void setTextBox(WebElement element, String value) {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.sendKeys(value);
	}

	public void waitUntilDisplayed(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		
	}

	public void switchChildWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindow = windowHandles.iterator().next();
		String childWindow = windowHandles.iterator().next();
		driver.switchTo().window(childWindow);
	}

	public void switchToParentWindow() {

	}

	public List<String> getListofTextFromWebElements(List<WebElement> list) {
		List<String> actualList = new ArrayList<String>();
		for (WebElement item : list) {
			actualList.add(item.getText().toLowerCase());
		}
		return actualList;
	}
}
