package com.sample.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.sample.pages.HomePage;
import com.sample.pages.JobBoard;

public class BaseClass {
	
	String driverPath = "/Users/rakesh/Documents/Sneha_work/drivers/geckodriver";
	WebDriver driver;
	HomePage homePage;
	JobBoard jobBoard;

	@BeforeMethod()
	public void setup() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.navigate().to("https://raptormaps.com/");
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		jobBoard = new JobBoard(driver);
	}
	
	@AfterClass()
	public void tearDown() {
		driver.close();
	}
}
