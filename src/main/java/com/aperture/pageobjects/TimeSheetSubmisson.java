package com.aperture.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aperture.utilities.Waits;

public class TimeSheetSubmisson {

	WebDriver ldriver;
	Waits wait;
	Logger llogger;

	public TimeSheetSubmisson(WebDriver rdriver, Logger rlogger) {
		ldriver = rdriver;
		llogger = rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		System.out.println("refrence contain :" + wait);
	}

	@FindBy(xpath = "//*[@id=\'account-menu\']//*[text()='Timesheet']")
	@CacheLookup
	WebElement linktimesheet;

	// @FindBy(xpath = "//*[@id='navbarResponsive']//a[contains(text(), 'My
	// Timesheet')]/@href")
	@FindBy(xpath = "//*[@id='navbarResponsive']/ul/li[1]/ul/li[1]/a")
	@CacheLookup
	WebElement linkmytimesheet;

	@FindBy(id = "main-heading")
	@CacheLookup
	WebElement divpageheading;

	@FindBy(xpath = "//*[@id='weeklyTSRow']/tbody/tr[2]/td[10]/div")
	@CacheLookup
	WebElement checkstatus;

	@FindBy(css = "p.group span:nth-of-type(2)+img")
	@CacheLookup
	WebElement btnnexttimesheet;
	//// *[@id='weeklyTSRow']/tbody/tr[2]/td[2]/input
	@FindBy(id = "submit-button")
	@CacheLookup
	WebElement btntimesheetsubmit;

	@FindBy(xpath = " //*[@class='mat-input-element mat-form-field-autofill-control ng-pristine ng-valid ng-touched']")
	WebElement enterComment;

	@FindBy(xpath = "//*[@class='mat-dialog-content']")
	WebElement commentDialogbox;

	@FindBy(xpath = "//button[@class='cancel-submit mat-button' and contains(., 'Cancel')]")
	WebElement cancelComment;

	public boolean checkheading() {
		wait.waitTillElementToBeClickable(divpageheading);
		if (divpageheading.getText().equals("My Timesheet"))
			return true;
		else
			return false;
	}

	public String checkstatus() {
		wait.waitTillElementToBeClickable(checkstatus);
		llogger.info("user checking status of timesheet " + checkstatus);
		return checkstatus.getText();

	}

	public void clickOnNext() {
		wait.waitTillElementToBeClickable(btnnexttimesheet);
		llogger.info("user clicked on next " + btnnexttimesheet.getText());
		btnnexttimesheet.click();
	}

	public void fillWeeklyTimeSheet() {
		String locator = null;
		for (int i = 0; i <= 4; i++) {
			llogger.info("user filling timesheet");
			locator = "(//input[@id='0-" + i + "'])[1]";
			WebElement weeklyTime = ldriver.findElement(By.xpath(locator));
			wait.waitTillElementToBeClickable(weeklyTime);
			weeklyTime.sendKeys("0");
		}
	}

	public void cancelCommentMessage() {
		Actions action = new Actions(ldriver);
		llogger.info("user clicked on cancel comment");
		action.moveToElement(cancelComment).click().build().perform();
		wait.waitTillElementToBeClickable(cancelComment);
		cancelComment.click();
	}

	public void clickOnTimeSheetSubmit() {
		llogger.info("user clicked on timesheet submit button " + btntimesheetsubmit.getText());
		wait.waitTillElementToBeClickable(btntimesheetsubmit);
		btntimesheetsubmit.click();
	}

	public void enterCommentMessage(String msg) {
		// wait.waitTillElementToBeClickable(commentDialogbox);
		wait.waitTillVisibilityOf(enterComment);
		llogger.info("user entered comment message " + msg);
		Actions action = new Actions(ldriver);
		action.moveToElement(commentDialogbox).click().build();
		System.out.println("Comment box xpath is  " + enterComment);
		enterComment.sendKeys(msg);
	}

}
