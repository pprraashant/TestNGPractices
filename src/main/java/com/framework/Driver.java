package com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver
{
	WebDriver driver;
	
	public boolean launchBrowser(String browser)
	{
	String operatingSystem=System.getProperty("os.name");
	String projectPath= System.getProperty("user.dir");
		
		if(operatingSystem.contains("windows"))
		{
			
		}
		else if(operatingSystem.contains("Mac"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"/exe/MacOS/ChromeDriver");
		
		}
		if(browser.contains("chrome"))
		{
			driver=new ChromeDriver();
		}
		return true;
		
	}
	public boolean closeBrowser()
	{
		driver.close();
		driver.quit();
		return true;
	}
	
	
}