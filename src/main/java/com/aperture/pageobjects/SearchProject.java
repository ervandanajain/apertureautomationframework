package com.aperture.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class SearchProject{
	
	WebDriver ldriver;
	Waits wait;

	public SearchProject(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		 wait=new Waits(ldriver,3000);
		 System.out.println(" on login refrence contain :" + wait);
	}
	
	@FindBy(xpath="//input[@placeholder='Search project (type project name, project id, account name, etc...)']")
	@CacheLookup
	WebElement txtsearchproject;
	
	@FindBy(xpath="//mat-table//mat-row")
	@CacheLookup
	List<WebElement> listproject;
	
	@FindBy(xpath="//mat-table//mat-row//mat-cell//a")
	@CacheLookup
	List<WebElement> listprojectcode;
	

	
	
  	public void searchProject(String projectname)
	{
		wait.waitTillVisibilityOf(txtsearchproject);
		txtsearchproject.sendKeys(projectname);
	}
	
	public void searchResult(String projectname)
	{
		for(int i=0;i<=listproject.size();i++) {
			System.out.println("At row num "+i+"->"+listproject.get(i).getText());
			if(listproject.get(i).getText().contains(projectname)) {
				System.out.println(listprojectcode.get(i).getText());
			listprojectcode.get(i).click();}
			
		}
	}
	
	
}
