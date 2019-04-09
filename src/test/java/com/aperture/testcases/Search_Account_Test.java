package com.aperture.testcases;

import org.testng.annotations.Test;

import com.aperture.core.BaseClass;
import com.aperture.pageobjects.SearchAccount;
import com.aperture.reusablecode.AssertTest;

public class Search_Account_Test extends BaseClass {
	SearchAccount searchaccounts;
	NavigationMenu_Test navigation;
	AssertTest asserttest;

	public Search_Account_Test() {
		super();
	}

	@Test(priority = 0)
	public void runlogin() throws Exception {
		System.out.println("Before Test");
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();

		searchaccounts = new SearchAccount(driver,logger);
		navigation = new NavigationMenu_Test();
		asserttest=new AssertTest(driver, logger);
	}

	@Test(priority = 1)
	public void navigate_To_Account() {

		// System.out.println("Checking to click on Accounts");
		navigation.navigateToAccount();
		asserttest.assertTitle("Account");
	}

	@Test(priority = 2)
	public void SearchAccount() {
		String accountname = "Mckenzie";
		searchaccounts.searchAccount(accountname);
		
		String linktext=searchaccounts.searchResult(accountname);
		asserttest.assertURL(linktext);
	}

}
