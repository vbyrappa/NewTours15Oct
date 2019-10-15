package com.AutDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToursBooking {
	WebDriver driver;
	
	@BeforeTest
	public void launchApplication() throws InterruptedException{
	//public static void man(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.get("http://newtours.demoaut.com//");
	Thread.sleep(5000);
	}
	
	
	@Test
	public void bookflight() throws InterruptedException{
		System.out.println("Login to the New Tours");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		System.out.println("Select the Number of Passengers");
		WebElement passengerDrop= driver.findElement(By.name("passCount"));
		Select passengerDown = new Select(passengerDrop);
		passengerDown.selectByIndex(1);
		Thread.sleep(1000);
		System.out.println("Select the From Place");
		WebElement departingDrop = driver.findElement(By.name("fromPort"));
		Select departingDown = new Select(departingDrop);
		departingDown.selectByVisibleText("New York");
		Thread.sleep(1000);
		System.out.println("Select the Month of Travelling");
		WebElement fromMonthDrop = driver.findElement(By.name("fromMonth"));
		Select fromMonthDown = new Select(fromMonthDrop);
		fromMonthDown.selectByVisibleText("November");
		Thread.sleep(1000);
		System.out.println("Seelct the Day of Journey");
		WebElement fromDayDrop = driver.findElement(By.name("fromDay"));
		Select fromDayDown = new Select(fromDayDrop);
		fromDayDown.selectByValue("23");
		Thread.sleep(1000);
		System.out.println("Select the Destination Place");
		WebElement arrivingDrop = driver.findElement(By.name("toPort"));
		Select arrivingDown = new Select(arrivingDrop);
		arrivingDown.selectByVisibleText("Paris");
		Thread.sleep(1000);
		System.out.println("Select the Return Journey Month");
		WebElement toMonthDrop = driver.findElement(By.name("toMonth"));
		Select toMonthDown = new Select(toMonthDrop);
		toMonthDown.selectByVisibleText("November");
		Thread.sleep(1000);
		System.out.println("Select the Return Journey Date");
		WebElement toDayDrop = driver.findElement(By.name("toDay"));
		Select toDayDown = new Select(toDayDrop);
		toDayDown.selectByValue("25");
		Thread.sleep(1000);
		System.out.println("Select the Class of Journey");
		driver.findElement(By.xpath("(/html/body//input[contains(@name,'servClass')])[2]")).click();
		Thread.sleep(1000);
		System.out.println("Select the Airlines You like to Travel");
		WebElement airlineDrop = driver.findElement(By.name("airline"));
		Select airlineDown = new Select(airlineDrop);
		airlineDown.selectByVisibleText("Blue Skies Airlines");
		Thread.sleep(1000);
		System.out.println("Click on the Continue Button");
		driver.findElement(By.name("findFlights")).click();		
	}
	
		@Test
		public void selectFlight() throws InterruptedException{		
		Thread.sleep(5000);
		System.out.println("Click on the Flights with Convienient Date and Time for To Journey");
		driver.findElement(By.xpath("(/html/body//input[contains(@name,'outFlight')])[2]")).click();
		System.out.println("Click on the Flights with Convienient Date and Time for Return Journey");
		driver.findElement(By.xpath("(/html/body//input[contains(@name,'inFlight')])[2]")).click();
		System.out.println("Click on the CheckOut Button");
		driver.findElement(By.name("reserveFlights")).click();
		Thread.sleep(3000);
		System.out.println("Click on the SignOut Button");
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException{
		Thread.sleep(10000);
		System.out.println("Click on the Close Browser Button");
		driver.close();
	}
	
}

	
