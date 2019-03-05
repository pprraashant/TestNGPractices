package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javafx.scene.control.Alert;

public class TestDemo {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //setup web driver
    	  String projectPath= System.getProperty("user.dir");
    	System.setProperty("webdriver.chrome.driver", projectPath+"//exe//chromedriver.exe");
        driver = new ChromeDriver();

        //create new thread for interaction with windows authentication window
        (new Thread(new LoginWindow())).start();                

        //open your url. this will prompt you for windows authentication
        driver.get("https://tst02.stage.att.com/shop/login/login.html");
        Thread.sleep(600);
        //add test scripts below ...
        driver.findElement(By.linkText("Home")).click();    
        //.....
        //.....
    driver.close();
    driver.quit();
    }
}