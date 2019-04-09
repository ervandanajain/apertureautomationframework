package com.aperture.testcases;

import org.testng.annotations.Test;

import com.aperture.core.BaseClass;
import com.aperture.pageobjects.SearchResource;
import com.aperture.reusablecode.AssertTest;

public class Search_Resource_Test extends BaseClass {
	SearchResource searchresources;
	NavigationMenu_Test navigation;
	AssertTest asserttest;

	public Search_Resource_Test() {
		super();
	}

	@Test(priority = 0)
	public void runlogin() throws Exception {
		System.out.println("Before Test");
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();

		searchresources = new SearchResource(driver, logger);
		navigation = new NavigationMenu_Test();
		asserttest=new AssertTest(driver, logger);
	}

	@Test(priority = 1)
	public void navigate_To_Resource() {
		navigation.navigateToResource();
		asserttest.assertTitle("Resource");
		
	}

	@Test(priority = 2)
	public void SearchResource() {
		String resourcename = "IN10027";
		searchresources.searchResource(resourcename);
		asserttest.assertURL("view-resource");
	}

}
