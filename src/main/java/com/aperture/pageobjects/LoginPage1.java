package com.aperture.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aperture.utilities.Waits;

public class LoginPage1{
	
	WebDriver ldriver;
	Logger llogger;
	Waits wait;

	public LoginPage1(WebDriver rdriver,Logger rlogger) {
		ldriver=rdriver;
		llogger=rlogger;
		PageFactory.initElements(ldriver, this);
		 wait=new Waits(ldriver,3000);
		 System.out.println(" on login refrence contain :" + wait);
	}
	
	@FindBy(xpath="//*[@name='loginfmt']")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(id="idSIButton9")
	@CacheLookup
	WebElement btnusernext;
	
	@FindBy(id="displayName")
	@CacheLookup
	WebElement textdisplay;
	
	@FindBy(id="i0118")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(id="idSIButton9")
	@CacheLookup
	WebElement btnsignin;
	
	@FindBy(id="idBtn_Back")
	@CacheLookup
	WebElement btnNo;
	
	
  	public void setUsername(String username)
	{
		wait.waitTillVisibilityOf(txtusername);
		llogger.debug("User Entered UserName");
		txtusername.sendKeys(username);
	}
	
	public void clickOnNext()
	{
		wait.waitTillElementToBeClickable(btnusernext);
		llogger.debug("User clicked on Next");
		btnusernext.click();
	}
	
	public boolean checkuser(String username) {
		wait.waitTillVisibilityOf(textdisplay);
		if(textdisplay.getText().equals(username))
			return true;
		else return false;
	}
	
	public void setPassword(String password)
	{
		wait.waitTillVisibilityOf( txtpassword);
		llogger.debug("User Entered Password");
		txtpassword.sendKeys(password);
	}
	
	public void clickOnSignin()
	{
		wait.waitTillElementToBeClickable( btnsignin);
		llogger.debug("User Clicked on SignIn");
		btnsignin.click();
	}
	
	public void clickOnDontSave()
	{
		wait.waitTillElementToBeClickable( btnNo);
		llogger.debug("User Clicked on No");
		btnNo.click();
	}
}
