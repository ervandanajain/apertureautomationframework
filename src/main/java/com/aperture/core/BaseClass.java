package com.aperture.core;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aperture.utilities.ExcelUtils;
import com.aperture.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static Logger logger;

	public BaseClass() {

	}
static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setup(String br) {

		logger = Logger.getLogger("aperture");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseurl);
		System.out.println("In Base class , Driver is "+driver);
		logger.info("URL is opened");
	}
	
	@DataProvider(name = "accountdata")
	 
	    public Object[][] ExcelAccountData() throws Exception{
	 
	         Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx","Account");
	System.out.println("Testing Excel sheet");
	         System.out.println(testObjArray[0][7].getClass().getName());
	         return (testObjArray);
	 }
	
	@DataProvider(name = "projectdata")
	 
    public Object[][] ExcelData() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx","Project");
System.out.println("Testing Excel sheet");
         System.out.println(testObjArray[0][7].getClass().getName());
         return (testObjArray);
 }
	
	@DataProvider(name = "resourcedata")
	 
    public Object[][] ExcelResourceData() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\Vandana.jain\\eclipse-workspace\\gspann.aperture\\src\\main\\resources\\com\\aperture\\test\\AppertureDataProvider.xlsx","Resource");
System.out.println("Testing Excel sheet");
         System.out.println(testObjArray[0][7].getClass().getName());
         return (testObjArray);
 }
	
	@BeforeMethod(alwaysRun=true) public void addLogger() { 
		  logger.info("===============================");
		   }

	
	  @AfterClass(alwaysRun=true) public void tearDown() { 
		  driver.quit(); }
	 

}
