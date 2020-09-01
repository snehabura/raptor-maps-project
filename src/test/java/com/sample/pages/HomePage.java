package com.sample.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(id = "hs-eu-decline-button")
	WebElement cookieAlert;

	@FindBy(id = "menu-item-5086")
	WebElement aboutLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public boolean isCookieAlertDisplayed() {
		try {
			cookieAlert.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void declineCookieAlert() {
		cookieAlert.click();
	}

	public WebElement getAboutElement() {
		return aboutLink;
	}

}
