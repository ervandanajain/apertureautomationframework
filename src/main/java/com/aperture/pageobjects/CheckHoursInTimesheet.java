package com.aperture.pageobjects;

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
	Waits wait;
	CheckHoursInTimesheet checkhours;


	public CheckHoursInTimesheet(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		System.out.println("refrence contain :" + wait);
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
		return checkstatus.getText();

	}

	public void clickOnNext() {
		wait.waitTillElementToBeClickable(btnnexttimesheet);
		btnnexttimesheet.click();
	}
	
	public void fillWeeklyTimeSheet(int hours) {
		String locator = null;
		for (int i = 0; i <= 4; i++) {
			locator = "//*[@id='0-" + i + "']";
			System.out.println("locator of timesheet area is "+locator);
			WebElement weeklyTime = ldriver.findElement(By.xpath(locator));
			System.out.println("Driver is " + ldriver +" Element is "+ weeklyTime);
			wait.waitTillVisibilityOf(weeklyTime);
			String hour= Integer.toString(hours);
			weeklyTime.clear();
			weeklyTime.sendKeys(hour);			
		}		
		}
	public void clickOnTimeSheetSubmit() {
		System.out.println("click on timesheet submit button");
		wait.waitTillElementToBeClickable(btntimesheetsubmit);
		btntimesheetsubmit.click();
	}
	
	public String checkPopUpType() {
		checkhours=new CheckHoursInTimesheet(ldriver);
		//wait.waitTillVisibilityOf(commentBoxMessage);
		ldriver.switchTo().activeElement();
		System.out.println("Alert box  " +commentBoxMessage.isDisplayed());
		//System.out.println("Comment box  " +enterComment.isDisplayed());
		System.out.println("Comment  box  ");
		System.out.println("in check popup type box ");
		System.out.println("in check popup type box ");
		String type="false";
		
			try {
				if(commentBoxMessage.isDisplayed()) {
			System.out.println("alert box "+ commentBoxMessage);
		type= "alertmessage"; }
		else 
		{
		System.out.println(" Nothing returned");
		type=  "false";
		}}
			catch (Exception e) {
				//if(!commentBoxMessage.isDisplayed()) {
					System.out.println("Trying comment box and got exception" +e.getMessage());
					if(enterComment.isDisplayed())
					System.out.println("comment box "+ enterComment);
					type=  "commentbox";}
			
		
		
		return type;
		}
		
	
	public boolean handlePopUp(String type,String expectedType,String msg)
	{
		System.out.println("Returned type is "+ type);
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
		System.out.println("CommentBox xpath is " + commentBoxMessage);
		return commentBoxMessage.getText();
	}
	
	public  void enterCommentMessage(String msg) {
		//wait.waitTillElementToBeClickable(commentDialogbox);
		wait.waitTillVisibilityOf(enterComment);
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
