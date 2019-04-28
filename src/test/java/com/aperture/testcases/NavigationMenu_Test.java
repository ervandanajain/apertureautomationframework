package com.aperture.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.aperture.core.BaseClass;
import com.aperture.pageobjects.NavigationMenu;

public class NavigationMenu_Test extends BaseClass {
	NavigationMenu nm;

	// LoginPage1 lp1;
	public NavigationMenu_Test() throws IOException {
		super();
	}

	@Test
	public void navigateToTimesheet() {
		nm = new NavigationMenu(driver,logger);
		nm.clickOnTimeSheet();
		//nm.clickOnMyTimeSheet();
	}
	
	@Test
	public void navigateToMyTimesheet() {
		nm =new NavigationMenu(driver,logger);
		nm.clickOnMyTimeSheet();
	}

	@Test
	public void navigateToAccount() {
		nm =new NavigationMenu(driver,logger);
		nm.clickOnAccounts();
		logger.info("clicked on Accounts");
	}

	@Test
	public void navigateToProject() {
		nm =new NavigationMenu(driver,logger);
		nm.clickOnProject();
		logger.info("clicked on Project");
	}

	@Test
	public void navigateToResource() {
		nm =new NavigationMenu(driver,logger);
		nm.clickOnResource();
		logger.info("clicked on Resource");
	}
}
