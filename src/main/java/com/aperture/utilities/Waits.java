package com.aperture.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	WebDriver ldriver;
	int ltimeout;
	//public static Logger logger;
	public Waits(WebDriver driver,int timeout)
	{
		ldriver=driver;
		ltimeout=timeout;
	}
	public void waitTillVisibilityOf(WebElement element) {
		//logger.info("waiting for visibility of " +element);
		System.out.println("in visibility of" + element);
		new WebDriverWait(ldriver,ltimeout).
		until(ExpectedConditions.visibilityOf(element));
		
	
	}

	public void waitTillElementToBeClickable(WebElement element) {
		//logger.info("waiting for clickability of " +element);
		System.out.println("in clickability of" + element);
		new WebDriverWait(ldriver,ltimeout).
		until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
}