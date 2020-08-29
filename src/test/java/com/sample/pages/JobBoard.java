package com.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobBoard {
	WebDriver driver;
	
	@FindBy(id="menu-item-5094")
	WebElement jobBoard;
	
	@FindBy(xpath="//*[text()='Quality Assurance Specialist']")
	//@FindBy(xpath="//*[@id=\"et-boc\"]/div/div[2]/div/div[1]/div[9]/div/h4/b")
	WebElement qaTitle;
	
	@FindBy(xpath="//*[@id=\"et-boc\"]/div/div[2]/div/div[1]/div[9]/div/p[2]/span")
	WebElement qaJobDescription;
	
	public JobBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement jobBoardClick() {
		return jobBoard;
	}
	
	public WebElement findQaTitle() {
		return qaTitle;
		
	}
	
	public String getQaJobDescription() {
		return qaJobDescription.getText();
	}

}
