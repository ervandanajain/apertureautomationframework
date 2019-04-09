package com.aperture.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aperture.utilities.Waits;

public class CheckHoursInTimesheet  {
	WebDriver ldriver;
	Logger llogger;
	Waits wait;
	CheckHoursInTimesheet checkhours;


	public CheckHoursInTimesheet(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
	}
	
	@FindBy(id = "main-heading")
	@CacheLookup
	WebElement divpageheading;

	@FindBy(xpath = "//*[@id='weeklyTSRow']/tbody/tr[2]/td[10]/div")
	@CacheLookup
	WebElement checkstatus;

	@FindBy(css = "p.group span:nth-of-type(2)+img")
	@CacheLookup
	WebElement btnnexttimesheet;
	
	@FindBy(xpath="//*[@class='mat-dialog-container ng-tns-c19-8 ng-trigger ng-trigger-slideDialog ng-star-inserted']")
	WebElement commentDialogbox;
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]")
	WebElement commentBoxMessage;
	
	@FindBy(xpath=" //*[@class='mat-input-element mat-form-field-autofill-control ng-pristine ng-valid ng-touched']")
	WebElement enterComment;
	
	@FindBy(xpath="//button[@type='button' and contains(., 'Submit')]")
	WebElement submitComment;
	
	@FindBy(xpath="//button[@class='cancel-submit mat-button' and contains(., 'Cancel')]")
	WebElement cancelComment;
	
	@FindBy(id="submit-button")
	@CacheLookup
	WebElement btntimesheetsubmit;
	
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
	
	public void fillWeeklyTimeSheet(int hours) {
		String locator = null;
		for (int i = 0; i <= 4; i++) {
			llogger.info("user filling timesheet ");
			locator = "//*[@id='0-" + i + "']";
			llogger.info("locator of timesheet area is "+locator);
			WebElement weeklyTime = ldriver.findElement(By.xpath(locator));
			llogger.info("Driver is " + ldriver +" Element is "+ weeklyTime);
			wait.waitTillVisibilityOf(weeklyTime);
			String hour= Integer.toString(hours);
			weeklyTime.clear();
			weeklyTime.sendKeys(hour);			
		}		
		}
	public void clickOnTimeSheetSubmit() {
		llogger.info("user clicked on timesheet submit button");
		wait.waitTillElementToBeClickable(btntimesheetsubmit);
		btntimesheetsubmit.click();
	}
	
	public String checkPopUpType() {
		checkhours=new CheckHoursInTimesheet(ldriver,llogger);
		//wait.waitTillVisibilityOf(commentBoxMessage);
		ldriver.switchTo().activeElement();
		llogger.info("Alert box  " +commentBoxMessage.isDisplayed());
		//llogger.info("Comment box  " +enterComment.isDisplayed());
		llogger.info("Comment  box  ");
		llogger.info("in check popup type box ");
		llogger.info("in check popup type box ");
		String type="false";
		
			try {
				if(commentBoxMessage.isDisplayed()) {
			llogger.info("alert box "+ commentBoxMessage);
		type= "alertmessage"; }
		else 
		{
		llogger.info(" Nothing returned");
		type=  "false";
		}}
			catch (Exception e) {
				//if(!commentBoxMessage.isDisplayed()) {
					llogger.info("Trying comment box and got exception" +e.getMessage());
					if(enterComment.isDisplayed())
					llogger.info("comment box "+ enterComment);
					type=  "commentbox";}
			
		
		
		return type;
		}
		
	
	public boolean handlePopUp(String type,String expectedType,String msg)
	{
		llogger.info("Returned type is "+ type);
		if(type=="alertmessage") {
			boolean isFound =checkhours.getCommentBoxMesage().contains(msg);
			Assert.assertTrue(isFound);
			ldriver.switchTo().activeElement().click();
			return true;}
		
			else if(type=="commentbox") {
				ldriver.switchTo().activeElement().click();
				checkhours.enterCommentMessage(msg);
				checkhours.cancelCommentMessage();
				if(type==expectedType)
				return true;
				else 
				return false;
			}
			else return false;
	}
	
	public  String getCommentBoxMesage() {
		wait.waitTillVisibilityOf(commentBoxMessage);
		llogger.info("CommentBox xpath is " + commentBoxMessage);
		return commentBoxMessage.getText();
	}
	
	public  void enterCommentMessage(String msg) {
		//wait.waitTillElementToBeClickable(commentDialogbox);
		wait.waitTillVisibilityOf(enterComment);
		llogger.info("user entered comment message " + msg);
		Actions action =new Actions(ldriver);
		action.moveToElement(commentDialogbox).click().build();
		System.out.println("Comment box xpath is  "+enterComment);
		enterComment.sendKeys(msg);
	}
	
	public void submitCommentMessage() {
		wait.waitTillElementToBeClickable(submitComment);
		submitComment.click();
	}
	
	public void cancelCommentMessage() {
		Actions action =new Actions(ldriver);
				action.moveToElement(cancelComment).click().build().perform();
		wait.waitTillElementToBeClickable(cancelComment);
		cancelComment.click();
	}
	public int hoursEqualToZero() {return 0;}
	public int hoursBetweenZeroAndEight() {return 5;}
	public int hoursGreaterThanEight() {return 9;}
	public int hoursGreaterThanTwentyFour() {return 25;}
}
