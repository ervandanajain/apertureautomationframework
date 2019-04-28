package com.aperture.testcases;

import org.testng.annotations.Test;
import com.aperture.core.BaseClass;
import com.aperture.core.SourceDataProvider;
import com.aperture.pageobjects.AddProject;
import com.aperture.reusablecode.AssertTest;

public class Add_Project_Test extends BaseClass {
	AddProject project;
	NavigationMenu_Test navigation;
	AssertTest asserttest;

	String[] technology;
	String testingstep;
	String[] practices;

	public Add_Project_Test() {
		super();
	}

	@Test(priority = 0)
	public void runlogin() throws Exception {
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();
		project = new AddProject(driver, logger);
		navigation = new NavigationMenu_Test();
		asserttest = new AssertTest(driver, logger);
	}

	@Test(priority = 1)
	public void navigate_To_Project() {
		navigation.navigateToProject();
		asserttest.assertTitle("Project");
	}

	@Test(priority = 2)
	public void clickOnAddAccount() {
		project.clickOnAddProject();
		// asserttest.assertURL(linktext);
	}

	@Test(dataProvider = "projectdata", dataProviderClass = SourceDataProvider.class,priority = 3)

	public void addProjectPositiveCases(String accountcode, String customerproject, String customermanager,
			String customerprojectname, String projectname, String onshoremanager, String offshoremanager,
			String projecttype, String countries, String practice, String projectstatus, String technologies,
			String projectstartdate, String projectenddate) {
		practices = practice.split(",");
		for (int i = 0; i < practices.length; i++) {
			logger.info("practices in excel is :" + practices[i]);
		}
		technology = technologies.split(" ");
		for (int i = 0; i < technology.length; i++) {
			logger.info("technology in excel is :" + technology[i]);
		}
		//System.out.println(testing);
		project.enterAccountCode(accountcode);
		project.enterCustomerProject(customerproject);
		asserttest.assertValidValue("Customer Project");
		project.enterCustomerManager(customermanager);
		asserttest.assertValidValue("Customer Manager");
		project.enterCustomerProjectName(customerprojectname);
		asserttest.assertValidValue("Customer Project Name");
		project.enterProjectName(projectname);
		asserttest.assertValidValue("Project Name");
		project.enterOnshoreManager(onshoremanager);
		asserttest.assertValidValue("OnShoreManager");
		project.enterOffshoreManager(offshoremanager);
		asserttest.assertValidValue("OffShoreManager");
		project.enterProjectType(projecttype);
		asserttest.assertValidValue("Project Type");
		project.enterCountry(countries);
		asserttest.assertValidValue("Country");
		project.enterProjectStatus(projectstatus);
		asserttest.assertValidValue("Project Status");
		project.enterTechnology(technology);
		asserttest.assertValidValue("Technology");
		project.enterProjectStartDate(projectstartdate);
		asserttest.assertValidValue("Project Start date");
		project.enterProjectEndDate(projectenddate);
		asserttest.assertValidValue("Project Enddate");
		project.selectPractices(practices);
		asserttest.assertValidValue("Practice");
		project.clickOnCreateProject();
	}
	
/*	@Test(dataProvider = "projectdatabugs", dataProviderClass = SourceDataProvider.class,priority = 4)

	public void addProjectNegativeCases(String accountcode, String customerproject, String customermanager,
			String customerprojectname, String projectname, String onshoremanager, String offshoremanager,
			String projecttype, String countries, String practice, String projectstatus, String technologies,
			String projectstartdate, String projectenddate) {
		practices = practice.split(",");
		for (int i = 0; i < practices.length; i++) {
			logger.info("practices in excel is :" + practices[i]);
		}
		technology = technologies.split(" ");
		for (int i = 0; i < technology.length; i++) {
			logger.info("technology in excel is :" + technology[i]);
		}
		//System.out.println(testing);
		project.enterAccountCode(accountcode);
		project.enterCustomerProject(customerproject);
		asserttest.assertInvalidValue("Customer Project");
		project.enterCustomerManager(customermanager);
		asserttest.assertInvalidValue("Customer Manager");
		project.enterCustomerProjectName(customerprojectname);
		asserttest.assertInvalidValue("Customer Project Name");
		project.enterProjectName(projectname);
		asserttest.assertInvalidValue("Project Name");
		project.enterOnshoreManager(onshoremanager);
		asserttest.assertInvalidValue("OnShoreManager");
		project.enterOffshoreManager(offshoremanager);
		asserttest.assertInvalidValue("OffShoreManager");
		project.enterProjectType(projecttype);
		asserttest.assertInvalidValue("Project Type");
		project.enterCountry(countries);
		asserttest.assertInvalidValue("Country");
		project.enterProjectStatus(projectstatus);
		asserttest.assertInvalidValue("Project Status");
		project.enterTechnology(technology);
		asserttest.assertInvalidValue("Technology");
		project.enterProjectStartDate(projectstartdate);
		asserttest.assertInvalidValue("Project Start date");
		project.enterProjectEndDate(projectenddate);
		asserttest.assertInvalidValue("Project Enddate");
	//	project.selectPractices(practices);
	//	asserttest.assertInvalidValue("Practice");
		project.clickOnCreateProject();
	}
*/
}
