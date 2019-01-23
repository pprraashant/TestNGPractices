package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	
	@Test
	public static void captureScreenMethod() throws Exception{
		String operatingSystem=System.getProperty("os.name");
		String projectPath= System.getProperty("user.dir");
		//	System.out.println(CaptureScreenshot.class.getClassLoader());
			if(operatingSystem.contains("windows"))
			{
				System.setProperty("webdriver.chrome.driver", projectPath+"/exe/ChromeDriver.exe");
			}
			else if(operatingSystem.contains("Mac"))
			{
				System.setProperty("webdriver.chrome.driver", projectPath+"/exe/MacOS/ChromeDriver");
			
			}
		WebDriver driver = new ChromeDriver();
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		//driver.manage().window().maximize();
		driver.get("https://www.softwaretestingmaterial.com/capture-screenshot-using-selenium-webdriver");
		long startTime = System.currentTimeMillis();
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(projectPath+"/screenshots/screenshot.png"));
		long endTime = System.currentTimeMillis();
		System.out.println("Took "+(endTime - startTime) + " ms");
		
		long startTime1 = System.currentTimeMillis();
		File newfile= new File(projectPath+"/screenshots/screenshot1.png");
		byte[] fname = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		OutputStream os=new FileOutputStream(newfile);
		os.write(fname);
		os.close();
		long endTime1 = System.currentTimeMillis();
		System.out.println("Took "+(endTime1 - startTime1) + " ms");
		
		driver.close();
		driver.quit();		
	}
}