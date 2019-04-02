package com.aperture.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class AddAccounts {
	WebDriver ldriver;
	Logger llogger;
	public AddAccounts(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
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
	
	@FindBy(xpath="//div[@role='alert']")
	@CacheLookup
	WebElement alertMessage;
	
	String countryxpath="//div[@id='cdk-overlay-2']/div/mat-option/span[starts-with(text(),'%s')]";
	//String customergroupxpath="//div[@id='cdk-overlay-0']/div/mat-option/span[starts-with(text(),'%s')]";
	String customergroupxpath="//div[@id='cdk-overlay-0']/div/mat-option/span";

	public void clickOnAddAccount()
	{
		wait.waitTillElementToBeClickable(btnAddAccount);
		llogger.info("user clicked on "+btnAddAccount.getText());
		llogger.info("===============================");
		btnAddAccount.click();
	}
	
	
	
	public void enterCustomerGroup(String customergroup)
	{
	//	wait.waitTillElementToBeClickable(divCustomerGroup);
		try {
			llogger.info("entring customer group "+customergroup);
			divCustomerGroup.click();
			List<WebElement> customergrouplist=ldriver.findElements(By.xpath(customergroupxpath));
			for(int i=0;i<customergrouplist.size();i++) {
			if(customergrouplist.get(i).getText().contains(customergroup))
				customergrouplist.get(i).click();
			else {
			txtCustomerGroup.clear();
			txtCustomerGroup.sendKeys(customergroup);
			break;}
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		}
	public void enterCustomerName(String customername)
	{
		wait.waitTillElementToBeClickable(txtCustomerName);
		llogger.info("entering customer name "+customername);
		txtCustomerName.sendKeys(customername);
	}
	
	public void enterCustomerEntity(String customerentity)
	{
		wait.waitTillElementToBeClickable(txtCustomerEntity);
		llogger.info("entering customer entity "+customerentity);
		txtCustomerEntity.sendKeys(customerentity);
	}
	public void enterCustomerReportingManager(String customerReportingManager)
	{
		wait.waitTillElementToBeClickable(txtCustomerReportingManager);
		llogger.info("entering customer reporting manager "+customerReportingManager);
		txtCustomerReportingManager.sendKeys(customerReportingManager);
	}
	
	public void enterAccountManager(String accountManager)
	{
		wait.waitTillElementToBeClickable(divAccountManger);
		llogger.info("entring Account Manager "+accountManager);
		//divAccountManger.click();
		txtAccountManager.clear();
		txtAccountManager.sendKeys(accountManager);
	}
	
	public void enterCountry(String country)
	{
		wait.waitTillElementToBeClickable(divCountry);
		llogger.info("entring country "+country);
		//divCountry.click();
		txtCountry.clear();
		ldriver.findElement(By.xpath(String.format(countryxpath, country))).click();
//		txtCountry.sendKeys(country);
	}
	
	public void enterCustomerEmailId(String customerEmailId)
	{
		wait.waitTillElementToBeClickable(txtCustomerEmailId);
		llogger.info("entering customer email id "+customerEmailId);
		txtCustomerEmailId.sendKeys(customerEmailId);
	}
	
	public void enterContactNumber(String customerContactNumber)
	{
		wait.waitTillElementToBeClickable(txtCustomerContactNumber);
		llogger.info("entering customer number "+customerContactNumber);
		txtCustomerContactNumber.sendKeys(customerContactNumber);
	}
	
	public void checkRadioTimetrack(String valueOfTimeTrack)
	{
		//wait.waitTillElementToBeClickable(radiotimetrack);
		llogger.info("checking timesheet "+valueOfTimeTrack);
		
         int RowCount = radiotimetrack.size();
         for (int i = 0; i < RowCount; i++)
         {
         // Check the check boxes based on index
            if(radiotimetrack.get(i).getText().equals(valueOfTimeTrack));
            radiotimetrack.get(i).click();
            
         }
		
	}
	
	
	public void clickOnCreateAccount()
	{
		//wait.waitTillElementToBeClickable(radiotimetrack);
		llogger.info("creating account ");
		btnCreateAccount.click();
		
	}
	
	public boolean verifyAccountCreation(String value)
	{
		return alertMessage.getText().equals(value);
	}
	
	

}
