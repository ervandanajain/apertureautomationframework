package com.aperture.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.aperture.utilities.EmailReport;
import com.aperture.utilities.ExcelUtils;
import com.aperture.utilities.ReadConfig;
import com.aperture.utilities.ZipFolder;

import okhttp3.internal.http2.ErrorCode;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public static Throwable cause;
	public static ErrorCode code;
	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	EmailReport emailreport = new EmailReport();
	public static Logger logger;
	public static File repfoldername;
	public static String repname;
	public static String repfolderpath;
	@FindBy(xpath = "//div[@role='alert']")
	@CacheLookup
	public static WebElement alertMessage;

	public BaseClass() {
	}

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		repname = "Extent_Report-" + System.setProperty("current.date.time", dateFormat.format(new Date()));
		repfoldername = new File(System.getProperty("user.dir") + "/test-output/" + repname);
		repfolderpath = System.getProperty("user.dir") + "/test-output/" + repname;
	}

	@BeforeSuite(alwaysRun = true)
	public static void preSetup() {
		repfoldername.mkdir();
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
		System.out.println("In Base class , Driver is " + driver);
		logger.info("URL is opened");
	}

	@BeforeMethod(alwaysRun = true)
	public void addLogger() {
		logger.info("===============================");
	}

	/*
	 * @AfterMethod(alwaysRun = true) public boolean verifyTest(String value) {
	 * return alertMessage.getText().equals(value); }
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void postExecution() {
		// File file = new File("/Users/pankaj/sitemap.xml");
		// String zipFileName = "/Users/pankaj/sitemap.zip";
		File dir = new File(repfolderpath);
		String zipDirName = repfolderpath + "/tmp.zip";
		// ZipFolder.zipSingleFile(file, zipFileName);
		ZipFolder zipFiles = new ZipFolder();
		// zipFiles.zipDirectory(dir, zipDirName);
		// System.out.println("Zipped folder now will email");
		// emailreport.EmailExtentReport(repfolderpath + "//tmp.zip");
	}
}
