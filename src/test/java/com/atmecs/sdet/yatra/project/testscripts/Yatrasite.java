package com.atmecs.sdet.yatra.project.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class Yatrasite {

	public static void main(String[] args) {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		
		 driver= new ChromeDriver();
		
		 driver.get("https://www.yatra.com/");
		
		driver.findElement(By.xpath("//span[contains(text(),'+ More')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Cruise')]")).click();
		
		driver.findElement(By.xpath("//input[@id='destinationId']")).sendKeys("Africa");
		
		//Select dest= new Select(destination);
		
		//dest.selectByIndex(2);
		
		

	}

}
