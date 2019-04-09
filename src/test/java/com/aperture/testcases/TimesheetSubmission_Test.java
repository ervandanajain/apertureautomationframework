package com.aperture.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aperture.core.BaseClass;
import com.aperture.pageobjects.SubmitPendingTimesheet;
import com.aperture.pageobjects.TimeSheetSubmisson;

public class TimesheetSubmission_Test extends BaseClass {
	TimeSheetSubmisson tss;
	NavigationMenu_Test navigation;
	//LoginPage1 lp1;

	public TimesheetSubmission_Test() throws IOException {
		super();
		
	}
	@Test(priority=0)
	public void runLogin() throws InterruptedException, IOException {
		LoginPage_Test testloginpage=new LoginPage_Test();
		testloginpage.loginTest();
		navigation=new NavigationMenu_Test();
	}
//@Test(alwaysRun =true,dependsOnGroups= {"login"})
	@Test(priority=1)
	public void timesheetsubmittion()  {
	
			navigation.navigateToTimesheet();
			String status = tss.checkstatus();
			System.out.print("Status is : " + status);
			while (!status.isEmpty()) {
				tss.clickOnNext();
				Assert.assertTrue(tss.checkheading());
			}
		}

	
	 // @Test(dependsOnMethods = {"timesheetsubmittion"})	
	 	@Test(priority=2)
	   public void fillWeeklyTimeSheet() 
	  { 
		  tss.fillWeeklyTimeSheet();
	      tss.clickOnTimeSheetSubmit();
	      WebElement currentElement=  driver.switchTo().activeElement();
	      System.out.println("element is "+currentElement);
	      tss.enterCommentMessage("filling timesheet");
	      tss.cancelCommentMessage();
	  }
	 	}
/*	
@Test(priority=3)
public void checkpendingtimesheet() 
{ 
	SubmitPendingTimesheet spt=new SubmitPendingTimesheet(driver);
	 spt.clickOnPendingDropDown();
		
		String[] split = spt.getpending().get(1).split("\n");
		
		 System.out.println(split[0]);
		 List<String> list =spt.getpending();
		 //System.out.println(list.get(1));
	
		// System.out.print("Print Substring " +list.get(1).substring());//list.get(1).indexOf("\n")));
		 WebElement date= driver.findElement(By.xpath("//*[text()='4 Feb - 10 Feb, 2019']"));
		 date.click();
		 spt.clickOnPendingDropDown();
	 
	 }
}*/
	 


