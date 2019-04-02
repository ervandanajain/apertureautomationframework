package com.aperture.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class SearchResource{
	
	WebDriver ldriver;
	Waits wait;

	public SearchResource(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		 wait=new Waits(ldriver,3000);
		 System.out.println(" on login refrence contain :" + wait);
	}
	
	@FindBy(xpath="//input[@placeholder='Search Resource (eg. type resource id, resource name, email-id, technology etc.)']")
	@CacheLookup
	WebElement txtsearchresource;
	
	
	
	String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[starts-with(text(), '%s')]";


	
	
  	public void searchResource(String resourcename)
	{
		wait.waitTillVisibilityOf(txtsearchresource);
		txtsearchresource.sendKeys(resourcename);
		ldriver.findElement(By.xpath(String.format(commonXpath, resourcename))).click();
	}
	
	
	
	
}
