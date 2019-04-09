package com.aperture.testcases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;


import com.aperture.core.BaseClass;
import com.aperture.pageobjects.AddAccounts;
import com.aperture.pageobjects.CheckHoursInTimesheet;

public class CheckHoursInTimesheet_Test extends BaseClass {
	CheckHoursInTimesheet checkhours;
	NavigationMenu_Test navigation;
	String type;
	String msg;
	String expectedType;
	
	public CheckHoursInTimesheet_Test() throws IOException {
		super();
	}
	
	@Test(priority=0)
	public void runlogin() throws Exception
	{
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();
		checkhours=new CheckHoursInTimesheet(driver,logger);
		navigation = new NavigationMenu_Test();
	
		
	}
	
	@Test(priority = 1)
	public void navigate_To_TimeSheet() {
		navigation.navigateToTimesheet();
		navigation.navigateToMyTimesheet();
	}
	
	@Test(priority=2)
	public void searchEmptyTimesheet() {
		checkhours.checkheading();
		checkhours.checkstatus();
		checkhours.clickOnNext();
	}
	
	@Test(priority=3)
	public void hoursEqualToZero () 
	{
		checkhours.fillWeeklyTimeSheet(checkhours.hoursEqualToZero());
		checkhours.clickOnTimeSheetSubmit();
		 type=checkhours.checkPopUpType();
		 msg="Comment is mandatory when Total working hours per day is 0";
		expectedType="alertmessage";
		System.out.println("returned type is "+type);
		boolean res=checkhours.handlePopUp(type,expectedType,msg);
		Assert.assertEquals(true, res);
		
		
		
	}
	@Test(priority=4)
	public void hoursBetweenZeroAndEight()
	{
		checkhours.fillWeeklyTimeSheet(checkhours.hoursBetweenZeroAndEight());
		checkhours.clickOnTimeSheetSubmit();
		String type=checkhours.checkPopUpType();
		String msg="Checking for hours between 0 to 8";
		expectedType="commentbox";
		checkhours.handlePopUp(type,expectedType,msg);

		//checkhours.submitCommentMessage();
	}
	@Test(priority=5)
	public void hoursGreaterThanEight()
	{
		checkhours.fillWeeklyTimeSheet(checkhours.hoursGreaterThanEight());
		checkhours.clickOnTimeSheetSubmit();
		String type=checkhours.checkPopUpType();
		type=checkhours.checkPopUpType();
		 msg="Comment is mandatory when worked for more than 8 hours on the same project";
		expectedType="alertmessage";
		checkhours.handlePopUp(type,expectedType,msg);
		
	}
	@Test(priority=6)
	public void hoursGreaterThanTwentyFour()
	{
		checkhours.fillWeeklyTimeSheet(checkhours.hoursGreaterThanTwentyFour());
		checkhours.clickOnTimeSheetSubmit();
		System.out.println(checkhours.getCommentBoxMesage());
		type=checkhours.checkPopUpType();
		 msg="You are not allowed to enter more than 24 total day hours";
		expectedType="alertmessage";
		checkhours.handlePopUp(type,expectedType,msg);
		driver.switchTo().activeElement().click();
		
	}
}
