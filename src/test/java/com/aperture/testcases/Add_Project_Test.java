package com.aperture.testcases;
import org.testng.annotations.Test;
import com.aperture.core.BaseClass;
import com.aperture.pageobjects.AddProject;
public class Add_Project_Test extends BaseClass {
	AddProject project;
	NavigationMenu_Test navigation;
	String accountCode;
	String customerProject;
	String customerManager;
	String customerProjectName;
	String projectName;
	String onShoreManager;
	String offShoreManager;
	String projectType;
	String country;
	String projectStatus;
	String[] technology;
	String projectStartDate;
	String projectEndDate;
	String[] practices;
	public Add_Project_Test() {
		super();
	}
	@Test(priority = 0)
	public void runlogin() throws Exception {
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();
		project = new AddProject(driver);
		navigation = new NavigationMenu_Test();
	}
	@Test(priority = 1)
	public void navigate_To_Project() {
		navigation.navigateToProject();
	}
	@Test(priority = 2)
	public void clickOnAddAccount() {
		project.clickOnAddProject();
	}
	@Test(dataProvider = "projectdata", priority = 3)
	public void fetchdatafromexcel(String accountcode, String customerproject, String customermanager,
			String customerprojectname, String projectname, String onshoremanager, String offshoremanager,
			String projecttype, String countries, String practice, String projectstatus, String technologies,
			String projectstartdate, String projectenddate) {
		accountCode = accountcode;
		customerProject = customerproject;
		customerManager = customermanager;
		customerProjectName = customerprojectname;
		projectName = projectname;
		onShoreManager = onshoremanager;
		offShoreManager = offshoremanager;
		projectType = projecttype;
		country = countries;
		practices = practice.split(",");
		for (int i = 0; i < practices.length; i++) {
			logger.info("practices in excel is :" + practices[i]);
		}
		projectStatus = projectstatus;
		technology = technologies.split(" ");
		for (int i = 0; i < technology.length; i++) {
			logger.info("technology in excel is :" + technology[i]);
		}
		projectStartDate = projectstartdate;
		projectEndDate = projectenddate;
	}
	@Test(priority = 4)
	public void addProjectPositiveCases() {
		
		project.enterAccountCode(accountCode);
		project.enterCustomerProject(customerProject);
		project.enterCustomerManager(customerManager);
		project.enterCustomerProjectName(customerProjectName);
		project.enterProjectName(projectName);
		project.enterOnshoreManager(onShoreManager);
		project.enterOffshoreManager(offShoreManager);
		project.enterProjectType(projectType);
		project.enterCountry(country);
		project.selectPractices();
		project.enterPractices(practices);
		project.clickOnMainDiv();
		project.enterProjectStatus(projectStatus);
		project.enterTechnology(technology);
		project.enterProjectStartDate(projectStartDate);
		project.enterProjectEndDate(projectEndDate);
		project.clickOnCreateProject();
	}
}
