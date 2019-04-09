package com.aperture.reusablecode;

import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.aperture.core.BaseClass;
import com.aperture.exceptions.ElementNotPresentInList;
import com.aperture.exceptions.LinkIsBroken;
import com.aperture.exceptions.NoItemFound;
import com.aperture.utilities.Waits;
import okhttp3.internal.http2.ErrorCode;

//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.*;
public class CommonMethods extends BaseClass {
	//static String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[contains(text(), '%s')]";
	static String commonXpath = "//div[contains(@class,'mat-autocomplete-panel')]/mat-option//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]";
	WebDriver ldriver;
	Logger llogger;
	static Waits wait;
	Actions action;
	String firstWord;
	List<WebElement> listresult;

	public CommonMethods(WebDriver rdriver, Logger rlogger) {
		ldriver = rdriver;
		llogger = rlogger;
		PageFactory.initElements(ldriver, this);
		wait = new Waits(ldriver, 30000);
		llogger.info("refrence contain :" + wait);
		action = new Actions(driver);
	}

	public static List<WebElement> findAllLinks(WebDriver driver) {
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> finalList = new ArrayList<WebElement>();
		for (WebElement element : elementList) {
			if (element.getAttribute("href") != null) {
				finalList.add(element);
			}
		}
		return finalList;
	}

	public static String isLinkBroken(URL url) {
		// url = new URL("https://yahoo.com");
		String response = "";
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			response = connection.getResponseMessage();
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static String searchResult(List<WebElement> listresult, List<WebElement> listresultlink, String name) {
		if (listresult.size() >= 1) {
			for (int i = 0; i < listresult.size(); i++) {
				// System.out.println("At row num "+i+"->"+listresult.get(i).getText());
				if (listresult.get(i).getText().contains(name)) {
					URL link;
					try {
						link = new URL(listresultlink.get(i).getAttribute("href"));
						String response = CommonMethods.isLinkBroken(link);
						if (response.trim().equalsIgnoreCase("OK")) {
							System.out.println("clicking on link");
							String linktext = listresultlink.get(i).getText();
							listresultlink.get(i).click();
							// llogger.info("user clicked on matching project " + linktext);
							return linktext;
						} else
							throw new LinkIsBroken("Response sent by server for link " + link + " is " + response,
									cause.getCause(), code.CONNECT_ERROR);
					} catch (LinkIsBroken | IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else
			throw new NoItemFound("No Such Project Present in the list", cause.getCause(), code.INTERNAL_ERROR);
		return "No Such Project";
	}

	public void selectFromList(String name, String fieldname, WebElement element) {
		try {
			wait.waitTillElementToBeClickable(element);
			element.clear();
			element.sendKeys(name.trim());
			llogger.info("user entered " + fieldname + " " + name);
			if (name.contains(" "))
				firstWord = name.substring(0, name.indexOf(" "));
			else
				firstWord = name.trim();
			List<WebElement> checklist = driver.findElements(By.xpath(String.format(commonXpath, firstWord.trim().toLowerCase())));
			if (checklist.size() > 0) {
				System.out.println("Inside xpath last character is" + checklist.get(0).getText() + "yoyo");
				if (checklist.get(0).getText().charAt(checklist.get(0).getText().length() - 1) == ' ') {
					listresult = driver.findElements(By.xpath(String.format(commonXpath, name.trim().toLowerCase() + " ")));
				} else
					listresult = driver.findElements(By.xpath(String.format(commonXpath, name.trim().toLowerCase())));
				for (int i = 0; i < listresult.size(); i++) {
					System.out.println(listresult.get(i));
					if (listresult.get(i).getText().trim().equalsIgnoreCase(name.trim())) {
						llogger.info(name + " matched with " + listresult.get(i).getText() + " at index " + i);
						listresult.get(i).click();
						action.sendKeys(Keys.ESCAPE).build().perform();
						break;
					}
				}
			} else {
				action.sendKeys(Keys.ESCAPE).build().perform();
				throw new ElementNotPresentInList("No Such " + fieldname + "Present in the list", cause.getCause(),
						code.INTERNAL_ERROR);
			}
		} catch (NoItemFound | ElementNotPresentInList | NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void checkRadio(String name, String fieldname, List<WebElement> elementlist) {
		try {
			wait.waitTillElementToBeClickable(elementlist.get(0));
			llogger.info("user checking " + fieldname + " " + name);
			int RowCount = elementlist.size();
			for (int i = 0; i <= RowCount; i++) {
				// Check the check boxes based on index
				if (elementlist.get(i).getText().equals(name)) {
					elementlist.get(i).click();
					break;
				} else
					throw new NoItemFound("No Such " + fieldname + "Project Present in the list", cause.getCause(),
							code.INTERNAL_ERROR);
			}
		} catch (NoItemFound | ElementNotPresentInList | NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void enterValue(String name, String fieldname, WebElement element) {
		wait.waitTillElementToBeClickable(element);
		element.clear();
		element.sendKeys(name);
		llogger.info("user entered " + fieldname + " " + name);
	}

	public void clickOnButton(String fieldname, WebElement element) {
		wait.waitTillElementToBeClickable(element);
		llogger.info("user clicked on  " + fieldname);
		element.click();
	}

	public void enterValues(String[] data, String fieldname, WebElement element) {
		wait.waitTillElementToBeClickable(element);
		element.clear();
		while (element.getText().length()>0)
			action.sendKeys(Keys.BACK_SPACE).build().perform();
		for (int i = 0; i < data.length; i++) {
			element.sendKeys(data[i]);
			llogger.info("user entered " + fieldname + " " + data[i]);
			List<WebElement> checklist = driver.findElements(By.xpath(String.format(commonXpath, data[i].trim().toLowerCase())));
			if (checklist.size() > 0) {
			for (int j = 0; i < checklist.size(); j++) {
			
				if (checklist.get(j).getText().trim().equalsIgnoreCase(data[i].trim())) {
					llogger.info(data[i] + " matched with " + checklist.get(i).getText() + " at index " + i);
					checklist.get(j).click();
					break;
				}
		}
			} else {
				element.sendKeys(", ");
				break;}
			action.sendKeys(Keys.ESCAPE).build().perform();
	}
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void selectFromCheckBoxList(WebElement divlink, String fieldname, String[] linkname, WebElement element,
			List<WebElement> elementlist) {
		try {
			wait.waitTillElementToBeClickable(divlink);
			llogger.info("user selecting " + fieldname);
			divlink.click();
			wait.waitTillElementToBeClickable(element);

			for (int j = 0; j < linkname.length; j++) {
				element.clear();
				element.sendKeys(linkname[j]);
				llogger.info("user entered  practice in searchbox " + linkname[j]);
				if (elementlist.size() > 0)
					for (int i = 0; i <= elementlist.size(); i++) {

						// llogger.info("At row num "+i+"->"+listpractices.get(i).getText());
						if (elementlist.get(i).getText().trim().equalsIgnoreCase(linkname[j].trim())) {
							llogger.info("Printing elements in Practice array " + linkname[j]);
							elementlist.get(i).click();
							llogger.info("User clicked on Practice " + elementlist.get(i).getText());
							break;
						}
					}
				else
					throw new NoItemFound("No Such " + fieldname + "Project Present in the list", cause.getCause(),
							code.INTERNAL_ERROR);
			}
		} catch (NoItemFound | ElementNotPresentInList | NullPointerException e) {
			e.printStackTrace();
		}
	}
}
