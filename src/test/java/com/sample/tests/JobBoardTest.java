package com.sample.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobBoardTest extends BaseClass {

	Logger log = Logger.getLogger(JobBoardTest.class.getName());

	@BeforeMethod
	private void loginAndNavigateToJobBoard() throws InterruptedException {
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

	}

	@Test(priority = 0)
	public void qualityAssuranceSpecialistJobValidation() throws InterruptedException {
		assertTrue(jobBoard.findQaTitle());
		log.info("Quality Assurance Specialist Job found");
	}

	@Test(priority = 1, dependsOnMethods = { "qualityAssuranceSpecialistJobValidation" })
	public void qualityAssuranceSpecialistJobDescriptionValidation() throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		if (jobBoard.findQaTitle()) {
			String jD = "Raptor Maps software is used by a global customer base in the clean energy sector. Quality Assurance is a critical aspect of our fast-paced development cycle. We have a full-time quality assurance position available in our software engineering team.";
			je.executeScript("arguments[0].scrollIntoView(true);", jobBoard.qaTitle());
			Assert.assertEquals(jD, jobBoard.getQaJobDescription());
			log.info("Quality Assurance Specialist Job and its description found");
		} else {
			log.info("Quality Assurance Specialist Job Not found");
		}

	}

	@Test(priority = 2)
	public void astronautJobValidation() throws InterruptedException {
		assertFalse(jobBoard.findAstronautTitle());
		log.info("There is no Astronaut job posting.");
	}

}
