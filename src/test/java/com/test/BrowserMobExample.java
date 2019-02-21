package com.test;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class BrowserMobExample {
	
	String driverPath = "F:/drivers/chromedriver/";

	String sFileName = "";
	public WebDriver driver;
	public BrowserMobProxy proxy;
	
	@BeforeTest
	public void setUp() {
		
	   // start the proxy
	    proxy = new BrowserMobProxyServer();
	    proxy.start(0);

	    String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"//exe//chromedriver.exe");
	    //get the Selenium proxy object - org.openqa.selenium.Proxy;
	    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	    sFileName=projectPath+"harfile.har";
	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	   // capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		ChromeOptions co= new ChromeOptions();
	    
		co.setCapability(CapabilityType.PROXY, seleniumProxy);
	    //set chromedriver system property
		//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver(co);
		
	    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
	    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

	    // create a new HAR with the label "seleniumeasy.com"
	    proxy.newHar("seleniumeasy.com");

	    // open seleniumeasy.com
	    driver.get("https://www.att.com/");
        
	}
	
	@Test
	public void testCaseOne() {
		System.out.println("Navigate to selenium tutorials page");
		driver.findElement(By.linkText("wireless"));
	}
	
	@AfterTest
	public void tearDown() {

		// get the HAR data
		Har har = proxy.getHar();

		// Write HAR Data in a File
		File harFile = new File(sFileName);
		try {
			har.writeTo(harFile);
		} catch (IOException ex) {
			 System.out.println (ex.toString());
		     System.out.println("Could not find file " + sFileName);
		}
		
		if (driver != null) {
			proxy.stop();
			driver.quit();
		}
	}
}