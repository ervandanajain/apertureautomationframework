package com.aperture.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class SearchAccount{
	
	WebDriver ldriver;
	Waits wait;

	public SearchAccount(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		 wait=new Waits(ldriver,3000);
		 System.out.println(" on login refrence contain :" + wait);
	}
	
	@FindBy(xpath="//input[@placeholder='Search account (type customer name, account code, etc...)']")
	@CacheLookup
	WebElement txtsearchaccount;
	
	@FindBy(xpath="//mat-table//mat-row")
	@CacheLookup
	List<WebElement> listaccount;
	
	@FindBy(xpath="//mat-table//mat-row//mat-cell//a")
	@CacheLookup
	List<WebElement> listaccountcode;
	

	
	
  	public void searchAccount(String accountname)
	{
		wait.waitTillVisibilityOf(txtsearchaccount);
		txtsearchaccount.sendKeys(accountname);
	}
	
	public void searchResult(String accountname)
	{
		for(int i=0;i<=listaccount.size();i++) {
			System.out.println("At row num "+i+"->"+listaccount.get(i).getText());
			if(listaccount.get(i).getText().contains(accountname)) {
				System.out.println(listaccountcode.get(i).getText());
			listaccountcode.get(i).click();}
			
		}
	}
	
	
}
