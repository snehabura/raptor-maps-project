package com.sample.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sample.pages.HomePage;
import com.sample.pages.JobBoard;

public class BaseClass {
	
	String driverPath = "/Users/rakesh/Documents/Sneha_work/drivers/geckodriver";
	WebDriver driver;
	HomePage homePage;
	JobBoard jobBoard;

	@BeforeSuite(description="Set up and start firefox driver")
	public void setup() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.navigate().to("https://raptormaps.com/");
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		jobBoard = new JobBoard(driver);
	}
	
	@AfterSuite(description="Close driver")
	public void tearDown() {
		driver.close();
	}
}
