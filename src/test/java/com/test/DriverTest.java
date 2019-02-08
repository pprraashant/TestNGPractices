package com.test;

import org.testng.annotations.Test;

import com.framework.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DriverTest {
	@Test(dataProvider = "dp" ,priority= 2)
	public void TC_03_f(Integer n, String s) {
		System.out.println("Interger: " + n + " " + "String: " + s);
		System.out.println("Inside dataProvider void f method");
	}

	@Test(priority = 1)
	public void TC_04_f() {
		
		System.out.println("TC_04_f with priority 1");
	}
	@BeforeMethod
	public void before1Method() {
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

	@DataProvider(name = "dp", parallel = true)
	public Object[][] dp() {
		System.out.println("Inside dataProvider");
		return new Object[][] { new Object[] { 1, "Guru99" }, new Object[] { 2, "99Guru" }, };
	}

	@DataProvider(name = "dp1")
	public Object[][] dp1() {
		System.out.println("Inside dataProvider");
		return new Object[][] { new Object[] { 1, "Gu9r9u" }, new Object[] { 2, "9Guru9" }, };
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}

	@AfterTest
	public void afterTest(ITestContext iTestContext) {
		System.out.println("AfterTest");
		ITestNGMethod[] methods = iTestContext.getAllTestMethods();
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
			IRetryAnalyzer v = method.getRetryAnalyzer();
			// // v.retry(itestResult);
			// Object [] objs=itestResult.getParameters();
			// for(Object obj : objs)
			// {
			// System.out.println(obj.getClass());
			// }

		}
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}

	@Test(dataProvider = "dp1" , priority=3)
	public void TC_01_launchBrowser(Integer n, String s) {

		System.out.println("Insider LaunchBrowser Test");
		System.out.println("Interger: " + n + " " + "String: " + s);
		Driver driver = new Driver();
		Assert.assertTrue(driver.launchBrowser("chrome"));
		driver.driver.get("http://www.google.com");

		WebElement element = driver.driver.findElement(By.xpath("//*[@name='q']"));
		element.click();
		// Enter a search query
		element.sendKeys(s);

		// Submit the query. Webdriver searches for the form using the text
		// input element automatically
		// No need to locate/find the submit button
		element.submit();

		// This code will print the page title
		System.out.println("Page title is: " + driver.driver.getTitle());
		// System.out.println("Page title is: " +
		// driver.driver.getPageSource());

		Assert.assertEquals(driver.closeBrowser(), true);

	}

	@Test(priority=4, alwaysRun = true ,enabled=false)
	public void TC_02_closeBrowser() {
		System.out.println("Insider CloseBrowser Test");
		Driver driver = new Driver();
		// Assert.assertTrue(driver.launchBrowser("chrome"));
		Assert.assertEquals(driver.closeBrowser(), true);

	}
}
