package com.aperture.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aperture.reusablecode.CommonMethods;
import com.aperture.utilities.Waits;

public class SearchAccount {

	WebDriver ldriver;
	Waits wait;
	Logger llogger;

	public SearchAccount(WebDriver rdriver, Logger rlogger) {
		ldriver = rdriver;
		llogger = rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 3000);
		System.out.println(" on login refrence contain :" + wait);
	}

	@FindBy(xpath = "//input[@placeholder='Search account (type customer name, account code, etc...)']")
	@CacheLookup
	WebElement txtsearchaccount;

	@FindBy(xpath = "//mat-table//mat-row")
	@CacheLookup
	List<WebElement> listaccount;

	@FindBy(xpath = "//mat-table//mat-row//mat-cell//a")
	@CacheLookup
	List<WebElement> listaccountcode;

	public void searchAccount(String accountname) {
		wait.waitTillVisibilityOf(txtsearchaccount);
		llogger.info("user searching for project " + accountname);
		txtsearchaccount.sendKeys(accountname);
	}

	public String searchResult(String accountname) {
		return CommonMethods.searchResult(listaccount, listaccountcode, accountname);
	}

}
