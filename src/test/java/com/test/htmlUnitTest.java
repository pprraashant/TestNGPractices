package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;		
public class htmlUnitTest {				
		public static void main(String[] args) throws InterruptedException {
                     // Creating a new instance of the HTML unit driver
                      
			WebDriver  driver = new HtmlUnitDriver();
                     
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("135.28.13.11:8080"); 
			((HtmlUnitDriver) driver).setProxySettings(proxy);
                     
                   
           		     // Navigate to Google		
                     driver.get("http://www.google.com");
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   System.out.println(driver.getCurrentUrl());
                   System.out.println(((HtmlUnitDriver) driver).getBrowserVersion());
                    WebElement element = driver.findElement(By.name("q"));	
                     
                    // Enter a search query		
                    element.sendKeys("Guru99");	
                   
		            // Submit the query. Webdriver searches for the form using the text input element automatically		
                    // No need to locate/find the submit button		
                    element.submit();			
                    
            		// This code will print the page title		
                    System.out.println("Page title is: " + driver.getTitle());		
                    
                    driver.quit();			
         }		
}