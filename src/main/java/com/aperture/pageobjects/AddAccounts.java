package com.aperture.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aperture.reusablecode.CommonMethods;
import com.aperture.utilities.Waits;

public class AddAccounts {
	WebDriver ldriver;
	Logger llogger;
	CommonMethods commonmethods;
	public AddAccounts(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
		commonmethods=new CommonMethods(ldriver,llogger);
	}
	
	
	
	Waits wait;
	
	
	@FindBy(xpath="//span[@class='mat-button-wrapper'][text()='Add Account ']")
	@CacheLookup
	WebElement btnAddAccount;
	
	@FindBy(xpath="//*[@class='mat-input-infix mat-form-field-infix']")
	@CacheLookup
	WebElement divCustomerGroup;
	
	@FindBy(xpath="//input[@formcontrolname='customerGroup']")
	@CacheLookup
	WebElement txtCustomerGroup;
	
	@FindBy(xpath="//input[@formcontrolname='customerName']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(xpath="//input[@formcontrolname='customerEntity']")
	@CacheLookup
	WebElement txtCustomerEntity;
	
	
	@FindBy(xpath="//input[@formcontrolname='customerReportingManager']")
	@CacheLookup
	WebElement txtCustomerReportingManager;
	
	@FindBy(xpath="//*[@class='mat-input-infix mat-form-field-infix']")
	@CacheLookup
	WebElement divAccountManger;
	
	@FindBy(xpath="//input[@formcontrolname='accountManager']")
	@CacheLookup
	WebElement txtAccountManager;
	
	@FindBy(xpath="//*[@class='mat-autocomplete-panel mat-autocomplete-visible ng-star-inserted']")
	@CacheLookup
	WebElement optionsCountry;
	
	@FindBy(xpath="//*[@class='mat-input-infix mat-form-field-infix']")
	@CacheLookup
	WebElement divCountry;
	
	@FindBy(xpath="//input[@formcontrolname='country']")
	@CacheLookup
	WebElement txtCountry;
	
	@FindBy(xpath="//input[@formcontrolname='customerEmailId']")
	@CacheLookup
	WebElement txtCustomerEmailId;
	
	@FindBy(xpath="//input[@formcontrolname='customerContactNumber']")
	@CacheLookup
	WebElement txtCustomerContactNumber;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper'][text()='Create Account']")
	@CacheLookup
	WebElement btnCreateAccount;
	
	
	//@FindBy(xpath="//mat-radio-button[contains(@class,'mat-radio-button mat-accent')]")
	@FindBy(xpath="//mat-radio-group[contains(@class,'mat-radio-group')]/mat-radio-button")
	@CacheLookup
	List<WebElement> radiotimetrack;
	
	public void clickOnAddAccount()
	{
		commonmethods.clickOnButton("Add Account ", btnAddAccount);
	}
	
	
	
	public void enterCustomerGroup(String customergroup)
	{
		commonmethods.selectFromList(customergroup,"account code", txtCustomerGroup);
		}
	public void enterCustomerName(String customername)
	{
		commonmethods.enterValue(customername," Customer Name ", txtCustomerName);
	}
	
	public void enterCustomerEntity(String customerentity)
	{
		commonmethods.enterValue(customerentity," Customer Entity ", txtCustomerEntity);
	}
	public void enterCustomerReportingManager(String customerReportingManager)
	{
		commonmethods.enterValue(customerReportingManager," Reporting Manager ", txtCustomerReportingManager);
	}
	
	public void enterAccountManager(String accountManager)
	{
		commonmethods.enterValue(accountManager," Account Manager ", txtAccountManager);
		
	}
	
	public void enterCountry(String country)
	{
		commonmethods.selectFromList(country,"country", txtCountry);

	}
	
	public void enterCustomerEmailId(String customerEmailId)
	{
		commonmethods.enterValue(customerEmailId,"Email ID", txtCustomerEmailId);
	}
	
	public void enterContactNumber(String customerContactNumber )
	{
		commonmethods.enterValue(customerContactNumber," Contact Number ", txtCustomerContactNumber);
	}
	
	public void checkRadioTimetrack(String valueOfTimeTrack)
	{
		commonmethods.checkRadio(valueOfTimeTrack, "TimeTrck", radiotimetrack);
	}
	
	
	public void clickOnCreateAccount()
	{
		commonmethods.clickOnButton("Create Account ", btnCreateAccount);
		
	}
	
	
	
	

}
