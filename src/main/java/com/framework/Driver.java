package com.framework;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Driver
{
	public WebDriver driver;
	
	public boolean launchBrowser(String browser)
	{
	String operatingSystem=System.getProperty("os.name");
	String projectPath= System.getProperty("user.dir");
		
		if(operatingSystem.contains("Windows"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//exe//chromedriver.exe");
			
			
		}
		else if(operatingSystem.contains("Mac"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"/exe/MacOS/ChromeDriver");
		
		}
		if(browser.contains("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browser.contains("htmlunit"))
		{
			driver = new HtmlUnitDriver(true);
	          
				Proxy proxy = new Proxy();
				proxy.setHttpProxy("135.28.13.11:8080"); 
				((HtmlUnitDriver) driver).setProxySettings(proxy);
	                     
			//((HtmlUnitDriver) driver).setJavascriptEnabled(true);
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