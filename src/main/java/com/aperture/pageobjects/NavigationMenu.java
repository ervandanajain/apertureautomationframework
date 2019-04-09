package com.aperture.pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;
public class NavigationMenu {
	WebDriver ldriver;
	Waits wait;
	Logger llogger;
	public NavigationMenu(WebDriver rdriver,Logger rlogger) {
		ldriver = rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
	}
	@FindBy(xpath="//*[@id=\'account-menu\']//*[text()='Timesheet']")
	@CacheLookup
	WebElement linktimesheet;
	//@FindBy(xpath = "//*[@id='navbarResponsive']//a[contains(text(), 'My Timesheet')]/@href")
	@FindBy(xpath="//*[@id='navbarResponsive']/ul/li[1]/ul/li[1]/a")
	@CacheLookup
	WebElement linkmytimesheet;
	//*[@id='navbarResponsive']//*[text()='Account']
	@FindBy(xpath="//a[@routerlink='/listaccounts']//*[text()='Account']")
	@CacheLookup
	WebElement linkaccount;
	@FindBy(xpath="//a[@routerlink='/projects/list-projects']//*[text()='Project']")
	@CacheLookup
	WebElement linkProject;
	@FindBy(xpath="//a[@routerlink='/resource/search-resource']//*[text()='Resource']")
	@CacheLookup
	WebElement linkResource;
	
	public void clickOnTimeSheet(){
		//WebElement linktimesheet=ldriver.findElement(By.xpath("/html/body/jhi-main/div[2]/div/jhi-home/div/div/div/div/span"));
		wait.waitTillElementToBeClickable(linktimesheet);
		llogger.info("on timesheet refrence "+linktimesheet.getText());
		linktimesheet.click();
		llogger.info("refrence contain :" + wait +" 2");
	}
	public void clickOnMyTimeSheet() {
		llogger.info("we are on mytimesheet page");
		llogger.info("mytimesheet page link is "+ linkmytimesheet);
		wait.waitTillElementToBeClickable(linkmytimesheet);
		llogger.info("on my timesheet refrence "+linkmytimesheet.getText());
		linkmytimesheet.click();
	}
	public void clickOnAccounts() {
		llogger.info("we are on Accounts page");
		llogger.info("account page link is "+ linkaccount);
		wait.waitTillElementToBeClickable(linkaccount);
		llogger.info("on my project refrence "+linkaccount.getText());
		linkaccount.click();
	}
	public void clickOnProject() {
		llogger.info("we are on project page");
		llogger.info("project page link is "+ linkProject);
		wait.waitTillElementToBeClickable(linkProject);
		llogger.info("on project refrence "+linkProject.getText());
		linkProject.click();
	}
	public void clickOnResource() {
		llogger.info("we are on resource page");
		llogger.info("resource page link is "+ linkResource);
		wait.waitTillElementToBeClickable(linkResource);
		llogger.info("on resource refrence "+linkResource.getText());
		linkResource.click();
	}
}
