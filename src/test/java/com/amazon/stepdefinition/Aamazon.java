package com.amazon.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aamazon {
	
	 static long startTime;	
		static WebDriver driver;
		
		@BeforeClass
		public static void browserlaunch() {
		System.out.println("launch method from before class");
		System .setProperty("webdriver.chrome.driver", "C:\\Users\\DINESH MUTHUSAMY\\eclipse-workspace\\SeleniumProjects\\driver\\chromedriver.exe")	;
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("https://www.amazon.com/");
		}
		  
		@BeforeMethod	
		public void beforemethod() {
	  System.out.println("Before method");
	    startTime=  System.currentTimeMillis();
		
	}
		@Test
		    public void aftermethod() {
		 
		System.out.println("Aftermethod");
	    long endTime=System.currentTimeMillis();
	    System.out.println("Time Taken for process:"+(endTime-startTime));
		} 
		  
		@AfterClass
		   public static void browserquit() {
		     System.out.println("quit the browser");
		
		}	

			@Test
			  public void method1() {
			   WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
				search.sendKeys("lg tv 55 inch",Keys.ENTER);
			WebElement Choose=	driver.findElement(By.xpath("//div[contains(@class,'small s-title-instructions-style')]"));
			    Choose.click();
				}	
			
			@Test
			public void method3() throws IOException {
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File source=screenshot.getScreenshotAs(OutputType.FILE);
				File target=new File("C:\\Users\\DINESH MUTHUSAMY\\eclipse-workspace\\junit-feb\\target\\am.png");
				FileUtils.copyFile(source,target);
			}  
		  
		  
		  
		  
		  
		  
		  
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


