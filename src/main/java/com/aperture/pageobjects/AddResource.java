package com.aperture.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class AddResource {
	WebDriver ldriver;
	Logger llogger;
	AddResource addproject;

	public AddResource(WebDriver rdriver, Logger rlogger) {
		ldriver = rdriver;
		llogger = rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
	}

	Waits wait;

	// @FindBy(xpath="//mat-card-header[@class='mat-card-header']")
	// @CacheLookup
	// WebElement maindiv;

	@FindBy(xpath = "//button[contains(@class,'add-resource-btn')]")
	@CacheLookup
	WebElement btnAddResource;

	@FindBy(xpath = "//input[@formcontrolname='resourceName']")
	@CacheLookup
	WebElement txtName;

	@FindBy(xpath = "//mat-radio-group[contains(@class,'mat-radio-group')]/mat-radio-button")
	@CacheLookup
	List<WebElement> radioGender;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	@CacheLookup
	WebElement txtCompanyName;

	@FindBy(xpath = "//input[@formcontrolname='department']")
	@CacheLookup
	WebElement txtDepartment;

	@FindBy(xpath = "//input[@formcontrolname='designation']")
	@CacheLookup
	WebElement txtDesignation;

	@FindBy(xpath = "//*[@class='mat-autocomplete-panel mat-autocomplete-visible ng-star-inserted']")
	@CacheLookup
	WebElement optionsBaseLocation;

	@FindBy(xpath = "//input[@formcontrolname='baseLocation']")
	@CacheLookup
	WebElement txtBaseLocation;

	// @FindBy(xpath="//div[contains(@class,'mat-select-content')]")
	@FindBy(xpath = "//mat-select[@placeholder='Practices']")
	@CacheLookup
	WebElement selectPractices;

	@FindBy(xpath = "//div[contains(@class,mat-select)]//input[@placeholder='search']")
	@CacheLookup
	WebElement txtPracticesSelect;

	@FindBy(xpath = "//div[contains(@class,mat-select-content)]//mat-option//span")
	@CacheLookup
	List<WebElement> listpractices;

	@FindBy(xpath = "//input[@placeholder='Primary Skills']")
	@CacheLookup
	WebElement txtResourcePSkills;

	@FindBy(xpath = "//input[@placeholder='Secondary Skills']")
	@CacheLookup
	WebElement txtResourceSSkills;

	@FindBy(xpath = "//input[@formcontrolname='joiningDate']")
	@CacheLookup
	WebElement txtJoiningDate;

	// @FindBy(xpath="//input[@type='file']/following-sibling::span[contains(text(),'Select
	// Profile Picture')]")
	@FindBy(xpath = "//input[@type='file' ][contains(@accept,'.png')]")
	@CacheLookup
	WebElement selectprofilepicture;

	@FindBy(xpath = "//button[text()='Edit']")
	@CacheLookup
	WebElement btneditimage;

	@FindBy(xpath = "//div[contains(@class,'cropper')]")
	@CacheLookup
	WebElement divCropper;

	@FindBy(xpath = "//button[text()='Save']")
	@CacheLookup
	WebElement btnsaveimage;

	@FindBy(xpath = "//input[@type='file'][contains(@accept,'.doc')]")
	@CacheLookup
	WebElement selectresume;

	@FindBy(xpath = "//span[@class='mat-button-wrapper'][text()='Save & Next']")
	@CacheLookup
	WebElement btnSaveResource;

	@FindBy(xpath = "//mat-radio-group[@formcontrolname='employeeType']")
	@CacheLookup
	List<WebElement> radioEmployeeType;

	String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[starts-with(text(), '%s')]";
	String commonxpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[contains(text(), '%s')][1]";

	public void clickOnAddResource() {
		wait.waitTillElementToBeClickable(btnAddResource);
		llogger.info("user clicked on add resource  " + btnAddResource.getText());
		btnAddResource.click();
	}

	/*
	 * public void clickOnMainDiv() { wait.waitTillElementToBeClickable(maindiv);
	 * llogger.info("clicking on main div"); maindiv.click(); }
	 */
	public void enterName(String name) {
		wait.waitTillVisibilityOf(txtName);
		llogger.info("user entered name  " + name);
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void checkRadioGender(String valueOfGender) {
		// wait.waitTillElementToBeClickable(radioGender);
		llogger.info("user checked gender radio button " + valueOfGender);

		int RowCount = radioGender.size();
		for (int i = 0; i < RowCount; i++) {
			if (radioGender.get(i).getText().contentEquals(valueOfGender))
				radioGender.get(i).click();

		}

	}

	public void enterCompanyName(String companyname) {
		wait.waitTillElementToBeClickable(txtCompanyName);
		llogger.info("user entered Company Name " + companyname);
		txtCompanyName.click();
		txtCompanyName.clear();
		txtCompanyName.sendKeys(companyname);
		ldriver.findElement(By.xpath(String.format(commonXpath, " " + companyname + " "))).click();
	}

	public void enterDepartment(String department) {
		wait.waitTillElementToBeClickable(txtDepartment);
		llogger.info("user entered  Department Name " + department);
		txtDepartment.click();
		txtDepartment.clear();
		txtDepartment.sendKeys(department);
		ldriver.findElement(By.xpath(String.format(commonXpath, " " + department + " "))).click();
	}

	public void enterDesignation(String designation) {
		wait.waitTillElementToBeClickable(txtDesignation);
		llogger.info("user entered  designation of resource " + designation);
		txtDesignation.click();
		txtDesignation.clear();
		txtDesignation.sendKeys(designation);
		ldriver.findElement(By.xpath(String.format(commonXpath, " " + designation + " "))).click();

	}

	public void enterBaseLocation(String baseLocation) {
		wait.waitTillElementToBeClickable(txtBaseLocation);
		llogger.info("user entered  baseLocation " + baseLocation);
		txtBaseLocation.clear();
		txtBaseLocation.sendKeys(baseLocation);
		ldriver.findElement(By.xpath(String.format(commonXpath, " " + baseLocation))).click();

	}

	public void enterJoiningDate(String joiningdate) {
		wait.waitTillElementToBeClickable(txtJoiningDate);
		llogger.info("user entered  joining date " + joiningdate);
		txtJoiningDate.sendKeys(joiningdate);
	}

	public void selectPractices() {
		wait.waitTillElementToBeClickable(selectPractices);
		llogger.info("user selecting Practices ");
		selectPractices.click();

	}

	public void enterPractices(String[] practicename) {
		addproject = new AddResource(ldriver, llogger);
		wait.waitTillElementToBeClickable(txtPracticesSelect);
		llogger.info("user entered practice in searchbox ");
		for (int j = 0; j < practicename.length; j++) {
			txtPracticesSelect.clear();
			txtPracticesSelect.sendKeys(practicename[j]);
			addproject.selectPractice(practicename[j]);
		}
	}

	public void selectPractice(String practicename) {
		for (int i = 0; i <= listpractices.size() + 1; i++) {

			// llogger.info("At row num "+i+"->"+listpractices.get(i).getText());
			if (listpractices.get(i).getText().trim().equals(practicename)) {
				llogger.info("Printing elements in array " + practicename);
				llogger.info("user entering practice"+listpractices.get(i).getText().trim());
				listpractices.get(i).click();
				break;
			}
		}
	}

	public void enterPSkills(String[] pskills) {
		wait.waitTillElementToBeClickable(txtResourcePSkills);
		for (int i = 0; i < pskills.length; i++) {
			llogger.info("user entered primary skills " + pskills[i]);
			txtResourcePSkills.clear();
			txtResourcePSkills.sendKeys(pskills[i].substring(0, 1));
			ldriver.findElement(By.xpath(String.format(commonxpath, " " + pskills[i] + " "))).click();

		}
	}

	public void enterSSkills(String[] sskills) {
		wait.waitTillElementToBeClickable(txtResourceSSkills);
		llogger.info("user entered secondary skills ");
		for (int i = 0; i < sskills.length; i++) {
			llogger.info("user entered secondary skills " + sskills[i]);
			txtResourceSSkills.clear();
			txtResourceSSkills.sendKeys(sskills[i].substring(0, 1));
			ldriver.findElement(By.xpath(String.format(commonxpath, " " + sskills[i] + " "))).click();

		}
	}

	public void selectProfilePicture(String path) {
		llogger.info("user selecting profile picture from " + path);
		selectprofilepicture.sendKeys(path);
	}

	public void editProfilePicture() {
		llogger.info("user clicked on edit image");
		btneditimage.click();
	}

	public void cropProfilePicture() {

		ldriver.switchTo().activeElement();
		llogger.info("user croping profile picture");
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript(
				"arguments[0].setAttribute('style', 'top: 2px; left: 122px; width: 193px; height: 193px; margin-left: calc(50% - 228px); visibility: visible;')",
				divCropper);
		btnsaveimage.click();

	}

	public void selectResume(String path) {
		llogger.info("user selecting resume from " + path);
		selectresume.sendKeys(path);
	}

	public void clickOnCreateResource() {
		// wait.waitTillElementToBeClickable(radiotimetrack);
		llogger.info("user clicked on create resource " + btnSaveResource);
		btnSaveResource.click();

	}

	public void checkEmployeeType(String valueOfEmployee) {
		llogger.info("user checked employee type radio button " + valueOfEmployee);

		int RowCount = radioEmployeeType.size();
		for (int i = 0; i < RowCount; i++) {
			// Check the check boxes based on index
			llogger.info(radioEmployeeType.get(i).getText());
			System.out.println(
					"value of employee type" + radioEmployeeType.get(i).getText().contentEquals(valueOfEmployee));
			if (radioEmployeeType.get(i).getText().contentEquals(valueOfEmployee)) {
				radioEmployeeType.get(i).click();
				break;
			}

		}
	}

}
