package com.aperture.testcases;
import org.testng.annotations.Test;
import com.aperture.core.BaseClass;
import com.aperture.pageobjects.AddAccounts;
public class Add_Account_Test extends BaseClass {
	AddAccounts accounts;
	NavigationMenu_Test navigation;
	String CustomerGroup;
	String CustomerName;
	String CustomerEntity;
	String CustomerContactPerson;
	String AccountManager;
	String Country;
	String EmailId;
	String ContactNumber;
	public Add_Account_Test() {
		super();
	}
	@Test(priority = 0)
	public void runlogin() throws Exception {
		LoginPage_Test testloginpage = new LoginPage_Test();
		testloginpage.loginTest();
		accounts = new AddAccounts(driver, logger);
		navigation = new NavigationMenu_Test();
	}
	@Test(priority = 1)
	public void navigate_To_Account() {
		navigation.navigateToAccount();
	}
	@Test(dataProvider = "accountdata", priority = 2)
	public void fetchdatafromexcel(String customergroup, String customername, String customerentity,
			String customercontactperson, String accountmanager, String country, String emailid, String contactnumber) {
		CustomerGroup = customergroup;
		CustomerName = customername;
		CustomerEntity = customerentity;
		CustomerContactPerson = customercontactperson;
		AccountManager = accountmanager;
		Country = country;
		EmailId = emailid;
		ContactNumber = contactnumber;
		System.out.println("ContactNumber is "+ContactNumber);
	}
	@Test(priority = 3)
	public void createAccountPositiveCase() {
		accounts.clickOnAddAccount();
		accounts.enterCustomerGroup(CustomerGroup);
		accounts.enterCustomerName(CustomerName);
		accounts.enterCustomerEntity(CustomerEntity);
		accounts.enterCustomerReportingManager(CustomerContactPerson);
		accounts.enterAccountManager(AccountManager);
		accounts.enterCountry(Country);
		accounts.enterCustomerEmailId(EmailId);
		accounts.enterContactNumber(ContactNumber);
		accounts.checkRadioTimetrack("NO");
		accounts.clickOnCreateAccount();
		assert accounts.verifyAccountCreation("Example test"):"Expected Results: Account created Successfully";
	}
}
