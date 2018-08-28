package com.test;

import org.testng.annotations.Test;

import com.framework.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DriverTest {
  @Test(dataProvider = "dp")
  public void TC_03_f(Integer n, String s) {
	  System.out.println("Interger: "+n+" "+"String: "+s);
	  System.out.println("Inside dataProvider void f method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");
  }


  @DataProvider(name="dp",parallel=true)
  public Object[][] dp() {
	  System.out.println("Inside dataProvider");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @DataProvider(name="dp1")
  public Object[][] dp1() {
	  System.out.println("Inside dataProvider");
    return new Object[][] {
      new Object[] { 1, "c" },
      new Object[] { 2, "d" },
    };
  }
  @BeforeClass(alwaysRun=true)
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
  public void afterTest() {
	  System.out.println("AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }


  @Test(dataProvider="dp1")
  public void TC_01_launchBrowser(Integer n, String s) {
	  
	  System.out.println("Insider LaunchBrowser Test");
	  System.out.println("Interger: "+n+" "+"String: "+s);
    Driver driver=new Driver();
    Assert.assertTrue(driver.launchBrowser("htmlunit"));
    driver.driver.get("http://www.google.com");	
    
    WebElement element = driver.driver.findElement(By.xpath("//*[@name='q']"));	
    element.click();
    // Enter a search query		
    element.sendKeys("Guru99");	
   
    // Submit the query. Webdriver searches for the form using the text input element automatically		
    // No need to locate/find the submit button		
    element.submit();			
    
	// This code will print the page title		
    System.out.println("Page title is: " + driver.driver.getTitle());	
    System.out.println("Page title is: " + driver.driver.getPageSource());	
    
    Assert.assertEquals(driver.closeBrowser(), true);
    
  }
  
  @Test(alwaysRun=true)
  public void TC_02_closeBrowser() {
	  System.out.println("Insider CloseBrowser Test");
    Driver driver=new Driver();
    //Assert.assertTrue(driver.launchBrowser("chrome"));
    Assert.assertEquals(driver.closeBrowser(), true);
    
  }
}
