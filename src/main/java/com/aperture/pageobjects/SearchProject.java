package com.aperture.pageobjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aperture.reusablecode.CommonMethods;
import com.aperture.utilities.Waits;

public class SearchProject {
	WebDriver ldriver;
	Waits wait;
	Logger llogger;

	public SearchProject(WebDriver rdriver, Logger rlogger) {
		ldriver = rdriver;
		llogger = rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 3000);
		System.out.println(" on login refrence contain :" + wait);
	}

	@FindBy(xpath = "//input[@placeholder='Search project (type project name, project id, account name, etc...)']")
	@CacheLookup
	WebElement txtsearchproject;
	@FindBy(xpath = "//mat-table//mat-row")
	@CacheLookup
	List<WebElement> listproject;
	@FindBy(xpath = "//mat-table//mat-row//mat-cell//a")
	@CacheLookup
	List<WebElement> listprojectcode;
	@FindBy(xpath = "//li[contains(@class,'nav-item active')]")
	WebElement activelink;

	public void searchProject(String projectname) {
		wait.waitTillVisibilityOf(txtsearchproject);
		llogger.info("user searching for project " + projectname);
		txtsearchproject.clear();
		txtsearchproject.sendKeys(projectname);
	}

	public String searchResult(String projectname) {
		return CommonMethods.searchResult(listproject, listprojectcode, projectname);
	}

	public void assertTitle(String title) {
		System.out.println("Aserting title");
		wait.waitTillVisibilityOf(activelink);
		String actualvalue = activelink.getText();
		System.out.println("Active link text is " + actualvalue);
	}

	public void getURL() {
		System.out.println("Current url is " + ldriver.getCurrentUrl());
	}
}
