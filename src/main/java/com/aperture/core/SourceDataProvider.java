package com.aperture.core;

import org.testng.annotations.DataProvider;

import com.aperture.utilities.ExcelUtils;

public class SourceDataProvider {
	@DataProvider(name = "accountdata")

	public Object[][] ExcelAccountData() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(
				"C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx",
				"Account");
		System.out.println("Testing Excel sheet");
		System.out.println(testObjArray[0][7].getClass().getName());
		return (testObjArray);
	}

	@DataProvider(name = "projectdata")

	public Object[][] ExcelProjectData() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(
				"C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx",
				"Project");
		return (testObjArray);
	}
	
	@DataProvider(name = "projectdatabugs")

	public Object[][] ExcelProjectBugsData() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(
				"C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx",
				"ProjectBugs");
		return (testObjArray);
	}

	@DataProvider(name = "resourcedata")

	public Object[][] ExcelResourceData() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(
				"C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx",
				"Resource");
		System.out.println("Testing Excel sheet");
		System.out.println(testObjArray[0][7].getClass().getName());
		return (testObjArray);
	}

}
