package com.aperture.testcases;


import org.testng.annotations.Test;

import com.aperture.core.BaseClass;
import com.aperture.pageobjects.SearchProject;

public class Search_Project_Test extends BaseClass {
	SearchProject searchprojects;
	NavigationMenu_Test navigation;

	public Search_Project_Test() {
		super();
	}

	@Test(priority = 0)
	public void runlogin() throws Exception {
		System.out.println("Before Test");
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();

		searchprojects = new SearchProject(driver);
		navigation = new NavigationMenu_Test();
	}

	@Test(priority = 1)
	public void navigate_To_Project() {

		// System.out.println("Checking to click on Projects");
		navigation.navigateToProject();
		;
	}

	@Test(priority = 2)
	public void SearchProject() {
		String projectname = "Mckenzie";
		searchprojects.searchProject(projectname);
		searchprojects.searchResult(projectname);
	}

}
