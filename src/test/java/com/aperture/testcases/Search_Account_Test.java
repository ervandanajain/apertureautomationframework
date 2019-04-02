package com.aperture.testcases;

import org.testng.annotations.Test;

import com.aperture.core.BaseClass;

import com.aperture.pageobjects.SearchAccount;

public class Search_Account_Test extends BaseClass {
	SearchAccount searchaccounts;
	NavigationMenu_Test navigation;

	public Search_Account_Test() {
		super();
	}

	@Test(priority = 0)
	public void runlogin() throws Exception {
		System.out.println("Before Test");
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();

		searchaccounts = new SearchAccount(driver);
		navigation = new NavigationMenu_Test();
	}

	@Test(priority = 1)
	public void navigate_To_Account() {

		// System.out.println("Checking to click on Accounts");
		navigation.navigateToAccount();
		;
	}

	@Test(priority = 2)
	public void SearchAccount() {
		String accountname = "Mckenzie";
		searchaccounts.searchAccount(accountname);
		searchaccounts.searchResult(accountname);
	}

}
