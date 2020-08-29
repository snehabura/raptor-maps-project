package com.sample.tests;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sample.pages.HomePage;
import com.sample.pages.JobBoard;

public class JobBoardTest {
	
	String driverPath ="/Users/rakesh/Documents/Sneha_work/drivers/geckodriver";
	
	WebDriver driver ;
	HomePage homePage;
	JobBoard jobBoard;
	
	@BeforeTest()
	public void setup() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.navigate().to("https://raptormaps.com/");
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		jobBoard = new JobBoard(driver);
	}
	
	@Test()
	public void jobValidation() throws InterruptedException {
		
		
		if(homePage.isCookieAlertDisplayed()) {
			homePage.declineCookieAlert();
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(homePage.getAboutElement()).build().perform();
		Thread.sleep(3000);
		action.moveToElement(jobBoard.jobBoardClick()).click().build().perform();
		Thread.sleep(5000);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		je.executeScript("arguments[0].scrollIntoView(true);",jobBoard.findQaTitle()); //why
		
		String jD ="Raptor Maps software is used by a global customer base in the clean energy sector. Quality Assurance is a critical aspect of our fast-paced development cycle. We have a full-time quality assurance position available in our software engineering team.";
		
		if(jobBoard.findQaTitle().isDisplayed())
		{
		System.out.println("QaJobDescription found using text");
		Assert.assertEquals( jD, jobBoard.getQaJobDescription());
		}
		 
		else {
		System.out.println("QaJobDescription not found");
		}
		
		
	}
	
	@AfterClass()
	public void tearDown() {
		driver.close();
	}

}
