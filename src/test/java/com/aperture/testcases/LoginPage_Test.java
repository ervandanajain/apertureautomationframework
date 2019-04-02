package com.aperture.testcases;


import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;

import com.aperture.core.BaseClass;
import com.aperture.pageobjects.LoginPage1;

public class LoginPage_Test extends BaseClass {
	public LoginPage_Test() throws IOException {
		super();
	}

	// @Test(groups= {"login"})
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage1 lp1 = new LoginPage1(driver, logger);
		lp1.setUsername(username);
		logger.info("entered username");
		lp1.clickOnNext();
		logger.info("clicked on next");
		if (lp1.checkuser(username)) {
			lp1.setPassword(password);
			logger.info("entered password");
			lp1.clickOnSignin();
			logger.info("click on signin");
			lp1.clickOnDontSave();
			// Assert.assertEquals(driver.findElement(By.id("displayName")).getText(),username);
			Assert.assertEquals(driver.getTitle(), "aperture");
		}
	}
}
