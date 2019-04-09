package com.aperture.reusablecode;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aperture.core.BaseClass;
import com.aperture.utilities.Waits;

public class AssertTest extends BaseClass{
	 
	 Waits wait;
	 String actualvalue;
	WebDriver ldriver;
	Logger llogger;
	SoftAssert softassert;
	public AssertTest(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		softassert=new SoftAssert();
	}
	@FindBy(xpath="//li[contains(@class,'nav-item active')]")
		WebElement activelink;
	
	@FindBy(xpath="//mat-form-field[contains(@class,'ng-invalid')and contains(@class,'mat-focused')]")
	List<WebElement> invalidclass;
	
	@FindBy(xpath="//mat-form-field[contains(@class,'ng-valid')and contains(@class,'mat-focused')]")
	List<WebElement> validclass;
	
	@FindBy(xpath="//mat-error[@role='alert']")
	List<WebElement> alertmessage;

	 String pagetitle="//h4[text()='%s']";
	public  void  assertURL(String keyword) {
		//driver.wait(5,TimeUnit.SECONDS);
		System.out.println("Current url  -"+driver.getCurrentUrl());
		actualvalue=ldriver.getCurrentUrl();
		 System.out.println("Assert actual value "+actualvalue);
		 System.out.println("Keyword to be tested is "+keyword);
		 boolean check=actualvalue.contains(keyword);
		 Assert.assertEquals(check, true);
	}
	public  void assertTitle(String title) {
		System.out.println("Aserting title");
		wait.waitTillVisibilityOf(activelink);
		actualvalue=activelink.getText();
		System.out.println("Active link text is "+actualvalue);
		Assert.assertEquals(actualvalue.trim().equalsIgnoreCase(title.trim()),true );
	}
	
	public  void assertValidValue(String fieldname) {
		System.out.println("Aserting value of "+fieldname);
		//wait.waitTillVisibilityOf(invaliclass);
		if(validclass.size()>0) {
		softassert.assertTrue(true);
		}
		else softassert.fail(fieldname+" Failed");
	//	Assert.assertEquals(actualvalue.trim().equalsIgnoreCase(title.trim()),true );
	}
	
	public  void assertInvalidValue(String fieldname) {
		System.out.println("Aserting value of "+fieldname);
		//wait.waitTillVisibilityOf(invaliclass);
		if(invalidclass.size()>0) {
			//if(alertmessage.size()>0)
				for (int i = 0; i < alertmessage.size(); i++) 
					actualvalue=alertmessage.get(i).getText();
		System.out.println("Error: "+actualvalue);
		softassert.assertTrue(true, "Passed "+fieldname+ " with error message  "+actualvalue);
		}
		else Assert.fail(fieldname+" Passed");
	//	Assert.assertEquals(actualvalue.trim().equalsIgnoreCase(title.trim()),true );
	}
	


}
