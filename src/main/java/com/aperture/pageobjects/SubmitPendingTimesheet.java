package com.aperture.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aperture.utilities.Waits;

public class SubmitPendingTimesheet {
	
	WebDriver ldriver;
	Waits wait;

	public SubmitPendingTimesheet(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		System.out.println("refrence contain :" + wait);
	}

	@FindBy(xpath="//*[@id=\'weeklyPending\']")
	@CacheLookup
	WebElement pendingdropdown;
	
	//@FindBy(xpath = "//*[@id='navbarResponsive']//a[contains(text(), 'My Timesheet')]/@href")
	@FindBy(xpath="//*[@class=\"pendingDropdown-layout\"]/tbody/tr")
	@CacheLookup
	List<WebElement> pendingrows; ;

	@FindBy(id = "main-heading")
	@CacheLookup
	WebElement divpageheading;

	@FindBy(xpath = "//*[@id='weeklyTSRow']/tbody/tr[2]/td[10]/div")
	@CacheLookup
	WebElement checkstatus;

	@FindBy(css = "p.group span:nth-of-type(2)+img")
	@CacheLookup
	WebElement btnnexttimesheet;
	////*[@id='weeklyTSRow']/tbody/tr[2]/td[2]/input
	@FindBy(id="submit-button")
	@CacheLookup
	WebElement btntimesheetsubmit;

	public void clickOnPendingDropDown(){
		
		//WebElement linktimesheet=ldriver.findElement(By.xpath("/html/body/jhi-main/div[2]/div/jhi-home/div/div/div/div/span"));
		wait.waitTillElementToBeClickable(pendingdropdown);
		System.out.println("on timesheet refrence "+pendingdropdown.getText());
		pendingdropdown.click();
		System.out.println("refrence contain :" + wait +" 2");
	}

	public List<String> getpending() {
		 //create an empty list in which the label texts will be stored
	    List<String> labelsList = new ArrayList();
	    //iterate through all the webElements
	    for (WebElement webElement : pendingrows) {
	        //add each webElements label to the labelsList
	        labelsList.add(webElement.getText());
	       
	    }
	    //return all the label texts that are visible in the dropdown
	    return labelsList;
	}



}
