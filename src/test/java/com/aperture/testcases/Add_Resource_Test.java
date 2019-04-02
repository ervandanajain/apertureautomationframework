package com.aperture.testcases;
import org.testng.annotations.Test;
import com.aperture.core.BaseClass;
import com.aperture.pageobjects.AddResource;
public class Add_Resource_Test extends BaseClass {
	AddResource resource;
	NavigationMenu_Test navigation;
	String name;
	String gender;
	String companyName;
	String department;
	String designation;
	String baseLocation;
	String projectStatus;
	String[] pSkills;
	String[] sSkills;
	String joiningDate;
	String[] practices;
	String employeeType;
	public Add_Resource_Test() {
		super();
	}
	@Test(priority = 0)
	public void runlogin() throws Exception {
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();
		resource = new AddResource(driver, logger);
		navigation = new NavigationMenu_Test();
	}
	
	@Test(priority = 1)
	public void navigateToResource() {
		navigation.navigateToResource();
	}
	
	@Test(priority = 2)
	public void clickOnAddResource() {
		resource.clickOnAddResource();
	}
	
	@Test(dataProvider = "resourcedata", priority = 3)
	public void fetchdatafromexcel(String namee, String genderr, String companyname, String departmentt,
			String designationn, String baselocation, String joiningdate, String practice, String pskills,
			String sskills, String employeetype) {
		name = namee;
		gender = genderr;
		companyName = companyname;
		department = departmentt;
		designation = designationn;
		baseLocation = baselocation;
		practices = practice.split(",");
		for (int i = 0; i < practices.length; i++) {
			logger.info("practices in excel is :" + practices[i]);
		}
		pSkills = pskills.split(" ");
		for (int i = 0; i < pSkills.length; i++) {
			logger.info("pskills in excel is :" + pSkills[i]);
		}
		sSkills = sskills.split(" ");
		for (int i = 0; i < sSkills.length; i++) {
			logger.info("sskills in excel is :" + sSkills[i]);
		}
		joiningDate = joiningdate;
		employeeType = employeetype;
	}
	
	@Test(priority = 4)
	public void addResourcePositiveCases() {
		resource.enterName(name);
		resource.enterCompanyName(companyName);
		resource.checkRadioGender(gender);
		resource.enterDepartment(department);
		resource.enterDesignation(designation);
		resource.enterBaseLocation(baseLocation);
		resource.enterJoiningDate(joiningDate);
		resource.selectPractices();
		resource.enterPractices(practices);
		resource.enterPSkills(pSkills);
		resource.enterSSkills(sSkills);
		String profilepicpath = "C:\\Users\\Vandana.jain\\Downloads\\imagetoupload.jpg";
		resource.selectProfilePicture(profilepicpath);
		resource.cropProfilePicture();
		String resumepath = "C:\\Users\\Vandana.jain\\Downloads\\automationresume.docx";
		resource.selectResume(resumepath);
		resource.clickOnCreateResource();
		resource.checkEmployeeType(employeeType);
	}
}
