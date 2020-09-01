package com.sample.tests;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JobBoardTest extends BaseClass {
	

	@Test(priority=0)
	public void qaJobValidation() throws InterruptedException {

		if (homePage.isCookieAlertDisplayed()) {
			homePage.declineCookieAlert();
		}

		Actions action = new Actions(driver);
		Assert.assertNotNull(homePage.getAboutElement());
		action.moveToElement(homePage.getAboutElement()).build().perform();
		Thread.sleep(3000);
		Assert.assertNotNull(jobBoard.jobBoardClick());
		action.moveToElement(jobBoard.jobBoardClick()).click().build().perform();
		Thread.sleep(5000);

		JavascriptExecutor je = (JavascriptExecutor) driver;

		if (jobBoard.findQaTitle()) {
			Assert.assertTrue( jobBoard.qaTitle().isDisplayed());
			
			String jD = "Raptor Maps software is used by a global customer base in the clean energy sector. Quality Assurance is a critical aspect of our fast-paced development cycle. We have a full-time quality assurance position available in our software engineering team.";

			je.executeScript("arguments[0].scrollIntoView(true);", jobBoard.qaTitle()); 
			
			System.out.println("QaTitle found");
			Assert.assertEquals(jD, jobBoard.getQaJobDescription());

		} else {
			System.out.println("QaTitle not found");
		}

	}
	
	@Test(priority=1)
	public void astronautJobSearch() throws InterruptedException {
		if (homePage.isCookieAlertDisplayed()) {
			homePage.declineCookieAlert();
		}

		Actions action = new Actions(driver);
		Assert.assertNotNull(homePage.getAboutElement());
		action.moveToElement(homePage.getAboutElement()).build().perform();
		Thread.sleep(3000);
		Assert.assertNotNull(jobBoard.jobBoardClick());
		action.moveToElement(jobBoard.jobBoardClick()).click().build().perform();
		Thread.sleep(5000);
		
		if (jobBoard.findAstronautTitle()) {

			System.out.println("AstronautTitle found");
		}

		else {
			System.out.println("AstronautTitle not found");
		}
	}

}
