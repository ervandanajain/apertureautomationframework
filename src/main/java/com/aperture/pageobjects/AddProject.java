package com.aperture.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class AddProject {
	WebDriver ldriver;
	AddProject addproject;
	public AddProject(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		System.out.println("refrence contain :" + wait);
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
	
	
	String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[starts-with(text(), '%s')]";


	public void clickOnAddProject()
	{
		wait.waitTillElementToBeClickable(btnAddProject);
		System.out.println("on add account  refrence "+btnAddProject.getText());
		btnAddProject.click();
	}
	
	public void clickOnMainDiv()
	{
		wait.waitTillElementToBeClickable(maindiv);
		System.out.println("clicking on main div");
		maindiv.click();
	}
	
	public void enterAccountCode(String accountcode)
	{
		wait.waitTillElementToBeClickable(txtAccountCode);
		System.out.println("entring account code  ");
		txtAccountCode.clear();
		txtAccountCode.sendKeys(accountcode);
		ldriver.findElement(By.xpath(String.format(commonXpath," " +accountcode))).click();
		}
	
	public void enterCustomerProject(String customerproject)
	{
		wait.waitTillElementToBeClickable(txtCustomerProject);
		System.out.println("entering customer name ");
		txtCustomerProject.sendKeys(customerproject);
	}
	
	public void enterCustomerManager(String customerManager)
	{
		wait.waitTillElementToBeClickable(txtCustomerManager);
		System.out.println("entering customer  manager ");
		txtCustomerManager.sendKeys(customerManager);
	}
	
	public void enterCustomerProjectName(String customerprojectname)
	{
		wait.waitTillElementToBeClickable(txtCustomerProjectName);
		System.out.println("entring Customer Project Name ");
		txtCustomerProjectName.clear();
		txtCustomerProjectName.sendKeys(customerprojectname);
	}
	
	public void enterProjectName(String projectname)
	{
		wait.waitTillElementToBeClickable(txtProjectName);
		System.out.println("entring Project Name ");
		txtProjectName.clear();
		txtProjectName.sendKeys(projectname);
	}
	
	public void enterOnshoreManager(String onshoremanager)
	{
		wait.waitTillElementToBeClickable(txtOnshoreManager);
		System.out.println("entring onshoremanager manager ");
		txtOnshoreManager.clear();
		txtOnshoreManager.sendKeys(onshoremanager);
		ldriver.findElement(By.xpath(String.format(commonXpath, onshoremanager))).click();
		
	}
	
	
	public void enterOffshoreManager(String offshoremanager)
	{
		wait.waitTillElementToBeClickable(txtOffshoreManager);
		System.out.println("entring offshore manager ");
		txtOffshoreManager.clear();
		txtOffshoreManager.sendKeys(offshoremanager);
		ldriver.findElement(By.xpath(String.format(commonXpath, offshoremanager))).click();
		
	}
	
	
	public void enterProjectType(String projecttype)
	{
		wait.waitTillElementToBeClickable(txtProjectTypeCode);
		System.out.println("entring project type ");
		txtProjectTypeCode.clear();
		txtProjectTypeCode.sendKeys(projecttype);
		ldriver.findElement(By.xpath(String.format(commonXpath," " +  projecttype))).click();
		
	}
	
	
	public void enterCountry(String country)
	{
		wait.waitTillElementToBeClickable(txtCountry);
		System.out.println("entring country ");
		txtCountry.clear();
		txtCountry.sendKeys(country);
		ldriver.findElement(By.xpath(String.format(commonXpath," " + country))).click();
		
	}
	
	public void selectPractices()
	{
		wait.waitTillElementToBeClickable(selectPractices);
		System.out.println("selecting Practices ");
		selectPractices.click();
		
		
	}
	
	public void enterPractices(String[] practicename)
	{
		addproject=new AddProject(ldriver);
		wait.waitTillElementToBeClickable(txtCustomerManager);
		System.out.println("entering practice in searchbox ");
		for(int j=0;j<practicename.length;j++) {
			txtPracticesSelect.clear();
		txtPracticesSelect.sendKeys(practicename[j]);
		addproject.selectPractice(practicename[j]);
		}
	}
	
	public  void selectPractice(String practicename)
	{
		for(int i=0;i<=listpractices.size()+1;i++) {
			
			//System.out.println("At row num "+i+"->"+listpractices.get(i).getText());
			if(listpractices.get(i).getText().trim().equals(practicename)) {
				System.out.println("Printing elements in array "+ practicename);
				System.out.println(listpractices.get(i).getText().trim());
				listpractices.get(i).click();
				break;
			}
		}
	}
	
	
	public void enterProjectStatus(String projectstatus)
	{
		wait.waitTillElementToBeClickable(txtProjectStatus);
		System.out.println("entring project status ");
		txtProjectStatus.clear();
		txtProjectStatus.sendKeys(projectstatus);
		ldriver.findElement(By.xpath(String.format(commonXpath," " +  projectstatus))).click();
		
	}
	
	
	public void enterTechnology(String[] projecttechnology)
	{
		wait.waitTillElementToBeClickable(txtProjectTechnologies);
		System.out.println("entring project technology ");
		for(int i=0;i<projecttechnology.length;i++) {
		txtProjectTechnologies.clear();
		txtProjectTechnologies.sendKeys(projecttechnology[i]+" ,");
		ldriver.findElement(By.xpath(String.format(commonXpath," " +  projecttechnology[i]))).click();
//		txtCountry.sendKeys(country);
	}
	}
	
	public void enterProjectStartDate(String startdate)
	{
		wait.waitTillElementToBeClickable(txtStartDate);
		System.out.println("entering start date");
		txtStartDate.sendKeys(startdate);
	}
	
	public void enterProjectEndDate(String enddate)
	{
		wait.waitTillElementToBeClickable(txtEndDate);
		System.out.println("entering project enddate ");
		txtEndDate.sendKeys(enddate);
	}
	
	
	
	public void clickOnCreateProject()
	{
		//wait.waitTillElementToBeClickable(radiotimetrack);
		System.out.println("creating account ");
		btnCreateProject.click();
		
	}

}
