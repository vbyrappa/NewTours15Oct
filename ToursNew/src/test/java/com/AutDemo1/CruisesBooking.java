package com.AutDemo1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CruisesBooking {
	
	WebDriver driver;
	
	@BeforeTest
	public void openApplication() throws InterruptedException	{
	//public static void main(String[] args) throws InterruptedException, IOException{
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.get("http://newtours.demoaut.com//");
	Thread.sleep(5000);
	}
	
	@Test
	public void bookCruise() throws InterruptedException, IOException{
		System.out.println("Enter the Crednetials to login to Application for Curises Booking");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		System.out.println("Click on the Cruises Link");
		driver.findElement(By.linkText("Cruises")).click();
		Thread.sleep(3000);
		System.out.println("Take a Screenshot of the Cruises Page");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("D:\\selenium\\Cruises.png"));
		Thread.sleep(1000);		
		
		System.out.println("Click on the SignOut");
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@AfterTest
	public void browserClose() throws InterruptedException{		
		Thread.sleep(10000);
		driver.close();
	}
}
