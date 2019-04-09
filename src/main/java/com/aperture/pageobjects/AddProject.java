package com.aperture.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aperture.reusablecode.CommonMethods;
import com.aperture.utilities.Waits;

public class AddProject {
	WebDriver ldriver;
	Logger llogger;
	AddProject addproject;
	CommonMethods commonmethods;
	public AddProject(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
		commonmethods=new CommonMethods(ldriver, llogger);
	}
	
	
	
	Waits wait;
	
	
	@FindBy(xpath="//span[@class='mat-button-wrapper'][text()='Add Project ']")
	@CacheLookup
	WebElement btnAddProject;
	
	@FindBy(xpath="//mat-card-header[@class='mat-card-header']")
	@CacheLookup
	WebElement maindiv;
	
	@FindBy(xpath="//*[@class='mat-input-infix mat-form-field-infix']")
	@CacheLookup
	WebElement divaccountcode;
	
	@FindBy(xpath="//input[@formcontrolname='accountCode']")
	@CacheLookup
	WebElement txtAccountCode;
	
	@FindBy(xpath="//input[@formcontrolname='customerProjectId']")
	@CacheLookup
	WebElement txtCustomerProject;
	
	@FindBy(xpath="//input[@formcontrolname='customerManager']")
	@CacheLookup
	WebElement txtCustomerManager;
	
	@FindBy(xpath="//*[@class='mat-input-infix mat-form-field-infix']")
	@CacheLookup
	WebElement divAccountManger;
	
	@FindBy(xpath="//input[@formcontrolname='customerProjectName']")
	@CacheLookup
	WebElement txtCustomerProjectName;
	
	@FindBy(xpath="//input[@formcontrolname='projectName']")
	@CacheLookup
	WebElement txtProjectName;
	
	@FindBy(xpath="//input[@formcontrolname='offshoreManagerCode']")
	@CacheLookup
	WebElement txtOffshoreManager;
	
	@FindBy(xpath="//input[@formcontrolname='onshoreManagerCode']")
	@CacheLookup
	WebElement txtOnshoreManager;
	
	@FindBy(xpath="//input[@formcontrolname='projectTypeCode']")
	@CacheLookup
	WebElement txtProjectTypeCode;
	
	@FindBy(xpath="//*[@class='mat-autocomplete-panel mat-autocomplete-visible ng-star-inserted']")
	@CacheLookup
	WebElement optionsCountry;
	
	@FindBy(xpath="//input[@formcontrolname='country']")
	@CacheLookup
	WebElement txtCountry;
	
	//@FindBy(xpath="mat-select[formcontrolname='practices']")
	@FindBy(xpath="//div[contains(@class,'mat-input-infix')]//mat-select")
	@CacheLookup
	WebElement selectPractices;
	
	@FindBy(xpath="//div[contains(@class,mat-select-content)]//input[@placeholder='search']")
	@CacheLookup
	WebElement txtPracticesSelect;
	
	@FindBy(xpath="//div[contains(@class,mat-select-content)]//mat-option//span")
	@CacheLookup
	List<WebElement> listpractices;
	
	@FindBy(xpath="//div[contains(@class,mat-select-content)]//mat-option//mat-pseudo-checkbox")
	@CacheLookup
	List<WebElement> listcheckpractices;
	
	@FindBy(xpath="//input[@formcontrolname='projectStatusCode']")
	@CacheLookup
	WebElement txtProjectStatus;
	
	@FindBy(xpath="//input[@placeholder='Technologies']")
	@CacheLookup
	WebElement txtProjectTechnologies;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	@CacheLookup
	WebElement txtStartDate;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	@CacheLookup
	WebElement txtEndDate;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper'][text()='Create Project']")
	@CacheLookup
	WebElement btnCreateProject;
	
	@FindBy(xpath="//li[contains(@class,'nav-item active')]")
	WebElement activelink;
	
	String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[starts-with(text(), '%s')]";


	public void clickOnAddProject()
	{
		wait.waitTillElementToBeClickable(btnAddProject);
		llogger.info("user clicked on add account "+btnAddProject.getText());
		btnAddProject.click();
	}
	
	public void clickOnMainDiv()
	{
		wait.waitTillElementToBeClickable(maindiv);
		llogger.info("user clicked  on main div");
		maindiv.click();
	}
	
	public void enterAccountCode(String accountcode)
	{
		commonmethods.selectFromList(accountcode,"Account Code", txtAccountCode);	}
	
	public void enterCustomerProject(String customerproject)
	{
		commonmethods.enterValue(customerproject,"Customer Project ", txtCustomerProject);
	}
	
	public void enterCustomerManager(String customerManager)
	{
		commonmethods.enterValue(customerManager,"Customer Manager ", txtCustomerManager);
	}
	
	public void enterCustomerProjectName(String customerprojectname)
	{
		commonmethods.enterValue(customerprojectname,"Customer Project Name", txtCustomerProjectName);
	}
	
	public void enterProjectName(String projectname)
	{
		commonmethods.enterValue(projectname," Project Name", txtProjectName);
	}
	
	public void enterOnshoreManager(String onshoremanager)
	{
		commonmethods.selectFromList(onshoremanager,"Onshore manager", txtOnshoreManager);	
	}
	
	
	public void enterOffshoreManager(String offshoremanager)
	{
		commonmethods.selectFromList(offshoremanager,"off shore manager", txtOffshoreManager);
	}
	
	
	public void enterProjectType(String projecttype)
	{
		commonmethods.selectFromList(projecttype,"Project Type", txtProjectTypeCode);
	}
	
	
	public void enterCountry(String country)
	{
		commonmethods.selectFromList(country,"country", txtCountry);
	}
	
	public void selectPractices(String[] practicename)
	{
		
		commonmethods.selectFromCheckBoxList(selectPractices,"Practices",practicename,txtPracticesSelect,listpractices);
	}

	
	
	public void enterProjectStatus(String projectstatus)
	{
		commonmethods.selectFromList(projectstatus,"Project Status", txtProjectStatus);
	}
	
	
	public void enterTechnology(String[] projecttechnology)
	{
		commonmethods.enterValues(projecttechnology,"Technology ",txtProjectTechnologies);
	}
	
	public void enterProjectStartDate(String startdate)
	{
		commonmethods.enterValue(startdate,"Start Date ", txtStartDate);
	}
	
	public void enterProjectEndDate(String enddate)
	{
		commonmethods.enterValue(enddate,"End Date ", txtEndDate);
	}
	
	
	
	public void clickOnCreateProject()
	{
		wait.waitTillElementToBeClickable(btnCreateProject);
		btnCreateProject.click();
		llogger.info("user clicked  on creating project "+btnCreateProject.getText());
		
	}

}
