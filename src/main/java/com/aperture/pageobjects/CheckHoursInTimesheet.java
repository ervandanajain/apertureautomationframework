package com.aperture.pageobjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	
	@FindBy(xpath = "//tr[contains(@class,'project-row')]/td[contains(@class,'first-child')]")
	@CacheLookup
	List<WebElement> rowProjectName;
	
	@FindBy(xpath="//div[contains(@class,'totalDayHoursDiv ')]")
	@CacheLookup
	List<WebElement> totalhour;
	
	@FindBy(xpath="//textarea[@type='text']")
	@CacheLookup
	WebElement commentfortotalhour;
	
	@FindBy(xpath="//div[contains(@class,'mat-input-subscript-wrapper')]]")
	@CacheLookup
	WebElement divcommentfortotalhour;

	@FindBy(xpath = "//span[contains(@class,'projectName')]")
	@CacheLookup
	WebElement spanprojectname;
	
	@FindBy(xpath="//span[@class='week-date']")
	@CacheLookup
	WebElement spanDate;
	
	@FindBy(xpath = "//*[@id='weeklyTSRow']/tbody/tr[2]/td[10]/div")
	@CacheLookup
	WebElement checkstatus;

	@FindBy(css = "p.group span:nth-of-type(2)+img")
	@CacheLookup
	WebElement btnnexttimesheet;
	
	@FindBy(xpath="//*[contains(@class,'mat-dialog-container')]")
	WebElement commentDialogbox;
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]")
	WebElement commentBoxMessage;
	
	@FindBy(xpath=" //*[@class='mat-input-element mat-form-field-autofill-control ng-pristine ng-valid ng-touched']")
	WebElement enterComment;
	
	@FindBy(xpath="//button[@type='button' and contains(., 'Submit')]")
	WebElement submitComment;
	
	
	@FindBy(xpath="//button[@class='cancel-submit mat-button' and contains(., 'Cancel')]")
	WebElement cancelComment;
	
	@FindBy(xpath="//button[@id='save-button']")
	WebElement btntimesheetsave;
	
	@FindBy(id="submit-button")
	@CacheLookup
	WebElement btntimesheetsubmit;
	
	@FindBy(xpath="//button[contains(@class,'mat-raised-button')]")
	@CacheLookup
	List<WebElement> saveandsubmitbutton;
	
	
	public  int getWeekStatus() throws ParseException {
		// TODO Auto-generated method stub
		String date=spanDate.getText();
		String splitdate[]=date.split("-");
		String splitdate2[]=splitdate[1].split(",");
		if(splitdate[0].contains("Dec") && splitdate[1].contains("Jan"))
		splitdate2[1]=Integer.toString(Integer.parseInt(splitdate2[1].trim())-1);
		String startdate=splitdate[0].trim()+", "+splitdate2[1].trim();
		String enddate=splitdate[1].trim();
		System.out.println(startdate);
		System.out.println(enddate);

		final DateFormat sdf = new SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH);
		
        Date edate = sdf.parse(enddate);
        Date sdate = sdf.parse(startdate);
        return checkDateWeek(sdate,edate);
        }
	
	public int checkDateWeek(Date sdate,Date edate)
	{
		int status=0;
		Date currentdate = new Date();
		if(sdate.before(currentdate))
			status=-1;//previous week
		else if(sdate.before(currentdate)||edate.after(currentdate)) 
         status=0;//current week
         else if (edate.before(currentdate))
        	 status=1;//next week
         return status;
        }
	

	
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
	
	public String checkNumberofProject() {
	int count=rowProjectName.size();
	if((count==1)&&(rowProjectName.get(0).getText().contains("APP-Dev Bench")))
		return "Bench";
	else return "Allocated";
	}
	
	public boolean checkTotalHourPerDay(WebElement totalhour) {
		wait.waitTillVisibilityOf(totalhour);
		String totalhrs=totalhour.getText();
		int totalhours=Integer.parseInt(totalhrs);
		if((totalhours==0)||(totalhours>8))
			if(totalhrs.contains("**")) {
				totalhour.click();
				wait.waitTillVisibilityOf(commentfortotalhour);
				commentfortotalhour.sendKeys("abcd");
				divcommentfortotalhour.click();
				return true;
			}
			else return false;
		else return true;
	}
	public void fillWeeklyTimeSheet(String hour2) {
		String locator = null;
		for (int i = 1; i <= 5; i++) {
			llogger.info("user filling timesheet ");
			locator = "//*[@id='0-" + i + "']";
			llogger.info("locator of timesheet area is "+locator);
			WebElement weeklyTime = ldriver.findElement(By.xpath(locator));
			wait.waitTillVisibilityOf(weeklyTime);
			weeklyTime.clear();
			weeklyTime.sendKeys(hour2);	
			boolean checkttlhr= checkTotalHourPerDay(totalhour.get(i));
			
		}		
		}
	
	public void clickOnTimeSheetSave() {
		llogger.info("user clicked on timesheet save button");
		wait.waitTillElementToBeClickable(btntimesheetsave);
		btntimesheetsave.click();
	}
	
	public void clickOnTimeSheetSubmit() {
		llogger.info("user clicked on timesheet submit button");
		wait.waitTillElementToBeClickable(btntimesheetsubmit);
		btntimesheetsubmit.click();
	}
	
	public String checkPopUpType() {
		checkhours=new CheckHoursInTimesheet(ldriver,llogger);
		//wait.waitTillVisibilityOf(commentBoxMessage);
		List<WebElement> popupType=new ArrayList<WebElement>();
		//popupType.add(commentBoxMessage);
		//popupType.add(enterComment);
		popupType.add(ldriver.switchTo().activeElement());
		System.out.println(popupType);
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
